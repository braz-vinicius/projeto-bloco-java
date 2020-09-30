package br.infnet.votum.model;

import br.infnet.votum.model.IEntidadeImprimivel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("PessoaJuridica")
public class PessoaJuridica extends Pessoa implements IEntidadeImprimivel, Serializable {
    private String numeroCnpj;
    private LocalDate dataAberturaRegistro;

    public PessoaJuridica(String nome, String numeroCnpj, LocalDate dataAberturaRegistro) {
        this.numeroCnpj = numeroCnpj;
        this.dataAberturaRegistro = dataAberturaRegistro;
    }

    public PessoaJuridica() {

    }

    public String getNumeroCnpj() {
        return numeroCnpj;
    }

    public void setNumeroCnpj(String numeroCnpj) {
        this.numeroCnpj = numeroCnpj;
    }

    public LocalDate getDataAberturaRegistro() {
        return dataAberturaRegistro;
    }

    public void setDataAberturaRegistro(LocalDate dataAberturaRegistro) {
        this.dataAberturaRegistro = dataAberturaRegistro;
    }

    @Override
    public String toString() {
        return String.format("J;%s;%s;%d",
                nome,
                numeroCnpj,
                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataAberturaRegistro));
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Numero CNPJ: %s%n", numeroCnpj);
        System.out.printf("Data Abertura: %s%n", DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataAberturaRegistro));
    }
}
