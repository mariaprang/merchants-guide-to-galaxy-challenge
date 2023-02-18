package test;

import main.parsers.MapperParser;
import main.parsers.MetalPriceInformationParser;
import main.parsers.RomanNumeralQueryParser;
import main.workflow.MapManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

public class RomanNumeralQueryParserTest {

    private RomanNumeralQueryParser parser = new RomanNumeralQueryParser();
    private MapperParser mapperParser = new MapperParser();
    private MapManager mapManager = MapManager.getInstance();

    @Before
    public void setupUnitTokenInformation() {
        mapperParser.parse("glob is I");
        mapperParser.parse("prok is V");
        mapperParser.parse("pish is X");
        mapperParser.parse("tegj is L");
    }

    @Test
    public void romanNumberToIntegerValidTest() {
        parser.parse("how much is pish tegj glob glob");
        int value = mapManager.getIntegerResultFromRomanNumeral("pish tegj glob glob");
        Assert.assertEquals(42, value);
    }

    @Test(expected = InvalidParameterException.class)
    public void romanNumberToIntegerInvalidTest() {
        parser.parse("how much is abs klm glob glob");
    }

}
