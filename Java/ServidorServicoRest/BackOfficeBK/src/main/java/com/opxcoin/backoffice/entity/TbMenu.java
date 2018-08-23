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
@Table(name = "tb_menu")
@NamedQueries({
    @NamedQuery(name = "TbMenu.findAll", query = "SELECT t FROM TbMenu t")
    , @NamedQuery(name = "TbMenu.findByMenuId", query = "SELECT t FROM TbMenu t WHERE t.menuId = :menuId")
    , @NamedQuery(name = "TbMenu.findByParentId", query = "SELECT t FROM TbMenu t WHERE t.parentId = :parentId")
    , @NamedQuery(name = "TbMenu.findByModule", query = "SELECT t FROM TbMenu t WHERE t.module = :module")
    , @NamedQuery(name = "TbMenu.findByUrl", query = "SELECT t FROM TbMenu t WHERE t.url = :url")
    , @NamedQuery(name = "TbMenu.findByMenuName", query = "SELECT t FROM TbMenu t WHERE t.menuName = :menuName")
    , @NamedQuery(name = "TbMenu.findByMenuType", query = "SELECT t FROM TbMenu t WHERE t.menuType = :menuType")
    , @NamedQuery(name = "TbMenu.findByRoleId", query = "SELECT t FROM TbMenu t WHERE t.roleId = :roleId")
    , @NamedQuery(name = "TbMenu.findByDeep", query = "SELECT t FROM TbMenu t WHERE t.deep = :deep")
    , @NamedQuery(name = "TbMenu.findByOrdering", query = "SELECT t FROM TbMenu t WHERE t.ordering = :ordering")
    , @NamedQuery(name = "TbMenu.findByPosition", query = "SELECT t FROM TbMenu t WHERE t.position = :position")
    , @NamedQuery(name = "TbMenu.findByMenuIcons", query = "SELECT t FROM TbMenu t WHERE t.menuIcons = :menuIcons")
    , @NamedQuery(name = "TbMenu.findByActive", query = "SELECT t FROM TbMenu t WHERE t.active = :active")
    , @NamedQuery(name = "TbMenu.findByAllowGuest", query = "SELECT t FROM TbMenu t WHERE t.allowGuest = :allowGuest")})
public class TbMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id")
    private Integer menuId;
    @Column(name = "parent_id")
    private Integer parentId;
    @Size(max = 50)
    @Column(name = "module")
    private String module;
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "menu_name")
    private String menuName;
    @Size(max = 10)
    @Column(name = "menu_type")
    private String menuType;
    @Size(max = 100)
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "deep")
    private Short deep;
    @Column(name = "ordering")
    private Integer ordering;
    @Size(max = 7)
    @Column(name = "position")
    private String position;
    @Size(max = 30)
    @Column(name = "menu_icons")
    private String menuIcons;
    @Size(max = 2)
    @Column(name = "active")
    private String active;
    @Lob
    @Size(max = 65535)
    @Column(name = "access_data")
    private String accessData;
    @Size(max = 2)
    @Column(name = "allow_guest")
    private String allowGuest;
    @Lob
    @Size(max = 65535)
    @Column(name = "menu_lang")
    private String menuLang;

    public TbMenu() {
    }

    public TbMenu(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Short getDeep() {
        return deep;
    }

    public void setDeep(Short deep) {
        this.deep = deep;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMenuIcons() {
        return menuIcons;
    }

    public void setMenuIcons(String menuIcons) {
        this.menuIcons = menuIcons;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getAccessData() {
        return accessData;
    }

    public void setAccessData(String accessData) {
        this.accessData = accessData;
    }

    public String getAllowGuest() {
        return allowGuest;
    }

    public void setAllowGuest(String allowGuest) {
        this.allowGuest = allowGuest;
    }

    public String getMenuLang() {
        return menuLang;
    }

    public void setMenuLang(String menuLang) {
        this.menuLang = menuLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMenu)) {
            return false;
        }
        TbMenu other = (TbMenu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opxcoin.backoffice.entity.TbMenu[ menuId=" + menuId + " ]";
    }
    
}
