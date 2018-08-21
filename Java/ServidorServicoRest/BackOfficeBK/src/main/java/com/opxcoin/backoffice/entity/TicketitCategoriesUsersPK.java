/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marcelo
 */
@Embeddable
public class TicketitCategoriesUsersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;

    public TicketitCategoriesUsersPK() {
    }

    public TicketitCategoriesUsersPK(int categoryId, int userId) {
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) categoryId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketitCategoriesUsersPK)) {
            return false;
        }
        TicketitCategoriesUsersPK other = (TicketitCategoriesUsersPK) object;
        if (this.categoryId != other.categoryId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TicketitCategoriesUsersPK[ categoryId=" + categoryId + ", userId=" + userId + " ]";
    }
    
}
