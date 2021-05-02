package sgd.mn.commands

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Introspected
data class CampoCustomizadoSaveCommand(
    @NotEmpty
    @Size(max = 255)
    val nome: String,

    @NotEmpty
    val valor: String,
)
