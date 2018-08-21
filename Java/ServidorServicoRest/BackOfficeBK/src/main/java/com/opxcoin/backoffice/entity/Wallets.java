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
@Table(name = "wallets")
@NamedQueries({
    @NamedQuery(name = "Wallets.findAll", query = "SELECT w FROM Wallets w")
    , @NamedQuery(name = "Wallets.findById", query = "SELECT w FROM Wallets w WHERE w.id = :id")
    , @NamedQuery(name = "Wallets.findByEntryBy", query = "SELECT w FROM Wallets w WHERE w.entryBy = :entryBy")
    , @NamedQuery(name = "Wallets.findByBitcoin", query = "SELECT w FROM Wallets w WHERE w.bitcoin = :bitcoin")
    , @NamedQuery(name = "Wallets.findByEthereum", query = "SELECT w FROM Wallets w WHERE w.ethereum = :ethereum")})
public class Wallets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entry_by")
    private int entryBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "bitcoin")
    private String bitcoin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ethereum")
    private String ethereum;

    public Wallets() {
    }

    public Wallets(Integer id) {
        this.id = id;
    }

    public Wallets(Integer id, int entryBy, String bitcoin, String ethereum) {
        this.id = id;
        this.entryBy = entryBy;
        this.bitcoin = bitcoin;
        this.ethereum = ethereum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(int entryBy) {
        this.entryBy = entryBy;
    }

    public String getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(String bitcoin) {
        this.bitcoin = bitcoin;
    }

    public String getEthereum() {
        return ethereum;
    }

    public void setEthereum(String ethereum) {
        this.ethereum = ethereum;
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
        if (!(object instanceof Wallets)) {
            return false;
        }
        Wallets other = (Wallets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.Wallets[ id=" + id + " ]";
    }
    
}
