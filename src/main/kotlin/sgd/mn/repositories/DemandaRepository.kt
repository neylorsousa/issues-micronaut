package sgd.mn.repositories

import io.micronaut.transaction.annotation.ReadOnly
import io.micronaut.transaction.annotation.TransactionalAdvice
import sgd.mn.commands.DemandaSaveCommand
import sgd.mn.domains.Demanda
import sgd.mn.domains.Etiqueta
import sgd.mn.domains.Pessoa
import sgd.mn.domains.TipoPessoa
import java.time.LocalDateTime
import javax.inject.Singleton
import javax.persistence.EntityManager

interface DemandaRepository {
    fun findById(id: Long): Demanda?
    fun save(demanda: DemandaSaveCommand): Demanda
    fun deleteById(id: Long)
}

@Singleton
open class DemandaRepositoryImpl(private val entityManager: EntityManager) : DemandaRepository {

    @ReadOnly
    override fun findById(id: Long): Demanda? {
        return entityManager.find(Demanda::class.java, id)
    }

    @TransactionalAdvice
    override fun save(demandaSaveCommand: DemandaSaveCommand): Demanda {
        val demanda = Demanda(
            null,
            demandaSaveCommand.assunto,
            demandaSaveCommand.descricao,
            null,
            demandaSaveCommand.etiquetasId?.map { Etiqueta(it, null) }?.toSet(),
            Pessoa(null, "Demandante", null, null, null, "numero", TipoPessoa.FISICA),
            Pessoa(null, "Autor", null, null, null, "numero", TipoPessoa.FISICA),
            null,
            demandaSaveCommand.empresa,
            null,
            "teste",
            null,
            null,
            null,
            demandaSaveCommand.fraude,
            LocalDateTime.now()
        )
        entityManager.persist(demanda)
        return demanda
    }

    @TransactionalAdvice
    override fun deleteById(id: Long) {
        entityManager.remove(entityManager.getReference(Demanda::class.java, id))
    }
}
