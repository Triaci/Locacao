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
    private CarroModel Id_Carro;

    @OneToOne
    private UsuarioModel Id_Usuario;

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

    public CarroModel getId_Carro() {
        return Id_Carro;
    }

    public void setId_Carro(CarroModel id_Carro) {
        Id_Carro = id_Carro;
    }

    public UsuarioModel getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(UsuarioModel id_Usuario) {
        Id_Usuario = id_Usuario;
    }
}
