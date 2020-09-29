package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "FacilityReport", schema = "hrproject", catalog = "")
public class FacilityReportEntity {
    private int facilityReportId;
    private String title;
    private Integer empId;
    private Date reportDate;
    private String description;
    private String status;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "facilityReportId", nullable = false)
    public int getFacilityReportId() {
        return facilityReportId;
    }

    public void setFacilityReportId(int facilityReportId) {
        this.facilityReportId = facilityReportId;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "reportDate", nullable = true)
    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacilityReportEntity that = (FacilityReportEntity) o;
        return facilityReportId == that.facilityReportId &&
                Objects.equals(title, that.title) &&
                Objects.equals(empId, that.empId) &&
                Objects.equals(reportDate, that.reportDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityReportId, title, empId, reportDate, description, status);
    }
}
