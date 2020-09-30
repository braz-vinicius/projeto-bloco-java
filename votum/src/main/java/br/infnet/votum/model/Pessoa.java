package br.infnet.votum.model;

import br.infnet.votum.model.IEntidadeImprimivel;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Pessoa")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="tipopessoa",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue("Pessoa")
public class Pessoa implements IEntidadeImprimivel, Serializable {


    protected Integer id;
    protected String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public void imprimir() {
        System.out.println("Nome: " + nome);
    }
}
