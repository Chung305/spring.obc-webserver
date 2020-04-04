package com.github.curriculeon.controllers;

import com.github.curriculeon.services.MyObjectService;
import com.github.curriculeon.models.MyObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/my-controller")
public class MyObjectController {
    private MyObjectService service;

    public MyObjectController(MyObjectService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<MyObject>> index() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyObject> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<MyObject> create(@RequestBody MyObject myObject) {
        return new ResponseEntity<>(service.create(myObject), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<MyObject> update(@PathVariable Long id, @RequestBody MyObject myObject) {
        return new ResponseEntity<>(service.update(id, myObject), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyObject> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
