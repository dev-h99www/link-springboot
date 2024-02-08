package h9w.me.link.members.controller;

import h9w.me.link.common.TokenProvider;
import h9w.me.link.common.model.ResponseDTO;
import h9w.me.link.members.model.dto.SignInResponseDTO;
import h9w.me.link.members.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "localhost")
@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    @Autowired
    public MemberController(MemberService memberService, TokenProvider tokenProvider) {
        this.memberService = memberService;
        this.tokenProvider = tokenProvider;
    }

    @GetMapping("{memberId}")
    public ResponseDTO<?> login(@PathVariable("memberId") String memberId) {

        try {

            SignInResponseDTO signInResponseDTO = memberService.findMember(memberId);
            signInResponseDTO.setToken(tokenProvider.create(signInResponseDTO.getMember()));

            return ResponseDTO.setSuccess("Login success", signInResponseDTO);

        } catch(Exception e) {

            return ResponseDTO.setFailed("Login fail");
        }
    }


}
