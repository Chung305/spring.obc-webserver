package com.github.curriculeon.controllers.eap;

import com.github.curriculeon.models.eap.SignUpForm;
import com.github.curriculeon.services.EapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author frankierodriguez
 * @created 04/03/2020 - 6:52 PM
 */
@Controller
@CrossOrigin
@RequestMapping("/eap/")
public class FormController {

    @Autowired
    private EapService eapService;

    @RequestMapping("form/contact")
    public ResponseEntity<?> contactFormSubmission(SignUpForm signUpForm){
        try {
            return new ResponseEntity<>(getService().contactFormSubmission(signUpForm), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private EapService getService() {
        return eapService;
    }


}
