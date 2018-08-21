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
@Table(name = "ticketit_settings")
@NamedQueries({
    @NamedQuery(name = "TicketitSettings.findAll", query = "SELECT t FROM TicketitSettings t")
    , @NamedQuery(name = "TicketitSettings.findById", query = "SELECT t FROM TicketitSettings t WHERE t.id = :id")
    , @NamedQuery(name = "TicketitSettings.findByLang", query = "SELECT t FROM TicketitSettings t WHERE t.lang = :lang")
    , @NamedQuery(name = "TicketitSettings.findBySlug", query = "SELECT t FROM TicketitSettings t WHERE t.slug = :slug")
    , @NamedQuery(name = "TicketitSettings.findByCreatedAt", query = "SELECT t FROM TicketitSettings t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TicketitSettings.findByUpdatedAt", query = "SELECT t FROM TicketitSettings t WHERE t.updatedAt = :updatedAt")})
public class TicketitSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "lang")
    private String lang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "slug")
    private String slug;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "default")
    private String default1;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public TicketitSettings() {
    }

    public TicketitSettings(Integer id) {
        this.id = id;
    }

    public TicketitSettings(Integer id, String slug, String value, String default1) {
        this.id = id;
        this.slug = slug;
        this.value = value;
        this.default1 = default1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDefault1() {
        return default1;
    }

    public void setDefault1(String default1) {
        this.default1 = default1;
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
        if (!(object instanceof TicketitSettings)) {
            return false;
        }
        TicketitSettings other = (TicketitSettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TicketitSettings[ id=" + id + " ]";
    }
    
}
