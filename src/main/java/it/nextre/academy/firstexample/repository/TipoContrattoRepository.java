package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.TipoContratto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContrattoRepository extends JpaRepository<TipoContratto, Integer> {
}