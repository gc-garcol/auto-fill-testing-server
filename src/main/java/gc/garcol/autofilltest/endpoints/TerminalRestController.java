package gc.garcol.autofilltest.endpoints;

import gc.garcol.autofilltest.services.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Value("${gc.garcol.testFile}")
    private String testName;

    @GetMapping("/")
    public ResponseEntity<String> runTestCase() {
        terminalService.executeTest(testName);
        return ResponseEntity.ok().body("running success");
    }

}
