package br.infnet.votum.service;

import br.infnet.votum.model.Voto;
import br.infnet.votum.repository.IProposicaoRepository;
import br.infnet.votum.repository.IVotoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VotoService {

    private final IVotoRepository votoRepository;
    private final IProposicaoRepository proposicaoService;

    public VotoService(IVotoRepository votoRepository, IProposicaoRepository proposicaoService) {

        this.votoRepository = votoRepository;
        this.proposicaoService = proposicaoService;
    }

    public void incluir(Voto voto) {
        voto.setDataHoraVoto(LocalDateTime.now());
        this.votoRepository.save(voto);
    }

    public List<Voto> obterLista(){

        return (List<Voto>) this.votoRepository.findAll();
    }
}
