/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "ticketit_categories_users")
@NamedQueries({
    @NamedQuery(name = "TicketitCategoriesUsers.findAll", query = "SELECT t FROM TicketitCategoriesUsers t")
    , @NamedQuery(name = "TicketitCategoriesUsers.findByCategoryId", query = "SELECT t FROM TicketitCategoriesUsers t WHERE t.ticketitCategoriesUsersPK.categoryId = :categoryId")
    , @NamedQuery(name = "TicketitCategoriesUsers.findByUserId", query = "SELECT t FROM TicketitCategoriesUsers t WHERE t.ticketitCategoriesUsersPK.userId = :userId")})
public class TicketitCategoriesUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TicketitCategoriesUsersPK ticketitCategoriesUsersPK;

    public TicketitCategoriesUsers() {
    }

    public TicketitCategoriesUsers(TicketitCategoriesUsersPK ticketitCategoriesUsersPK) {
        this.ticketitCategoriesUsersPK = ticketitCategoriesUsersPK;
    }

    public TicketitCategoriesUsers(int categoryId, int userId) {
        this.ticketitCategoriesUsersPK = new TicketitCategoriesUsersPK(categoryId, userId);
    }

    public TicketitCategoriesUsersPK getTicketitCategoriesUsersPK() {
        return ticketitCategoriesUsersPK;
    }

    public void setTicketitCategoriesUsersPK(TicketitCategoriesUsersPK ticketitCategoriesUsersPK) {
        this.ticketitCategoriesUsersPK = ticketitCategoriesUsersPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketitCategoriesUsersPK != null ? ticketitCategoriesUsersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketitCategoriesUsers)) {
            return false;
        }
        TicketitCategoriesUsers other = (TicketitCategoriesUsers) object;
        if ((this.ticketitCategoriesUsersPK == null && other.ticketitCategoriesUsersPK != null) || (this.ticketitCategoriesUsersPK != null && !this.ticketitCategoriesUsersPK.equals(other.ticketitCategoriesUsersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TicketitCategoriesUsers[ ticketitCategoriesUsersPK=" + ticketitCategoriesUsersPK + " ]";
    }
    
}
