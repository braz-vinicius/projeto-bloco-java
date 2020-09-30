package br.infnet.votum.model;

import br.infnet.votum.model.IEntidadeImprimivel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Voto")
public class Voto implements IEntidadeImprimivel, Serializable {

    private Integer id;
    private Proposicao proposicao;
    private LocalDateTime dataHoraVoto;
    private VotoEnum votoValor;
    private Pessoa pessoa;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="pessoa_id",foreignKey=@ForeignKey(name = "Fk_voto_pessoa"))
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="proposicao_id",foreignKey=@ForeignKey(name = "Fk_voto_proposicao"))
    public Proposicao getProposicao() {
        return proposicao;
    }

    public VotoEnum getVotoValor() {
        return votoValor;
    }


    public void setProposicao(Proposicao proposicao) {
        this.proposicao = proposicao;
    }

    public LocalDateTime getDataHoraVoto() {
        return dataHoraVoto;
    }

    public void setDataHoraVoto(LocalDateTime dataHoraVoto) {
        this.dataHoraVoto = dataHoraVoto;
    }

    public void setVotoValor(VotoEnum votoValor) {
        this.votoValor = votoValor;
    }

    public Voto(LocalDateTime dataHoraVoto, Proposicao proposicao, Pessoa pessoa, VotoEnum voto) {
      //  this.pessoa = pessoa;
        this.proposicao = proposicao;
        this.votoValor = voto;
        this.dataHoraVoto = dataHoraVoto;
    }

    public Voto() {

    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s",
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(dataHoraVoto),
                proposicao,
//                pessoa,
                votoValor == VotoEnum.Sim ? "Sim" : "Nao"
                );
    }

    @Override
    public void imprimir() {
        System.out.printf("Data/Hora: %s%n", DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataHoraVoto));
        proposicao.imprimir();
//        pessoa.imprimir();
        System.out.printf("Voto: %s%n", votoValor == VotoEnum.Sim ? "Sim" : "Nao");
    }



}
