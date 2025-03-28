package com.cmoiss.controleestoque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Product extends EntidadeNomeada {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id")
    Categoria categoria;

    public Product(@NonNull String nome, Categoria categoria) {
        super(nome);
        this.categoria = categoria;
    }
}
