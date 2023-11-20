package com.example.homework_10_6.controller;

import com.example.homework_10_6.entity.Person;
import com.example.homework_10_6.repository.MyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/security")
@AllArgsConstructor
public class MyControllerSecurity {

    private MyRepository repository;

    @GetMapping("/by_city")
    @Secured("ROLE_READ")
    public List<Person> getByCity(@RequestParam("city") String city) {
        return repository.findByCity(city);
    }

    @GetMapping("/by_age")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> getByAge(@RequestParam("age") int age) {
        return repository.findByPersonData_AgeLessThan(age);
    }


    @GetMapping("/by_name")
    @PreAuthorize("hasAnyRole('ROLE_WRITE','ROLE_DELETE')")
    public Optional<Person> getByAge(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return repository.findByPersonData_NameAndPersonData_Surname(name, surname);
    }

    @GetMapping("/by_username")
    @PreAuthorize("#username == authentication.principal.username")
    public String getUserName(@RequestParam("username") String username) {
        return "Hello" + username;
    }
}