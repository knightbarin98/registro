package com.curame.urgencias.registro.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="emergency_records")
public class EmergencyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean allergies;
    @Column(name = "allergies_desciption" , nullable = true)
    private String allergiesDescription;
    private String nss;
    @Column(name = "insurance_code", nullable = true )
    private String insuranceCode;
    @Column(name = "insurance_company", nullable = true)
    private String insuranceCompany;
    @Column(name = "diagnostic_review" , nullable = true)
    private String diagnosticReview;
    @ManyToOne
    @JoinColumn(name="pacient_id")
    private Pacient pacient;
}
