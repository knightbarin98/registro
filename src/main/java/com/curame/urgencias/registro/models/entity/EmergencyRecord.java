package com.curame.urgencias.registro.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity(name="EmergencyRecord")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="ers")
public class EmergencyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean allergies;
    private String allergiesDescription;
    private String nss;
    private String insuranceCode;
    private String insuranceCompany;
    private String diagnosticReview;
}
