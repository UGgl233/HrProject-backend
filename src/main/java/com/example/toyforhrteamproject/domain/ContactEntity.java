package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Contact", schema = "hrproject", catalog = "")
public class ContactEntity {
    private int contactId;
    private Integer personId;
    private String relationship;
    private String title;
    private Byte isReferrence;
    private Byte isEmergency;
    private Byte isLandlord;
    private String name;
    private String phone;
    private String email;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "contactId", nullable = false)
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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
    @Column(name = "relationship", nullable = true, length = 30)
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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
    @Column(name = "name", nullable = true, length = 60)
    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return title;
    }

    public void setPhone(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return title;
    }

    public void setEmail(String title) {
        this.title = title;
    }


    @Basic
    @Column(name = "isReferrence", nullable = true)
    public Byte getIsReferrence() {
        return isReferrence;
    }

    public void setIsReferrence(Byte isReferrence) {
        this.isReferrence = isReferrence;
    }

    @Basic
    @Column(name = "isEmergency", nullable = true)
    public Byte getIsEmergency() {
        return isEmergency;
    }

    public void setIsEmergency(Byte isEmergency) {
        this.isEmergency = isEmergency;
    }

    @Basic
    @Column(name = "isLandlord", nullable = true)
    public Byte getIsLandlord() {
        return isLandlord;
    }

    public void setIsLandlord(Byte isLandlord) {
        this.isLandlord = isLandlord;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactEntity that = (ContactEntity) o;
        return contactId == that.contactId &&
                Objects.equals(personId, that.personId) &&
                Objects.equals(relationship, that.relationship) &&
                Objects.equals(title, that.title) &&
                Objects.equals(isReferrence, that.isReferrence) &&
                Objects.equals(isEmergency, that.isEmergency) &&
                Objects.equals(isLandlord, that.isLandlord) &&
                Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, personId, relationship, title, isReferrence, isEmergency, isLandlord, name, phone, email);
    }
}
