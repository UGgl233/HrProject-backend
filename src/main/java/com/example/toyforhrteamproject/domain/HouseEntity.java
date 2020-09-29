package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "House", schema = "hrproject", catalog = "")
public class HouseEntity {
    private int houseId;
    private Integer contactId;
    private String address;
    private Integer numberOfPerson;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "houseId", nullable = false)
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "contactId", nullable = true)
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 30)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "numberOfPerson", nullable = true)
    public Integer getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(Integer numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseEntity that = (HouseEntity) o;
        return houseId == that.houseId &&
                Objects.equals(contactId, that.contactId) &&
                Objects.equals(address, that.address) &&
                Objects.equals(numberOfPerson, that.numberOfPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, contactId, address, numberOfPerson);
    }
}
