package h9w.me.link.members.model.repository;

import h9w.me.link.LinkApplication;
import h9w.me.link.config.JPAConfiguration;
import h9w.me.link.members.model.dto.MemberDTO;
import h9w.me.link.members.model.entity.Member;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        JPAConfiguration.class,
        LinkApplication.class
})
class MemberRepositoryTest {

    @Autowired private MemberRepository repo;
    @Autowired private ModelMapper mapper;

    private String logMember(Member member) {
        return mapper.map(member, MemberDTO.class).toString();
    }

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    public void findMembers() {
        List<Member> members = repo.findAll();

        assertNotNull(members);


        members.stream().map(v -> { return logMember(v); }).forEach(System.out::println);
    }
}