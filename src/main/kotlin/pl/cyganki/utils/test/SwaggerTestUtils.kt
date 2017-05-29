package pl.cyganki.utils.test

import io.github.robwin.markup.builder.MarkupLanguage
import io.github.robwin.swagger2markup.GroupBy
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler


@Throws(Exception::class)
fun generateApiDoc(mockMvc: MockMvc) {
    mockMvc.perform(get("/v2/api-docs")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(Swagger2MarkupResultHandler.outputDirectory("docs")
                    .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                    .withPathsGroupedBy(GroupBy.TAGS)
                    .withExamples("docs").build())
            .andExpect(status().isOk)
}