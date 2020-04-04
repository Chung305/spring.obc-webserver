package com.github.curriculeon.services;

import com.github.curriculeon.models.eap.SignUpForm;
import com.github.curriculeon.repositories.EapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EapService {

    @Autowired
    private EapRepository eapRepository;


    public ResponseEntity<?> contactFormSubmission(SignUpForm signUpForm) {
        ResponseEntity<?> responseEntity;

        try {

            responseEntity = new ResponseEntity<>(eapRepository.save(signUpForm), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        return responseEntity;
    }
}
