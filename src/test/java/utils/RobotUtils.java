package utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

@UtilityClass
public class RobotUtils {
    private final int DELAY_MS = 1000;
    private final String UPLOADS_FOLDER = "src/test/resources";

    /**
     * Uploads a file from the uploads folder by file name.
     * @param fileName the name of the file, e.g. "avatar.png"
     */
    public void uploadFileFromUploadsFolder(String fileName) {
        String fullPath = UPLOADS_FOLDER + fileName;
        uploadFile(fullPath);
    }

    /**
     * Uploads a file by its absolute or relative path.
     * @param filePath the full path to the file
     */
    public void uploadFile(String filePath) {
        try {
            Robot robot = new Robot();
            File file = new File(filePath);
            StringSelection path = new StringSelection(file.getAbsolutePath());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(DELAY_MS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(DELAY_MS);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(""), null);
        } catch (AWTException e) {
            String message = "Exception while creating robot class to upload file: %s".formatted(filePath);
            AqualityServices.getLogger().error(message);
            throw new RuntimeException(message, e);
        }
    }
}
