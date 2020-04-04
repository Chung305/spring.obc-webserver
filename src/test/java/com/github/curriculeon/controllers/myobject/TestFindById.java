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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

/**
 * @author leonhunter
 * @created 04/04/2020 - 12:20 AM
 */

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TestFindById {
    @Autowired
    private MockMvc mvc;


    @MockBean
    private MyObjectRepository repository;

    @Test
    public void test1() throws Exception {
        test(1L);
    }

    @Test
    public void test2() throws Exception {
        test(2L);
    }

    @Test
    public void test3() throws Exception {
        test(3L);
    }

    private void test(Long givenId) throws Exception {
        MyObject myObject = new MyObject();
        BDDMockito
                .given(repository.findById(givenId))
                .willReturn(Optional.of(myObject));
        String expectedContent = new ObjectMapper().writeValueAsString(myObject);
        this.mvc.perform(MockMvcRequestBuilders
                .get("/my-controller/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

}
