package sgd.mn.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import sgd.mn.commands.DemandaSaveCommand
import sgd.mn.domains.Demanda
import sgd.mn.repositories.DemandaRepository
import javax.validation.Valid

//TODO - Substituir pelo micronout-data-jdbc
@Validated
@Controller("/demandas")
class DemandaController(private val demandaRepository: DemandaRepository) {

    @Get("/{id}")
    fun getById(id: Long): Demanda? {
        return demandaRepository.findById(id)
    }

    @Post
    fun save(@Body @Valid demandaSaveCommand: DemandaSaveCommand): HttpResponse<Demanda> {
        val demanda = demandaRepository.save(demandaSaveCommand)
        return HttpResponse.created(demanda)
    }

    @Delete("/{id}")
    fun deleteById(id: Long) {
        demandaRepository.deleteById(id)
    }
}
