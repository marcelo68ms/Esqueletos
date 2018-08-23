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
@Table(name = "tb_audits")
@NamedQueries({
    @NamedQuery(name = "TbAudits.findAll", query = "SELECT t FROM TbAudits t")
    , @NamedQuery(name = "TbAudits.findByAuditID", query = "SELECT t FROM TbAudits t WHERE t.auditID = :auditID")
    , @NamedQuery(name = "TbAudits.findByUserID", query = "SELECT t FROM TbAudits t WHERE t.userID = :userID")
    , @NamedQuery(name = "TbAudits.findByModuleID", query = "SELECT t FROM TbAudits t WHERE t.moduleID = :moduleID")
    , @NamedQuery(name = "TbAudits.findByModuleName", query = "SELECT t FROM TbAudits t WHERE t.moduleName = :moduleName")
    , @NamedQuery(name = "TbAudits.findByModuleTitle", query = "SELECT t FROM TbAudits t WHERE t.moduleTitle = :moduleTitle")
    , @NamedQuery(name = "TbAudits.findByModuleTable", query = "SELECT t FROM TbAudits t WHERE t.moduleTable = :moduleTable")
    , @NamedQuery(name = "TbAudits.findByModuleKey", query = "SELECT t FROM TbAudits t WHERE t.moduleKey = :moduleKey")
    , @NamedQuery(name = "TbAudits.findByCreated", query = "SELECT t FROM TbAudits t WHERE t.created = :created")
    , @NamedQuery(name = "TbAudits.findByModuleDataID", query = "SELECT t FROM TbAudits t WHERE t.moduleDataID = :moduleDataID")
    , @NamedQuery(name = "TbAudits.findByAuditType", query = "SELECT t FROM TbAudits t WHERE t.auditType = :auditType")})
public class TbAudits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AuditID")
    private Long auditID;
    @Column(name = "UserID")
    private Integer userID;
    @Column(name = "ModuleID")
    private Integer moduleID;
    @Size(max = 50)
    @Column(name = "ModuleName")
    private String moduleName;
    @Size(max = 50)
    @Column(name = "ModuleTitle")
    private String moduleTitle;
    @Size(max = 20)
    @Column(name = "ModuleTable")
    private String moduleTable;
    @Size(max = 20)
    @Column(name = "ModuleKey")
    private String moduleKey;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "ModuleDataID")
    private Integer moduleDataID;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ModuleData")
    private String moduleData;
    @Size(max = 10)
    @Column(name = "AuditType")
    private String auditType;

    public TbAudits() {
    }

    public TbAudits(Long auditID) {
        this.auditID = auditID;
    }

    public Long getAuditID() {
        return auditID;
    }

    public void setAuditID(Long auditID) {
        this.auditID = auditID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public String getModuleTable() {
        return moduleTable;
    }

    public void setModuleTable(String moduleTable) {
        this.moduleTable = moduleTable;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getModuleDataID() {
        return moduleDataID;
    }

    public void setModuleDataID(Integer moduleDataID) {
        this.moduleDataID = moduleDataID;
    }

    public String getModuleData() {
        return moduleData;
    }

    public void setModuleData(String moduleData) {
        this.moduleData = moduleData;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditID != null ? auditID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAudits)) {
            return false;
        }
        TbAudits other = (TbAudits) object;
        if ((this.auditID == null && other.auditID != null) || (this.auditID != null && !this.auditID.equals(other.auditID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbAudits[ auditID=" + auditID + " ]";
    }
    
}
