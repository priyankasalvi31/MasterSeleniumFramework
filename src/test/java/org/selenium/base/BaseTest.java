package org.selenium.base;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v109.browser.Browser;
import org.selenium.constants.DriverTypes;
import org.selenium.factory.DriverManager;
import org.selenium.utils.CookiesUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium.abstractfactory.DriverManagerAbstract;
import com.selenium.abstractfactory.DriverManagerFactoryAbstract;
import com.selenium.factoryDriver.DriverManagerFactory;

import io.restassured.http.Cookies;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class BaseTest {
	private ThreadLocal<DriverManagerAbstract> driverManager= new ThreadLocal<DriverManagerAbstract>();
	private ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	public DriverManagerAbstract getDriverManager() {
		return this.driverManager.get();
	}
	public void setDriverManager(DriverManagerAbstract driverManager) {
		this.driverManager.set(driverManager);
	}
	
	public WebDriver getDriver() {
		return this.driver.get();
	}
	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	@Parameters({"browser"})
@BeforeMethod
public synchronized void startDriver(@Optional String browser)
{	browser=System.getProperty("browser",browser);
		//if(browser==null)
			//browser="chrome";
//setDriver(DriverManagerFactory.getManager(DriverTypes.valueOf(browser)).createDriver());
setDriverManager(DriverManagerFactoryAbstract.getManager(DriverTypes.valueOf(browser)));
setDriver(getDriverManager().getDriver());  
System.out.println("CURRENT THREAD: "+Thread.currentThread().getId()+", "+"DRIVER= "+getDriver());
}
	
	public void injectCookiesToBrowser(Cookies cookies)
	{
		List<Cookie> seleniumCookies = new CookiesUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
		for(Cookie cookie:seleniumCookies)
		{
			getDriver().manage().addCookie(cookie);
		}
	}
@AfterMethod
public synchronized void quitDriver(@Optional String browser,ITestResult result) throws IOException
{
	

if(result.getStatus()==ITestResult.FAILURE)
{
	File destFile = new File("src"+File.separator+browser+File.separator+result.getTestClass().getRealClass().getSimpleName()+"-"
+result.getMethod().getMethodName()+".png");
	//takeScreenshot(destFile);
	takeScreenshotUsingAshot(destFile);
}
getDriverManager().getDriver().quit();
}

private void takeScreenshot(File destFile) throws IOException
{
	TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
	File fileSrc = takesScreenshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(fileSrc, destFile);
}

private void takeScreenshotUsingAshot(File destFile)
{
	Screenshot screenshot = new AShot().
	shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(getDriver());
	try {
		ImageIO.write(screenshot.getImage(), "PNG", destFile);
	}
	catch(IOException e){
		e.printStackTrace();
	}
	}
}
