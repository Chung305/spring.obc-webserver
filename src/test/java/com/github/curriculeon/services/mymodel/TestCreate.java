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
 * @created 04/04/2020 - 12:25 AM
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyApplication.class)
public class TestCreate {
    @MockBean
    private MyService service;

    @Test
    public void test1() {
        MyModel expectedMyModel = new MyModel();
        expectedMyModel.setId(0L);
        expectedMyModel.setName("First test");
        test(expectedMyModel);
    }

    @Test
    public void test2() {
        MyModel expectedMyModel = new MyModel();
        expectedMyModel.setId(1L);
        expectedMyModel.setName("Second test");
        test(expectedMyModel);
    }

    @Test
    public void test3() {
        MyModel expectedMyModel = new MyModel();
        expectedMyModel.setId(2L);
        expectedMyModel.setName("Third test");
        test(expectedMyModel);
    }

    // given
    private void test(MyModel expectedMyModel) {
        MyController controller = new MyController(service);
        HttpStatus expected = HttpStatus.CREATED;
        BDDMockito
                .given(service.create(expectedMyModel))
                .willReturn(expectedMyModel);

        // When
        ResponseEntity<MyModel> response = controller.create(expectedMyModel);
        HttpStatus actual = response.getStatusCode();
        MyModel actualMyModel = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMyModel, actualMyModel);
    }


}
