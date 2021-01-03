package gc.garcol.autofilltest.service_test;

import gc.garcol.autofilltest.AutoFillTestApplication;
import gc.garcol.autofilltest.services.TerminalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author thai-van
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AutoFillTestApplication.class)
public class TestTerminalService {

    @Autowired
    TerminalService service;

    @Test
    public void testExecute() {
        service.executeTest("testCaseName", "testCaseContent0", "executorContent0");
    }

}
