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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "tb_groups")
@NamedQueries({
    @NamedQuery(name = "TbGroups.findAll", query = "SELECT t FROM TbGroups t")
    , @NamedQuery(name = "TbGroups.findByGroupId", query = "SELECT t FROM TbGroups t WHERE t.groupId = :groupId")
    , @NamedQuery(name = "TbGroups.findByName", query = "SELECT t FROM TbGroups t WHERE t.name = :name")
    , @NamedQuery(name = "TbGroups.findByDescription", query = "SELECT t FROM TbGroups t WHERE t.description = :description")
    , @NamedQuery(name = "TbGroups.findByLevel", query = "SELECT t FROM TbGroups t WHERE t.level = :level")})
public class TbGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Integer groupId;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Column(name = "level")
    private Integer level;

    public TbGroups() {
    }

    public TbGroups(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbGroups)) {
            return false;
        }
        TbGroups other = (TbGroups) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbGroups[ groupId=" + groupId + " ]";
    }
    
}
