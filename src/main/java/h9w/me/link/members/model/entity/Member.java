package h9w.me.link.members.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_MEMBER")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Member {
    @Id
    @Column(name = "MEMBER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "MEMBER_ROLE_NO")
    private int memberRoleNo;
}
