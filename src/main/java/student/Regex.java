package student;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex implements Serializable {
    private static final long serialVersionUID = 1L;

    //1. String regexEmail = "\\b[A-Za-z]+\\w*@(gmail.com|outlook.com)\\b";
    public String getRegex() {
        return "\\b[A-Za-z]+\\w*@(gmail.com|outlook.com)\\b";
    }

    //2. liệt kê sinh viên có email là gmail
    public ArrayList<Student> listGmail(ArrayList<Student> students) {
        String regexEmail = "\\b[A-Za-z]+\\w*@(gmail.com)\\b";
        Pattern patternEmail;
        ArrayList<Student> studentgmail = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++) {
            String text = students.get(i).getEmail();
            patternEmail = Pattern.compile(regexEmail);
            Matcher matcherEmail = patternEmail.matcher(text);
            if (matcherEmail.find()) {
                studentgmail.add(students.get(i));
//                System.out.println(text.substring(matcherEmail.start(), matcherEmail.end()));
            }
        }
        return studentgmail;

    }


    //3. liệt kê sinh viên có email là outlook
    public ArrayList<Student> listOutlook(ArrayList<Student> students) {
        String regexEmail = "\\b[A-Za-z]+\\w*@(outlook.com)\\b";
        Pattern patternEmail;
        ArrayList<Student> studentOutlook = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++) {
            String text = students.get(i).getEmail();
            patternEmail = Pattern.compile(regexEmail);
            Matcher matcherEmail = patternEmail.matcher(text);
            if (matcherEmail.find()) {
                studentOutlook.add(students.get(i));
//                System.out.println(text.substring(matcherEmail.start(), matcherEmail.end()));
            }
        }
        return studentOutlook;

    }


    //chuyển thông tin sinh viên có email là outlook vào file outlook.bin
    public void writeInfoOutlook(ArrayList<Student> students, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos);
            for (Student student : students) {
                dos.writeUTF(student.getID());
                dos.writeUTF(student.getName());
                dos.writeUTF(student.getEmail());
                dos.writeFloat(student.getBonus());
                dos.writeFloat(student.getReport());
                dos.writeFloat(student.getApp());
                dos.writeFloat(student.getLT());
                dos.writeFloat(student.getAvg());
            }
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //4. đọc file outlook.bin
    public void readInfoOutlook(ArrayList<Student> students) {
        try {
            FileInputStream fis = new FileInputStream("src/test/outlook.bin");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {

                String ID = dis.readUTF();
                String Name = dis.readUTF();
                String Email = dis.readUTF();
                float bonus = dis.readFloat();
                float report = dis.readFloat();
                float app = dis.readFloat();
                float LT = dis.readFloat();
                float avg = dis.readFloat();

                Student student = new Student(ID, Name, Email, bonus, report, app, LT, avg);
                System.out.println(student);
            }
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printListStudent1(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s.toString());
            System.out.println("\n");

        }
    }

    public static void main(String[] args) {
        Regex r = new Regex();
        ReadData reader = new ReadData();
        ArrayList<Student> Students;
        Students = reader.readData("src/test/output.csv");

        //1.
        String regex = r.getRegex();
        System.out.println(regex);

        //2. gmail
        ArrayList<Student> studentgmails = r.listGmail(Students);
        printListStudent1(studentgmails);

        //3. outlook
        ArrayList<Student> studentOutlook = r.listOutlook(Students);
        printListStudent1(studentOutlook);

        r.writeInfoOutlook(studentOutlook, "src/test/outlook.bin");
        r.readInfoOutlook(studentOutlook);


    }

}
