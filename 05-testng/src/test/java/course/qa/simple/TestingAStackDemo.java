package course.qa.simple;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class TestingAStackDemo {
    Stack<Object> stack;
    String anElement = "an element";

    @BeforeGroups("emptyStack")
    void createNewStack() {
        stack = new Stack<>();
    }

    @Test(groups = {"emptyStack"})
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test(description = "throws EmptyStackException when popped", expectedExceptions = EmptyStackException.class, groups = {"emptyStack"})
    void throwsExceptionWhenPoped() {
        stack.pop();
    }

    // Stack after pushing an element
    @BeforeGroups("stackAfterPushing")
    void createStackAndPush() {
        stack = new Stack<>();
        stack.push(anElement);
    }

    @Test(description = "is no longer empty", groups= {"stackAfterPushing"})
    void isEmptyAfterPush() {
        assertFalse(stack.isEmpty());
    }

    @Test(description = "returns element when poped", groups= {"stackAfterPushing"})
    void returnsElementWhenPopedAfterPush() {
        assertEquals(anElement, stack.pop());
        assertTrue(stack.isEmpty(), "Stack should be empty after pop()");
    }

//    @Nested
//    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
//    @DisplayName("after pushing 3 elements")
//    class AfterPushing3Elems {
//        List<String> elements = List.of("one", "two", "three");
//
//        @BeforeAll
//        void createNewStack() {
//            stack = new Stack<>();
//            elements.forEach(stack::push);
//        }
//
//        @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
//        @DisplayName("returns element when poped ")
//        void returnsElementWhenPoped() {
//            assertThat(stack.pop()).isInstanceOf(String.class).isIn(elements);
//        }
//    }
}
