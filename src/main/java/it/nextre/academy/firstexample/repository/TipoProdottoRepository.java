package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.model.TipoProdotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdottoRepository extends JpaRepository<TipoProdotto, Integer> {
    // custom query here
}
