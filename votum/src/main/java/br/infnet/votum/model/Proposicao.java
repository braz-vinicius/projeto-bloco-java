package br.infnet.votum.model;

import javax.persistence.*;

@Entity
@Table(name = "Proposicao")
public class Proposicao {
    private String nomeProposicao;
    private String tema;
    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public String getNomeProposicao() {
        return nomeProposicao;
    }

    public String getTema() {
        return tema;
    }

    public void setNomeProposicao(String proposicao) {
        this.nomeProposicao = proposicao;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Proposicao(){

    }
    public Proposicao(String nomeProposicao, String tema) {
        this.setNomeProposicao(nomeProposicao);
        this.setTema(tema);
    }

    @Override
    public String toString() {
        return String.format("%s;%s", getNomeProposicao(), getTema());
    }

    public void imprimir() {
        System.out.printf("Proposição: %s%n", getNomeProposicao());
        System.out.printf("Tema: %s%n", getTema());

    }


}
