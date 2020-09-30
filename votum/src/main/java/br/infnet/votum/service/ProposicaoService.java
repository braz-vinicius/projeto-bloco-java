package br.infnet.votum.service;

import br.infnet.votum.model.Proposicao;
import br.infnet.votum.repository.IProposicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProposicaoService {

    private final IProposicaoRepository proposicaoRepository;

    public ProposicaoService(@Autowired IProposicaoRepository proposicaoRepository) {
        this.proposicaoRepository = proposicaoRepository;
    }

    public List<Proposicao> obterLista() {
        return (List<Proposicao>) proposicaoRepository.findAll();
    }

    public void incluir(Proposicao proposicao) {
        proposicaoRepository.save(proposicao);
    }
}
