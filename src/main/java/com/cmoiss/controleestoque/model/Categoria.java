package com.cmoiss.controleestoque.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @ToString @EqualsAndHashCode
@NoArgsConstructor @RequiredArgsConstructor
@Entity @Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Setter
    @Column(nullable = false, unique = true)
    private String nome;
}
