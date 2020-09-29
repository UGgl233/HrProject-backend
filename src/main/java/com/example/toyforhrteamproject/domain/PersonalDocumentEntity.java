package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "PersonalDocument", schema = "hrproject", catalog = "")
public class PersonalDocumentEntity {
    private int personalDocumentId;
    private Integer empId;
    private String path;
    private String title;
    private String comment;
    private Date createdDate;
    private String createBy;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "personalDocumentId", nullable = false)
    public int getPersonalDocumentId() {
        return personalDocumentId;
    }

    public void setPersonalDocumentId(int personalDocumentId) {
        this.personalDocumentId = personalDocumentId;
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
    @Column(name = "path", nullable = true, length = 50)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
    @Column(name = "createBy", nullable = true, length = 30)
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalDocumentEntity that = (PersonalDocumentEntity) o;
        return personalDocumentId == that.personalDocumentId &&
                Objects.equals(empId, that.empId) &&
                Objects.equals(path, that.path) &&
                Objects.equals(title, that.title) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(createBy, that.createBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalDocumentId, empId, path, title, comment, createdDate, createBy);
    }
}
