package br.infnet.votum.infraestrutura;

import java.io.*;

public abstract class DaoBase<TEntity> implements IDaoBase<TEntity> {

    @Override
    public void Incluir(TEntity entidade) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(GetDataSourcePath(), true));
            writer.write(entidade + "\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
