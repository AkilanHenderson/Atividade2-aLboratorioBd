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
@Table(name = "TipoVeiculo")
public class TipoVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull @Column(nullable = false, length = 50) @Size(max = 50)
    private String descricao;

    @NonNull @Column(nullable = false, length = 10) @Size(max = 10)
    private float pesoMaximo;

    @Singular("listveiculo")
    @OneToMany(mappedBy = "tipoVeiculo")  @ToString.Exclude
    private List<Veiculo> veiculos;

}
