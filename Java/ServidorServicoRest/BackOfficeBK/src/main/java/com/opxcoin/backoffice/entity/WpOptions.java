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
import javax.persistence.Lob;
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
@Table(name = "wp_options")
@NamedQueries({
    @NamedQuery(name = "WpOptions.findAll", query = "SELECT w FROM WpOptions w")
    , @NamedQuery(name = "WpOptions.findByOptionId", query = "SELECT w FROM WpOptions w WHERE w.optionId = :optionId")
    , @NamedQuery(name = "WpOptions.findByOptionName", query = "SELECT w FROM WpOptions w WHERE w.optionName = :optionName")
    , @NamedQuery(name = "WpOptions.findByAutoload", query = "SELECT w FROM WpOptions w WHERE w.autoload = :autoload")})
public class WpOptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "option_id")
    private Long optionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 191)
    @Column(name = "option_name")
    private String optionName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "option_value")
    private String optionValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "autoload")
    private String autoload;

    public WpOptions() {
    }

    public WpOptions(Long optionId) {
        this.optionId = optionId;
    }

    public WpOptions(Long optionId, String optionName, String optionValue, String autoload) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.autoload = autoload;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getAutoload() {
        return autoload;
    }

    public void setAutoload(String autoload) {
        this.autoload = autoload;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionId != null ? optionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpOptions)) {
            return false;
        }
        WpOptions other = (WpOptions) object;
        if ((this.optionId == null && other.optionId != null) || (this.optionId != null && !this.optionId.equals(other.optionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.WpOptions[ optionId=" + optionId + " ]";
    }
    
}
