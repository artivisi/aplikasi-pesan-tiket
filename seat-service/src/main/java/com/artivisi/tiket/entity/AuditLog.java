package com.artivisi.tiket.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="audit_log")
public class AuditLog {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private String id;

    @NotNull
    @Column(name="waktu_kejadian", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuKejadian = new Date();
    
    @NotNull
    private String user;
    @NotNull
    private String action;
    @NotNull
    private String data;

    public String getId(){
        return id;
    }

    public void setId(String x){
        id = x;
    }

    public String getAction(){
        return action;
    }

    public void setAction(String x){
        action = x;
    }

    public String getData(){
        return data;
    }

    public void setData(String x){
        data = x;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    

    public Date getWaktuKejadian(){
        return waktuKejadian;
    }

    public void setId(Date x){
        waktuKejadian = x;
    }
}
