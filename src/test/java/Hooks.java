import Core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforeScenario () {
        DriverFactory.initialize();
    }

    @After
    public void afterScenario () {
        DriverFactory.quit();
    }
}
