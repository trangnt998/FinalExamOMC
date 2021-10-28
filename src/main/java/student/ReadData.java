package student;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReadData {
     String COMMA_DELIMITER = ",";

    public  void CaculatorAvg(ArrayList<Student> students) {
        for(Student s: students) {
            float avg = (float) (s.getBonus()*0.1 + s.getReport()*0.3 + s.getApp()*0.15 + s.getLT()*0.45);
            float du = (float) (avg - Math.floor(avg));
            if(du < 0.25) {
                du = 0;
            }else if(du >=0.25 && du < 0.75) {
                du = (float) 0.5;
            }else {
                du = (float) 1.0;
            }
            avg = (float) (du + Math.floor(avg));
            s.setAvg(avg);
            //System.out.println(s.avg);
        }

    }

    //6. THống kê
    public void statistical(ArrayList<Student> students) {
        int size = students.size();

        int[] dieukien = new int[5];
        for (int i = 0; i < 5; i++){
            dieukien[i] = 0;
        }
        // dieukien 0-4: khong dat, dat, gioi, kha, tb
        for(int i =0; i< size; i ++) {
            if(students.get(i).getAvg() <= 4.5) {
                dieukien[0] += 1;
            }
            else {
                dieukien[1] += 1;
            }

            if(students.get(i).getAvg() >= 8.0) {
                dieukien[2] += 1;
            }
            if(students.get(i).getAvg() >= 4.5 && students.get(i).getAvg() < 6.5) {
                dieukien[4] += 1;
            }
            if(students.get(i).getAvg()>=6.5 && students.get(i).getAvg()<8.0) {
                dieukien[3] += 1;
            }
        }

        //print //////////////
        System.out.println("Thống kê \t\t\t Số lượng \t\t Tỉ lệ");
        System.out.println("Số lượng sinh viên \t\t" +size +"\t\t");
        System.out.println("Đạt \t\t\t\t\t" +dieukien[1] +"\t\t\t" + Math.round(100*dieukien[1]/size) +"%");
        System.out.println("Không Đạt \t\t\t\t" +dieukien[0] +"\t\t\t" + (100 - Math.round(100*dieukien[1]/size))+"%");
        System.out.println("Giỏi \t\t\t\t\t" +dieukien[2] +"\t\t\t" + Math.round(100*dieukien[2]/size)+"%");
        System.out.println("Khá \t\t\t\t\t" +dieukien[3] +"\t\t\t" + Math.round(100*dieukien[3]/size)+"%");
        System.out.println("Trung Bình \t\t\t\t" +dieukien[4] +"\t\t\t" + (Math.round(100*dieukien[1]/size)-Math.round(100*dieukien[2]/size)-Math.round(100*dieukien[3]/size))+"%");
    }

    //2. Danh sách 10 sinh viên có điểm lí thuyết cao nhất
    public void ListTop10byLTPoints(ArrayList<Student> students) {
        ArrayList<Student> sorted_Students = (ArrayList<Student>) students.clone();
        Collections.sort(sorted_Students, new Comparator<Student>(){
            public int compare(Student s1, Student s2) {
                if(s1.getLT() - s2.getLT() >=0)
                    return -1;
                else return 1;
            }
        });

        for(int i = 0; i < sorted_Students.size(); i ++) {
            if(i >= 10) {
                break;
            }else {
                System.out.println(sorted_Students.get(i).toString());
            }
        }
    }


    //4. danh sách 10 sinh viên điểm tổng kết thấp nhất
    public void ListTop10WorstbyAvgPoint(ArrayList<Student> students) {
        ArrayList<Student> sorted_Students = (ArrayList<Student>) students.clone();
        Collections.sort(sorted_Students, new Comparator<Student>(){
            public int compare(Student s1, Student s2) {
                if(s1.getAvg() - s2.getAvg() >=0)
                    return 1;
                else return -1;
            }
        });
        for(int i = 0; i < sorted_Students.size(); i ++) {
            if(i >= 10) {
                break;
            }else {
                System.out.print(sorted_Students.get(i).toString());
                System.out.println(", AVG = " + sorted_Students.get(i).getAvg());
            }
        }
    }


    //xuất danh sách sinh viên vào output.csv
    public void ExportListStudent(ArrayList<Student> students, String path) throws IOException {
        File file = new File(path);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        // write tieu de
        bw.write("ID,Name,Email,Bonus,Report,App,LT,Avg");
        bw.newLine();
        for(Student s: students){
            bw.write(s.getID() +","+ s.getName()+","+s.getEmail()+","+Float.toString(s.getBonus())+","+Float.toString(s.getReport())+","+Float.toString(s.getApp())+","+ Float.toString(s.getLT())+","+ Float.toString(s.getAvg()));
            bw.newLine();

        }
        bw.close();
        fw.close();

    }


//1 . Đọc file csv
    public  ArrayList<Student> readData(String path) {
        FileReader fileReader = null;
        ArrayList<Student> Students = new ArrayList<Student>();

        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(fileReader);
        Students = new ArrayList<Student>();
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            while((line = reader.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                String id = values[0];
                String Name = values[1];
                String Email = values[2];
                float bonus = Float.valueOf(values[3]);
                float report = Float.valueOf(values[4]);
                float app = Float.valueOf(values[5]);
                float LT = Float.valueOf(values[6]);
                Students.add(new Student(id, Name, Email, bonus, report, app, LT));

            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Students;

    }


    public static void printListStudent(ArrayList<Student> students) {
        for(Student s: students) {
            System.out.println(s.toString());
            System.out.println("\n");

        }
    }


}

