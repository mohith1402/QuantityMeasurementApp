package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-2;

    @Test
    public void testAddition_WithTargetUnit_FeetAndInchesToYards() {
        Length foot = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = foot.add(inches, LengthUnit.YARDS);

        assertEquals(0.666, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_WithTargetUnit_InchesAndCentimetersToInches() {
        Length inches = new Length(2.0, LengthUnit.INCHES);
        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length result = inches.add(cm, LengthUnit.INCHES);

        assertEquals(3.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_WithTargetUnit_YardsAndFeetToFeet() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(2.0, LengthUnit.FEET);
        Length result = yard.add(feet, LengthUnit.FEET);

        assertEquals(5.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_WithTargetUnit_YardsAndYardsToCentimeters() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(1.0, LengthUnit.YARDS);
        Length result = yard1.add(yard2, LengthUnit.CENTIMETERS);

        assertEquals(182.88, result.getValue(), EPSILON);
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_WithTargetUnit_NullLength_Throws() {
        Length length = new Length(2.0, LengthUnit.INCHES);
        length.add(null, LengthUnit.FEET);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_WithTargetUnit_NullTargetUnit_Throws() {
        Length length1 = new Length(2.0, LengthUnit.INCHES);
        Length length2 = new Length(2.0, LengthUnit.INCHES);
        length1.add(length2, null);
    }

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

        assertEquals(1.166666, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testFeetEquality() {
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(5.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(10.0, LengthUnit.INCHES);
        assertFalse(feet.equals(inches));
    }
}