package it.nextre.academy.firstexample.repository;
import it.nextre.academy.firstexample.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
}
