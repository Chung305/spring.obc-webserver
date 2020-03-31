package com.github.curriculeon.controllers.location;

import com.github.curriculeon.services.location.LocationQuerierImpl;
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
 * @created 03/27/2020 - 6:52 PM
 */
@Controller
@RequestMapping(value = "/state")
public class StateController {
    private LocationQuerierImpl locationQuerier;

    @Autowired
    public StateController(LocationQuerierImpl locationQuerier) {
        this.locationQuerier = locationQuerier;
    }

    @GetMapping("/{countryName}")
    public ResponseEntity<List<String>> findByCountry(@PathVariable String countryName) {
        return new ResponseEntity<>(locationQuerier.getAllStateNames(countryName), HttpStatus.OK);
    }
}
