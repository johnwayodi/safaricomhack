package com.johnwayodi.careerRegistration.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@MappedSuperclass
public class AbstractModel {

    @Id
    @GeneratedValue
    @Type(type = "uuid-binary")
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Column(name = "Date_Created",nullable = false)
    private ZonedDateTime dateCreated;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
