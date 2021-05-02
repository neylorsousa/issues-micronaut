package sgd.mn.domains

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "CAMPO_CUSTOMIZADO")
data class CampoCustomizado(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @NotEmpty
    @Size(max = 255)
    val nome: String,

    @NotEmpty
    val valor: String,

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_DEMANDA")
    val demanda: Demanda,
)
