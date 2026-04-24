package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

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

    @Test
    public void testMultipleFeetComparison() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void yardEquals3Feet() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }

    @Test
    public void yardEquals1Yard() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(yard1.equals(yard2));
    }

    @Test
    public void yardEqualsHalfYard() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(0.5, LengthUnit.YARDS);
        assertFalse(yard1.equals(yard2));
    }

    @Test
    public void cmEquals1Inch() {
        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length inch = new Length(1.0, LengthUnit.INCHES);
        assertTrue(cm.equals(inch));
    }

    @Test
    public void cmEquals1Feet() {
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertTrue(cm.equals(feet));
    }

    @Test
    public void testEquality_NullComparison() {
        Length length = new Length(5.0, LengthUnit.FEET);
        assertFalse(length.equals(null));
    }

    @Test
    public void testEquality_DifferentClass() {
        Length length = new Length(5.0, LengthUnit.FEET);
        assertFalse(length.equals("5.0"));
    }
}