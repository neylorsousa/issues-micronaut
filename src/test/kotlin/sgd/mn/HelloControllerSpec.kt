package sgd.mn

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloControllerSpec {


    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun testHelloWorldResponse() {
        val rsp: String = client.toBlocking()
            .retrieve("/hello")
        assertEquals("Hello World", rsp)
    }
}
