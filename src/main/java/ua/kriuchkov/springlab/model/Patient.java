package ua.kriuchkov.springlab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Column(name = "patient_name")
    private String name;

    @Column(name = "patient_addr")
    private String address;

    @Column(name = "med_police")
    private Integer medPolice;

    @Column(name = "patient_sex")
    private String sex;
}
