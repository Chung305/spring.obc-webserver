package com.github.curriculeon.controllers;

import com.github.curriculeon.models.eap.UserAccount;
import com.github.curriculeon.repositories.UserAccountRepository;
import com.github.curriculeon.services.UserAccountService;
import com.github.curriculeon.utils.controllers.AbstractSimpleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author leonhunter
 * @created 04/05/2020 - 6:26 PM
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/useraccount")
public class UserAccountController extends AbstractSimpleController<Long, UserAccount, UserAccountRepository, UserAccountService> {
    public UserAccountController(UserAccountService service) {
        super(service);
    }
}
