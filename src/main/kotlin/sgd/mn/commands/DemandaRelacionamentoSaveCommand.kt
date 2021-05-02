package sgd.mn.commands

import io.micronaut.core.annotation.Introspected
import sgd.mn.domains.TipoRelacionamento
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotNull

@Introspected
data class DemandaRelacionamentoSaveCommand(
    @NotNull
    val demandaId: Long,

    @NotNull
    @Enumerated(EnumType.STRING)
    val tipoRelacionamento: TipoRelacionamento,
)
