package gc.garcol.autofilltest.terminal_test;

import gc.garcol.autofilltest.utils.TerminalUtil;
import org.junit.jupiter.api.Test;

/**
 * @author thai-van
 **/
public class TestCallingCommand {

    @Test
    public void testCallLs() {
        String cmd = "ls";
        TerminalUtil.INSTANCE.execute(cmd);
    }

}
