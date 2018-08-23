/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "operacoes")
@NamedQueries({
    @NamedQuery(name = "Operacoes.findAll", query = "SELECT o FROM Operacoes o")
    , @NamedQuery(name = "Operacoes.findById", query = "SELECT o FROM Operacoes o WHERE o.id = :id")
    , @NamedQuery(name = "Operacoes.findByOperacao", query = "SELECT o FROM Operacoes o WHERE o.operacao = :operacao")
    , @NamedQuery(name = "Operacoes.findByValor", query = "SELECT o FROM Operacoes o WHERE o.valor = :valor")
    , @NamedQuery(name = "Operacoes.findByMoeda", query = "SELECT o FROM Operacoes o WHERE o.moeda = :moeda")
    , @NamedQuery(name = "Operacoes.findByCreatedAt", query = "SELECT o FROM Operacoes o WHERE o.createdAt = :createdAt")})
public class Operacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "operacao")
    private String operacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "moeda")
    private String moeda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Operacoes() {
    }

    public Operacoes(Integer id) {
        this.id = id;
    }

    public Operacoes(Integer id, String operacao, String valor, String moeda, Date createdAt) {
        this.id = id;
        this.operacao = operacao;
        this.valor = valor;
        this.moeda = moeda;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacoes)) {
            return false;
        }
        Operacoes other = (Operacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Operacoes[ id=" + id + " ]";
    }
    
}
