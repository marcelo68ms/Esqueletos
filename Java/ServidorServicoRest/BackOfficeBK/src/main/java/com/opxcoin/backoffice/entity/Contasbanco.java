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
@Table(name = "contasbanco")
@NamedQueries({
    @NamedQuery(name = "Contasbanco.findAll", query = "SELECT c FROM Contasbanco c")
    , @NamedQuery(name = "Contasbanco.findById", query = "SELECT c FROM Contasbanco c WHERE c.id = :id")
    , @NamedQuery(name = "Contasbanco.findByBanco", query = "SELECT c FROM Contasbanco c WHERE c.banco = :banco")
    , @NamedQuery(name = "Contasbanco.findByAgencia", query = "SELECT c FROM Contasbanco c WHERE c.agencia = :agencia")
    , @NamedQuery(name = "Contasbanco.findByConta", query = "SELECT c FROM Contasbanco c WHERE c.conta = :conta")
    , @NamedQuery(name = "Contasbanco.findByTipo", query = "SELECT c FROM Contasbanco c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Contasbanco.findByOperacao", query = "SELECT c FROM Contasbanco c WHERE c.operacao = :operacao")
    , @NamedQuery(name = "Contasbanco.findByFavorecido", query = "SELECT c FROM Contasbanco c WHERE c.favorecido = :favorecido")
    , @NamedQuery(name = "Contasbanco.findByDocumento", query = "SELECT c FROM Contasbanco c WHERE c.documento = :documento")})
public class Contasbanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "favorecido")
    private String favorecido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "documento")
    private String documento;

    public Contasbanco() {
    }

    public Contasbanco(Integer id) {
        this.id = id;
    }

    public Contasbanco(Integer id, String banco, String agencia, String conta, String tipo, String operacao, String favorecido, String documento) {
        this.id = id;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.tipo = tipo;
        this.operacao = operacao;
        this.favorecido = favorecido;
        this.documento = documento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
        if (!(object instanceof Contasbanco)) {
            return false;
        }
        Contasbanco other = (Contasbanco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Contasbanco[ id=" + id + " ]";
    }
    
}
