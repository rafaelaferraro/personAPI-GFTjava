package projetojavaGFT.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projetojavaGFT.personapi.DTO.MessageResponseDTO;
import projetojavaGFT.personapi.entity.Person;
import projetojavaGFT.personapi.repository.PersonRepository;

@Service

public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with Id" + savedPerson.getId())
                .build();
    }

}
