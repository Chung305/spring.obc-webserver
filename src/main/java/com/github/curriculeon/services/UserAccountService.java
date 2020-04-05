package com.github.curriculeon.services;

import com.github.curriculeon.models.eap.UserAccount;
import com.github.curriculeon.repositories.UserAccountRepository;
import com.github.curriculeon.utils.services.AbstractSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends AbstractSimpleService<Long, UserAccount, UserAccountRepository> {

    @Autowired
    public UserAccountService(UserAccountRepository crudRepository) {
                super(crudRepository);
    }

    @Override
    public UserAccount update(UserAccount existingData, UserAccount newEntityData) {
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

    public UserAccount contactFormSubmission(UserAccount signUpForm) {
        return getRepository().save(signUpForm);
    }
}
