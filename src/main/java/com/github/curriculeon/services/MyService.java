package com.github.curriculeon.services;

import com.github.curriculeon.repositories.MyRepository;
import com.github.curriculeon.models.MyModel;

public class MyService {
    private MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public Iterable<MyModel> index() {
        return repository.findAll();
    }

    public MyModel show(Long id) {
        return repository.findById(id).get();
    }

    public MyModel create(MyModel myModel) {
        return repository.save(myModel);
    }

    public MyModel update(Long id, MyModel newMyModelData) {
        MyModel originalMyModel = repository.findById(id).get();
        originalMyModel.setName(newMyModelData.getName());
        return repository.save(originalMyModel);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
