package h9w.me.link.dodel;

import h9w.me.link.LinkApplication;
import h9w.me.link.config.JPAConfiguration;
import h9w.me.link.dodel.entity.Member;
import org.junit.jupiter.api.Test;
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
class TestRepositoryTest {

    @Autowired
    private TestRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    public void findMembers() {
        List<Member> members = repo.findAll();

        assertNotNull(members);

        members.forEach(System.out::println);
    }
}