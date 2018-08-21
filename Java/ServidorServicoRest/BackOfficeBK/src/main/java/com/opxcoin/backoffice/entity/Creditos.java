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
@Table(name = "creditos")
@NamedQueries({
    @NamedQuery(name = "Creditos.findAll", query = "SELECT c FROM Creditos c")
    , @NamedQuery(name = "Creditos.findById", query = "SELECT c FROM Creditos c WHERE c.id = :id")
    , @NamedQuery(name = "Creditos.findByEntryBy", query = "SELECT c FROM Creditos c WHERE c.entryBy = :entryBy")
    , @NamedQuery(name = "Creditos.findByMeio", query = "SELECT c FROM Creditos c WHERE c.meio = :meio")
    , @NamedQuery(name = "Creditos.findByPBrl", query = "SELECT c FROM Creditos c WHERE c.pBrl = :pBrl")
    , @NamedQuery(name = "Creditos.findByStatus", query = "SELECT c FROM Creditos c WHERE c.status = :status")
    , @NamedQuery(name = "Creditos.findByCreatedAt", query = "SELECT c FROM Creditos c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Creditos.findByUpdatedAt", query = "SELECT c FROM Creditos c WHERE c.updatedAt = :updatedAt")})
public class Creditos implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "pBrl")
    private BigDecimal pBrl;
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

    public Creditos() {
    }

    public Creditos(Integer id) {
        this.id = id;
    }

    public Creditos(Integer id, int entryBy, String meio, BigDecimal pBrl, String status, Date createdAt, Date updatedAt) {
        this.id = id;
        this.entryBy = entryBy;
        this.meio = meio;
        this.pBrl = pBrl;
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

    public String getMeio() {
        return meio;
    }

    public void setMeio(String meio) {
        this.meio = meio;
    }

    public BigDecimal getPBrl() {
        return pBrl;
    }

    public void setPBrl(BigDecimal pBrl) {
        this.pBrl = pBrl;
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
        if (!(object instanceof Creditos)) {
            return false;
        }
        Creditos other = (Creditos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Creditos[ id=" + id + " ]";
    }
    
}
