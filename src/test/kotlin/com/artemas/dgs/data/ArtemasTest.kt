package com.artemas.dgs.data

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ArtemasTest(
    @Autowired
    val webTestClient: WebTestClient
) {
    
    @Test
    fun `call graphQL`() {
        webTestClient.post()
            .uri("/graphql")
            .contentType(APPLICATION_JSON)
            .bodyValue("""
                {
                  "query": "{shows{title}}"
                }
            """.trimIndent())
            .exchange()
            .expectStatus()
            .is2xxSuccessful
            .expectHeader()
            .contentType(APPLICATION_JSON)
            .expectBody()
            .json("""
                {"data":{"shows":[{"title":"Stranger Things"},{"title":"Ozark"},{"title":"The Crown"},{"title":"Dead to Me"},{"title":"Orange is the New Black"}]}}
            """.trimIndent())
    }
}