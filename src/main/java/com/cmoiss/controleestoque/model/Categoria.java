package com.cmoiss.controleestoque.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Categoria extends EntidadeNomeada {
    public Categoria() {
        super();
    }

    public Categoria(@NonNull String nome) {
        super(nome);
    }
}
