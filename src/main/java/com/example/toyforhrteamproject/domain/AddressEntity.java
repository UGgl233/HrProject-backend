package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Address", schema = "hrproject", catalog = "")
public class AddressEntity {
    private int addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private Integer zipcode;
    private String stateName;
    private String stateAbbr;
    private Integer personId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "addressId", nullable = false)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "addressLine1", nullable = true, length = 50)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Basic
    @Column(name = "addressLine2", nullable = true, length = 50)
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "zipcode", nullable = true)
    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "stateName", nullable = true, length = 30)
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Basic
    @Column(name = "stateAbbr", nullable = true, length = 30)
    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    @Basic
    @Column(name = "personId", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return addressId == that.addressId &&
                Objects.equals(addressLine1, that.addressLine1) &&
                Objects.equals(addressLine2, that.addressLine2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(stateName, that.stateName) &&
                Objects.equals(stateAbbr, that.stateAbbr) &&
                Objects.equals(personId, that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, addressLine1, addressLine2, city, zipcode, stateName, stateAbbr, personId);
    }
}
