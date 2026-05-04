package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuantityVolumeTest {

    private static final double EPSILON = 1e-2;

    @Test
    public void testVolumeEquality_Litres() {
        Quantity<VolumeUnit> l1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> l2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testVolumeEquality_Gallons() {
        Quantity<VolumeUnit> g1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> g2 = new Quantity<>(1.0, VolumeUnit.GALLON);
        assertTrue(g1.equals(g2));
    }

    @Test
    public void testVolumeConversion_GallonToLitre() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litre = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(gallon.equals(litre));
    }

    @Test
    public void testVolumeConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertTrue(litre.equals(ml));
    }

    @Test
    public void testVolumeAddition_GallonAndLitres() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litres = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = gallon.add(litres, VolumeUnit.LITRE);

        assertEquals(7.57, result.getValue(), EPSILON);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void testConvertToBaseUnit_MillilitreToLitre() {
        assertEquals(1.0, VolumeUnit.MILLILITRE.convertToBaseUnit(1000.0), EPSILON);
    }

    @Test
    public void testConvertToBaseUnit_GallonToLitre() {
        assertEquals(3.78541, VolumeUnit.GALLON.convertToBaseUnit(1.0), EPSILON);
    }

    @Test
    public void testConvertFromBaseUnit_LitreToLitre() {
        assertEquals(2.0, VolumeUnit.LITRE.convertFromBaseUnit(2.0), EPSILON);
    }

    @Test
    public void testConvertFromBaseUnit_LitreToMillilitre() {
        assertEquals(1000.0, VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0), EPSILON);
    }

    @Test
    public void testConvertFromBaseUnit_LitreToGallon() {
        assertEquals(1.0, VolumeUnit.GALLON.convertFromBaseUnit(3.78541), EPSILON);
    }
}
