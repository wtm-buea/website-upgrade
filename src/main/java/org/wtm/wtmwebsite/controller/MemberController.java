package org.wtm.wtmwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wtm.wtmwebsite.dto.Member;
import org.wtm.wtmwebsite.exception.BadRequestException;
import org.wtm.wtmwebsite.exception.NotFoundException;
import org.wtm.wtmwebsite.service.command.MemberCommand;
import org.wtm.wtmwebsite.service.query.MemberQuery;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberCommand memberCommand;

    @Autowired
    private MemberQuery memberQuery;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Member> createMember( @RequestBody Member member ) {
        Member newMember = memberCommand.createMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Page<Member>> getMembers(@RequestParam(value = "page", required = false) Integer page,
                                             @RequestParam(value = "size", required = false) Integer size) {
        if ( page == null || size ==null ) {
            page = 1;
            size = 20;
        } else if ( page <= 0 || size <= 0 ) {
            throw BadRequestException.create("Invalid page number: {0} or page size: {1} value", page, size);
        }

        Page<Member> result = memberQuery.findAll(page-1, size);
        if ( page > result.getTotalPages() ) {
            throw NotFoundException.create("Not found: page {0} not found", page);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/{memberId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Member> getMemberById(@PathVariable("memberId") String memberId) {
        Member newMember = memberQuery.findById(memberId);
        if (newMember == null) {
            throw NotFoundException.create("Not found: member with id, {0} does not exist in the system", memberId);
        }
        return new ResponseEntity<>(newMember, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{memberId}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Member> updateMember( @RequestBody Member member, @PathVariable("memberId") String memberId ) {
        Member updatedMember = memberQuery.findById(memberId);
        if (updatedMember == null) {
            throw NotFoundException.create("Not found: member with id, {0} does not exist in the system", memberId);
        }

        updatedMember = memberCommand.updateMember(member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{memberId}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<HttpStatus> deleteMember( @PathVariable("memberId") String memberId ) {
        memberCommand.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
