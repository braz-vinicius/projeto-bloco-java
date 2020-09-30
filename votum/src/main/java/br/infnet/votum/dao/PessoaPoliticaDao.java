package br.infnet.votum.dao;

import br.infnet.votum.auxiliar.Constante;
import br.infnet.votum.infraestrutura.DaoBase;
import br.infnet.votum.model.PessoaPolitica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PessoaPoliticaDao extends DaoBase<PessoaPolitica> {
    @Override
    public List<PessoaPolitica> ObterLista() {
        List<PessoaPolitica> resultado = new ArrayList<PessoaPolitica>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(GetDataSourcePath()));

            String linha;
            String[] campos = null;

            while ((linha = reader.readLine()) != null) {
                campos = linha.split(";");
                PessoaPolitica pessoa = new PessoaPolitica(
                        campos[0],
                        campos[1],
                        campos[2]);

                resultado.add(pessoa);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public String GetDataSourcePath() {
        return Constante.TPESSOAPOLITICA;
    }
}
