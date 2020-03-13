package it.nextre.academy.firstexample.service;

import it.nextre.academy.firstexample.dto.AssistenzaDTO;
import it.nextre.academy.firstexample.model.Assistenza;

import java.util.List;

public interface AssistenzaService {
    List<Assistenza> findAll();

    Assistenza findById(Integer id);

    Assistenza insert(Assistenza assistenza);

    Assistenza update(Integer id, Assistenza assistenza);

    Boolean delete(Integer id);

    Assistenza toAssistenza(AssistenzaDTO dto);
}//end class
