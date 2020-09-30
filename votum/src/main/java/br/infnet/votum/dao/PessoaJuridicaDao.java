package br.infnet.votum.dao;

import br.infnet.votum.auxiliar.Constante;
import br.infnet.votum.infraestrutura.DaoBase;
import br.infnet.votum.model.PessoaJuridica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDao extends DaoBase<PessoaJuridica> {
    @Override
    public List<PessoaJuridica> ObterLista() {

        List<PessoaJuridica> resultado = new ArrayList<PessoaJuridica>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(GetDataSourcePath()));

            String linha;
            String[] campos = null;

            while ((linha = reader.readLine()) != null) {
                campos = linha.split(";");
                PessoaJuridica pessoaJuridica = new PessoaJuridica(
                        campos[0],
                        campos[1],
                        LocalDate.parse(campos[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                resultado.add(pessoaJuridica);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;

    }

    @Override
    public String GetDataSourcePath() {
        return Constante.TPESSOAJURIDICA;
    }
}
