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
@Table(name = "Veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 40) @Size(max = 40)
    private String numeroPlaca;

    @ManyToOne
    @JoinColumn(name = "filial_id", nullable = false)  @ToString.Exclude
    private Filial filial;

    @ManyToOne
    @JoinColumn(name = "tipoveiculo_id")  @ToString.Exclude
    private TipoVeiculo tipoVeiculo;

    @Singular("listfrete")
    @OneToMany(mappedBy = "veiculo")  @ToString.Exclude
    private List<Frete> frete;
}
