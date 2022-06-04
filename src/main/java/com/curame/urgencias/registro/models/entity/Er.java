package com.curame.urgencias.registro.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="ers")
public class Er {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean allergies;
    @Column(name = "allergies_description")
    private String allergiesDescription;
    private String nss;
    @Column(name = "insurance_code")
    private String insuranceCode;
    @Column(name = "insurance_company")
    private String insuranceCompany;
    @Column(name = "diagnostic_review")
    private String diagnosticReview;
    @Column(name="pacient_id", insertable = false, updatable = false)
    private Long pacientId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pacient_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pacient pacient;
}
