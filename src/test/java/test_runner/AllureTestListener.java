package test_runner;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import io.qameta.allure.Allure;

public class AllureTestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.addAttachment("Test Failed", "Test Method: " + result.getMethod().getMethodName());
    }

    // Implement other methods as needed (e.g., onTestSuccess, onTestSkipped, etc.)
}

