package org.wtm.wtmwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wtm.wtmwebsite.dao.MemberDocument;
import org.wtm.wtmwebsite.dto.Account;
import org.wtm.wtmwebsite.repository.MemberRepository;
import org.wtm.wtmwebsite.service.mapper.AccountMapper;

@Service
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberDocument memberDoc = memberRepository.findByEmail(email);
        if( memberDoc == null ) {
            throw new UsernameNotFoundException(email);
        }
        Account account = AccountMapper.getAccountDTO(memberDoc);
        return account;
    }
}
