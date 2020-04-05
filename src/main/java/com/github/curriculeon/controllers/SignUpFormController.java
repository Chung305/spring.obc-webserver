package com.github.curriculeon.controllers;

import com.github.curriculeon.models.eap.SignUpForm;
import com.github.curriculeon.repositories.SignUpFormRepository;
import com.github.curriculeon.services.SignUpFormService;
import com.github.curriculeon.utils.controllers.AbstractSimpleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author leonhunter
 * @created 04/05/2020 - 6:26 PM
 */
@Controller
@RequestMapping(value = "/signup")
public class SignUpFormController extends AbstractSimpleController<Long, SignUpForm, SignUpFormRepository, SignUpFormService> {
    @Autowired
    public SignUpFormController(SignUpFormService service) {
        super(service);
    }
}
