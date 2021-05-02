package sgd.mn.domains

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Acompanhamento(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @NotNull
    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "ID_DEMANDA")
    val demanda: Demanda?,

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "ID_PESSOA_AUTOR")
    val autor: @NotNull Pessoa?,

    @NotBlank
    val descricao: String?,

    //@CreatedDate
    //@LastModifiedDate
    @Column(name = "DATA_MODIFICACAO")
    val dtModificacao: LocalDateTime?,
)
