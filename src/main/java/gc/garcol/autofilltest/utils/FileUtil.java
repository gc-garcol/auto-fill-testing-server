package gc.garcol.autofilltest.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author thai-van
 **/
public enum FileUtil {

    INSTANCE;

    public void overideFile(String path, String content) {
        UncheckUtil.INSTANCE.keepRunning(() -> doOverideFile(path, content));
        System.out.println(String.format("[%s] %s", "created", path));
    }

    private void doOverideFile(String path, String content) throws Exception {
        File file = new File(path);
        file.createNewFile();

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
    }

}
