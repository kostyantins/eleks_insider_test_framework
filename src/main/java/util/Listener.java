package util;

import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class Listener extends TestListenerAdapter {

	@Step
	@Override
	public void onTestFailure(ITestResult result) {
		takeScreenShot(result.getTestName());
	}

	@Attachment
	private byte[] takeScreenShot(String methodName) {
		return ((TakesScreenshot) WebDriverFactory.getDriver())
				.getScreenshotAs(OutputType.BYTES);
	}

	@Override
	public void onTestStart(ITestResult result) {
		FileWriter fileWriter;
		
		Runtime runtime = Runtime.getRuntime();
		DateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(result.getStartMillis());
		try {
			InetAddress address = InetAddress.getLocalHost();
			fileWriter = new FileWriter("src/main/resources/environment.properties");
			fileWriter.write("Web: Eleks Insider \n");
			fileWriter.write("OSname: " + System.getProperty("os.name") + "\n");
			fileWriter.write("OSversion: " + System.getProperty("os.version") + "\n");
			fileWriter.write("OSbyte: " + System.getProperty("os.arch") + "\n");
			fileWriter.write("HostName: " + System.getProperty("user.name")+"\n");
			fileWriter.write("TestStarted:" + formatter.format(calendar.getTime()) + "\n");
			fileWriter.write("HostAddress: "+ address.getHostAddress() + "\n");
			fileWriter.write("HostName: "+ address.getHostName() + "\n");
			fileWriter.write("QAAutomationTesters: "+ "Halyna Leshchyshyn, Kostyantin Sichenko" + "\n");
			fileWriter.write("CanonicalHostName: "+ address.getCanonicalHostName() + "\n");
			fileWriter.write("LocalHost: "+ address.getLocalHost() + "\n");
			fileWriter.write("LoopbackAddress: "+ address.getLoopbackAddress() + "\n");
			fileWriter.write("JavaVersion: " + System.getProperty("java.runtime.version") + "\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
