package sgd.mn.commands

import io.micronaut.core.annotation.Introspected
import sgd.mn.domains.TipoAcessoDemanda
import sgd.mn.domains.TipoIdentificador
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
data class AcessoDemandaSaveCommand(
    @NotEmpty
    @Size(max = 255)
    val identificador: String,

    @NotNull
    @Enumerated(EnumType.STRING)
    val tipoIdentificador: TipoIdentificador,

    @NotNull
    @Enumerated(EnumType.STRING)
    val tipoAcessoDemanda: TipoAcessoDemanda?,
)
