package test;

import main.parsers.MapperParser;
import main.parsers.MetalPriceInformationParser;
import main.parsers.RomanNumberMetalQueryParser;
import main.parsers.RomanNumeralQueryParser;
import main.workflow.MapManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

public class RomanNumberMetalQueryParserTest {

    private RomanNumberMetalQueryParser parser = new RomanNumberMetalQueryParser();
    private MetalPriceInformationParser metalPriceInformationParser = new MetalPriceInformationParser();
    private MapperParser mapperParser = new MapperParser();
    private MapManager mapManager = MapManager.getInstance();

    @Before
    public void setupUnitTokenInformation() {
        mapperParser.parse("glob is I");
        mapperParser.parse("prok is V");
        mapperParser.parse("pish is X");
        mapperParser.parse("tegj is L");
        metalPriceInformationParser.parse("glob glob Silver is 34 Credits");
    }

    @Test
    public void romanNumberCreditQueryValidTest() {
        parser.parse("how many Credits is glob prok Silver");
        double creditValue = mapManager.getCreditValueFromRomanvNumeral("glob prok Silver");
        Assert.assertEquals(68, creditValue,0);
    }

    @Test(expected = InvalidParameterException.class)
    public void romanNumberCreditQueryInvalidTest() {
        parser.parse("how many Credits is wood chuck chuck");
    }
}
