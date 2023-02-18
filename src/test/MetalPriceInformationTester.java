package test;

import main.enums.MaterialTypes;
import main.parsers.MapperParser;
import main.parsers.MetalPriceInformationParser;
import main.workflow.MapManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

public class MetalPriceInformationTester {

    private MetalPriceInformationParser parser = new MetalPriceInformationParser();
    private MapperParser mapperParser = new MapperParser();
    private MapManager mapManager = MapManager.getInstance();

    @Before
    public void setupUnitTokenInformation(){
        mapperParser.parse("glob is I");
        mapperParser.parse("prok is V");
        mapperParser.parse("pish is X");
        mapperParser.parse("tegj is L");
    }

    @Test
    public void metalTypePriceEvaluationValidTest(){
        parser.parse("glob glob Silver is 34 Credits");
        int silverCreditValue = mapManager.getCreditByCommodity(MaterialTypes.SILVER);
        Assert.assertEquals(17, silverCreditValue);
    }

    @Test(expected = InvalidParameterException.class)
    public void metalTypePriceEvaluationIValidTest(){
        parser.parse("glob glob glob glob Silver is 34 Credits");
    }

}
