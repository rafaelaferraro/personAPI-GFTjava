package projetojavaGFT.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetojavaGFT.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
