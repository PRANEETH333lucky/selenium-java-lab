
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("file:///C:/selenium-lab/program.html");

            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("1234");
            driver.findElement(By.id("login")).click();

            String result = driver.findElement(By.id("message")).getText();

            if (result.equals("Login Successful!")) {
                System.out.println("Test 1 Passed: Valid Login");
            } else {
                throw new AssertionError("Valid login test failed");
            }

            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("password")).clear();

            driver.findElement(By.id("username")).sendKeys("wrong");
            driver.findElement(By.id("password")).sendKeys("0000");
            driver.findElement(By.id("login")).click();

            result = driver.findElement(By.id("message")).getText();

            if (result.equals("Invalid Credentials!")) {
                System.out.println("Test 2 Passed: Invalid Login");
            } else {
                throw new AssertionError("Invalid login test failed");
            }
        } finally {
            driver.quit();
        }
    }
}
