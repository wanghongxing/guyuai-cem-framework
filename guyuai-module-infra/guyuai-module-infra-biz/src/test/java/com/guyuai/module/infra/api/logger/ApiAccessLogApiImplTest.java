package com.guyuai.module.infra.api.logger;

import com.guyuai.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import com.guyuai.module.infra.service.logger.ApiAccessLogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ApiAccessLogApiImplTest {

    @Mock
    private ApiAccessLogService mockApiAccessLogService;

    @InjectMocks
    private ApiAccessLogApiImpl apiAccessLogApiImplUnderTest;

    @Test
    void testCreateApiAccessLog() {
        // Setup
        final ApiAccessLogCreateReqDTO createDTO = new ApiAccessLogCreateReqDTO();
        createDTO.setTraceId("traceId");
        createDTO.setUserId(0L);
        createDTO.setUserType(0);
        createDTO.setApplicationName("applicationName");
        createDTO.setRequestMethod("requestMethod");

        // Run the test
        apiAccessLogApiImplUnderTest.createApiAccessLog(createDTO);

        // Verify the results
        // Confirm ApiAccessLogService.createApiAccessLog(...).
        final ApiAccessLogCreateReqDTO createReqDTO = new ApiAccessLogCreateReqDTO();
        createReqDTO.setTraceId("traceId");
        createReqDTO.setUserId(0L);
        createReqDTO.setUserType(0);
        createReqDTO.setApplicationName("applicationName");
        createReqDTO.setRequestMethod("requestMethod");
        verify(mockApiAccessLogService).createApiAccessLog(createReqDTO);
    }
}
