package br.fag.edu.locacao.model;

import javax.persistence.*;
import java.util.Date;

public class BaseModel {
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreate;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUpdate;

    @Column
    private long version;

    @PrePersist
    private void prePersist(){
        version = 0;
        dtCreate = new Date();
        dtUpdate = new Date();
    }

    @PreUpdate
    private void preUpdate(){
        version ++;
        dtUpdate = new Date();
    }

}
