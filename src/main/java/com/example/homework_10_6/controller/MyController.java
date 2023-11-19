package com.example.homework_10_6.controller;

import com.example.homework_10_6.entity.Person;
import com.example.homework_10_6.repository.MyRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class MyController {

    private MyRepository repository;

    @GetMapping("/by_city")
    public List<Person> getByCity(@RequestParam("city") String city) {
        return repository.findByCity(city);
    }

    @GetMapping("/by_age")
    public List<Person> getByAge(@RequestParam("age") int age) {
        return repository.findByPersonData_AgeLessThan(age);
    }


    @GetMapping("/by_name")
    public Optional<Person> getByAge(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return repository.findByPersonData_NameAndPersonData_Surname(name, surname);
    }
}
