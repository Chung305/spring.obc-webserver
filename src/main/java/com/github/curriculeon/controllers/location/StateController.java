package com.github.curriculeon.controllers.location;

import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountry;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountryResult;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leonhunter
 * @created 03/27/2020 - 6:52 PM
 */
@Controller
@RequestMapping(value = "/state")
public class StateController {
    private static final String endpoint = "https://api.printful.com/countries";

    @GetMapping("/{countryName}")
    public ResponseEntity<List<String>> findByCountry(@PathVariable String countryName) {
        PrintfulCountryResult response = new RestTemplate().getForObject(endpoint, PrintfulCountryResult.class);
        System.out.println(response);
        List<PrintfulCountry> countries = response.getResult();

        return new ResponseEntity<>(response
                .getResult()
                .stream()
                .filter(country -> country.getName().equals(countryName))
                .findFirst()
                .get()
                .getStates()
                .stream()
                .map(PrintfulState::getName)
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
