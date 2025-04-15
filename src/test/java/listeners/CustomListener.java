package com.novosiolov.lab13.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;

public class CustomListener implements ITestListener, ISuiteListener, IExecutionListener {

    private static final Logger logger = LogManager.getLogger(CustomListener.class);

    @Override
    public void onStart(ISuite suite) {
        logger.info("▶ Suite started: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        logger.info("✅ Suite finished: " + suite.getName());
    }

    @Override
    public void onExecutionStart() {
        logger.info("🚀 Test execution started");
    }

    @Override
    public void onExecutionFinish() {
        logger.info("🏁 Test execution finished");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("🔵 Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("🟢 Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("🔴 Test FAILED: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("🟡 Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}
