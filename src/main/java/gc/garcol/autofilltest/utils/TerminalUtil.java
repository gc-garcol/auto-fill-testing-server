package gc.garcol.autofilltest.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author thai-van
 **/
public enum TerminalUtil {

    INSTANCE;

    public void execute(String command) {
        UncheckUtil.INSTANCE.keepRunning(() -> wrapExecuteWithLog(command));
    }

    private void wrapExecute(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
    }

    private void wrapExecuteWithLog(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = bufReader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
