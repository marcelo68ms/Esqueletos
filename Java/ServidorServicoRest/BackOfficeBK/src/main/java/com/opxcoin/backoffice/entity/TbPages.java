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
@Table(name = "tb_pages")
@NamedQueries({
    @NamedQuery(name = "TbPages.findAll", query = "SELECT t FROM TbPages t")
    , @NamedQuery(name = "TbPages.findByPageID", query = "SELECT t FROM TbPages t WHERE t.pageID = :pageID")
    , @NamedQuery(name = "TbPages.findByTitle", query = "SELECT t FROM TbPages t WHERE t.title = :title")
    , @NamedQuery(name = "TbPages.findByAlias", query = "SELECT t FROM TbPages t WHERE t.alias = :alias")
    , @NamedQuery(name = "TbPages.findBySinopsis", query = "SELECT t FROM TbPages t WHERE t.sinopsis = :sinopsis")
    , @NamedQuery(name = "TbPages.findByCreated", query = "SELECT t FROM TbPages t WHERE t.created = :created")
    , @NamedQuery(name = "TbPages.findByUpdated", query = "SELECT t FROM TbPages t WHERE t.updated = :updated")
    , @NamedQuery(name = "TbPages.findByFilename", query = "SELECT t FROM TbPages t WHERE t.filename = :filename")
    , @NamedQuery(name = "TbPages.findByStatus", query = "SELECT t FROM TbPages t WHERE t.status = :status")
    , @NamedQuery(name = "TbPages.findByAllowGuest", query = "SELECT t FROM TbPages t WHERE t.allowGuest = :allowGuest")
    , @NamedQuery(name = "TbPages.findByTemplate", query = "SELECT t FROM TbPages t WHERE t.template = :template")
    , @NamedQuery(name = "TbPages.findByMetakey", query = "SELECT t FROM TbPages t WHERE t.metakey = :metakey")
    , @NamedQuery(name = "TbPages.findByDefault1", query = "SELECT t FROM TbPages t WHERE t.default1 = :default1")
    , @NamedQuery(name = "TbPages.findByPagetype", query = "SELECT t FROM TbPages t WHERE t.pagetype = :pagetype")
    , @NamedQuery(name = "TbPages.findByViews", query = "SELECT t FROM TbPages t WHERE t.views = :views")
    , @NamedQuery(name = "TbPages.findByUserid", query = "SELECT t FROM TbPages t WHERE t.userid = :userid")
    , @NamedQuery(name = "TbPages.findByImage", query = "SELECT t FROM TbPages t WHERE t.image = :image")})
public class TbPages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pageID")
    private Integer pageID;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 100)
    @Column(name = "alias")
    private String alias;
    @Size(max = 250)
    @Column(name = "sinopsis")
    private String sinopsis;
    @Lob
    @Size(max = 65535)
    @Column(name = "note")
    private String note;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 50)
    @Column(name = "filename")
    private String filename;
    @Size(max = 7)
    @Column(name = "status")
    private String status;
    @Lob
    @Size(max = 65535)
    @Column(name = "access")
    private String access;
    @Size(max = 2)
    @Column(name = "allow_guest")
    private String allowGuest;
    @Size(max = 9)
    @Column(name = "template")
    private String template;
    @Size(max = 255)
    @Column(name = "metakey")
    private String metakey;
    @Lob
    @Size(max = 65535)
    @Column(name = "metadesc")
    private String metadesc;
    @Size(max = 2)
    @Column(name = "default")
    private String default1;
    @Size(max = 5)
    @Column(name = "pagetype")
    private String pagetype;
    @Lob
    @Size(max = 65535)
    @Column(name = "labels")
    private String labels;
    @Column(name = "views")
    private Integer views;
    @Column(name = "userid")
    private Integer userid;
    @Size(max = 255)
    @Column(name = "image")
    private String image;

    public TbPages() {
    }

    public TbPages(Integer pageID) {
        this.pageID = pageID;
    }

    public Integer getPageID() {
        return pageID;
    }

    public void setPageID(Integer pageID) {
        this.pageID = pageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
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

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getAllowGuest() {
        return allowGuest;
    }

    public void setAllowGuest(String allowGuest) {
        this.allowGuest = allowGuest;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getMetakey() {
        return metakey;
    }

    public void setMetakey(String metakey) {
        this.metakey = metakey;
    }

    public String getMetadesc() {
        return metadesc;
    }

    public void setMetadesc(String metadesc) {
        this.metadesc = metadesc;
    }

    public String getDefault1() {
        return default1;
    }

    public void setDefault1(String default1) {
        this.default1 = default1;
    }

    public String getPagetype() {
        return pagetype;
    }

    public void setPagetype(String pagetype) {
        this.pagetype = pagetype;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pageID != null ? pageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPages)) {
            return false;
        }
        TbPages other = (TbPages) object;
        if ((this.pageID == null && other.pageID != null) || (this.pageID != null && !this.pageID.equals(other.pageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbPages[ pageID=" + pageID + " ]";
    }
    
}
