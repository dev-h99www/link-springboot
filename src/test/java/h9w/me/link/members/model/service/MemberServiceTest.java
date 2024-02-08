package h9w.me.link.members.model.service;

import h9w.me.link.LinkApplication;
import h9w.me.link.config.JPAConfiguration;
import h9w.me.link.members.model.dto.MemberDTO;
import h9w.me.link.members.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        LinkApplication.class,
        JPAConfiguration.class
})
@Transactional
class MemberServiceTest {

    @Autowired private MemberService service;

    @Test
    public void initTest() {
        assertNotNull(service);
    }

}