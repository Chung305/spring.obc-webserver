package com.github.curriculeon.services;

import com.github.curriculeon.models.MyObject;
import com.github.curriculeon.repositories.MyObjectRepository;
import com.github.curriculeon.utils.services.AbstractSimpleService;
import org.springframework.stereotype.Service;

@Service
public class MyObjectService extends AbstractSimpleService<Long, MyObject, MyObjectRepository> {
    public MyObjectService(MyObjectRepository crudRepository) {
        super(crudRepository);
    }

    @Override
    public MyObject update(MyObject originalMyObject, MyObject newEntityData) {
        originalMyObject.setName(newEntityData.getName());
        return getRepository().save(originalMyObject);
    }
}
