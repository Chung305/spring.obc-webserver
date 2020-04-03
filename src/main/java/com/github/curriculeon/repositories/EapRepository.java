package com.github.curriculeon.repositories;

import com.github.curriculeon.models.eap.SignUpForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EapRepository extends CrudRepository<SignUpForm, Long> {
}
