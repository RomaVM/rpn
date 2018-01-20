import data_acces.DataReader;
import data_acces.DataWriter;
import logic.ExpressionParser;

public class Main {

    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        parser.calc(DataReader.getInstance().readData());
    }
}

