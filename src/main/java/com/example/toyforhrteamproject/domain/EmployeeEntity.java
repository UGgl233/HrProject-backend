package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Employee", schema = "hrproject", catalog = "")
public class EmployeeEntity {
    private int empId;
    private Integer personId;
    private String title;
    private Integer managerId;
    private Date startDate;
    private Date endDate;
    private String avartar;
    private String car;
    private Integer visaStatusId;
    private Date visaStartDate;
    private Date visaEndDate;
    private Integer driverLisence;
    private Date driverLisenceExpirationDate;
    private Integer houseId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "empId", nullable = false)
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "personId", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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
    @Column(name = "managerId", nullable = true)
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "startDate", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "avartar", nullable = true, length = 100)
    public String getAvartar() {
        return avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }

    @Basic
    @Column(name = "car", nullable = true, length = 30)
    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Basic
    @Column(name = "visaStatusID", nullable = true)
    public Integer getVisaStatusId() {
        return visaStatusId;
    }

    public void setVisaStatusId(Integer visaStatusId) {
        this.visaStatusId = visaStatusId;
    }

    @Basic
    @Column(name = "visaStartDate", nullable = true)
    public Date getVisaStartDate() {
        return visaStartDate;
    }

    public void setVisaStartDate(Date visaStartDate) {
        this.visaStartDate = visaStartDate;
    }

    @Basic
    @Column(name = "visaEndDate", nullable = true)
    public Date getVisaEndDate() {
        return visaEndDate;
    }

    public void setVisaEndDate(Date visaEndDate) {
        this.visaEndDate = visaEndDate;
    }

    @Basic
    @Column(name = "driverLisence", nullable = true)
    public Integer getDriverLisence() {
        return driverLisence;
    }

    public void setDriverLisence(Integer driverLisence) {
        this.driverLisence = driverLisence;
    }

    @Basic
    @Column(name = "driverLisenceExpirationDate", nullable = true)
    public Date getDriverLisenceExpirationDate() {
        return driverLisenceExpirationDate;
    }

    public void setDriverLisenceExpirationDate(Date driverLisenceExpirationDate) {
        this.driverLisenceExpirationDate = driverLisenceExpirationDate;
    }

    @Basic
    @Column(name = "houseID", nullable = true)
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return empId == that.empId &&
                Objects.equals(personId, that.personId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(managerId, that.managerId) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(avartar, that.avartar) &&
                Objects.equals(car, that.car) &&
                Objects.equals(visaStatusId, that.visaStatusId) &&
                Objects.equals(visaStartDate, that.visaStartDate) &&
                Objects.equals(visaEndDate, that.visaEndDate) &&
                Objects.equals(driverLisence, that.driverLisence) &&
                Objects.equals(driverLisenceExpirationDate, that.driverLisenceExpirationDate) &&
                Objects.equals(houseId, that.houseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, personId, title, managerId, startDate, endDate, avartar, car, visaStatusId, visaStartDate, visaEndDate, driverLisence, driverLisenceExpirationDate, houseId);
    }
}
