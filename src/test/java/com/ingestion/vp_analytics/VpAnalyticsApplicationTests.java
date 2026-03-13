package com.ingestion.vp_analytics;

import com.ingestion.vp_analytics.adapters.input.web.IngestionController;
import com.ingestion.vp_analytics.domain.ports.input.ProcessSpreadsheetInputPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(IngestionController.class)
class VpAnalyticsApplicationTests {

    @MockitoBean
    private ProcessSpreadsheetInputPort useCase;

    @Test
    void contextLoads() {
    }

}
