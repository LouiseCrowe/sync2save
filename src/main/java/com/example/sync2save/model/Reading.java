package com.example.sync2save.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "reading")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Date timestamp;
    private Double value;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id", referencedColumnName = "policyId", nullable = false)
    private Policy policy;

    public Reading() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public Date getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(Date timestamp) {

        this.timestamp = timestamp;
    }

    public Double getValue() {

        return value;
    }

    public void setValue(Double value) {

        this.value = value;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Policy getPolicy() {

        return policy;
    }

    public void setPolicy(Policy policy) {

        this.policy = policy;
    }
}
