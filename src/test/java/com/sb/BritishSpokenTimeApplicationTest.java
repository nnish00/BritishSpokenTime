package com.sb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BritishSpokenTimeApplicationTest {

    @Autowired
    private BritishSpokenTimeApplication britishSpokenTimeApplication;

    @Test
    public void contextLoads() {
        assertNotNull(britishSpokenTimeApplication);
    }

    @Test
    public void testMainMethod() {
         BritishSpokenTimeApplication.main(new String[] {});
    }

}

