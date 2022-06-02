package course.qa.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;

import static org.junit.Assert.*;

@Slf4j
public class CalculatorTest {
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
    }

    @After
    public void tearDown() throws Exception {
        log.info("After test method");
    }

    @Test
    public void add() {
        log.info("Testing add()");
    }

    @Test
    public void multiply() {
        log.info("Testing multiply()");
    }

    @Test
    public void divide() {
        log.info("Testing divide()");
    }
}
