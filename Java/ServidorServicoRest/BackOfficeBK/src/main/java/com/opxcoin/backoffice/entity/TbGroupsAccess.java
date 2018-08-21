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
import javax.validation.constraints.Size;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "tb_groups_access")
@NamedQueries({
    @NamedQuery(name = "TbGroupsAccess.findAll", query = "SELECT t FROM TbGroupsAccess t")
    , @NamedQuery(name = "TbGroupsAccess.findById", query = "SELECT t FROM TbGroupsAccess t WHERE t.id = :id")
    , @NamedQuery(name = "TbGroupsAccess.findByGroupId", query = "SELECT t FROM TbGroupsAccess t WHERE t.groupId = :groupId")
    , @NamedQuery(name = "TbGroupsAccess.findByModuleId", query = "SELECT t FROM TbGroupsAccess t WHERE t.moduleId = :moduleId")})
public class TbGroupsAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "module_id")
    private Integer moduleId;
    @Lob
    @Size(max = 65535)
    @Column(name = "access_data")
    private String accessData;

    public TbGroupsAccess() {
    }

    public TbGroupsAccess(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getAccessData() {
        return accessData;
    }

    public void setAccessData(String accessData) {
        this.accessData = accessData;
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
        if (!(object instanceof TbGroupsAccess)) {
            return false;
        }
        TbGroupsAccess other = (TbGroupsAccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbGroupsAccess[ id=" + id + " ]";
    }
    
}
