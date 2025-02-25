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
@Table(name = "Cliente")
public class Cliente extends PessoaFisica {

    @NonNull
    @Column(nullable = false, length = 12) @Size(max = 12)
    private String contato;

    private boolean ativo;

    @Singular("listfrete")
    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Frete> frete;

}
