package ua.kriuchkov.springlab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    @Column(name = "doctor_name")
    private String name;

    @Column(name = "doctor_position")
    private String position;

    @Column(name = "cabinet_num")
    private Integer cabinetNum;

    @Column(name = "work_time")
    private String workTime;

    @Column(name = "service")
    private String service;

    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "salary")
    private Integer salary;
}
