import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.anssizu.fitnesstracker.User;

/**
 *
 * @author anselmusheino
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

     @Test
     public void simpleUserKcalTest()
     {
         User user = new User();
         int kcals = 100;
         user.addTotalExerciseKcals(kcals);
         assertEquals(kcals, user.getTotalExerciseKcals());
     }
}
