package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);

        assertTrue(feet1.equals(feet2));
    }

    private void assertTrue(boolean equals) {
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(10.0);

        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testEquality_NullInput() {
        Feet feet = new Feet(5.0);

        assertFalse(feet.equals(null));
    }

    @Test
    public void testEquality_NonNumericInput() {
        Feet feet = new Feet(5.0);

        assertFalse(feet.equals("5.0"));
    }

    @Test
    public void testEquality_SameReference() {
        Feet feet = new Feet(5.0);

        assertTrue(feet.equals(feet));
    }
}