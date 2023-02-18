package test;

import main.enums.RomanSymbols;
import main.parsers.MapperParser;
import main.validators.ValidatorManager;
import main.workflow.MapManager;
import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

public class MapperParserTest {

    private MapperParser mapperParser = new MapperParser();
    private MapManager mapManager = MapManager.getInstance();

    @Test
    public void validInputTest() {
        mapperParser.parse("glob is I");
        Assert.assertEquals(mapManager.getRomanNumeralByUnit("glob"), RomanSymbols.I);
    }

    @Test(expected = InvalidParameterException.class)
    public void inValidInputTest() {
        mapperParser.parse("glob is Y");
    }

}
