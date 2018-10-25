package smart.service;

import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


@ContextConfiguration("classpath*:/smart-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void testHasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        assertTrue(b1);
    }

    @Test
    public void testFindUserByUser() {
    }

    @Test
    public void testUpdateLoginInfo() {
    }

    @Test
    public void testInsertsuccess() {
    }
}