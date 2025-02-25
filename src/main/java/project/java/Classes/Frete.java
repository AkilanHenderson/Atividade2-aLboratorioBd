package project.java.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import project.java.Repository.FreteDAO;

import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Frete")
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 12) @Size(max = 12)
    private int numeroNotaFiscal;

    @NonNull
    @Column(nullable = false, length = 12) @Size(max = 12)
    private BigDecimal valorKmRodado;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")  @ToString.Exclude
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")  @ToString.Exclude
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "categoriafrete_id")  @ToString.Exclude
    private CategoriaFrete categoriaFrete;

    @Singular("listitemfrete")  @ToString.Exclude
    @OneToMany(mappedBy = "frete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemFrete> itemfrete;

    @ManyToOne
    @JoinColumn(name = "cidade_origem_id")  @ToString.Exclude
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "cidade_destino_id")  @ToString.Exclude
    private Cidade cidadeDestino;

    public BigDecimal calcularFrete(FreteDAO freteDAO) {
        if (freteDAO == null) {
            throw new IllegalArgumentException("O DAO não pode ser nulo.");
        }

        // Validação das cidades
        if (this.cidadeOrigem == null || this.cidadeDestino == null) {
            throw new IllegalArgumentException("Cidades de origem e destino devem ser informadas.");
        }

        // Busca a distância entre as cidades de origem e destino
        BigDecimal distancia = freteDAO.buscarDistanciaEntreCidades(this.cidadeOrigem.getId(), this.cidadeDestino.getId());
        if (distancia == null) {
            throw new IllegalArgumentException("Distância não encontrada entre as cidades.");
        }

        // Calcula o valor do frete
        BigDecimal valorBasico = valorKmRodado.multiply(distancia);
        BigDecimal adicional = valorBasico.multiply(BigDecimal.valueOf(categoriaFrete.getPercentualAdicional() / 100));
        return valorBasico.add(adicional);
    }
}
