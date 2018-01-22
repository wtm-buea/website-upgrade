package org.wtm.wtmwebsite.service.query.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wtm.wtmwebsite.dao.MemberDocument;
import org.wtm.wtmwebsite.dto.Member;
import org.wtm.wtmwebsite.repository.MemberRepository;
import org.wtm.wtmwebsite.service.mapper.MemberMapper;
import org.wtm.wtmwebsite.service.query.MemberQuery;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MemberQueryImplementation implements MemberQuery {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member findById(String uuid) {
        MemberDocument memberDoc = memberRepository.findById(uuid);
        return MemberMapper.getMemberDTO( memberDoc );
    }

    @Override
    public Member findByEmail(String email) {
        MemberDocument memberDoc = memberRepository.findById(email);
        return MemberMapper.getMemberDTO( memberDoc );
    }

    @Override
    public Page<Member> findAll(Integer page, Integer size) {
        List<MemberDocument> memberDocs = memberRepository.findAll(new PageRequest( page, size ));
        List<Member> members = new ArrayList<>();
        memberDocs.forEach(memberDoc -> members.add(MemberMapper.getMemberDTO(memberDoc)));
        return new PageImpl<>(members, new PageRequest(page, size), memberRepository.count());
    }

}
