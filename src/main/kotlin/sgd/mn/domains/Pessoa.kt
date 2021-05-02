package sgd.mn.domains

import javax.persistence.*
import javax.validation.constraints.*

@Entity
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @NotBlank
    @Size(max = 255)
    val nome: String,

    @Email
    val email: String?,

    @Pattern(regexp = "\\d{10,11}")
    val celular: String?,

    @Embedded
    val uta: Uta?,

    @NotNull
    @Size(max = 20)
    @Column(name = "NUMERO_DOCUMENTO")
    val numeroDocumento: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_PESSOA")
    val tipoPessoa: TipoPessoa,
)

@Embeddable
data class Uta(
    @Column(name = "UTA_ID")
    val id: Int?,

    @Size(max = 10)
    @Column(name = "UTA_SIGLA")
    val sigla: String?,
)

enum class TipoPessoa {
    JURIDICA, FISICA
}
