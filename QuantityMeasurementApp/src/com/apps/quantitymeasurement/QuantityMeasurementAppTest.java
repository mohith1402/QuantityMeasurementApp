package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(10.0);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet = new Feet(5.0);
        assertFalse(feet.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet = new Feet(5.0);
        assertFalse(feet.equals("5.0"));
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet = new Feet(5.0);
        assertTrue(feet.equals(feet));
    }

    @Test
    public void testInchesEquality_SameValue() {
        Inches inches1 = new Inches(5.0);
        Inches inches2 = new Inches(5.0);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inches1 = new Inches(5.0);
        Inches inches2 = new Inches(10.0);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches inches = new Inches(5.0);
        assertFalse(inches.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches inches = new Inches(5.0);
        assertFalse(inches.equals("5.0"));
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inches = new Inches(5.0);
        assertTrue(inches.equals(inches));
    }
}