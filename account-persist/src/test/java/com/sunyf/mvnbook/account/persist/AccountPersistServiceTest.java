package com.sunyf.mvnbook.account.persist;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountPersistServiceTest { private AccountPersistService service;

    @Before
    public void prepare() throws Exception {

        File persistDataFile = new File("target/test-classes/persist-data.xml");

        if (persistDataFile.exists()) {
            persistDataFile.delete();
        }

        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persist.xml");

        service = (AccountPersistService) ctx.getBean("accountPersistService");

        Account account = new Account();
        account.setId("sunyf");
        account.setName("sunyf");
        account.setEmail("sunyf@changeme.com");
        account.setPassword("this_should_be_encrypted");
        account.setActivated(true);

        service.createAccount(account);
    }

    @Test
    public void testReadAccount() throws Exception {
        Account account = service.readAccount("sunyf");

        assertNotNull(account);
        assertEquals("sunyf", account.getId());
        assertEquals("sunyf", account.getName());
        assertEquals("sunyf@changeme.com", account.getEmail());
        assertEquals("this_should_be_encrypted", account.getPassword());
        assertTrue(account.isActivated());
    }

    @Test
    public void testDeleteAccount() throws Exception {
        assertNotNull(service.readAccount("sunyf"));
        service.deleteAccount("sunyf");
        assertNull(service.readAccount("sunyf"));
    }

    @Test
    public void testCreateAccount() throws Exception {
        assertNull(service.readAccount("mike"));

        Account account = new Account();
        account.setId("mike");
        account.setName("Mike");
        account.setEmail("mike@changeme.com");
        account.setPassword("this_should_be_encrypted");
        account.setActivated(true);

        service.createAccount(account);

        assertNotNull(service.readAccount("mike"));
    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account account = service.readAccount("sunyf");

        account.setName("sunyf");
        account.setEmail("sunyf@changeme.com");
        account.setPassword("this_still_should_be_encrypted");
        account.setActivated(false);

        service.updateAccount(account);

        account = service.readAccount("sunyf");

        assertEquals("sunyf", account.getName());
        assertEquals("sunyf@changeme.com", account.getEmail());
        assertEquals("this_still_should_be_encrypted", account.getPassword());
        assertFalse(account.isActivated());
    }
}
