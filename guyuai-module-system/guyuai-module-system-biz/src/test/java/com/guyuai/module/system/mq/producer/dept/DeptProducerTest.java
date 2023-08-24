package com.guyuai.module.system.mq.producer.dept;

import com.guyuai.framework.mq.core.RedisMQTemplate;
import com.guyuai.module.system.mq.message.dept.DeptRefreshMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeptProducerTest {

    @Mock
    private RedisMQTemplate mockRedisMQTemplate;

    @InjectMocks
    private DeptProducer deptProducerUnderTest;

    @Test
    void testSendDeptRefreshMessage() {
        // Setup
        // Run the test
        deptProducerUnderTest.sendDeptRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final DeptRefreshMessage message = new DeptRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }
}
