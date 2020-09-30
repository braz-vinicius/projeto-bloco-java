package br.infnet.votum.infraestrutura;

import java.util.List;

public interface IDaoBase<TEntity> {
    public List<TEntity> ObterLista();
    public void Incluir(TEntity entidade);
    public String GetDataSourcePath();
}
