package br.fag.edu.locacao.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Usuario_Model extends Base_Model{

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
    private Usuario_Model usuario_model;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
