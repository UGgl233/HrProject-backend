package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ApplicationWorkFlow", schema = "hrproject", catalog = "")
public class ApplicationWorkFlowEntity {
    private int applicationWorkFlowId;
    private Integer empId;
    private Date createdDate;
    private Date modificationDate;
    private String status;
    private String comments;
    private String type;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "applicationWorkFlowId", nullable = false)
    public int getApplicationWorkFlowId() {
        return applicationWorkFlowId;
    }

    public void setApplicationWorkFlowId(int applicationWorkFlowId) {
        this.applicationWorkFlowId = applicationWorkFlowId;
    }

    @Basic
    @Column(name = "empId", nullable = true)
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "createdDate", nullable = true)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
    @Column(name = "status", nullable = true, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = -1)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationWorkFlowEntity that = (ApplicationWorkFlowEntity) o;
        return applicationWorkFlowId == that.applicationWorkFlowId &&
                Objects.equals(empId, that.empId) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(modificationDate, that.modificationDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationWorkFlowId, empId, createdDate, modificationDate, status, comments, type);
    }
}
