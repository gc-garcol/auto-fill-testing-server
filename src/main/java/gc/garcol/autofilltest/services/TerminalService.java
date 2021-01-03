package gc.garcol.autofilltest.services;

import gc.garcol.autofilltest.utils.NightWatchUtil;
import gc.garcol.autofilltest.utils.TerminalUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author thai-van
 **/
@AllArgsConstructor
@Service
public class TerminalService {

    private final NightWatchUtil nightWatchUtil;

    /**
     *
     * @param testName
     */
    public void executeTest(String testName) {
        String command = nightWatchUtil.parseCommand(testName);
        TerminalUtil.INSTANCE.execute(command);
    }

}
