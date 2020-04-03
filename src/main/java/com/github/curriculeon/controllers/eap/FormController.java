package com.github.curriculeon.controllers.eap;

import com.github.curriculeon.models.eap.SignUpForm;
import com.github.curriculeon.services.EapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/eap/")
public class FormController {

    @Autowired
    private EapService eapService;

    @RequestMapping("form/contact")
    public ResponseEntity<?> contactFormSubmission(SignUpForm signUpForm){
        return eapService.contactFormSubmission(signUpForm);
    }
}
