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


    @Test
    public void emptyEmailLabel(){
    }

    @Test
    public void wrongEmailAdress(){
    }

    @Test
    public void emptyPasswordLabel(){
    }

    @Test
    public void noExistAccount(){
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
