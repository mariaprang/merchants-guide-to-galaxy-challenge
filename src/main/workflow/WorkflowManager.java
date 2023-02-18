package main.workflow;
import main.enums.MaterialTypes;
import main.enums.InputTypes;
import main.inputKeywords.InputKeywords;
import main.parsers.MetalPriceInformationParser;
import main.parsers.MapperParser;
import main.parsers.Parser;
import main.validators.ValidatorManager;

import java.io.*;

public class WorkflowManager {

    private File file;
    private ValidatorManager validatorManager;
    private Parser parser;

    public WorkflowManager(String filePath) {
        this.validatorManager = new ValidatorManager();
        this.file = new File(filePath);
    }

    public InputTypes getInputType(String inputLine) {
        if (inputLine.contains(InputKeywords.MATCH_PHRASE)
                && inputLine.split(InputKeywords.DELIMITER).length == 3) {
            return InputTypes.MAPPING;
        } else if (checkIfInputContainsCommodityInformation(inputLine)) {
            return InputTypes.COMMODITY_PRICE_INFORMATION; // glob glob Iron
        } else if (inputLine.contains(InputKeywords.CREDIT_PHRASE)) {
            return InputTypes.CREDIT_VALUE_QUESTION;
        } else if (inputLine.contains(InputKeywords.ROMAN_NUMERAL_QUESTION_PHRASE)) {
            return InputTypes.ROMAN_NUMBER_QUESTION;
        } else {
            return InputTypes.NONE;
        }
    }

    private boolean checkIfInputContainsCommodityInformation(String inputLine) {
        return ((inputLine.contains(MaterialTypes.IRON.getValue())
                || inputLine.contains(MaterialTypes.GOLD.getValue())
                || inputLine.contains(MaterialTypes.SILVER.getValue()))
                && !inputLine.contains(InputKeywords.ROMAN_NUMERAL_QUESTION_PHRASE)
                && !inputLine.contains(InputKeywords.CREDIT_PHRASE));
    }

    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine()) != null) {
                InputTypes inputType = getInputType(line);
                switch (inputType) {
                    case MAPPING:
                        parser = new MapperParser();
                        break;
                    case COMMODITY_PRICE_INFORMATION:
                        parser = new MetalPriceInformationParser();
                        break;
                    case ROMAN_NUMBER_QUESTION:
                        break;
                    case CREDIT_VALUE_QUESTION:
                        break;
                    default:
                        break;
                }
                parser.parse(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
