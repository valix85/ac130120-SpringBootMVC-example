package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.TipoGuasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoGuastoRepository extends JpaRepository<TipoGuasto, Integer> {
    // custom query here
}
