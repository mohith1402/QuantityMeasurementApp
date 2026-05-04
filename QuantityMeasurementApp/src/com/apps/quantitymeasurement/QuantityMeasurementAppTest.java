package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-2;

    @Test
    public void testLengthEquality_SameUnit() {
        Quantity<LengthUnit> feet1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> feet2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testLengthEquality_DifferentUnit() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testWeightEquality_SameUnit() {
        Quantity<WeightUnit> kg1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> kg2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertTrue(kg1.equals(kg2));
    }

    @Test
    public void testWeightEquality_DifferentUnit() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(grams));
    }

    @Test
    public void testCrossCategoryInequality() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(feet.equals(kg));
    }

    @Test
    public void testLengthAddition() {
        Quantity<LengthUnit> inches1 = new Quantity<>(2.0, LengthUnit.INCHES);
        Quantity<LengthUnit> inches2 = new Quantity<>(2.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = inches1.add(inches2);

        assertEquals(4.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testWeightAddition_WithTargetUnit() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = kg.add(grams, WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), EPSILON);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantity_NullUnit_ThrowsException() {
        new Quantity<>(1.0, null);
    }
}