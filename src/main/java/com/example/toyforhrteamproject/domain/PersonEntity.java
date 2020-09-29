package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Person", schema = "hrproject", catalog = "")
public class PersonEntity {
    private int personId;
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private String cellphone;
    private String alternatePhone;
    private String gender;
    private String ssn;
    private Date dob;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "personId", nullable = false)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = 30)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = true, length = 30)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "middlename", nullable = true, length = 30)
    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "cellphone", nullable = true, length = 30)
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Basic
    @Column(name = "alternatePhone", nullable = true, length = 30)
    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    @Basic
    @Column(name = "Gender", nullable = true, length = 10)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "SSN", nullable = true, length = 20)
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "dob", nullable = true)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return personId == that.personId &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(middlename, that.middlename) &&
                Objects.equals(email, that.email) &&
                Objects.equals(cellphone, that.cellphone) &&
                Objects.equals(alternatePhone, that.alternatePhone) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(ssn, that.ssn) &&
                Objects.equals(dob, that.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, firstname, lastname, middlename, email, cellphone, alternatePhone, gender, ssn, dob);
    }
}
