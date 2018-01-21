package logic;

import data_access.DataReader;
import data_access.DataWriter;
import java.util.List;

public class DataSaver {

    private List<String[]> inputData = DataReader.getInstance().readData();
    private ParserToRpn parserToRpn = new ParserToRpn();

    public void saveTransformedData() {
        for (int i = 1; i <= Integer.parseInt(inputData.get(0)[0]); i++) {
            DataWriter.getInstance().writeData(parserToRpn.convertInfixToRPN(inputData.get(i)));
            System.out.println(parserToRpn.convertInfixToRPN(inputData.get(i)));
        }
    }
}
