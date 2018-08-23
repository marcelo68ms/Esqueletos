/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opxcoin.backoffice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ordensCompra")
@NamedQueries({
    @NamedQuery(name = "OrdensCompra.findAll", query = "SELECT o FROM OrdensCompra o")
    , @NamedQuery(name = "OrdensCompra.findById", query = "SELECT o FROM OrdensCompra o WHERE o.id = :id")
    , @NamedQuery(name = "OrdensCompra.findByEntryBy", query = "SELECT o FROM OrdensCompra o WHERE o.entryBy = :entryBy")
    , @NamedQuery(name = "OrdensCompra.findByMoeda", query = "SELECT o FROM OrdensCompra o WHERE o.moeda = :moeda")
    , @NamedQuery(name = "OrdensCompra.findByQuantidade", query = "SELECT o FROM OrdensCompra o WHERE o.quantidade = :quantidade")
    , @NamedQuery(name = "OrdensCompra.findByPreco", query = "SELECT o FROM OrdensCompra o WHERE o.preco = :preco")
    , @NamedQuery(name = "OrdensCompra.findByPagar", query = "SELECT o FROM OrdensCompra o WHERE o.pagar = :pagar")
    , @NamedQuery(name = "OrdensCompra.findByComissao", query = "SELECT o FROM OrdensCompra o WHERE o.comissao = :comissao")
    , @NamedQuery(name = "OrdensCompra.findByStatus", query = "SELECT o FROM OrdensCompra o WHERE o.status = :status")
    , @NamedQuery(name = "OrdensCompra.findByDataCriacao", query = "SELECT o FROM OrdensCompra o WHERE o.dataCriacao = :dataCriacao")
    , @NamedQuery(name = "OrdensCompra.findByDataExecucao", query = "SELECT o FROM OrdensCompra o WHERE o.dataExecucao = :dataExecucao")
    , @NamedQuery(name = "OrdensCompra.findByPago", query = "SELECT o FROM OrdensCompra o WHERE o.pago = :pago")})
public class OrdensCompra implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "moeda")
    private String moeda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco")
    private BigDecimal preco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagar")
    private BigDecimal pagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comissao")
    private BigDecimal comissao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataExecucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExecucao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "pago")
    private String pago;

    public OrdensCompra() {
    }

    public OrdensCompra(Integer id) {
        this.id = id;
    }

    public OrdensCompra(Integer id, int entryBy, String moeda, BigDecimal quantidade, BigDecimal preco, BigDecimal pagar, BigDecimal comissao, String status, Date dataCriacao, Date dataExecucao, String pago) {
        this.id = id;
        this.entryBy = entryBy;
        this.moeda = moeda;
        this.quantidade = quantidade;
        this.preco = preco;
        this.pagar = pagar;
        this.comissao = comissao;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataExecucao = dataExecucao;
        this.pago = pago;
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

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPagar() {
        return pagar;
    }

    public void setPagar(BigDecimal pagar) {
        this.pagar = pagar;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
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
        if (!(object instanceof OrdensCompra)) {
            return false;
        }
        OrdensCompra other = (OrdensCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.OrdensCompra[ id=" + id + " ]";
    }
    
}
