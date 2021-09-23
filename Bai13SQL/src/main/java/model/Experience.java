package model;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;

    public Experience(){};

    public Experience(int id, String fullName, String birthDay, String phone, String email, String type, int count, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, type, count);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }


    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                "} " + super.toString();
    }

    @Override
    public void showInformation(){
        System.out.println("ID: " + super.getId() + " | Full name: " + super.getFullName() + " | DOB: " + super.getBirthDay() + " | Phone number: " + super.getPhone() + " | Email: " + super.getEmail() + " | Type: " + super.getType() + " | Identity: " + super.getCount() + " | Exp: " + expInYear + " | Skills: " + proSkill);
    }
}
