package com.github.curriculeon.services;

import com.github.curriculeon.repositories.MyRepository;
import com.github.curriculeon.models.MyModel;
import com.github.curriculeon.utils.services.AbstractSimpleService;
import org.springframework.stereotype.Service;

@Service
public class MyService extends AbstractSimpleService<Long, MyModel, MyRepository> {
    public MyService(MyRepository crudRepository) {
        super(crudRepository);
    }

    @Override
    public MyModel update(MyModel originalMyModel, MyModel newMyModelData) {
        originalMyModel.setName(newMyModelData.getName());
        return getRepository().save(originalMyModel);
    }
}
