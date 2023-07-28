package com.promineotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
//import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class TestDemoJUnitTest {

    // TestDemo named testDemo.
    private TestDemo testDemo;

    @BeforeEach
    void setup() throws Exception {
        testDemo = new TestDemo();
    }

    static Stream<Arguments> arguementsForAddPositive() {
        // returns stream as Stream.of(); each parameter set should be wrapped in an
        // arguements() method call.
        return Stream.of(
                Arguments.of(1, 1, 2, false),
                Arguments.of(1, 0, 1, false),
                Arguments.of(0, 1, 1, false),
                Arguments.of(0, 0, 0, false),
                Arguments.of(-1, 1, 0, true),
                Arguments.of(1, -1, 0, true),
                Arguments.of(-1, -1, 0, true),
                Arguments.of(2, 0, 2, false),
                Arguments.of(0, 2, 2, false),
                Arguments.of(0, 0, 0, false),
                Arguments.of(-2, 2, 0, true)

        );

    }

    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#arguementsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        // Test the value of expectedException. If it is false, assert that when
        // TestDemo.addPositive(a, b) is called with the values a and b, that result is
        // the same as the parameter expected.
        // The assertion should look like this:
        // if (!expectException) {
        // assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); }
        // add the test for the thrown exception in an else clause. Use
        // assertThatThrownBy for this.

        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
        }

    }
    // Create a method annoytated with @Test named
    // assertThatTwoPositiveNumbersAreAddedCorrectly.
    // method must have package visibility. use assertThat to test that the value
    // returned from addPositive is equal to the correct value

    @Test
    void assertThatTwoPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
        assertThat(testDemo.addPositive(1, 0)).isEqualTo(1);
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
    }

    // create a test for printString that tests that the correct string is returned
    @Test
    void assertThatStringIsReturned() { // test method
        assertThat(testDemo.printString("Hello World!")).isEqualTo("Hello World!");
        assertThat(testDemo.printString("Test String")).isEqualTo("Test String");
    }

    // create a method annotated with @Test named assertThatNumberSquaredIsCorrect
    // method must have package visibility. use assertThat to test that the value
    // returned from randomNumberSquared is equal to the correct value
    @Test
    void assertThatNumberSquaredIsCorrect() {
        assertThat(testDemo.randomNumberSquared()).isBetween(1, 100);
    }

    // program the mocked TestDemo object to return 5 when the getRandomInt method
    // is called
    // use the form doReturn(5).when(spy).getRandomInt();
    // use the form doReturn(5).when(spy).getRandomInt();
    @Test
    void assertThatRandomNumberIsCorrect() {
        // mock the TestDemo class using Mockito.spy
        TestDemo spy = Mockito.spy(testDemo); // mock the TestDemo class using Mockito.spy

        Mockito.doReturn(5).when(spy).getRandomInt();
        assertThat(spy.randomNumberSquared()).isEqualTo(25);
    }

}
