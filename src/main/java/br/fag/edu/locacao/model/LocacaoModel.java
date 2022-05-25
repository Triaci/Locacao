package br.fag.edu.locacao.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
@Table
public class LocacaoModel extends BaseModel {

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
    private CarroModel carro;

    @OneToOne
    private UsuarioModel usuario;

    public LocacaoModel() {
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

    public CarroModel getCarro() {
        return carro;
    }

    public void setCarro(CarroModel id_Carro) {
        carro = id_Carro;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel id_Usuario) {
        usuario = id_Usuario;
    }
}
