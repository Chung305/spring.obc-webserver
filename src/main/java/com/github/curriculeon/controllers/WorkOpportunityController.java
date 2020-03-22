package com.github.curriculeon.controllers;

import com.github.curriculeon.models.workopportunity.WorkOpportunity;
import com.github.curriculeon.services.WorkOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author leonhunter
 * @created 03/22/2020 - 5:19 PM
 */

@Controller
@RequestMapping(value = "/workopportunity")
public class WorkOpportunityController {
    private WorkOpportunityService service;

    @Autowired
    public WorkOpportunityController(WorkOpportunityService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<WorkOpportunity>> index() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOpportunity> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<WorkOpportunity> create(@RequestBody WorkOpportunity myModel) {
        return new ResponseEntity<>(service.create(myModel), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<WorkOpportunity> update(@PathVariable Long id, @RequestBody WorkOpportunity myModel) {
        return new ResponseEntity<>(service.update(id, myModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkOpportunity> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
