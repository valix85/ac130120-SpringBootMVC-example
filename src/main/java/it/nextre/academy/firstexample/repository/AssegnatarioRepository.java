package it.nextre.academy.firstexample.repository;
import it.nextre.academy.firstexample.model.Assegnatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssegnatarioRepository extends JpaRepository<Assegnatario,Integer> {
}