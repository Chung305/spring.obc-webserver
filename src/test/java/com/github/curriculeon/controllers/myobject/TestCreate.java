package com.github.curriculeon.controllers.myobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.curriculeon.models.MyObject;
import com.github.curriculeon.repositories.MyObjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author leonhunter
 * @created 04/04/2020 - 12:22 AM
 */
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TestCreate {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MyObjectRepository repository;

    @Test
    public void testCreate() throws Exception {
        test(new MyObject());
    }

    private void test(MyObject myObject) throws Exception {
        BDDMockito
                .given(repository.save(myObject))
                .willReturn(myObject);

        String expectedContent = new ObjectMapper().writeValueAsString(myObject);
        this.mvc.perform(MockMvcRequestBuilders
                .post("/my-controller/")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
