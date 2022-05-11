package br.fag.edu.locacao.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Carro_Model extends Base_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;





}
