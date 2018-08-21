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
import javax.validation.constraints.Size;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "tb_restapi")
@NamedQueries({
    @NamedQuery(name = "TbRestapi.findAll", query = "SELECT t FROM TbRestapi t")
    , @NamedQuery(name = "TbRestapi.findById", query = "SELECT t FROM TbRestapi t WHERE t.id = :id")
    , @NamedQuery(name = "TbRestapi.findByApiuser", query = "SELECT t FROM TbRestapi t WHERE t.apiuser = :apiuser")
    , @NamedQuery(name = "TbRestapi.findByApikey", query = "SELECT t FROM TbRestapi t WHERE t.apikey = :apikey")
    , @NamedQuery(name = "TbRestapi.findByCreated", query = "SELECT t FROM TbRestapi t WHERE t.created = :created")})
public class TbRestapi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "apiuser")
    private Integer apiuser;
    @Size(max = 100)
    @Column(name = "apikey")
    private String apikey;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Lob
    @Size(max = 65535)
    @Column(name = "modules")
    private String modules;

    public TbRestapi() {
    }

    public TbRestapi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApiuser() {
        return apiuser;
    }

    public void setApiuser(Integer apiuser) {
        this.apiuser = apiuser;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
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
        if (!(object instanceof TbRestapi)) {
            return false;
        }
        TbRestapi other = (TbRestapi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbRestapi[ id=" + id + " ]";
    }
    
}
