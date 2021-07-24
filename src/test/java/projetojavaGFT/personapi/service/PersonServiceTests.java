package projetojavaGFT.personapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import projetojavaGFT.personapi.DTO.Request.PersonDTO;
import projetojavaGFT.personapi.DTO.response.MessageResponseDTO;
import projetojavaGFT.personapi.entity.Person;
import projetojavaGFT.personapi.repository.PersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static projetojavaGFT.personapi.Utils.PersonUtils.createFakeDTO;
import static projetojavaGFT.personapi.Utils.PersonUtils.createFakeEntity;

@ExtendWith({MockitoExtension.class})
public class PersonServiceTests {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccesMessage = createdExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccesMessage, succesMessage);

    }

    private MessageResponseDTO createdExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with Id" + id)
                .build();
    }

}
