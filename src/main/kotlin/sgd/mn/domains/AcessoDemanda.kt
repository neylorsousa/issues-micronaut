package sgd.mn.domains

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "ACESSO_DEMANDA")
data class AcessoDemanda(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @ManyToOne(cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "ID_DEMANDA", nullable = false)
    val demanda: Demanda?,

    @NotEmpty
    @Size(max = 255)
    val identificador: String?,

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_IDENTIFICADOR")
    val tipoIdentificador: TipoIdentificador?,

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_ACESSO_DEMANDA")
    val tipoAcessoDemanda: TipoAcessoDemanda?,
)

enum class TipoIdentificador {
    GRUPO_REDE, ID_UTA, USUARIO_REDE
}

enum class TipoAcessoDemanda {
    OBSERVADOR, ENVOLVIDO, VISUALIZAR_DEMANDANTE
}
