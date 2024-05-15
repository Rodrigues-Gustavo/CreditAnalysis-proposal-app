package com.techgusta.creditAnalysis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;

    private String name;
    private String lastname;
    private String cpfCnpj;
    private String telephone;
    private Double salary;
}
