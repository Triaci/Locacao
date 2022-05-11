package br.fag.edu.locacao.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
@Table
public class Locacao_Model extends Base_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column
    private double valorLocado;

    @Column
    private Date dtInicio;

    @Column
    private Date dtFim;

    @OneToOne
    private Carro_Model Id_Carro;

    @OneToOne
    private Usuario_Model Id_Usuario;

    public Locacao_Model() {
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public double getValorLocado() {
        return valorLocado;
    }

    public void setValorLocado(double valorLocado) {
        this.valorLocado = valorLocado;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Carro_Model getId_Carro() {
        return Id_Carro;
    }

    public void setId_Carro(Carro_Model id_Carro) {
        Id_Carro = id_Carro;
    }

    public Usuario_Model getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(Usuario_Model id_Usuario) {
        Id_Usuario = id_Usuario;
    }
}
