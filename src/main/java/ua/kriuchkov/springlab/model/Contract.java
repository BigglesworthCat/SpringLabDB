package ua.kriuchkov.springlab.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    @Column(name = "contract_date")
//    private String date;
    private Date date;

    @Column(name = "contract_sum")
    private Integer sum;
}
