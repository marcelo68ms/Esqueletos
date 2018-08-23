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
@Table(name = "ticketit")
@NamedQueries({
    @NamedQuery(name = "Ticketit.findAll", query = "SELECT t FROM Ticketit t")
    , @NamedQuery(name = "Ticketit.findById", query = "SELECT t FROM Ticketit t WHERE t.id = :id")
    , @NamedQuery(name = "Ticketit.findBySubject", query = "SELECT t FROM Ticketit t WHERE t.subject = :subject")
    , @NamedQuery(name = "Ticketit.findByStatusId", query = "SELECT t FROM Ticketit t WHERE t.statusId = :statusId")
    , @NamedQuery(name = "Ticketit.findByPriorityId", query = "SELECT t FROM Ticketit t WHERE t.priorityId = :priorityId")
    , @NamedQuery(name = "Ticketit.findByUserId", query = "SELECT t FROM Ticketit t WHERE t.userId = :userId")
    , @NamedQuery(name = "Ticketit.findByAgentId", query = "SELECT t FROM Ticketit t WHERE t.agentId = :agentId")
    , @NamedQuery(name = "Ticketit.findByCategoryId", query = "SELECT t FROM Ticketit t WHERE t.categoryId = :categoryId")
    , @NamedQuery(name = "Ticketit.findByCreatedAt", query = "SELECT t FROM Ticketit t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "Ticketit.findByUpdatedAt", query = "SELECT t FROM Ticketit t WHERE t.updatedAt = :updatedAt")
    , @NamedQuery(name = "Ticketit.findByCompletedAt", query = "SELECT t FROM Ticketit t WHERE t.completedAt = :completedAt")})
public class Ticketit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "content")
    private String content;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "html")
    private String html;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_id")
    private int statusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priority_id")
    private int priorityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agent_id")
    private int agentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "completed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedAt;

    public Ticketit() {
    }

    public Ticketit(Integer id) {
        this.id = id;
    }

    public Ticketit(Integer id, String subject, String content, int statusId, int priorityId, int userId, int agentId, int categoryId) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.userId = userId;
        this.agentId = agentId;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
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
        if (!(object instanceof Ticketit)) {
            return false;
        }
        Ticketit other = (Ticketit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Ticketit[ id=" + id + " ]";
    }
    
}
