package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuantityWeightTest {

    private static final double EPSILON = 1e-2;

    @Test
    public void testWeightEquality_Kilograms() {
        QuantityWeight kg1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight kg2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(kg1.equals(kg2));
    }

    @Test
    public void testWeightEquality_Grams() {
        QuantityWeight g1 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight g2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertTrue(g1.equals(g2));
    }

    @Test
    public void testWeightEquality_Pounds() {
        QuantityWeight lb1 = new QuantityWeight(1.0, WeightUnit.POUND);
        QuantityWeight lb2 = new QuantityWeight(1.0, WeightUnit.POUND);
        assertTrue(lb1.equals(lb2));
    }

    @Test
    public void testWeightConversion_KgToGrams() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    public void testWeightConversion_PoundsToKg() {
        QuantityWeight lb = new QuantityWeight(1.0, WeightUnit.POUND);
        QuantityWeight kg = new QuantityWeight(0.453592, WeightUnit.KILOGRAM);
        assertTrue(lb.equals(kg));
    }

    @Test
    public void testWeightAddition_KgToKg() {
        QuantityWeight kg1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight kg2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight result = kg1.add(kg2);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testWeightAddition_KgAndGrams() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = kg.add(g);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testWeightAddition_WithTargetUnit() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = kg.add(g, WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), EPSILON);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeight_NullUnit_ThrowsException() {
        new QuantityWeight(1.0, null);
    }

    @Test
    public void testLengthAndWeightAreIncomparable() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        Length ft = new Length(1.0, LengthUnit.FEET);
        assertFalse(kg.equals(ft));
    }
}