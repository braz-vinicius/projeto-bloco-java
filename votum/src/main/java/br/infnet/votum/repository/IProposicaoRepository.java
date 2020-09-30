package br.infnet.votum.repository;

import br.infnet.votum.model.Proposicao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProposicaoRepository extends CrudRepository<Proposicao,Integer> {
}
