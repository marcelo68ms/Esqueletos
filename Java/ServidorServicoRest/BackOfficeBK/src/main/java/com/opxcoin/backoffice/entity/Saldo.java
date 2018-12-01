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

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "saldo")
@NamedQueries({
    @NamedQuery(name = "Saldo.findAll", query = "SELECT s FROM Saldo s")
    , @NamedQuery(name = "Saldo.findById", query = "SELECT s FROM Saldo s WHERE s.id = :id")
    , @NamedQuery(name = "Saldo.findByEntryBy", query = "SELECT s FROM Saldo s WHERE s.entryBy = :entryBy")
    , @NamedQuery(name = "Saldo.findByBrl", query = "SELECT s FROM Saldo s WHERE s.brl = :brl")
    , @NamedQuery(name = "Saldo.findBySaldoB", query = "SELECT s FROM Saldo s WHERE s.saldoB = :saldoB")
    , @NamedQuery(name = "Saldo.findBySaldoBR", query = "SELECT s FROM Saldo s WHERE s.saldoBR = :saldoBR")
    , @NamedQuery(name = "Saldo.findBySaldoBC", query = "SELECT s FROM Saldo s WHERE s.saldoBC = :saldoBC")
    , @NamedQuery(name = "Saldo.findBySaldoE", query = "SELECT s FROM Saldo s WHERE s.saldoE = :saldoE")
    , @NamedQuery(name = "Saldo.findBySaldoER", query = "SELECT s FROM Saldo s WHERE s.saldoER = :saldoER")
    , @NamedQuery(name = "Saldo.findBySaldoEC", query = "SELECT s FROM Saldo s WHERE s.saldoEC = :saldoEC")})
public class Saldo implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "brl")
    private BigDecimal brl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoB")
    private BigDecimal saldoB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoBR")
    private BigDecimal saldoBR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoBC")
    private BigDecimal saldoBC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoE")
    private BigDecimal saldoE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoER")
    private BigDecimal saldoER;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoEC")
    private BigDecimal saldoEC;

    public Saldo() {
    }

    public Saldo(Integer id) {
        this.id = id;
    }

    public Saldo(Integer id, int entryBy, BigDecimal brl, BigDecimal saldoB, BigDecimal saldoBR, BigDecimal saldoBC, BigDecimal saldoE, BigDecimal saldoER, BigDecimal saldoEC) {
        this.id = id;
        this.entryBy = entryBy;
        this.brl = brl;
        this.saldoB = saldoB;
        this.saldoBR = saldoBR;
        this.saldoBC = saldoBC;
        this.saldoE = saldoE;
        this.saldoER = saldoER;
        this.saldoEC = saldoEC;
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

    public BigDecimal getBrl() {
        return brl;
    }

    public void setBrl(BigDecimal brl) {
        this.brl = brl;
    }

    public BigDecimal getSaldoB() {
        return saldoB;
    }

    public void setSaldoB(BigDecimal saldoB) {
        this.saldoB = saldoB;
    }

    public BigDecimal getSaldoBR() {
        return saldoBR;
    }

    public void setSaldoBR(BigDecimal saldoBR) {
        this.saldoBR = saldoBR;
    }

    public BigDecimal getSaldoBC() {
        return saldoBC;
    }

    public void setSaldoBC(BigDecimal saldoBC) {
        this.saldoBC = saldoBC;
    }

    public BigDecimal getSaldoE() {
        return saldoE;
    }

    public void setSaldoE(BigDecimal saldoE) {
        this.saldoE = saldoE;
    }

    public BigDecimal getSaldoER() {
        return saldoER;
    }

    public void setSaldoER(BigDecimal saldoER) {
        this.saldoER = saldoER;
    }

    public BigDecimal getSaldoEC() {
        return saldoEC;
    }

    public void setSaldoEC(BigDecimal saldoEC) {
        this.saldoEC = saldoEC;
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
        if (!(object instanceof Saldo)) {
            return false;
        }
        Saldo other = (Saldo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Saldo[ id=" + id + " ]";
    }
    
}
