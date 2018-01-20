package data_acces;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DataWriter {
    private static DataWriter instance;
    private static final String OUTPUT = "output.txt";

    private DataWriter() {

    }

    public static DataWriter getInstance() {
        if (instance == null) {
            instance = new DataWriter();
        }
        return instance;
    }

    public void writeData(LinkedList<String> dataToSave) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT, true))) {
            for (String line : dataToSave) {
                bw.write(line);

            }
            bw.newLine();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
