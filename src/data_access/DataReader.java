package data_access;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static DataReader instance;
    private static final String INPUT = "input.txt";

    private DataReader() {

    }

    public static DataReader getInstance() {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    public List<String[]> readData() {
        List<String[]> listOfData = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(INPUT))) {
            while ((line = br.readLine()) != null) {
                listOfData.add(line.split(""));
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfData;
    }
}
