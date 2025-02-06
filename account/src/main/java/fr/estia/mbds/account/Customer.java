package fr.estia.mbds.account;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
