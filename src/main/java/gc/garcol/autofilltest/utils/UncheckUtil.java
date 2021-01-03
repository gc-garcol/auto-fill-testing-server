package gc.garcol.autofilltest.utils;

import gc.garcol.autofilltest.CustomRunnable;

/**
 * @author thai-van
 **/
public enum UncheckUtil {

    INSTANCE;

    public void run(CustomRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void keepRunning(CustomRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
