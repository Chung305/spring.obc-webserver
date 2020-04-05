package com.github.curriculeon.services;

import com.github.curriculeon.models.eap.SignUpForm;
import com.github.curriculeon.repositories.SignUpFormRepository;
import com.github.curriculeon.utils.services.AbstractSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leonhunter
 * @created 04/05/2020 - 6:29 PM
 */
@Service
public class SignUpFormService extends AbstractSimpleService<Long, SignUpForm, SignUpFormRepository> {
    @Autowired
    public SignUpFormService(SignUpFormRepository crudRepository) {
        super(crudRepository);
    }

    @Override
    public SignUpForm update(SignUpForm existingData, SignUpForm newEntityData) {
        existingData.setCity(newEntityData.getCity());
        existingData.setCountry(newEntityData.getCountry());
        existingData.setEmail(newEntityData.getEmail());
        existingData.setEmailUpdate(newEntityData.isEmailUpdate());
        existingData.setName(newEntityData.getName());
        existingData.setPhone(newEntityData.getPhone());
        existingData.setSignedUpDate(newEntityData.getSignedUpDate());
        existingData.setState(newEntityData.getState());
        existingData.setZipcode(newEntityData.getZipcode());
        return existingData;
    }
}
