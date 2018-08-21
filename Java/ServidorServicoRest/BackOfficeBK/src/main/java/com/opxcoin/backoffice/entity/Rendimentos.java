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
@Table(name = "rendimentos")
@NamedQueries({
    @NamedQuery(name = "Rendimentos.findAll", query = "SELECT r FROM Rendimentos r")
    , @NamedQuery(name = "Rendimentos.findById", query = "SELECT r FROM Rendimentos r WHERE r.id = :id")
    , @NamedQuery(name = "Rendimentos.findByEntryBy", query = "SELECT r FROM Rendimentos r WHERE r.entryBy = :entryBy")
    , @NamedQuery(name = "Rendimentos.findByPagamento", query = "SELECT r FROM Rendimentos r WHERE r.pagamento = :pagamento")
    , @NamedQuery(name = "Rendimentos.findByMoeda", query = "SELECT r FROM Rendimentos r WHERE r.moeda = :moeda")
    , @NamedQuery(name = "Rendimentos.findByStatus", query = "SELECT r FROM Rendimentos r WHERE r.status = :status")
    , @NamedQuery(name = "Rendimentos.findByCreatedAt", query = "SELECT r FROM Rendimentos r WHERE r.createdAt = :createdAt")
    , @NamedQuery(name = "Rendimentos.findByUpdatedAt", query = "SELECT r FROM Rendimentos r WHERE r.updatedAt = :updatedAt")
    , @NamedQuery(name = "Rendimentos.findByCapital", query = "SELECT r FROM Rendimentos r WHERE r.capital = :capital")})
public class Rendimentos implements Serializable {

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
    @Column(name = "pagamento")
    private float pagamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capital")
    private int capital;

    public Rendimentos() {
    }

    public Rendimentos(Integer id) {
        this.id = id;
    }

    public Rendimentos(Integer id, int entryBy, float pagamento, String moeda, String status, Date createdAt, Date updatedAt, int capital) {
        this.id = id;
        this.entryBy = entryBy;
        this.pagamento = pagamento;
        this.moeda = moeda;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.capital = capital;
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

    public float getPagamento() {
        return pagamento;
    }

    public void setPagamento(float pagamento) {
        this.pagamento = pagamento;
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

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
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
        if (!(object instanceof Rendimentos)) {
            return false;
        }
        Rendimentos other = (Rendimentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Rendimentos[ id=" + id + " ]";
    }
    
}
