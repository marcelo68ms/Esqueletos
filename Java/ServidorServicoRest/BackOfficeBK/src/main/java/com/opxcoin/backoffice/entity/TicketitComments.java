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
@Table(name = "ticketit_comments")
@NamedQueries({
    @NamedQuery(name = "TicketitComments.findAll", query = "SELECT t FROM TicketitComments t")
    , @NamedQuery(name = "TicketitComments.findById", query = "SELECT t FROM TicketitComments t WHERE t.id = :id")
    , @NamedQuery(name = "TicketitComments.findByUserId", query = "SELECT t FROM TicketitComments t WHERE t.userId = :userId")
    , @NamedQuery(name = "TicketitComments.findByTicketId", query = "SELECT t FROM TicketitComments t WHERE t.ticketId = :ticketId")
    , @NamedQuery(name = "TicketitComments.findByCreatedAt", query = "SELECT t FROM TicketitComments t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TicketitComments.findByUpdatedAt", query = "SELECT t FROM TicketitComments t WHERE t.updatedAt = :updatedAt")})
public class TicketitComments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "html")
    private String html;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticket_id")
    private int ticketId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public TicketitComments() {
    }

    public TicketitComments(Integer id) {
        this.id = id;
    }

    public TicketitComments(Integer id, String content, int userId, int ticketId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.ticketId = ticketId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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
        if (!(object instanceof TicketitComments)) {
            return false;
        }
        TicketitComments other = (TicketitComments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TicketitComments[ id=" + id + " ]";
    }
    
}
