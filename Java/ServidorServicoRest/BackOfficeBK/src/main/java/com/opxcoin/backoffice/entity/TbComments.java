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
@Table(name = "tb_comments")
@NamedQueries({
    @NamedQuery(name = "TbComments.findAll", query = "SELECT t FROM TbComments t")
    , @NamedQuery(name = "TbComments.findByCommentID", query = "SELECT t FROM TbComments t WHERE t.commentID = :commentID")
    , @NamedQuery(name = "TbComments.findByPageID", query = "SELECT t FROM TbComments t WHERE t.pageID = :pageID")
    , @NamedQuery(name = "TbComments.findByUserID", query = "SELECT t FROM TbComments t WHERE t.userID = :userID")
    , @NamedQuery(name = "TbComments.findByPosted", query = "SELECT t FROM TbComments t WHERE t.posted = :posted")})
public class TbComments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commentID")
    private Integer commentID;
    @Column(name = "pageID")
    private Integer pageID;
    @Column(name = "userID")
    private Integer userID;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comments")
    private String comments;
    @Column(name = "posted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posted;

    public TbComments() {
    }

    public TbComments(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getPageID() {
        return pageID;
    }

    public void setPageID(Integer pageID) {
        this.pageID = pageID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentID != null ? commentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbComments)) {
            return false;
        }
        TbComments other = (TbComments) object;
        if ((this.commentID == null && other.commentID != null) || (this.commentID != null && !this.commentID.equals(other.commentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbComments[ commentID=" + commentID + " ]";
    }
    
}
