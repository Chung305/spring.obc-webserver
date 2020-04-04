package com.github.curriculeon.services.myobject;

import com.github.curriculeon.MyApplication;
import com.github.curriculeon.controllers.MyObjectController;
import com.github.curriculeon.models.MyObject;
import com.github.curriculeon.services.MyObjectService;
import org.junit.Assert;
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
    private MyObjectService service;

    @Test
    public void test1() {
        MyObject expectedMyObject = new MyObject();
        expectedMyObject.setId(0L);
        expectedMyObject.setName("First test");
        test(expectedMyObject);
    }

    @Test
    public void test2() {
        MyObject expectedMyObject = new MyObject();
        expectedMyObject.setId(1L);
        expectedMyObject.setName("Second test");
        test(expectedMyObject);
    }

    @Test
    public void test3() {
        MyObject expectedMyObject = new MyObject();
        expectedMyObject.setId(2L);
        expectedMyObject.setName("Third test");
        test(expectedMyObject);
    }

    // given
    private void test(MyObject expectedMyObject) {
        MyObjectController controller = new MyObjectController(service);
        HttpStatus expected = HttpStatus.CREATED;
        BDDMockito
                .given(service.create(expectedMyObject))
                .willReturn(expectedMyObject);

        // When
        ResponseEntity<MyObject> response = controller.create(expectedMyObject);
        HttpStatus actual = response.getStatusCode();
        MyObject actualMyObject = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMyObject, actualMyObject);
    }


}
