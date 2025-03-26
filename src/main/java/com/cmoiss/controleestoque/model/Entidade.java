package com.cmoiss.controleestoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
@Getter
public abstract class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

}
