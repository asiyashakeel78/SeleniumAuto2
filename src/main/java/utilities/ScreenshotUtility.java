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
