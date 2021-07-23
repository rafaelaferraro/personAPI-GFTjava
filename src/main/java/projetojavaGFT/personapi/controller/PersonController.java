package projetojavaGFT.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetojavaGFT.personapi.DTO.MessageResponseDTO;
import projetojavaGFT.personapi.entity.Person;
import projetojavaGFT.personapi.repository.PersonRepository;
import projetojavaGFT.personapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
    }
}
