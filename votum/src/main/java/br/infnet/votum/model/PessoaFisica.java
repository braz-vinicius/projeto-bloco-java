package br.infnet.votum.model;

import br.infnet.votum.model.IEntidadeImprimivel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("PessoaFisica")
public class PessoaFisica extends Pessoa implements IEntidadeImprimivel, Serializable {

    private String numeroCpf;
    private LocalDate dataNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String numeroCpf, LocalDate dataNascimento) {
        this.numeroCpf = numeroCpf;
        this.dataNascimento = dataNascimento;

    }

    @Override
    public String toString() {
        return String.format("F;%s;%s;%s",
                nome,
                numeroCpf,
                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento));
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Numero CPF: %s%n", numeroCpf);
        System.out.printf("Data Nascimento: %s%n", DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento));
    }

    public String getNumeroCpf() {
        return numeroCpf;
    }

    public void setNumeroCpf(String numeroCpf) {
        this.numeroCpf = numeroCpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
