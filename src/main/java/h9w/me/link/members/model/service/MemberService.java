package h9w.me.link.members.model.service;

import h9w.me.link.members.model.dto.MemberDTO;
import h9w.me.link.members.model.dto.SignInResponseDTO;
import h9w.me.link.members.model.entity.Member;
import h9w.me.link.members.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final static int MEMBER_ROLE_ADMIN = 1;
    private final static int MEMBER_ROLE_USER   = 2;
    private final MemberRepository memberRepo;
    private final ModelMapper mapper;

    @Autowired
    public MemberService(MemberRepository memberRepo, ModelMapper mapper) {
        this.memberRepo = memberRepo;
        this.mapper = mapper;
    }

    public SignInResponseDTO findMember(String memberId) {

        Member member = memberRepo.findByMemberId(memberId);
        MemberDTO memberDTO = null;
        String loginType = null;
        if(member != null) {
            memberDTO = mapper.map(member, MemberDTO.class);
            loginType = "로그인";
        } else {
            Member saveMember = Member.builder().memberId(memberId).memberRoleNo(MEMBER_ROLE_USER).build();
            memberRepo.save(saveMember);

            memberDTO = mapper.map(saveMember, MemberDTO.class);
            loginType = "신규";
        }

        return SignInResponseDTO.builder().member(memberDTO).loginType(loginType).build();
    }

}

