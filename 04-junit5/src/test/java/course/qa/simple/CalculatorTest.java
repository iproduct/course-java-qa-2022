package course.qa.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;

import static org.junit.Assert.*;

@Slf4j
public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public static void init() {
        log.info("Before all tests in a class");
    }

    @AfterClass
    public static void destroy() {
        log.info("After all tests in a class");
    }

    @Before
    public void setUp() throws Exception {
        log.info("Before test method");
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        log.info("After test method");
        calculator = null;
    }

    @Test
    public void givenXandY_whenAdd_thenResultXplusY() {
        log.info("Testing add()");
        //test (action)
        int actual = calculator.add(5, 8);

        //verify (assert, post-condition)
        assertEquals("Regular addition should work", 13, actual);
    }

    @Test
    public void givenXandY_whenMultiply_thenResultXproductY() {
        log.info("Testing multiply()");
        //test (action)
        int actual = calculator.multiply(5, 8);

        //verify (assert, post-condition)
        assertEquals("Regular multiplication should work", 40, actual);
    }

    @Test
    public void givenXandY_whenDivide_thenResultXdivY() {
        log.info("Testing divide()");
        //test (action)
        int actual = calculator.divide(42, 5);

        //verify (assert, post-condition)
        assertEquals("Regular division should work", 8, actual);

    }

    @Test(expected = ArithmeticException.class)
    public void givenXandZeroDivider_whenDivide_thenArtithmeticExceptionThrown() {
        log.info("Testing divide by zero()");
        //test (action)
        int actual = calculator.divide(42, 0);
    }
}
