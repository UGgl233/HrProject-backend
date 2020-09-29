package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Role", schema = "hrproject", catalog = "")
public class RoleEntity {
    private int roleId;
    private String rolename;
    private String description;
    private Date createDate;
    private Date modificationDate;
    private String lastModificationUser;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "roleId", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "rolename", nullable = true, length = 30)
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 30)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "createDate", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modificationDate", nullable = true)
    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Basic
    @Column(name = "lastModificationUser", nullable = true, length = 30)
    public String getLastModificationUser() {
        return lastModificationUser;
    }

    public void setLastModificationUser(String lastModificationUser) {
        this.lastModificationUser = lastModificationUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId &&
                Objects.equals(rolename, that.rolename) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modificationDate, that.modificationDate) &&
                Objects.equals(lastModificationUser, that.lastModificationUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, rolename, description, createDate, modificationDate, lastModificationUser);
    }
}
