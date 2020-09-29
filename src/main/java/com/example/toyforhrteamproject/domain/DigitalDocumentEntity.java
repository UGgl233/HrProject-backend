package com.example.toyforhrteamproject.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DigitalDocument", schema = "hrproject", catalog = "")
public class DigitalDocumentEntity {
    private int digitalDocumentId;
    private String type;
    private Byte required;
    private String templateLocation;
    private String description;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "digitalDocumentId", nullable = false)
    public int getDigitalDocumentId() {
        return digitalDocumentId;
    }

    public void setDigitalDocumentId(int digitalDocumentId) {
        this.digitalDocumentId = digitalDocumentId;
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
    @Column(name = "required", nullable = true)
    public Byte getRequired() {
        return required;
    }

    public void setRequired(Byte required) {
        this.required = required;
    }

    @Basic
    @Column(name = "templateLocation", nullable = true, length = 50)
    public String getTemplateLocation() {
        return templateLocation;
    }

    public void setTemplateLocation(String templateLocation) {
        this.templateLocation = templateLocation;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalDocumentEntity that = (DigitalDocumentEntity) o;
        return digitalDocumentId == that.digitalDocumentId &&
                Objects.equals(type, that.type) &&
                Objects.equals(required, that.required) &&
                Objects.equals(templateLocation, that.templateLocation) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitalDocumentId, type, required, templateLocation, description);
    }
}
