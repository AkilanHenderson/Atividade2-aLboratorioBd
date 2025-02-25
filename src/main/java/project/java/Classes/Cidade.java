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
@Table(name = "Cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull @Column(nullable = false, length = 10) @Size(max = 10)
    private String uf;

    @NonNull @Column(nullable = false, length = 50) @Size(max = 50)
    private String nome;

    @NonNull @Column(nullable = false, length = 20) @Size(max = 20)
    private String estado;

    @Singular("listfreteorigem") @OneToMany(mappedBy = "cidadeOrigem")  @ToString.Exclude
    private List<Frete> fretesOrigem;

    @Singular("listfretedestino") @OneToMany(mappedBy = "cidadeDestino")  @ToString.Exclude
    private List<Frete> fretesDestino;

    @Singular("listdistanciaorigem") @OneToMany(mappedBy = "origem")  @ToString.Exclude
    private List<Distancia> distanciasOrigem;

    @Singular("listdistanciadestino") @OneToMany(mappedBy = "destino")  @ToString.Exclude
    private List<Distancia> distanciasDestino;
}
