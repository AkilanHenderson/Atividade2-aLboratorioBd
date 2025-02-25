package project.java.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "Funcionario")
public class Funcionario extends PessoaFisica{

    @NonNull
    @Column(nullable = false, length = 50) @Size(max = 50)
    private int matricula;

    @Singular("listdependente")
    @ToString.Exclude
    @OneToMany(mappedBy = "funcionario")
    private List<Dependente> dependentes;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "filial_id")
    private Filial filial;

}
