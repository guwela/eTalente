package com.eviro.assessment.grad001.pardonandmabasa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ntwanano;
    private String mabasa;
    private String httpImageLink;

    // Constructors, getters, and setters (omitted for brevity)
}
