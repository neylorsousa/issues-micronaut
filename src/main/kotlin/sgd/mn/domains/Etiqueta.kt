package sgd.mn.domains

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
data class Etiqueta(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @NotNull
    val descricao: String?,
)
