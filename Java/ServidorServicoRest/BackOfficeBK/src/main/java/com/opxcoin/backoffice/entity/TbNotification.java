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
@Table(name = "tb_notification")
@NamedQueries({
    @NamedQuery(name = "TbNotification.findAll", query = "SELECT t FROM TbNotification t")
    , @NamedQuery(name = "TbNotification.findById", query = "SELECT t FROM TbNotification t WHERE t.id = :id")
    , @NamedQuery(name = "TbNotification.findByUserid", query = "SELECT t FROM TbNotification t WHERE t.userid = :userid")
    , @NamedQuery(name = "TbNotification.findByEntryBy", query = "SELECT t FROM TbNotification t WHERE t.entryBy = :entryBy")
    , @NamedQuery(name = "TbNotification.findByUrl", query = "SELECT t FROM TbNotification t WHERE t.url = :url")
    , @NamedQuery(name = "TbNotification.findByTitle", query = "SELECT t FROM TbNotification t WHERE t.title = :title")
    , @NamedQuery(name = "TbNotification.findByCreated", query = "SELECT t FROM TbNotification t WHERE t.created = :created")
    , @NamedQuery(name = "TbNotification.findByIcon", query = "SELECT t FROM TbNotification t WHERE t.icon = :icon")
    , @NamedQuery(name = "TbNotification.findByIsRead", query = "SELECT t FROM TbNotification t WHERE t.isRead = :isRead")
    , @NamedQuery(name = "TbNotification.findByPostedBy", query = "SELECT t FROM TbNotification t WHERE t.postedBy = :postedBy")
    , @NamedQuery(name = "TbNotification.findByCreatedAt", query = "SELECT t FROM TbNotification t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TbNotification.findByUpdatedAt", query = "SELECT t FROM TbNotification t WHERE t.updatedAt = :updatedAt")})
public class TbNotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userid")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entry_by")
    private int entryBy;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "note")
    private String note;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 20)
    @Column(name = "icon")
    private String icon;
    @Size(max = 2)
    @Column(name = "is_read")
    private String isRead;
    @Column(name = "postedBy")
    private Integer postedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public TbNotification() {
    }

    public TbNotification(Integer id) {
        this.id = id;
    }

    public TbNotification(Integer id, int entryBy, Date createdAt, Date updatedAt) {
        this.id = id;
        this.entryBy = entryBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public int getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(int entryBy) {
        this.entryBy = entryBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public Integer getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Integer postedBy) {
        this.postedBy = postedBy;
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
        if (!(object instanceof TbNotification)) {
            return false;
        }
        TbNotification other = (TbNotification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbNotification[ id=" + id + " ]";
    }
    
}
