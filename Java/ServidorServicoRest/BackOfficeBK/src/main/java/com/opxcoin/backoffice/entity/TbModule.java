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
@Table(name = "tb_module")
@NamedQueries({
    @NamedQuery(name = "TbModule.findAll", query = "SELECT t FROM TbModule t")
    , @NamedQuery(name = "TbModule.findByModuleId", query = "SELECT t FROM TbModule t WHERE t.moduleId = :moduleId")
    , @NamedQuery(name = "TbModule.findByModuleName", query = "SELECT t FROM TbModule t WHERE t.moduleName = :moduleName")
    , @NamedQuery(name = "TbModule.findByModuleTitle", query = "SELECT t FROM TbModule t WHERE t.moduleTitle = :moduleTitle")
    , @NamedQuery(name = "TbModule.findByModuleNote", query = "SELECT t FROM TbModule t WHERE t.moduleNote = :moduleNote")
    , @NamedQuery(name = "TbModule.findByModuleAuthor", query = "SELECT t FROM TbModule t WHERE t.moduleAuthor = :moduleAuthor")
    , @NamedQuery(name = "TbModule.findByModuleCreated", query = "SELECT t FROM TbModule t WHERE t.moduleCreated = :moduleCreated")
    , @NamedQuery(name = "TbModule.findByModuleDb", query = "SELECT t FROM TbModule t WHERE t.moduleDb = :moduleDb")
    , @NamedQuery(name = "TbModule.findByModuleDbKey", query = "SELECT t FROM TbModule t WHERE t.moduleDbKey = :moduleDbKey")
    , @NamedQuery(name = "TbModule.findByModuleType", query = "SELECT t FROM TbModule t WHERE t.moduleType = :moduleType")})
public class TbModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "module_id")
    private Integer moduleId;
    @Size(max = 100)
    @Column(name = "module_name")
    private String moduleName;
    @Size(max = 100)
    @Column(name = "module_title")
    private String moduleTitle;
    @Size(max = 255)
    @Column(name = "module_note")
    private String moduleNote;
    @Size(max = 100)
    @Column(name = "module_author")
    private String moduleAuthor;
    @Column(name = "module_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moduleCreated;
    @Lob
    @Size(max = 65535)
    @Column(name = "module_desc")
    private String moduleDesc;
    @Size(max = 255)
    @Column(name = "module_db")
    private String moduleDb;
    @Size(max = 100)
    @Column(name = "module_db_key")
    private String moduleDbKey;
    @Size(max = 20)
    @Column(name = "module_type")
    private String moduleType;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "module_config")
    private String moduleConfig;
    @Lob
    @Size(max = 65535)
    @Column(name = "module_lang")
    private String moduleLang;

    public TbModule() {
    }

    public TbModule(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
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

    public String getModuleNote() {
        return moduleNote;
    }

    public void setModuleNote(String moduleNote) {
        this.moduleNote = moduleNote;
    }

    public String getModuleAuthor() {
        return moduleAuthor;
    }

    public void setModuleAuthor(String moduleAuthor) {
        this.moduleAuthor = moduleAuthor;
    }

    public Date getModuleCreated() {
        return moduleCreated;
    }

    public void setModuleCreated(Date moduleCreated) {
        this.moduleCreated = moduleCreated;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getModuleDb() {
        return moduleDb;
    }

    public void setModuleDb(String moduleDb) {
        this.moduleDb = moduleDb;
    }

    public String getModuleDbKey() {
        return moduleDbKey;
    }

    public void setModuleDbKey(String moduleDbKey) {
        this.moduleDbKey = moduleDbKey;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleConfig() {
        return moduleConfig;
    }

    public void setModuleConfig(String moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    public String getModuleLang() {
        return moduleLang;
    }

    public void setModuleLang(String moduleLang) {
        this.moduleLang = moduleLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduleId != null ? moduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbModule)) {
            return false;
        }
        TbModule other = (TbModule) object;
        if ((this.moduleId == null && other.moduleId != null) || (this.moduleId != null && !this.moduleId.equals(other.moduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbModule[ moduleId=" + moduleId + " ]";
    }
    
}
