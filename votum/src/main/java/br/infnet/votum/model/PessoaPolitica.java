package br.infnet.votum.model;

import br.infnet.votum.model.IEntidadeImprimivel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("PessoaPolitica")
public class PessoaPolitica extends Pessoa implements IEntidadeImprimivel, Serializable {
    private String partido;
    private String funcaoPublica;

    public PessoaPolitica() {

    }
    public PessoaPolitica(String nome, String partido, String funcaoPublica) {
        this.partido = partido;
        this.funcaoPublica = funcaoPublica;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getFuncaoPublica() {
        return funcaoPublica;
    }

    public void setFuncaoPublica(String funcaoPublica) {
        this.funcaoPublica = funcaoPublica;
    }



    @Override
    public String toString() {

        return String.format("P;%s;%s;%s",
                nome,
                partido,
                funcaoPublica);

    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Partido: %s%n", partido);
        System.out.printf("Cargo: %s%n", funcaoPublica);
    }

}
