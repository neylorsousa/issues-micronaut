package sgd.mn.domains

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column(name = "ID_BD_CLIENTE")
    val idBDCliente: Long?,

    @NotNull
    val descricao: String,
)
