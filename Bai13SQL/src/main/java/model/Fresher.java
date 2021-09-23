package model;

public class Fresher extends Employee{
    private String graduationDate;
    private String rank;
    private String education;

    public Fresher(){};

    public Fresher(int id, String fullName, String birthDay, String phone, String email, String type, int count, String graduationDate, String rank, String education) {
        super(id, fullName, birthDay, phone, email, type, count);
        this.graduationDate = graduationDate;
        this.rank = rank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate=" + graduationDate +
                ", rank='" + rank + '\'' +
                ", education='" + education + '\'' +
                "} " + super.toString();
    }

    @Override
    public void showInformation(){
        System.out.println("ID: " + super.getId() + " | Full name: " + super.getFullName() + " | DOB: " + super.getBirthDay() + " | Phone number: " + super.getPhone() + " | Email: " + super.getEmail() + " | Type: " + super.getType() + " | Identity: " + super.getCount() + " | Graduation date: " + graduationDate + " | Rank: " + rank + " | Education: " + education);
    }
}
