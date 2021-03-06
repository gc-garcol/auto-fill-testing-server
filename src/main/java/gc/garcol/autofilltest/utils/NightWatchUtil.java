package gc.garcol.autofilltest.utils;

import gc.garcol.autofilltest.constants.NightWatchConstant;

import static gc.garcol.autofilltest.constants.FileConstant.EXECUTOR_FOLDER;

/**
 * [Nightwatchjs] Running Tests: https://nightwatchjs.org/guide/running-tests/nightwatch-runner.html
 * <br>
 * Note: in WindowOS, Create a file <b>nightwatch.js</b> and add the following line: require('nightwatch/bin/runner.js');
 *
 * @author thai-van
 **/
public enum NightWatchUtil {

    WINDOW(NightWatchConstant.WINDOW),
    UNIX(NightWatchConstant.UNIX);

    private String osCommand;

    NightWatchUtil(String osCommand) {
        this.osCommand =  osCommand;
    }

    public String parseCommand(String testFile) {
        return String.format("%s ./%s/%s.js", osCommand, EXECUTOR_FOLDER, testFile);
    }

}
