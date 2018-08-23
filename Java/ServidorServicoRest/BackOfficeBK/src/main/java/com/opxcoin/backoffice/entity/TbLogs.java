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
@Table(name = "tb_logs")
@NamedQueries({
    @NamedQuery(name = "TbLogs.findAll", query = "SELECT t FROM TbLogs t")
    , @NamedQuery(name = "TbLogs.findByAuditID", query = "SELECT t FROM TbLogs t WHERE t.auditID = :auditID")
    , @NamedQuery(name = "TbLogs.findByIpaddress", query = "SELECT t FROM TbLogs t WHERE t.ipaddress = :ipaddress")
    , @NamedQuery(name = "TbLogs.findByUserId", query = "SELECT t FROM TbLogs t WHERE t.userId = :userId")
    , @NamedQuery(name = "TbLogs.findByModule", query = "SELECT t FROM TbLogs t WHERE t.module = :module")
    , @NamedQuery(name = "TbLogs.findByTask", query = "SELECT t FROM TbLogs t WHERE t.task = :task")
    , @NamedQuery(name = "TbLogs.findByLogdate", query = "SELECT t FROM TbLogs t WHERE t.logdate = :logdate")})
public class TbLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "auditID")
    private Integer auditID;
    @Size(max = 50)
    @Column(name = "ipaddress")
    private String ipaddress;
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 50)
    @Column(name = "module")
    private String module;
    @Size(max = 50)
    @Column(name = "task")
    private String task;
    @Lob
    @Size(max = 65535)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "logdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logdate;

    public TbLogs() {
    }

    public TbLogs(Integer auditID) {
        this.auditID = auditID;
    }

    public TbLogs(Integer auditID, Date logdate) {
        this.auditID = auditID;
        this.logdate = logdate;
    }

    public Integer getAuditID() {
        return auditID;
    }

    public void setAuditID(Integer auditID) {
        this.auditID = auditID;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
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
        if (!(object instanceof TbLogs)) {
            return false;
        }
        TbLogs other = (TbLogs) object;
        if ((this.auditID == null && other.auditID != null) || (this.auditID != null && !this.auditID.equals(other.auditID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbLogs[ auditID=" + auditID + " ]";
    }
    
}
