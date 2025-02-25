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
@Table(name = "Filial")
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull @Column(nullable = false, length = 50) @Size(max = 50)
    private String nome;

    @NonNull @Column(nullable = false, length = 70) @Size(max = 70)
    private String endereco;

    @NonNull @Column(nullable = false, length = 12) @Size(max = 12)
    private String telefone;

    @Singular("listfuncionarios")
    @OneToMany(mappedBy = "filial")  @ToString.Exclude
    private List<Funcionario> funcionarios;

    @Singular("listveiculos")
    @OneToMany(mappedBy = "filial")  @ToString.Exclude
    private List<Veiculo> veiculos;
}
