package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "VisaStatus", schema = "hrproject", catalog = "")
public class VisaStatusEntity {
    private int visaStatusId;
    private String visaType;
    private Byte isActive;
    private Date modificationDate;
    private String createUser;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "visaStatusId", nullable = false)
    public int getVisaStatusId() {
        return visaStatusId;
    }

    public void setVisaStatusId(int visaStatusId) {
        this.visaStatusId = visaStatusId;
    }

    @Basic
    @Column(name = "visaType", nullable = true, length = 20)
    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    @Basic
    @Column(name = "isActive", nullable = true)
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
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
    @Column(name = "createUser", nullable = true, length = 30)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisaStatusEntity that = (VisaStatusEntity) o;
        return visaStatusId == that.visaStatusId &&
                Objects.equals(visaType, that.visaType) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(modificationDate, that.modificationDate) &&
                Objects.equals(createUser, that.createUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visaStatusId, visaType, isActive, modificationDate, createUser);
    }
}
