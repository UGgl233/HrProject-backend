package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Facility", schema = "hrproject", catalog = "")
public class FacilityEntity {
    private int facilityId;
    private String type;
    private String description;
    private String quantity;
    private Integer houseId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "facilityId", nullable = false)
    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "quantity", nullable = true, length = 30)
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
        FacilityEntity that = (FacilityEntity) o;
        return facilityId == that.facilityId &&
                Objects.equals(type, that.type) &&
                Objects.equals(description, that.description) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(houseId, that.houseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityId, type, description, quantity, houseId);
    }
}
