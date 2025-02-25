package project.java.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PessoaFisica")
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull @Column(nullable = false, length = 50) @Size(max = 50)
    private String nome;

    @NonNull @Column(nullable = false, length = 40) @Size(max = 40)
    private String email;

    @Column(nullable = false, length = 12) @Size(max = 12)
    private String telefone;

    @Column(nullable = false, unique = true, length = 12) @Size(max = 12)
    private String cpf;
}
