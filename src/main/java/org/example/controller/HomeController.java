package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Person;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    PersonService personService;

    @GetMapping("/home")
    @Operation(summary = "Домашняя страница")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    @Operation(summary = "Получить информацию о всех людях")
    public Map<Long, Person> getUsers() {
        return personService.getPersonMap();
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "Получить информацию о человеке по id")
    public Person getUserById(@PathVariable long id) {
        return personService.getPersonMap().get(id);
    }

    @PostMapping("/save")
    @Operation(summary = "Сохранить информацию о человеке")
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

}
