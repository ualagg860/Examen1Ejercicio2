package conversionTemperatura;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import conversionTemperatura.ConversionTemperatura;

public class TestConversionTemperatura {

    private final ConversionTemperatura converter = new ConversionTemperatura();
    private static final double DELTA = 0.000001;

    @ParameterizedTest(name = "[{index}] {0} {1} -> {2} = {3}")
    @CsvFileSource(files = "test/conversionTemperatura/test_cases.csv", numLinesToSkip = 1)
    void testConvertTemperature(double input, String fromUnit, String toUnit, String expectedStr) {
        double result = converter.convertTemperature(input, fromUnit, toUnit);
        if (expectedStr.equalsIgnoreCase("NaN")) {
            assertTrue(Double.isNaN(result), "Se esperaba NaN pero se obtuvo: " + result);
        } else {
            double expected = Double.parseDouble(expectedStr);
            assertEquals(expected, result, DELTA, 
                String.format("Error en la conversión: %.5f %s → %s", input, fromUnit, toUnit));
        }
    }
}






