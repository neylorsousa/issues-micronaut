package sgd.mn.commands

import io.micronaut.core.annotation.Introspected
import sgd.mn.domains.Empresa
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
data class DemandaSaveCommand(
    @NotBlank
    @Size(max = 100)
    val assunto: String,

    @NotBlank
    val descricao: String,

    val etiquetasId: Set<Long>?,

    @Valid
    val demandante: PessoaSaveCommand?,

    @NotNull
    @Enumerated(EnumType.STRING)
    val empresa: Empresa,

    @Valid
    val produto: ProdutoSaveCommand?,

    val acessos: Set<@Valid AcessoDemandaSaveCommand>?,

    val campoCustomizados: List<@Valid CampoCustomizadoSaveCommand>?,

    val fraude: Boolean,

    val demandasRelacionadas: Set<@Valid DemandaRelacionamentoSaveCommand>?,
)


