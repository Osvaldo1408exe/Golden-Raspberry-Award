package com.osvaldo.gra;

import com.osvaldo.gra.dto.AwardIntervalResponse;
import com.osvaldo.gra.dto.ProducerIntervalDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(scripts = "/teste-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class AwardIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAwardIntervalsEndpoint() {
        String url = "http://localhost:" + port + "/awards/intervals";
        AwardIntervalResponse response = restTemplate.getForObject(url, AwardIntervalResponse.class);

        assertNotNull(response);
        assertNotNull(response.getMin());
        assertNotNull(response.getMax());

        // Testa se algum produtor retornou no menor intervalo
        List<ProducerIntervalDTO> min = response.getMin();
        assertFalse(min.isEmpty());

        // Testa se algum produtor retornou no maior intervalo
        List<ProducerIntervalDTO> max = response.getMax();
        assertFalse(max.isEmpty());

        // Verifica se o valor especificado está em menores intervalos
        boolean hasExpectedProducer = min.stream()
                .anyMatch(p -> p.getProducer().equalsIgnoreCase("Producer 1"));

        assertTrue(hasExpectedProducer, "Deveria conter Producer 1 nos menores intervalos");

    }
}
