package com.cmoiss.controleestoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@NoArgsConstructor @RequiredArgsConstructor
@Getter @Setter
public class EntidadeNomeada extends Entidade {
    @NonNull
    @Column(nullable = false, unique = true)
    protected String nome;
}
