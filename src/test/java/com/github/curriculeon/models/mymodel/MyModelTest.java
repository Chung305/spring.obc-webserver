package com.github.curriculeon.models.mymodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.curriculeon.models.MyModel;
import com.github.curriculeon.utils.services.EntityInterface;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;


public class MyModelTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(MyModel.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        MyModel myModel = new MyModel();
        String json = jsonWriter.writeValueAsString(myModel);
    }

    @Test
    public void testEntityInterface() {
        Assert.assertTrue(new MyModel() instanceof EntityInterface);
    }
}
