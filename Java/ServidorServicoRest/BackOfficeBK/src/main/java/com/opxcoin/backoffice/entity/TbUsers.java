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
@Table(name = "tb_users")
@NamedQueries({
    @NamedQuery(name = "TbUsers.findAll", query = "SELECT t FROM TbUsers t")
    , @NamedQuery(name = "TbUsers.findById", query = "SELECT t FROM TbUsers t WHERE t.id = :id")
    , @NamedQuery(name = "TbUsers.findByGroupId", query = "SELECT t FROM TbUsers t WHERE t.groupId = :groupId")
    , @NamedQuery(name = "TbUsers.findByUsername", query = "SELECT t FROM TbUsers t WHERE t.username = :username")
    , @NamedQuery(name = "TbUsers.findByPassword", query = "SELECT t FROM TbUsers t WHERE t.password = :password")
    , @NamedQuery(name = "TbUsers.findByEmail", query = "SELECT t FROM TbUsers t WHERE t.email = :email")
    , @NamedQuery(name = "TbUsers.findByFirstName", query = "SELECT t FROM TbUsers t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "TbUsers.findByLastName", query = "SELECT t FROM TbUsers t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "TbUsers.findByNascimento", query = "SELECT t FROM TbUsers t WHERE t.nascimento = :nascimento")
    , @NamedQuery(name = "TbUsers.findByCpf", query = "SELECT t FROM TbUsers t WHERE t.cpf = :cpf")
    , @NamedQuery(name = "TbUsers.findByAvatar", query = "SELECT t FROM TbUsers t WHERE t.avatar = :avatar")
    , @NamedQuery(name = "TbUsers.findByEntryBy", query = "SELECT t FROM TbUsers t WHERE t.entryBy = :entryBy")
    , @NamedQuery(name = "TbUsers.findByActive", query = "SELECT t FROM TbUsers t WHERE t.active = :active")
    , @NamedQuery(name = "TbUsers.findByLoginAttempt", query = "SELECT t FROM TbUsers t WHERE t.loginAttempt = :loginAttempt")
    , @NamedQuery(name = "TbUsers.findByLastLogin", query = "SELECT t FROM TbUsers t WHERE t.lastLogin = :lastLogin")
    , @NamedQuery(name = "TbUsers.findByCreatedAt", query = "SELECT t FROM TbUsers t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TbUsers.findByUpdatedAt", query = "SELECT t FROM TbUsers t WHERE t.updatedAt = :updatedAt")
    , @NamedQuery(name = "TbUsers.findByReminder", query = "SELECT t FROM TbUsers t WHERE t.reminder = :reminder")
    , @NamedQuery(name = "TbUsers.findByActivation", query = "SELECT t FROM TbUsers t WHERE t.activation = :activation")
    , @NamedQuery(name = "TbUsers.findByTicketitAdmin", query = "SELECT t FROM TbUsers t WHERE t.ticketitAdmin = :ticketitAdmin")
    , @NamedQuery(name = "TbUsers.findByTicketitAgent", query = "SELECT t FROM TbUsers t WHERE t.ticketitAgent = :ticketitAgent")
    , @NamedQuery(name = "TbUsers.findByRememberToken", query = "SELECT t FROM TbUsers t WHERE t.rememberToken = :rememberToken")
    , @NamedQuery(name = "TbUsers.findByLastActivity", query = "SELECT t FROM TbUsers t WHERE t.lastActivity = :lastActivity")
    , @NamedQuery(name = "TbUsers.findByWhatsapp", query = "SELECT t FROM TbUsers t WHERE t.whatsapp = :whatsapp")})
public class TbUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "group_id")
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 100)
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entry_by")
    private int entryBy;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "login_attempt")
    private Short loginAttempt;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Size(max = 64)
    @Column(name = "reminder")
    private String reminder;
    @Size(max = 50)
    @Column(name = "activation")
    private String activation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticketit_admin")
    private boolean ticketitAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticketit_agent")
    private boolean ticketitAgent;
    @Size(max = 100)
    @Column(name = "remember_token")
    private String rememberToken;
    @Column(name = "last_activity")
    private Integer lastActivity;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "google2fa_secret")
    private String google2faSecret;
    @Lob
    @Size(max = 65535)
    @Column(name = "config")
    private String config;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "whatsapp")
    private String whatsapp;

    public TbUsers() {
    }

    public TbUsers(Integer id) {
        this.id = id;
    }

    public TbUsers(Integer id, String username, String password, String email, Date nascimento, String cpf, int entryBy, Date createdAt, boolean ticketitAdmin, boolean ticketitAgent, String google2faSecret, String whatsapp) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.entryBy = entryBy;
        this.createdAt = createdAt;
        this.ticketitAdmin = ticketitAdmin;
        this.ticketitAgent = ticketitAgent;
        this.google2faSecret = google2faSecret;
        this.whatsapp = whatsapp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(int entryBy) {
        this.entryBy = entryBy;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Short getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(Short loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
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

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public boolean getTicketitAdmin() {
        return ticketitAdmin;
    }

    public void setTicketitAdmin(boolean ticketitAdmin) {
        this.ticketitAdmin = ticketitAdmin;
    }

    public boolean getTicketitAgent() {
        return ticketitAgent;
    }

    public void setTicketitAgent(boolean ticketitAgent) {
        this.ticketitAgent = ticketitAgent;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public Integer getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Integer lastActivity) {
        this.lastActivity = lastActivity;
    }

    public String getGoogle2faSecret() {
        return google2faSecret;
    }

    public void setGoogle2faSecret(String google2faSecret) {
        this.google2faSecret = google2faSecret;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
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
        if (!(object instanceof TbUsers)) {
            return false;
        }
        TbUsers other = (TbUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbUsers[ id=" + id + " ]";
    }
    
}
