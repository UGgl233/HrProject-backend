package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "UserRole", schema = "hrproject", catalog = "")
public class UserRoleEntity {
    private int userRoleId;
    private Integer userId;
    private Integer roleId;
    private Byte activeFlag;
    private Date createDate;
    private Date modificationDate;
    private String lastModificationUser;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "userRoleId", nullable = false)
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "userId", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "roleId", nullable = true)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "activeFlag", nullable = true)
    public Byte getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Byte activeFlag) {
        this.activeFlag = activeFlag;
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
        UserRoleEntity that = (UserRoleEntity) o;
        return userRoleId == that.userRoleId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(activeFlag, that.activeFlag) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modificationDate, that.modificationDate) &&
                Objects.equals(lastModificationUser, that.lastModificationUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRoleId, userId, roleId, activeFlag, createDate, modificationDate, lastModificationUser);
    }
}
