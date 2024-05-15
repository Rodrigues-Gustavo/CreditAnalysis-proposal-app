package com.techgusta.creditAnalysis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proposal {

    private Long id;

    private Double requestedAmount;
    private int paymentTime;
    private Boolean approved;
    private boolean integrated;
    private String observation;

    private User user;

}
