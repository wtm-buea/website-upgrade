package org.wtm.wtmwebsite.service.command.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wtm.wtmwebsite.dao.MemberDocument;
import org.wtm.wtmwebsite.dto.Member;
import org.wtm.wtmwebsite.repository.MemberRepository;
import org.wtm.wtmwebsite.service.command.MemberCommand;
import org.wtm.wtmwebsite.service.mapper.MemberMapper;

import java.util.UUID;

@Service
@Transactional
public class MemberCommandImplementation implements MemberCommand {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member createMember( Member member ) {
        MemberDocument newMember;
        member.setUuid(UUID.randomUUID().toString());
        newMember = memberRepository.create(MemberMapper.getMemberDAO(member));
        return MemberMapper.getMemberDTO(newMember);
    }

    @Override
    public Member updateMember( Member member ) {
        MemberDocument updatedMember;
        updatedMember = memberRepository.update(MemberMapper.getMemberDAO(member));
        return MemberMapper.getMemberDTO(updatedMember);
    }

    @Override
    public void deleteMember( String uuid ) {
        memberRepository.delete(uuid);
    }

}
