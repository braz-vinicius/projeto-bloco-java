package br.infnet.votum.dao;

import br.infnet.votum.auxiliar.Constante;
import br.infnet.votum.infraestrutura.DaoBase;
import br.infnet.votum.model.PessoaFisica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDao extends DaoBase<PessoaFisica> {
    @Override
    public List<PessoaFisica> ObterLista() {
        List<PessoaFisica> resultado = new ArrayList<PessoaFisica>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(GetDataSourcePath()));

            String linha;
            String[] campos = null;

            while ((linha = reader.readLine()) != null) {
                campos = linha.split(";");
                PessoaFisica pessoaFisica = new PessoaFisica(
                        campos[1],
                        campos[2],
                        LocalDate.parse(campos[3], DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                resultado.add(pessoaFisica);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public String GetDataSourcePath() {
        return Constante.TPESSOAFISICA;
    }
}
