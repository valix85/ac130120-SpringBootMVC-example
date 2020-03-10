package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.dto.ProdottoDto;
import it.nextre.academy.firstexample.model.Prodotto;
import it.nextre.academy.firstexample.repository.ProdottoRepositoryFake;
import it.nextre.academy.firstexample.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService {

    @Autowired
    ProdottoRepositoryFake prodottoRepository;

    @Override
    public List<Prodotto> getLastProduct(int max) {
        return prodottoRepository.getLasts(max);
    }

    @Override
    public ProdottoDto toDto(Prodotto prodotto) {
        return new ProdottoDto(
                prodotto.getId(),
                prodotto.getNome(),
                prodotto.getDescrizione(),
                prodotto.getPrezzo()
        );
    }

    @Override
    public Prodotto getOneById(Integer id) {
        return prodottoRepository.getById(id);
    }
}//end class
