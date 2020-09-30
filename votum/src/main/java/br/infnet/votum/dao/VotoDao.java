package br.infnet.votum.dao;

import br.infnet.votum.auxiliar.Constante;
import br.infnet.votum.infraestrutura.DaoBase;
import br.infnet.votum.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class VotoDao extends DaoBase<Voto> {

    @Override
    public List<Voto> ObterLista() {

        List<Voto> resultado = new ArrayList<Voto>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(GetDataSourcePath()));

            String linha;
            String[] campos = null;

            while ((linha = reader.readLine()) != null) {
                campos = linha.split(";");
                Proposicao proposicao = new Proposicao(campos[1], campos[2]);
                Pessoa pessoa = null;
                switch (campos[3]) {

                    case "F":
                        pessoa = new PessoaFisica(
                                campos[4],
                                campos[5],
                                LocalDate.parse(campos[6], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        break;
                    case "J":
                        pessoa = new PessoaJuridica(
                                campos[4],
                                campos[5],
                                LocalDate.parse(campos[6], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        break;

                    case "P":
                        pessoa = new PessoaPolitica(
                                campos[4],
                                campos[5],
                                campos[6]);
                        break;

                }

                Voto voto = new Voto(
                        LocalDateTime.parse(campos[0], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                        proposicao,
                        pessoa,
                        campos[7].equals("Sim") ? VotoEnum.Sim : VotoEnum.Nao
                );

                resultado.add(voto);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public String GetDataSourcePath() {
        return Constante.TVOTO;
    }
}
