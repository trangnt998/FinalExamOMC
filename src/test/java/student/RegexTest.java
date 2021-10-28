package student;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegexTest {
    ArrayList<Student> students = new ArrayList<Student>();
    Student student1 = new Student("11","Nguyen Thi Trang","trangnt998@gmail.com",5,10,9.5f,10);
    Student student2 = new Student("A","Nguyen Thi BB","trangnt998@outlook.com",0,0,0,0);
    Student student3 = new Student("B","Nguyen Thi As","trangnt998@onemount.com",0,0,0,9);

    @Test
    public void RegexTest_01(){
        students.add(student1);
        Regex r = new Regex();
        r.listGmail(students);

       String expect = "trangnt998@gmail.com";
        String actual = student1.getEmail();
        assertEquals(expect, actual);
    }


    @Test
    public void RegexTest_02(){
        students.add(student2);
        Regex r = new Regex();
        r.listOutlook(students);

        String expect = "trangnt998@outlook.com";
        String actual = student2.getEmail();
        assertEquals(expect, actual);
    }



}
