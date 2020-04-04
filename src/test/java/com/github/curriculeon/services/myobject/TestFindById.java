package com.github.curriculeon.services.myobject;

import com.github.curriculeon.MyApplication;
import com.github.curriculeon.controllers.MyObjectController;
import com.github.curriculeon.models.MyObject;
import com.github.curriculeon.services.MyObjectService;
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
public class TestFindById {
    @MockBean
    private MyObjectService service;

    private MyObjectController controller;

    @Before
    public void setup() {
        this.controller = new MyObjectController(service);
    }

    @Test
    public void testShow() {
        // Given
        Long expectedId = 1L;
        HttpStatus expected = HttpStatus.OK;
        MyObject expectedMyObject = new MyObject();
        expectedMyObject.setId(expectedId);
        BDDMockito.
                given(service.findById(1L))
                .willReturn(expectedMyObject);

        // When
        ResponseEntity<MyObject> response = controller.show(expectedId);
        HttpStatus actual = response.getStatusCode();
        MyObject actualMyObject = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMyObject, actualMyObject);
    }
}
