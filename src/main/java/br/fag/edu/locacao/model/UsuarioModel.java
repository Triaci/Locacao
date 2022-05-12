package br.fag.edu.locacao.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class UsuarioModel extends BaseModel {

    @Id
    @GeneratedValue
    private UUID Id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String telefone;

    @OneToOne
    private UsuarioModel usuario_model;


    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        this.Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
