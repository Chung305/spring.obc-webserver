package com.github.curriculeon.controllers;

import com.github.curriculeon.models.workopportunity.CountryEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leonhunter
 * @created 03/27/2020 - 5:17 PM
 * perhaps integrate  https://api.printful.com/countries
 */
@Controller
@RequestMapping(value = "/country")
public class CountryController {

    @GetMapping("/")
    public ResponseEntity<List<String>> index() {
        return new ResponseEntity<>(Arrays.asList(CountryEnum.values())
                .stream()
                .map(country -> country.name())
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
