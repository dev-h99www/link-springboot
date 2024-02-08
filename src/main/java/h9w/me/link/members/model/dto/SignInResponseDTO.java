package h9w.me.link.members.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class SignInResponseDTO {
    private MemberDTO member;
    private String loginType;
    private String token;
    private int exprTime = 3600000;
}
