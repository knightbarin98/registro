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
@Table(name="pacients")
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String neighborhood;
    @Column(name = "zip_code")
    private Integer zipCode;
    @OneToMany(mappedBy = "pacient", cascade = CascadeType.ALL)
    private List<Er> ers;

}
