/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "moedas")
@NamedQueries({
    @NamedQuery(name = "Moedas.findAll", query = "SELECT m FROM Moedas m")
    , @NamedQuery(name = "Moedas.findById", query = "SELECT m FROM Moedas m WHERE m.id = :id")
    , @NamedQuery(name = "Moedas.findByNome", query = "SELECT m FROM Moedas m WHERE m.nome = :nome")
    , @NamedQuery(name = "Moedas.findByCod", query = "SELECT m FROM Moedas m WHERE m.cod = :cod")
    , @NamedQuery(name = "Moedas.findByValorUsd", query = "SELECT m FROM Moedas m WHERE m.valorUsd = :valorUsd")
    , @NamedQuery(name = "Moedas.findByValorBrl", query = "SELECT m FROM Moedas m WHERE m.valorBrl = :valorBrl")
    , @NamedQuery(name = "Moedas.findByValorEur", query = "SELECT m FROM Moedas m WHERE m.valorEur = :valorEur")
    , @NamedQuery(name = "Moedas.findByValorBtc", query = "SELECT m FROM Moedas m WHERE m.valorBtc = :valorBtc")
    , @NamedQuery(name = "Moedas.findByPorcentagem", query = "SELECT m FROM Moedas m WHERE m.porcentagem = :porcentagem")
    , @NamedQuery(name = "Moedas.findBySaqueMinimo", query = "SELECT m FROM Moedas m WHERE m.saqueMinimo = :saqueMinimo")
    , @NamedQuery(name = "Moedas.findByTaxas", query = "SELECT m FROM Moedas m WHERE m.taxas = :taxas")})
public class Moedas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod")
    private String cod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorUsd")
    private BigDecimal valorUsd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorBrl")
    private BigDecimal valorBrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorEur")
    private BigDecimal valorEur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorBtc")
    private BigDecimal valorBtc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentagem")
    private BigDecimal porcentagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saqueMinimo")
    private BigDecimal saqueMinimo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "taxas")
    private String taxas;

    public Moedas() {
    }

    public Moedas(Integer id) {
        this.id = id;
    }

    public Moedas(Integer id, String nome, String cod, BigDecimal valorUsd, BigDecimal valorBrl, BigDecimal valorEur, BigDecimal valorBtc, BigDecimal porcentagem, BigDecimal saqueMinimo, String taxas) {
        this.id = id;
        this.nome = nome;
        this.cod = cod;
        this.valorUsd = valorUsd;
        this.valorBrl = valorBrl;
        this.valorEur = valorEur;
        this.valorBtc = valorBtc;
        this.porcentagem = porcentagem;
        this.saqueMinimo = saqueMinimo;
        this.taxas = taxas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public BigDecimal getValorUsd() {
        return valorUsd;
    }

    public void setValorUsd(BigDecimal valorUsd) {
        this.valorUsd = valorUsd;
    }

    public BigDecimal getValorBrl() {
        return valorBrl;
    }

    public void setValorBrl(BigDecimal valorBrl) {
        this.valorBrl = valorBrl;
    }

    public BigDecimal getValorEur() {
        return valorEur;
    }

    public void setValorEur(BigDecimal valorEur) {
        this.valorEur = valorEur;
    }

    public BigDecimal getValorBtc() {
        return valorBtc;
    }

    public void setValorBtc(BigDecimal valorBtc) {
        this.valorBtc = valorBtc;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(BigDecimal porcentagem) {
        this.porcentagem = porcentagem;
    }

    public BigDecimal getSaqueMinimo() {
        return saqueMinimo;
    }

    public void setSaqueMinimo(BigDecimal saqueMinimo) {
        this.saqueMinimo = saqueMinimo;
    }

    public String getTaxas() {
        return taxas;
    }

    public void setTaxas(String taxas) {
        this.taxas = taxas;
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
        if (!(object instanceof Moedas)) {
            return false;
        }
        Moedas other = (Moedas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Moedas[ id=" + id + " ]";
    }
    
}
