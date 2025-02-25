package project.java.Classes;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ItemFrete")
public class ItemFrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 50) @Size(max = 50)
    private String descricao;

    @NonNull
    @Column(nullable = false, length = 12) @Size(max = 12)
    private float peso;

    @ManyToOne
    @JoinColumn(name = "frete_id")  @ToString.Exclude
    private Frete frete;

}
