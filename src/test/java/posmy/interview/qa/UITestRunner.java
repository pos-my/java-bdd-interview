package posmy.interview.qa;

import com.frameworkium.core.ui.UITestLifecycle;
import com.frameworkium.core.ui.listeners.CaptureListener;
import io.cucumber.testng.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


@Listeners({CaptureListener.class})
@CucumberOptions(
        features = {"src/test/resources/features/"},
        tags = "@GoogleSearchEngine and not @TBD",
        plugin = {"message:target/cucumber-report.ndjason"},
        glue = {"posmy.interview.qa.glue"})

public class UITestRunner implements ITest {
    private static final Logger logger = LogManager.getLogger();
    private TestNGCucumberRunner testNGCucumberRunner;
    private ThreadLocal<String> scenarioName = new ThreadLocal<>();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        //this is the only UI test class so no need for separate @beforesuite
        UITestLifecycle.get().beforeSuite();
    }

    @BeforeMethod(alwaysRun = true)
    public void setTestName(Method method, Object[] testData) {
        Pickle pickleEvent = ((PickleWrapper) testData[0]).getPickle();
        String scenarioName = pickleEvent.getName();
        this.scenarioName.set(scenarioName);
        logger.info("START{}", scenarioName);
        UITestLifecycle.get().beforeTestMethod(scenarioName);
    }

    @Test(dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cfw) {
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        UITestLifecycle.get().afterTestMethod();
        logResult(result);
    }

    private void logResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                logger.error("FAIL()", scenarioName.get());
                break;
            case ITestResult.SKIP:
                logger.error("SKIP()", scenarioName.get());
                break;
            case ITestResult.SUCCESS:
                logger.error("SUCCESS()", scenarioName.get());
                break;
            default:
                logger.warn("Unexpected result status: {}", java.util.Optional.of(result.getStatus()));
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        UITestLifecycle.get().afterTestSuite();
    }

    @Override
    public String getTestName() {
        return scenarioName.get();
    }
}
