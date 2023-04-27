package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.example.model.Person;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    PersonService personService;

    @GetMapping("/home")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Домашняя страница")
    public String home() {
        return "home";
    }

    @GetMapping("/persons")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Получить информацию о всех людях")
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Получить информацию о человеке по id")
    public Person getPersonById(@PathVariable long id) {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @Operation(summary = "Удалить информацию о человеке")
    public void deleteById(@PathVariable long id) {
        personService.deletePersonById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @Operation(summary = "Удалить всю информацию")
    public void deleteAll() {
        personService.deleteAllPersons();
    }

    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Сохранить информацию о человеке")
    public void save(@RequestBody @Valid Person person) {
        personService.save(person);
    }

}
