package com.rory.repository;


import com.rory.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class UserRepositoryTest {
    //获取上下文
    private ApplicationContext ctx = null;
    private UserRepository userRepository = null;

    @Before
    public void setup() {
        System.out.println("setup is working......");
        ctx = new ClassPathXmlApplicationContext("spring-jpa.xml");
        userRepository = ctx.getBean(UserRepository.class);
    }

    @After
    public void destory() {
        ctx = null;
        System.out.println("destory is working......");
    }

    @Test
    public void testEntityManagerFctory() {

    }

    @Test
    public void findByName() {
        User user = userRepository.findByName("leo");
        System.out.println(user);
    }

    @Test
    public void findAll() {
        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }
    }
    @Test
    public void findQuery() {
        User user = userRepository.findMaxIdUser();
        System.out.println(user);

    }
    @Test
    public void update() {
        User user = userRepository.findMaxIdUser();
        System.out.println(user);

    }
    @Test
    public void deletete() {
        userRepository.deleteById(2);


    }
}