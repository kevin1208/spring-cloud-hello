package com.kevin.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by Kevin on 2018/1/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = TestController.class)
//@AutoConfigureRestDocs("classpath:application.yml")
//@ContextConfiguration({"classpath:application.yml"})
public class TestControllerTester {

    @Autowired
    private MockMvc mockMvc;

    @Value("${server.port}")
    private String value;

    @Test
    public void hi() throws Exception {
        System.out.println(value + "===================");
        mockMvc.perform(MockMvcRequestBuilders.get("/base/url/test?name=abc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hi abc,i am test port: 8763"));
    }

}
