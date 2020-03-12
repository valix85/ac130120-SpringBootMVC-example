package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.Esito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EsitoRepository extends JpaRepository<Esito, Integer>
{
    //custom query here
}//end class