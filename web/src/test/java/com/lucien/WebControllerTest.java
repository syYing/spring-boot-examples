
package com.lucien;

import com.lucien.web.WebController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    @Test
    public void getUser() throws Exception {
        String responseString = mvc.perform(MockMvcRequestBuilders.post("/getUser"))
            .andReturn().getResponse().getContentAsString();
        System.out.println("result: " + responseString);
    }

    @Test
    public void getUsers() throws Exception {
        String responseString = mvc.perform(MockMvcRequestBuilders.get("/getUsers"))
            .andReturn().getResponse().getContentAsString();
        System.out.println("result: " + responseString);
    }
}
