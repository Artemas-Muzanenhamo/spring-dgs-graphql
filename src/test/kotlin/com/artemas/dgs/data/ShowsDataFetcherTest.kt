package com.artemas.dgs.data

import com.artemas.dgs.service.ShowsService
import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DgsAutoConfiguration::class, ShowsDataFetcher::class, ShowsService::class])
class ShowsDataFetcherTest {

    @Autowired
    lateinit var dgsQueryExecutor: DgsQueryExecutor

    @Test
    fun `Shows all titles and release years`() {
        val titles : List<String> = dgsQueryExecutor.executeAndExtractJsonPath("""
            {
                shows {
                    title
                    releaseYear
                }
            }
        """.trimIndent(), "data.shows[*].title")

        assertThat(titles).contains("Ozark")
    }

    @Test
    fun `Shows filtered titles that contain the letter W`() {
        val titles : List<String> = dgsQueryExecutor.executeAndExtractJsonPath("""
            {
              shows(titleFilter: "w") {
                title
              }
            }
        """.trimIndent(), "data.shows[*].title")

        assertThat(titles).contains("The Crown", "Orange is the New Black")
    }
}