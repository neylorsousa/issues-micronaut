package sgd.mn.commands

import io.micronaut.core.annotation.Introspected
import sgd.mn.domains.TipoPessoa
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.Valid
import javax.validation.constraints.*

@Introspected
data class PessoaSaveCommand(
    @NotBlank
    @Size(max = 255)
    val nome: String,

    @Email
    val email: String?,

    @Pattern(regexp = "\\d{10,11}")
    val celular: String?,

    @Valid
    val uta: PessoaUtaSaveCommand?,

    @NotEmpty
    @Size(max = 20)
    val numeroDocumento: String,

    @NotNull
    @Enumerated(EnumType.STRING)
    val tipoPessoa: TipoPessoa,
)

@Introspected
data class PessoaUtaSaveCommand(
    @NotNull
    val id: Int,

    @NotBlank
    @Size(max = 10)
    val sigla: String,
)
