package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(5.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(10.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testInchesEquality_SameValue() {
        Length inches1 = new Length(5.0, LengthUnit.INCHES);
        Length inches2 = new Length(5.0, LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Length inches1 = new Length(5.0, LengthUnit.INCHES);
        Length inches2 = new Length(10.0, LengthUnit.INCHES);
        assertFalse(inches1.equals(inches2));
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

    @Test
    public void testEquality_SameReference() {
        Length length = new Length(5.0, LengthUnit.FEET);
        assertTrue(length.equals(length));
    }
}