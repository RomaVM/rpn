package data_access;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public void writeData(String dataToSave) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT, true))) {
            bw.write(dataToSave);
            bw.newLine();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
