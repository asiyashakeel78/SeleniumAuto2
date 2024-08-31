package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtility {

    public static void takeScreenshot(WebDriver driver, String filePath) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.createDirectories(Paths.get(filePath).getParent());
            Files.copy(scrFile.toPath(), Paths.get(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*The Screenshot class provides a utility method takeScreenshot to capture
 *  a screenshot of the current state of the browser represented by the 
 *  WebDriver instance and save it to the specified file path. 
 *  The method handles the creation of necessary directories and
 *   manages exceptions that might occur during the file operations.*/
