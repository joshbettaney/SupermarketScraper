import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Project test suite to host the unit tests within the project.
 * @author Joshua Bettaney
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ModelTest.class, PersisterTest.class
})
public class ProjectTestSuite {
}
