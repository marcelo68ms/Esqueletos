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
import javax.persistence.Lob;
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
@Table(name = "wp_usermeta")
@NamedQueries({
    @NamedQuery(name = "WpUsermeta.findAll", query = "SELECT w FROM WpUsermeta w")
    , @NamedQuery(name = "WpUsermeta.findByUmetaId", query = "SELECT w FROM WpUsermeta w WHERE w.umetaId = :umetaId")
    , @NamedQuery(name = "WpUsermeta.findByUserId", query = "SELECT w FROM WpUsermeta w WHERE w.userId = :userId")
    , @NamedQuery(name = "WpUsermeta.findByMetaKey", query = "SELECT w FROM WpUsermeta w WHERE w.metaKey = :metaKey")})
public class WpUsermeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "umeta_id")
    private Long umetaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private long userId;
    @Size(max = 255)
    @Column(name = "meta_key")
    private String metaKey;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "meta_value")
    private String metaValue;

    public WpUsermeta() {
    }

    public WpUsermeta(Long umetaId) {
        this.umetaId = umetaId;
    }

    public WpUsermeta(Long umetaId, long userId) {
        this.umetaId = umetaId;
        this.userId = userId;
    }

    public Long getUmetaId() {
        return umetaId;
    }

    public void setUmetaId(Long umetaId) {
        this.umetaId = umetaId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (umetaId != null ? umetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpUsermeta)) {
            return false;
        }
        WpUsermeta other = (WpUsermeta) object;
        if ((this.umetaId == null && other.umetaId != null) || (this.umetaId != null && !this.umetaId.equals(other.umetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.WpUsermeta[ umetaId=" + umetaId + " ]";
    }
    
}
