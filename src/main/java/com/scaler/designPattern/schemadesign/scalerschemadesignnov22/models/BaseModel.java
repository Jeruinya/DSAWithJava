package com.scaler.designPattern.schemadesign.scalerschemadesignnov22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private Long id;
}
