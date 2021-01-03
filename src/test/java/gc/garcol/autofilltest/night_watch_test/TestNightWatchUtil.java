package gc.garcol.autofilltest.night_watch_test;

import gc.garcol.autofilltest.utils.NightWatchUtil;
import org.junit.jupiter.api.Test;

/**
 * @author thai-van
 **/
public class TestNightWatchUtil {

    @Test
    public void testUnixFileName() {
        System.out.println(NightWatchUtil.UNIX.parseCommand("TestExecutor"));
    }

}
