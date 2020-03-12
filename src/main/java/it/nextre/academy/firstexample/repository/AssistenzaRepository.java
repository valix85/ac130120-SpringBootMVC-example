package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.Assistenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssistenzaRepository extends JpaRepository<Assistenza, Integer> {
}//end class
