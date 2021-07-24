package projetojavaGFT.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetojavaGFT.personapi.DTO.Request.PersonDTO;
import projetojavaGFT.personapi.DTO.response.MessageResponseDTO;
import projetojavaGFT.personapi.Mapper.PersonMapper;
import projetojavaGFT.personapi.entity.Person;
import projetojavaGFT.personapi.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with Id" + savedPerson.getId())
                .build();
    }

}
