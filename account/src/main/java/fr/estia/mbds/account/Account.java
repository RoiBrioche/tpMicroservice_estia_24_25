package fr.estia.mbds.account;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double balance;
    @CreationTimestamp
    private LocalDate dateCreated;

    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @Transient
    private Customer customer;
    private Long customerId;
}

