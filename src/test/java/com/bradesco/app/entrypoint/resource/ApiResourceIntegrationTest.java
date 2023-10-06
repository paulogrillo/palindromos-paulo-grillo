package com.bradesco.app.entrypoint.resource;

import com.bradesco.app.dto.MatrizResponse;
import com.bradesco.app.dto.WordResponse;
import com.bradesco.app.fixture.MatrizResponseFixture;
import com.bradesco.app.fixture.WordResponseFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiResourceIntegrationTest {

    private static final String CREATE_WORD_PATH = "http://localhost:8080/api/v1/add-words";
    private static final String FIND_PALINDROMO_PATH = "http://localhost:8080/api/v1/find-palindromic";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void given_a_post_word_request_When_is_valid_Then_return_status_should_201_created() throws Exception {
        WordResponse wordRequest = WordResponseFixture.load();

        mockMvc.perform(MockMvcRequestBuilders
                        .post(CREATE_WORD_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(wordRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("$.words[0]")
                        .value(wordRequest.getWords().get(0)))
                .andExpect(jsonPath("$.words[1]")
                        .value(wordRequest.getWords().get(1)));
    }

    @Test
    public void testFindPalindromicIntegration() throws Exception {
        MatrizResponse matrizRequest = MatrizResponseFixture.loadValidMatriz();

        mockMvc.perform(MockMvcRequestBuilders
                        .post(FIND_PALINDROMO_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(matrizRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.words[0]").value("OSSO"))
                .andExpect(jsonPath("$.words[1]").value("YJJY"))
                .andExpect(jsonPath("$.words[2]").value("ARARA"))
                .andExpect(jsonPath("$.words[3]").value("LPPL"));

    }
}
