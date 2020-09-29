package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "FacilityReportDetail", schema = "hrproject", catalog = "")
public class FacilityReportDetailEntity {
    private int facilityReportDetailId;
    private Integer facilityReportId;
    private Integer empId;
    private String comments;
    private Date createdDate;
    private Date lastModificationDate;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "facilityReportDetailId", nullable = false)
    public int getFacilityReportDetailId() {
        return facilityReportDetailId;
    }

    public void setFacilityReportDetailId(int facilityReportDetailId) {
        this.facilityReportDetailId = facilityReportDetailId;
    }

    @Basic
    @Column(name = "facilityReportId", nullable = true)
    public Integer getFacilityReportId() {
        return facilityReportId;
    }

    public void setFacilityReportId(Integer facilityReportId) {
        this.facilityReportId = facilityReportId;
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
    @Column(name = "comments", nullable = true, length = -1)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
    @Column(name = "lastModificationDate", nullable = true)
    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacilityReportDetailEntity that = (FacilityReportDetailEntity) o;
        return facilityReportDetailId == that.facilityReportDetailId &&
                Objects.equals(facilityReportId, that.facilityReportId) &&
                Objects.equals(empId, that.empId) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModificationDate, that.lastModificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityReportDetailId, facilityReportId, empId, comments, createdDate, lastModificationDate);
    }
}
