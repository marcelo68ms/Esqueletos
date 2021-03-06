/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "ticketit_statuses")
@NamedQueries({
    @NamedQuery(name = "TicketitStatuses.findAll", query = "SELECT t FROM TicketitStatuses t")
    , @NamedQuery(name = "TicketitStatuses.findById", query = "SELECT t FROM TicketitStatuses t WHERE t.id = :id")
    , @NamedQuery(name = "TicketitStatuses.findByName", query = "SELECT t FROM TicketitStatuses t WHERE t.name = :name")
    , @NamedQuery(name = "TicketitStatuses.findByColor", query = "SELECT t FROM TicketitStatuses t WHERE t.color = :color")})
public class TicketitStatuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "color")
    private String color;

    public TicketitStatuses() {
    }

    public TicketitStatuses(Integer id) {
        this.id = id;
    }

    public TicketitStatuses(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        if (!(object instanceof TicketitStatuses)) {
            return false;
        }
        TicketitStatuses other = (TicketitStatuses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TicketitStatuses[ id=" + id + " ]";
    }
    
}
