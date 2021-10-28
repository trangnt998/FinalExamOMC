package student;

public class Student {
    private String ID;
    private String Name;
    private String Email;
    private float bonus;
    private float report;
    private float app;
    private float LT;
    private float avg;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getReport() {
        return report;
    }

    public void setReport(float report) {
        this.report = report;
    }

    public float getApp() {
        return app;
    }

    public void setApp(float app) {
        this.app = app;
    }

    public float getLT() {
        return LT;
    }

    public void setLT(float lT) {
        LT = lT;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public Student(String ID, String name, String email, float bonus, float report, float app, float LT, float avg) {
        this.ID = ID;
        Name = name;
        Email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.LT = LT;
        this.avg = avg;
    }

    public Student(String iD, String name, String email, float bonus, float report, float app, float lT) {
        super();
        ID = iD;
        Name = name;
        Email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        LT = lT;
    }

    @Override

    public String toString() {
        return "Student [ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", bonus=" + bonus + ", report=" + report
                + ", app=" + app + ", LT=" + LT + "]";
    }


}
