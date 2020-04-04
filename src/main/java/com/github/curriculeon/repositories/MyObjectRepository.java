package com.github.curriculeon.repositories;

import com.github.curriculeon.models.MyObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyObjectRepository extends CrudRepository<MyObject, Long> {
}
