package model;

public class Intern extends Employee{
    private String major;
    private int semester;
    private String education;

    public Intern(){};

    public Intern(int id, String fullName, String birthDay, String phone, String email, String type, int count, String major, int semester, String education) {
        super(id, fullName, birthDay, phone, email, type, count);
        this.major = major;
        this.semester = semester;
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "major='" + major + '\'' +
                ", semester=" + semester +
                ", education='" + education + '\'' +
                "} " + super.toString();
    }

    @Override
    public void showInformation(){
        System.out.println("ID: " + super.getId() + " | Full name: " + super.getFullName() + " | DOB: " + super.getBirthDay() + " | Phone number: " + super.getPhone() + " | Email: " + super.getEmail() + " | Type: " + super.getType() + " | Identity: " + super.getCount() + " | Major: " + major + " | Semester: " + semester + " | Education: " + education);
    }

}
