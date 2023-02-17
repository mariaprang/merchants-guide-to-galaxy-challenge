package main.parsers;
import main.validators.interfaces.Validator;

public class ParserManager implements Parser {

    private Parser parser;
    private Validator validator;

    public ParserManager(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void parse(String inputLine)  {


    }





}
