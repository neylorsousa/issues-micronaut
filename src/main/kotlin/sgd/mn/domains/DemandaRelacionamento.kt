package sgd.mn.domains

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "DEMANDA_RELACIONAMENTO")
data class DemandaRelacionamento(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_DEMANDA_ORIGEM")
    val demandaOrigem: Demanda?,

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_RELACIONAMENTO")
    val tipoRelacionamento: TipoRelacionamento?,

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_DEMANDA_DESTINO")
    val demandaDestino: Demanda?,
)

enum class TipoRelacionamento {
    SUBTAREFA, DEPENDE, RELACIONADOS, DUPLICADOS
}
