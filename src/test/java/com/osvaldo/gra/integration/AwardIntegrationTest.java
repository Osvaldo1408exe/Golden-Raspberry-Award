package com.osvaldo.gra.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.osvaldo.gra.dto.AwardIntervalResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AwardIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnCorrectAwardIntervals() throws Exception {
        // Chamada GET para a API
        String responseJson = mockMvc.perform(get("/awards/intervals"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Converte a resposta
        AwardIntervalResponse actualResponse = objectMapper.readValue(responseJson, AwardIntervalResponse.class);

        // Carrega o JSON de src/test/resources
        AwardIntervalResponse expectedResponse = loadExpectedResponse();

        // Faz comparação
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);
    }

    private AwardIntervalResponse loadExpectedResponse() throws Exception {
        Path path = new ClassPathResource("expected_award_intervals.json").getFile().toPath();
        String json = Files.readString(path);
        return objectMapper.readValue(json, AwardIntervalResponse.class);
    }
}
