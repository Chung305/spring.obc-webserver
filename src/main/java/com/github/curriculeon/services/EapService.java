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
    public SignUpForm updateById(Long id, SignUpForm newEntityData) {
        SignUpForm databaseValue = findById(id);
        databaseValue.setCity(newEntityData.getCity());
        databaseValue.setCountry(newEntityData.getCountry());
        databaseValue.setEmail(newEntityData.getEmail());
        databaseValue.setEmailUpdate(newEntityData.isEmailUpdate());
        databaseValue.setName(newEntityData.getName());
        databaseValue.setPhone(newEntityData.getPhone());
        databaseValue.setSignedUpDate(newEntityData.getSignedUpDate());
        databaseValue.setState(newEntityData.getState());
        databaseValue.setZipcode(newEntityData.getZipcode());
        return getRepository().save(databaseValue);
    }


    public SignUpForm contactFormSubmission(SignUpForm signUpForm) {
        return getRepository().save(signUpForm);
    }
}
