package com.scaler.designPattern.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// 1:M
// 1:1

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> auditoriumFeatures;
}

// auditoriums                        // auditorium_features
// id | name | feature_id             //  id | value
// 1 | audi-1 |
