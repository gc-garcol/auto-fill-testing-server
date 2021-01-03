package gc.garcol.autofilltest.endpoints;

import gc.garcol.autofilltest.services.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thai-van
 **/
@RequiredArgsConstructor
@RestController("/api")
public class TerminalRestController {

    private final TerminalService terminalService;

    @GetMapping("/{testName}")
    public ResponseEntity<String> runTestCase(@PathVariable(value="testName") final String testName) {
        terminalService.executeTest(testName);
        return ResponseEntity.ok().body("success");
    }

}
