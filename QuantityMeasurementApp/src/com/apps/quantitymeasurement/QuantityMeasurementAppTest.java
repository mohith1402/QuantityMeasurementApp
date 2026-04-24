package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(36.0, Length.convert(3.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testConversion_InchesToFeet() {
        assertEquals(3.0, Length.convert(36.0, LengthUnit.INCHES, LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testConversion_YardsToInches() {
        assertEquals(72.0, Length.convert(2.0, LengthUnit.YARDS, LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testConversion_InchesToYards() {
        assertEquals(1.0, Length.convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS), EPSILON);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        assertEquals(1.0, Length.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES), 0.01);
    }

    @Test
    public void testConversion_InchesToCentimeters() {
        assertEquals(2.54, Length.convert(1.0, LengthUnit.INCHES, LengthUnit.CENTIMETERS), 0.01);
    }

    @Test
    public void testConversion_SameUnit() {
        assertEquals(5.0, Length.convert(5.0, LengthUnit.FEET, LengthUnit.FEET), EPSILON);
        assertEquals(10.0, Length.convert(10.0, LengthUnit.INCHES, LengthUnit.INCHES), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConversion_InvalidUnit_Throws_SourceNull() {
        Length.convert(5.0, null, LengthUnit.INCHES);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConversion_InvalidUnit_Throws_TargetNull() {
        Length.convert(5.0, LengthUnit.FEET, null);
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws_NaN() {
        try {
            Length.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Value must be finite", e.getMessage());
        }
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws_PositiveInfinity() {
        try {
            Length.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Value must be finite", e.getMessage());
        }
    }

    @Test
    public void testConversion_PrecisionTolerance() {
        double result = Length.convert(10.0, LengthUnit.YARDS, LengthUnit.CENTIMETERS);
        assertEquals(914.4, result, 0.01);
    }
}