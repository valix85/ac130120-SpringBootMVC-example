package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.Noleggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NoleggioRepository extends JpaRepository<Noleggio, Integer> {
}//end class
