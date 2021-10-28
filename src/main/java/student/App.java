package student;

import java.io.IOException;
import java.util.ArrayList;


public class App {


    public static void main(String[] args) throws IOException {
        ReadData reader = new ReadData();
        ArrayList<Student> Students;
        // 1.
        Students = reader.readData("src/test/data.csv");
//        reader.printListStudent(Students);
        // 2.
        //reader.ListTop10byLTPoints(Students);
        //3.
        reader.CaculatorAvg(Students);
        //4.
        reader.ListTop10WorstbyAvgPoint(Students);
        //5.
        reader.ExportListStudent(Students, "src/test//output.csv");

        //6.
        reader.statistical(Students);

    }
}
