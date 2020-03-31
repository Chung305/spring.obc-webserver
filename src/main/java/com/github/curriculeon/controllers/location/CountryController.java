package com.github.curriculeon.controllers.location;

import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountry;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulState;
import com.github.curriculeon.services.location.CountryControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author leonhunter
 * @created 03/27/2020 - 5:17 PM
 * perhaps integrate  https://api.printful.com/countries
 */
@Controller
@RequestMapping(value = "/country")
public class CountryController {
    private CountryControllerService service;

    @Autowired
    public CountryController(CountryControllerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<PrintfulCountry>> all() {
        return new ResponseEntity<>(service.all(), HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> names() {
        return new ResponseEntity<>(service.names(), HttpStatus.OK);
    }

    @GetMapping("/{countryName}")
    public ResponseEntity<PrintfulCountry> getCountry(
            @PathVariable String countryName) {
        return new ResponseEntity<>(service.getCountry(countryName), HttpStatus.OK);
    }

    @GetMapping("/{countryName}/states")
    public ResponseEntity<List<PrintfulState>> getAllStates(
            @PathVariable String countryName) {
        return new ResponseEntity<>(service.getAllStates(countryName), HttpStatus.OK);
    }


    @GetMapping("/{countryName}/states/names")
    public ResponseEntity<List<String>> getAllStateNames(
            @PathVariable String countryName) {
        return new ResponseEntity<>(service.getAllStateNames(countryName), HttpStatus.OK);
    }

    @GetMapping("/{countryName}/states/{stateName}")
    public ResponseEntity<PrintfulState> getState(
            @PathVariable String countryName,
            @PathVariable String stateName) {
        return new ResponseEntity<>(service.getState(countryName, stateName), HttpStatus.OK);
    }
}
