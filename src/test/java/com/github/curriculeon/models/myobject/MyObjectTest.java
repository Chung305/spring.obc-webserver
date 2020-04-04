package com.github.curriculeon.models.myobject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.curriculeon.models.MyObject;
import com.github.curriculeon.utils.services.EntityInterface;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;


public class MyObjectTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(MyObject.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        MyObject myObject = new MyObject();
        String json = jsonWriter.writeValueAsString(myObject);
    }

    @Test
    public void testEntityInterface() {
        Assert.assertTrue(new MyObject() instanceof EntityInterface);
    }
}
