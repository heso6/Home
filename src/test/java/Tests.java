import drivers.DriverProvider;
import org.junit.*;


public class Tests {

    @BeforeClass
    public static void init() {
        System.out.println("Starting all from this class tests...");
    }

    @Before
    public void initEachTest() {
        System.out.println("Starting test...");
    }




    @After
    public void after() {
        System.out.println("Test finished, closing driver...");
        DriverProvider.flush();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All tests finished.");
    }
}
