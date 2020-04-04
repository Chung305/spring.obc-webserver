package com.github.curriculeon.services.mymodel;

import com.github.curriculeon.MyApplication;
import com.github.curriculeon.controllers.MyController;
import com.github.curriculeon.models.MyModel;
import com.github.curriculeon.services.MyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leonhunter
 * @created 04/04/2020 - 12:26 AM
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyApplication.class)
public class TestShow {
    @MockBean
    private MyService service;

    private MyController controller;

    @Before
    public void setup() {
        this.controller = new MyController(service);
    }

    @Test
    public void testShow() {
        // Given
        Long expectedId = 1L;
        HttpStatus expected = HttpStatus.OK;
        MyModel expectedMyModel = new MyModel();
        expectedMyModel.setId(expectedId);
        BDDMockito.
                given(service.findById(1L))
                .willReturn(expectedMyModel);

        // When
        ResponseEntity<MyModel> response = controller.show(expectedId);
        HttpStatus actual = response.getStatusCode();
        MyModel actualMyModel = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMyModel, actualMyModel);
    }
}
