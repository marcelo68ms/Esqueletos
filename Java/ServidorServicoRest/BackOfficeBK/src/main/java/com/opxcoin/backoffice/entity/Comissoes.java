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
@Table(name = "comissoes")
@NamedQueries({
    @NamedQuery(name = "Comissoes.findAll", query = "SELECT c FROM Comissoes c")
    , @NamedQuery(name = "Comissoes.findById", query = "SELECT c FROM Comissoes c WHERE c.id = :id")
    , @NamedQuery(name = "Comissoes.findByEntryBy", query = "SELECT c FROM Comissoes c WHERE c.entryBy = :entryBy")
    , @NamedQuery(name = "Comissoes.findByRecebido", query = "SELECT c FROM Comissoes c WHERE c.recebido = :recebido")
    , @NamedQuery(name = "Comissoes.findByDe", query = "SELECT c FROM Comissoes c WHERE c.de = :de")
    , @NamedQuery(name = "Comissoes.findByNivel", query = "SELECT c FROM Comissoes c WHERE c.nivel = :nivel")
    , @NamedQuery(name = "Comissoes.findByCreatedAt", query = "SELECT c FROM Comissoes c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Comissoes.findByUpdatedAt", query = "SELECT c FROM Comissoes c WHERE c.updatedAt = :updatedAt")})
public class Comissoes implements Serializable {

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
    @Column(name = "recebido")
    private BigDecimal recebido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "de")
    private String de;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nivel")
    private String nivel;
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

    public Comissoes() {
    }

    public Comissoes(Integer id) {
        this.id = id;
    }

    public Comissoes(Integer id, int entryBy, BigDecimal recebido, String de, String nivel, Date createdAt, Date updatedAt) {
        this.id = id;
        this.entryBy = entryBy;
        this.recebido = recebido;
        this.de = de;
        this.nivel = nivel;
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

    public BigDecimal getRecebido() {
        return recebido;
    }

    public void setRecebido(BigDecimal recebido) {
        this.recebido = recebido;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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
        if (!(object instanceof Comissoes)) {
            return false;
        }
        Comissoes other = (Comissoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Comissoes[ id=" + id + " ]";
    }
    
}
