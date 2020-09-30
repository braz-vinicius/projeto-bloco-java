package br.infnet.votum.dao;

import br.infnet.votum.auxiliar.Constante;
import br.infnet.votum.infraestrutura.DaoBase;
import br.infnet.votum.infraestrutura.IDaoBase;
import br.infnet.votum.model.Proposicao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProposicaoDao extends DaoBase<Proposicao> {

    @Override
    public List<Proposicao> ObterLista() {
        List<Proposicao> resultado = new ArrayList<Proposicao>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(GetDataSourcePath()));

            String linha;
            String[] campos = null;

            while ((linha = reader.readLine()) != null) {
                campos = linha.split(";");
                Proposicao proposicao = new Proposicao(campos[0], campos[1]);
                resultado.add(proposicao);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public String GetDataSourcePath() {
        return Constante.TPROPOSICAO;
    }
}
