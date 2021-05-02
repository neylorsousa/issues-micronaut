package sgd.mn.commands

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
data class ProdutoSaveCommand(
    @NotNull
    val idBDCliente: Long,

    @NotBlank
    val descricao: String,
)
