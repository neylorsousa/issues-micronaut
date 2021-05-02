package sgd.mn.controllers

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sgd.mn.commands.DemandaSaveCommand
import sgd.mn.domains.Demanda
import sgd.mn.domains.Empresa
import javax.inject.Inject

@MicronautTest
class DemandaControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    /*
    TODO - verificar como fazer uma carga inicial para esse teste
    @Test
    fun `buscar demanda por id`() {
        val demanda = client.toBlocking().retrieve("/demandas/1", Demanda::class.java)
        assertEquals(1, demanda.id)
    }*/

    @Test
    fun `persistindo uma demanda minima`() {
        val demanda = DemandaSaveCommand(
            "Assunto teste",
            "Descrição de Teste",
            null,
            null,
            Empresa.POUPEX,
            null,
            null,
            null,
            false,
            null,
        )
        val response = client.toBlocking().exchange<DemandaSaveCommand, Demanda>(HttpRequest.POST("/demandas", demanda))
        assertEquals(HttpStatus.CREATED, response.status)
    }

}
