/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "bancouser")
@NamedQueries({
    @NamedQuery(name = "Bancouser.findAll", query = "SELECT b FROM Bancouser b")
    , @NamedQuery(name = "Bancouser.findById", query = "SELECT b FROM Bancouser b WHERE b.id = :id")
    , @NamedQuery(name = "Bancouser.findByEntryBy", query = "SELECT b FROM Bancouser b WHERE b.entryBy = :entryBy")
    , @NamedQuery(name = "Bancouser.findByBanco", query = "SELECT b FROM Bancouser b WHERE b.banco = :banco")
    , @NamedQuery(name = "Bancouser.findByAgencia", query = "SELECT b FROM Bancouser b WHERE b.agencia = :agencia")
    , @NamedQuery(name = "Bancouser.findByConta", query = "SELECT b FROM Bancouser b WHERE b.conta = :conta")
    , @NamedQuery(name = "Bancouser.findByTipo", query = "SELECT b FROM Bancouser b WHERE b.tipo = :tipo")
    , @NamedQuery(name = "Bancouser.findByOperacao", query = "SELECT b FROM Bancouser b WHERE b.operacao = :operacao")})
public class Bancouser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entry_by")
    private int entryBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "banco")
    private String banco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "agencia")
    private String agencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "conta")
    private String conta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "operacao")
    private String operacao;

    public Bancouser() {
    }

    public Bancouser(Integer id) {
        this.id = id;
    }

    public Bancouser(Integer id, int entryBy, String banco, String agencia, String conta, String tipo, String operacao) {
        this.id = id;
        this.entryBy = entryBy;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.tipo = tipo;
        this.operacao = operacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(int entryBy) {
        this.entryBy = entryBy;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
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
        if (!(object instanceof Bancouser)) {
            return false;
        }
        Bancouser other = (Bancouser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Bancouser[ id=" + id + " ]";
    }
    
}
