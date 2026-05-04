package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuantityArithmeticTest {

    private static final double EPSILON = 1e-2;

    @Test
    public void testSubtraction_SameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(3.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtraction_DifferentUnits() {
        Quantity<LengthUnit> q1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(1.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtraction_WithTargetUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testDivision_SameUnit() {
        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        double result = q1.divide(q2);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testDivision_DifferentUnits() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        double result = q1.divide(q2);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testSubtraction_Immutability() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        q1.subtract(q2);

        assertEquals(5.0, q1.getValue(), EPSILON);
        assertEquals(2.0, q2.getValue(), EPSILON);
    }

    @Test
    public void testDivision_Immutability() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        q1.divide(q2);

        assertEquals(10.0, q1.getValue(), EPSILON);
        assertEquals(2.0, q2.getValue(), EPSILON);
    }

    @Test
    public void testSubtraction_PrecisionAndRounding() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = q1.subtract(q2, VolumeUnit.LITRE);

        assertEquals(17.92, result.getValue(), EPSILON);
    }

    @Test
    public void testDivision_PrecisionHandling() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.POUND);
        Quantity<WeightUnit> q2 = new Quantity<>(100.0, WeightUnit.GRAM);
        double result = q1.divide(q2);

        assertEquals(4.53, result, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivision_ByZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);
        q1.divide(q2);
    }
}