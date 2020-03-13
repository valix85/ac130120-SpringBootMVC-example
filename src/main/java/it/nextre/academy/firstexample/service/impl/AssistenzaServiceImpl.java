package it.nextre.academy.firstexample.service.impl;
import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.customException.ResourceNotFoundException;
import it.nextre.academy.firstexample.dto.AssistenzaDTO;
import it.nextre.academy.firstexample.model.Assistenza;
import it.nextre.academy.firstexample.model.Catalogo;
import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.repository.AssistenzaRepository;
import it.nextre.academy.firstexample.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.List;
@Service
@Slf4j
public class AssistenzaServiceImpl implements AssistenzaService {
    @Autowired
    AssistenzaRepository assistenzaRepository;

    @Autowired
    ProdottoService prodottoService;

    @Autowired
    AssegnatarioService assegnatarioService;

    @Autowired
    TipoGuastoService tipoGuastoService;

    @Autowired
    EsitoService esitoService;



    @Override
    public List<Assistenza> findAll() {
        return assistenzaRepository.findAll();
    }
    @Override
    public Assistenza findById(Integer id) {
        return assistenzaRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
    @Override
    public Assistenza insert(Assistenza assistenza) {
        if (assistenza != null && assistenza.getId() != null &&
                assistenza.getIdProdotto() != null &&
                assistenza.getIdAssegnatario() != null &&
                assistenza.getCosto_riparazione() != null &&
                assistenza.getTipoGuasto() != null &&
                assistenza.getEsito() != null) {
            return assistenzaRepository.save(assistenza);
        }
        throw new BadDataException("Dati assistenza non validi");
    }
    @Override
    public Boolean delete(Integer id) {
        if (assistenzaRepository.findById(id).isPresent()) {
            assistenzaRepository.deleteById(id);
            return true;
        }
        throw new BadDataException();
    }

    @Override
    public Assistenza update(Integer id, Assistenza assistenza) {
        // todo fare metodo
        return null;
    }

    @Override
    public Assistenza toAssistenza(AssistenzaDTO assistenzaDto) {
        Assistenza tmp = new Assistenza();
        tmp.setId(assistenzaDto.getId());
        tmp.setIdProdotto(prodottoService.findOneById(assistenzaDto.getIdProdotto()));
        tmp.setIdAssegnatario(assegnatarioService.findOneById(assistenzaDto.getIdAssegnatario()));
        tmp.setData_inizio(assistenzaDto.getData_inizio());
        tmp.setData_fine(assistenzaDto.getData_fine());
        tmp.setCosto_riparazione(assistenzaDto.getCosto_riparazione());
        tmp.setNote(assistenzaDto.getNote());
        tmp.setTipoGuasto(tipoGuastoService.findOneById(assistenzaDto.getId()));
        tmp.setIn_garanzia(assistenzaDto.getIn_garanzia());
        tmp.setEsito(esitoService.findOneById(assistenzaDto.getEsito()));
        tmp.setFattura_cliente(assistenzaDto.getFattura_cliente());
        return tmp;
    }
}//end class
