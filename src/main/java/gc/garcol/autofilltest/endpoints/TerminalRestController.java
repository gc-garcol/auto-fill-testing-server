package gc.garcol.autofilltest.endpoints;

import gc.garcol.autofilltest.payload.requests.RequestTestData;
import gc.garcol.autofilltest.services.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thai-van
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TerminalRestController {

    private final TerminalService terminalService;

    @PostMapping("/")
    public ResponseEntity<String> executeTestCase(@RequestBody RequestTestData request) {
        terminalService.executeTest(request.getTestCaseFileName(), request.getTestCaseContent(), request.getExecutorContent());
        return ResponseEntity.ok().body("running success");
    }

}
