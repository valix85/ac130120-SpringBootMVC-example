package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.Catalogo;
import it.nextre.academy.firstexample.model.TipoProdotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
    // custom query here
}
