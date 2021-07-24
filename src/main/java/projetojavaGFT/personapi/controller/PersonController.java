package projetojavaGFT.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetojavaGFT.personapi.DTO.Request.PersonDTO;
import projetojavaGFT.personapi.DTO.response.MessageResponseDTO;
import projetojavaGFT.personapi.exception.PersonNotFoundException;
import projetojavaGFT.personapi.service.PersonService;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {

        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
      return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateByid(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateByid(id, personDTO);

    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);


    }
}
