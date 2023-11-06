package mypkg;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-5, 4));
        assertEquals(1000000, calculator.add(999999, 1));
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.subtract(5, 2));
        assertEquals(-9, calculator.subtract(2, 11));
        assertEquals(0, calculator.subtract(10, 10));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.multiply(3, 5));
        assertEquals(0, calculator.multiply(7, 0));
        assertEquals(-20, calculator.multiply(4, -5));
    }
}
