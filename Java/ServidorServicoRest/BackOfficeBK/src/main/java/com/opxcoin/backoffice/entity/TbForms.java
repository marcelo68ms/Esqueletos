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
import javax.validation.constraints.Size;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "tb_forms")
@NamedQueries({
    @NamedQuery(name = "TbForms.findAll", query = "SELECT t FROM TbForms t")
    , @NamedQuery(name = "TbForms.findByFormID", query = "SELECT t FROM TbForms t WHERE t.formID = :formID")
    , @NamedQuery(name = "TbForms.findByName", query = "SELECT t FROM TbForms t WHERE t.name = :name")
    , @NamedQuery(name = "TbForms.findByMethod", query = "SELECT t FROM TbForms t WHERE t.method = :method")
    , @NamedQuery(name = "TbForms.findByTablename", query = "SELECT t FROM TbForms t WHERE t.tablename = :tablename")
    , @NamedQuery(name = "TbForms.findByEmail", query = "SELECT t FROM TbForms t WHERE t.email = :email")})
public class TbForms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "formID")
    private Integer formID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 5)
    @Column(name = "method")
    private String method;
    @Size(max = 50)
    @Column(name = "tablename")
    private String tablename;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 225)
    @Column(name = "email")
    private String email;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "configuration")
    private String configuration;
    @Lob
    @Size(max = 65535)
    @Column(name = "success")
    private String success;
    @Lob
    @Size(max = 65535)
    @Column(name = "failed")
    private String failed;
    @Lob
    @Size(max = 65535)
    @Column(name = "redirect")
    private String redirect;

    public TbForms() {
    }

    public TbForms(Integer formID) {
        this.formID = formID;
    }

    public Integer getFormID() {
        return formID;
    }

    public void setFormID(Integer formID) {
        this.formID = formID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formID != null ? formID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbForms)) {
            return false;
        }
        TbForms other = (TbForms) object;
        if ((this.formID == null && other.formID != null) || (this.formID != null && !this.formID.equals(other.formID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbForms[ formID=" + formID + " ]";
    }
    
}
