package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.dto.ProdottoDemoDto;
import it.nextre.academy.firstexample.model.ProdottoDemo;
import it.nextre.academy.firstexample.repository.ProdottoDemoRepositoryFake;
import it.nextre.academy.firstexample.service.ProdottoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoDemoServiceImpl implements ProdottoDemoService {

    @Autowired
    ProdottoDemoRepositoryFake prodottoRepository;

    @Override
    public List<ProdottoDemo> getLastProduct(int max) {
        return prodottoRepository.getLasts(max);
    }

    @Override
    public ProdottoDemoDto toDto(ProdottoDemo prodotto) {
        return new ProdottoDemoDto(
                prodotto.getId(),
                prodotto.getNome(),
                prodotto.getDescrizione(),
                prodotto.getPrezzo()
        );
    }

    @Override
    public ProdottoDemo getOneById(Integer id) {
        return prodottoRepository.getById(id);
    }
}//end class
