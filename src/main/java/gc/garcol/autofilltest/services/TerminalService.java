package gc.garcol.autofilltest.services;

import gc.garcol.autofilltest.utils.FileUtil;
import gc.garcol.autofilltest.utils.NightWatchUtil;
import gc.garcol.autofilltest.utils.TerminalUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static gc.garcol.autofilltest.constants.FileConstant.EXECUTOR_FOLDER;
import static gc.garcol.autofilltest.constants.FileConstant.TEST_CASE_FOLDER;

/**
 * @author thai-van
 **/
@AllArgsConstructor
@Service
public class TerminalService {

    private final NightWatchUtil nightWatchUtil;

    private final String executorFile = "TestExecutor";

    /**
     *
     * @param testCaseFileName
     * @param testCaseContent
     * @param executorContent
     */
    public synchronized void executeTest(String testCaseFileName, String testCaseContent, String executorContent) {

        overideTestCaseFile(testCaseFileName, testCaseContent);

        overideExecutorFile(executorContent);

        executeNightWatch();
    }

    private void overideTestCaseFile(String testCaseFileName, String testCaseContent) {
        String pathFile = String.format("%s/%s.js", TEST_CASE_FOLDER, testCaseFileName);
        FileUtil.INSTANCE.overideFile(pathFile, testCaseContent);
    }

    private void overideExecutorFile(String executorContent) {
        String pathFile = String.format("%s/%s.js", EXECUTOR_FOLDER, executorFile);
        FileUtil.INSTANCE.overideFile(pathFile, executorContent);
    }

    private void executeNightWatch() {
        String command = nightWatchUtil.parseCommand(executorFile);
        TerminalUtil.INSTANCE.execute(command);
    }

}
