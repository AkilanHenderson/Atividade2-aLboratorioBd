package project.java.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Distancia")
public class Distancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull @Column(nullable = false, length = 10) @Size(max = 10)
    private BigDecimal quilometros;

    @ManyToOne
    @JoinColumn(name = "origem_id")
    @ToString.Exclude
    private Cidade origem;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    @ToString.Exclude
    private Cidade destino;

}
