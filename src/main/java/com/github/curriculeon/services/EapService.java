package com.github.curriculeon.services;

import com.github.curriculeon.models.eap.SignUpForm;
import com.github.curriculeon.repositories.EapRepository;
import com.github.curriculeon.utils.services.AbstractSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EapService extends AbstractSimpleService<Long, SignUpForm, EapRepository> {

    @Autowired
    public EapService(EapRepository crudRepository) {
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
        return getRepository().save(existingData);
    }

    public SignUpForm contactFormSubmission(SignUpForm signUpForm) {
        return getRepository().save(signUpForm);
    }
}
