package gc.garcol.autofilltest.services;

import gc.garcol.autofilltest.core.CustomFuture;
import gc.garcol.autofilltest.utils.FileUtil;
import gc.garcol.autofilltest.utils.NightWatchUtil;
import gc.garcol.autofilltest.utils.TerminalUtil;
import gc.garcol.autofilltest.utils.UncheckUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static gc.garcol.autofilltest.constants.FileConstant.EXECUTOR_FOLDER;
import static gc.garcol.autofilltest.constants.FileConstant.TEST_CASE_FOLDER;

/**
 * @author thai-van
 **/
@AllArgsConstructor
@Service
@Slf4j
public class TerminalService {

    private final NightWatchUtil nightWatchUtil;

    private final CustomFuture customFuture;

    private final ExecutorService executorService;

    private final String executorFile = "TestExecutor";

    /**
     *
     * @param testCaseFileName
     * @param testCaseContent
     * @param executorContent
     */
    public synchronized void executeTest(String testCaseFileName, String testCaseContent, String executorContent) {

        Future<?> future = executorService.submit(() -> {
            overideTestCaseFile(testCaseFileName, testCaseContent);

            overideExecutorFile(executorContent);

            executeNightWatch();
        });

        UncheckUtil.INSTANCE.keepRunning(() -> {
            customFuture.push(future);
            future.get();
        });
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
