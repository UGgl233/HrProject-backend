package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "RegistrationToken", schema = "hrproject", catalog = "")
public class RegistrationTokenEntity {
    private int tokenId;
    private String token;
    private Date validDuration;
    private String email;
    private String createdBy;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "tokenId", nullable = false)
    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    @Basic
    @Column(name = "token", nullable = true, length = 80)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "validDuration", nullable = true)
    public Date getValidDuration() {
        return validDuration;
    }

    public void setValidDuration(Date validDuration) {
        this.validDuration = validDuration;
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
    @Column(name = "createdBy", nullable = true, length = 30)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationTokenEntity that = (RegistrationTokenEntity) o;
        return tokenId == that.tokenId &&
                Objects.equals(token, that.token) &&
                Objects.equals(validDuration, that.validDuration) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenId, token, validDuration, email, createdBy);
    }
}
