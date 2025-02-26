package project.java.Classes;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @Entity
    @Table(name = "CategoriaFrete")
    public class CategoriaFrete {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    
        @NonNull
        @Column(nullable = false, length = 50) @Size(max = 50)
        private String nome;
    
        @NonNull
        @Column(nullable = false, length = 50) @Size(max = 50)
        private String descricao;
    
        @NonNull
        @Column(nullable = false, length = 12) @Size(max = 12)
        private float percentualAdicional;
    
        @Singular("listfrete")
        @ToString.Exclude
        @OneToMany(mappedBy = "categoriaFrete")
        private List<Frete> frete;
    }
