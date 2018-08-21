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
@Table(name = "carregar")
@NamedQueries({
    @NamedQuery(name = "Carregar.findAll", query = "SELECT c FROM Carregar c")
    , @NamedQuery(name = "Carregar.findById", query = "SELECT c FROM Carregar c WHERE c.id = :id")
    , @NamedQuery(name = "Carregar.findByEntryBy", query = "SELECT c FROM Carregar c WHERE c.entryBy = :entryBy")
    , @NamedQuery(name = "Carregar.findByMeio", query = "SELECT c FROM Carregar c WHERE c.meio = :meio")
    , @NamedQuery(name = "Carregar.findByCompra", query = "SELECT c FROM Carregar c WHERE c.compra = :compra")
    , @NamedQuery(name = "Carregar.findByValor", query = "SELECT c FROM Carregar c WHERE c.valor = :valor")
    , @NamedQuery(name = "Carregar.findByPUsd", query = "SELECT c FROM Carregar c WHERE c.pUsd = :pUsd")
    , @NamedQuery(name = "Carregar.findByPBrl", query = "SELECT c FROM Carregar c WHERE c.pBrl = :pBrl")
    , @NamedQuery(name = "Carregar.findByWallet", query = "SELECT c FROM Carregar c WHERE c.wallet = :wallet")
    , @NamedQuery(name = "Carregar.findByHash", query = "SELECT c FROM Carregar c WHERE c.hash = :hash")
    , @NamedQuery(name = "Carregar.findByStatus", query = "SELECT c FROM Carregar c WHERE c.status = :status")
    , @NamedQuery(name = "Carregar.findByCreatedAt", query = "SELECT c FROM Carregar c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Carregar.findByUpdatedAt", query = "SELECT c FROM Carregar c WHERE c.updatedAt = :updatedAt")
    , @NamedQuery(name = "Carregar.findByDias", query = "SELECT c FROM Carregar c WHERE c.dias = :dias")
    , @NamedQuery(name = "Carregar.findByLiberado", query = "SELECT c FROM Carregar c WHERE c.liberado = :liberado")})
public class Carregar implements Serializable {

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
    @Size(min = 1, max = 8)
    @Column(name = "meio")
    private String meio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "compra")
    private String compra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pUsd")
    private BigDecimal pUsd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pBrl")
    private BigDecimal pBrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "wallet")
    private String wallet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "hash")
    private String hash;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dias")
    private String dias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "liberado")
    private String liberado;

    public Carregar() {
    }

    public Carregar(Integer id) {
        this.id = id;
    }

    public Carregar(Integer id, int entryBy, String meio, String compra, BigDecimal valor, BigDecimal pUsd, BigDecimal pBrl, String wallet, String hash, String status, Date createdAt, Date updatedAt, String dias, String liberado) {
        this.id = id;
        this.entryBy = entryBy;
        this.meio = meio;
        this.compra = compra;
        this.valor = valor;
        this.pUsd = pUsd;
        this.pBrl = pBrl;
        this.wallet = wallet;
        this.hash = hash;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dias = dias;
        this.liberado = liberado;
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

    public String getMeio() {
        return meio;
    }

    public void setMeio(String meio) {
        this.meio = meio;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPUsd() {
        return pUsd;
    }

    public void setPUsd(BigDecimal pUsd) {
        this.pUsd = pUsd;
    }

    public BigDecimal getPBrl() {
        return pBrl;
    }

    public void setPBrl(BigDecimal pBrl) {
        this.pBrl = pBrl;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getLiberado() {
        return liberado;
    }

    public void setLiberado(String liberado) {
        this.liberado = liberado;
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
        if (!(object instanceof Carregar)) {
            return false;
        }
        Carregar other = (Carregar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Carregar[ id=" + id + " ]";
    }
    
}
