package com.novosiolov.lab13.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener, IExecutionListener, IInvokedMethodListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    // IExecutionListener
    @Override
    public void onExecutionStart() {
        logger.info("🟢 [Execution] Test run started.");
    }

    @Override
    public void onExecutionFinish() {
        logger.info("🔵 [Execution] Test run finished.");
    }

    // ISuiteListener
    @Override
    public void onStart(ISuite suite) {
        logger.info("🧪 [Suite Start] " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        logger.info("✅ [Suite Finish] " + suite.getName());
    }

    // IInvokedMethodListener
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        logger.info("➡️ [Before] " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        logger.info("⬅️ [After] " + method.getTestMethod().getMethodName());
    }

    // ITestListener
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("🟡 [Test Start] " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("🟢 [Test Passed] " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("🔴 [Test FAILED] " + result.getName());

        // ✨ Місце для запису відео
        // VideoRecorder.startRecording(); → test start
        // VideoRecorder.stopAndSave(); → тут або в afterInvocation
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⚠️ [Test Skipped] " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("🟠 [Test Partial Fail] " + result.getName());
    }
}
