package br.infnet.votum.repository;

import br.infnet.votum.model.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVotoRepository extends CrudRepository<Voto,Integer> {
}
