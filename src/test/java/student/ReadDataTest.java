package student;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReadDataTest {
    ArrayList<Student> students = new ArrayList<Student>();
    Student student1 = new Student("11","Nguyen Thi Trang","trangnt998@gmail.com",5,10,9.5f,10);
    Student student2 = new Student("A","Nguyen Thi BB","trangnt998@outlook.com",0,0,0,0);
    Student student3 = new Student("B","Nguyen Thi As","trangnt998@outlook.com",0,0,0,9);

    @Test
    public void CaculatorAvgTest_01(){
        students.add(student1);
        ReadData r = new ReadData();
        r. CaculatorAvg(students);

        float expect = 9.5f;
        float actual = student1.getAvg();
        assertEquals(expect, actual);
    }



    @Test
    public void CaculatorAvgTest_02(){
        students.add(student1);
        students.add(student2);
        ReadData r = new ReadData();
        r. CaculatorAvg(students);

        float[] expect = {9.5f,0f};
        float[] actual = new float[2];
        for (int i = 0; i < students.size(); i++){
            actual[i] = students.get(i).getAvg();
            assertEquals(expect[i], actual[i]);
        }
    }

    @Test
    public void CaculatorAvgTest_03(){
        students.add(student3);
        ReadData r = new ReadData();
        r. CaculatorAvg(students);

        float expect = 4.0f;
        float actual = student3.getAvg();
        assertEquals(expect, actual);
    }
}
