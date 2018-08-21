/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "saque")
@NamedQueries({
    @NamedQuery(name = "Saque.findAll", query = "SELECT s FROM Saque s")
    , @NamedQuery(name = "Saque.findById", query = "SELECT s FROM Saque s WHERE s.id = :id")
    , @NamedQuery(name = "Saque.findByEntryBy", query = "SELECT s FROM Saque s WHERE s.entryBy = :entryBy")
    , @NamedQuery(name = "Saque.findByWallet", query = "SELECT s FROM Saque s WHERE s.wallet = :wallet")
    , @NamedQuery(name = "Saque.findByQuantidade", query = "SELECT s FROM Saque s WHERE s.quantidade = :quantidade")
    , @NamedQuery(name = "Saque.findByMoeda", query = "SELECT s FROM Saque s WHERE s.moeda = :moeda")
    , @NamedQuery(name = "Saque.findByStatus", query = "SELECT s FROM Saque s WHERE s.status = :status")
    , @NamedQuery(name = "Saque.findByCreatedAt", query = "SELECT s FROM Saque s WHERE s.createdAt = :createdAt")
    , @NamedQuery(name = "Saque.findByUpdatedAt", query = "SELECT s FROM Saque s WHERE s.updatedAt = :updatedAt")})
public class Saque implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "wallet")
    private String wallet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "hash")
    private String hash;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "moeda")
    private String moeda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    public Saque() {
    }

    public Saque(Integer id) {
        this.id = id;
    }

    public Saque(Integer id, int entryBy, String wallet, BigDecimal quantidade, String hash, String moeda, String status, Date createdAt, Date updatedAt) {
        this.id = id;
        this.entryBy = entryBy;
        this.wallet = wallet;
        this.quantidade = quantidade;
        this.hash = hash;
        this.moeda = moeda;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(object instanceof Saque)) {
            return false;
        }
        Saque other = (Saque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Saque[ id=" + id + " ]";
    }
    
}
