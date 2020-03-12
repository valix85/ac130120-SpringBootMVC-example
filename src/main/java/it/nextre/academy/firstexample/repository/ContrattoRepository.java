package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.Contratto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContrattoRepository extends JpaRepository<Contratto, Integer> {
    // custom query here
}//end class
