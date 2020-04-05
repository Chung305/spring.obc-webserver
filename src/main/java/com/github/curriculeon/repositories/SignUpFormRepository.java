package com.github.curriculeon.repositories;

import com.github.curriculeon.models.eap.SignUpForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leonhunter
 * @created 04/05/2020 - 6:29 PM
 */
@Repository
public interface SignUpFormRepository extends CrudRepository<SignUpForm, Long> {
}
