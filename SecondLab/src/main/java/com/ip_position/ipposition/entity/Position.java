package com.ip_position.ipposition.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Position {

    @Id
    @SequenceGenerator(name = "position_sequence", sequenceName = "position_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_sequence")
    private Long id;

    private Double latitude;
    private Double longitude;

    public Position() {
    }

    public Position(Long id, Double latitude, Double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Position(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Position(Position position) {
        this.latitude = position.latitude;
        this.longitude = position.longitude;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Position(id=" + this.id +
                ", lat=" + this.latitude +
                ", lon=" + this.longitude + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Position other) {
            return Objects.equals(this.latitude, other.latitude) &&
                    Objects.equals(this.longitude, other.longitude);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}