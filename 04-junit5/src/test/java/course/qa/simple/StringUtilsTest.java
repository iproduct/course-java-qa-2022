package course.qa.simple;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    private static StringUtils stringUtils;

    @BeforeAll
    public static void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    @Description("Given 'radar' isPalindrome should return true")
    void given_radar_whenIsPalindrome_thenTrue() {

    }

    @Test
    @Description("Given 'byl hlyb' isPalindrome should return false")
    void given_byl_hlyb_whenIsPalindrome_thenFalse() {

    }
}
