package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testAddition_InchesToInches() {
        Length length1 = new Length(2.0, LengthUnit.INCHES);
        Length length2 = new Length(2.0, LengthUnit.INCHES);
        Length result = length1.add(length2);
        assertEquals(4.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_FeetToInches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.INCHES);
        Length result = length1.add(length2);
        assertEquals(1.166666, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_InchesToFeet() {
        Length length1 = new Length(2.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        Length result = length1.add(length2);
        assertEquals(14.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_FeetToFeet() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        Length result = length1.add(length2);
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_CentimetersToInches() {
        Length length1 = new Length(2.0, LengthUnit.INCHES);
        Length length2 = new Length(2.54, LengthUnit.CENTIMETERS);
        Length result = length1.add(length2);
        assertEquals(3.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullLength_Throws() {
        Length length1 = new Length(2.0, LengthUnit.INCHES);
        length1.add(null);
    }

    @Test
    public void testFeetEquality() {
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(5.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testInchesEquality() {
        Length inches1 = new Length(5.0, LengthUnit.INCHES);
        Length inches2 = new Length(5.0, LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(10.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testInchesInequality() {
        Length inches1 = new Length(5.0, LengthUnit.INCHES);
        Length inches2 = new Length(10.0, LengthUnit.INCHES);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(10.0, LengthUnit.INCHES);
        assertFalse(feet.equals(inches));
    }
}