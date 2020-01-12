package com.codegym.controllers;

import com.codegym.models.Clazz;
import com.codegym.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClassController {
    @Autowired
    private ClassService classService;
    @GetMapping("/api/class/")
    ResponseEntity<List<Clazz>> getClassList(){
        List<Clazz> clazzList = classService.findAllClass();
        if(clazzList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<List<Clazz>>(clazzList, HttpStatus.OK);
    }

    @PostMapping("/api/class/")
    ResponseEntity<Clazz> createClass(@RequestBody Clazz clazz, UriComponentsBuilder ucBuilder){
        classService.saveClass(clazz);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/class/{id}").buildAndExpand(clazz.getClassId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}