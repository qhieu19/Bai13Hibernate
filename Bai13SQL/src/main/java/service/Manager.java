package service;

import model.Employee;
import model.Experience;
import model.Fresher;
import model.Intern;
import validation.InputValidation;

import java.util.ArrayList;

public class Manager{
    private final InputValidation input = new InputValidation();
    private final Helper helper = new Helper();
    private final Printer printer = new Printer();
    private final ArrayList<Employee> list = new ArrayList<>();

//    //init data
//    public Manager(){
//        list.add(new Experience("1", "Anh", "19-07-2000", "0949022456", "anh@gmail.com", "experience", 1,5,"rat nhieu"));
//        list.add(new Fresher("2", "Hieu", "19-01-2001", "0342217180", "hieu19@gmail.com", "fresher", 2, "01/01/2021", "good", "FPT University"));
//        list.add(new Intern("3", "Hung", "01-01-2000", "0987656781", "hung@gmail.com", "intern", 3, "SE", 6, "FBT university of economic and finance :))"));
//    }

/*--------------read------------------------------------------------------------------------*/
    //display all employees
    public void showAll(){
        if(!list.isEmpty()){
            printer.print("Employees list");
            for (Employee e : list) {
                e.showInformation();
            }
        }else{
            printer.print("List is empty");
        }
    }

    //display all experience
    public void showExperience(){
        int count = 0;
        printer.printInLine("Experience");
        for (Employee e : list) {
            if(e instanceof Experience){
                e.showInformation();
                count++;
            }
        }
        if(count == 0){
            printer.print(" is empty");
        }
    }

    //display all fresher
    public void showFresher(){
        int count = 0;
        printer.printInLine("Fresher list");
        for (Employee e : list) {
            if(e instanceof Fresher){
                e.showInformation();
                count++;
            }
        }
        if(count == 0){
            printer.print(" is empty");
        }
    }

    //display all intern
    public void showIntern(){
        int count = 0;
        printer.printInLine("Intern list");
        for (Employee e : list) {
            if(e instanceof Intern) {
                e.showInformation();
                count++;
            }
        }
        if(count == 0){
            printer.print(" is empty");
        }
    }

    //display handler
    public void read(){
        printer.searchMenu();
        int choice = input.getIntLimit(1,4);
        switch (choice){
            case 1: showAll(); break;
            case 2: showExperience(); break;
            case 3: showFresher(); break;
            case 4: showIntern(); break;
            default: break;
        }
    }

/*--------------delete------------------------------------------------------------------------*/
    //delete employee
    public void delete(){
        printer.enter("id to delete");
        int id = input.getInt();
        int count = 0;
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getId()==(id)){
                count ++;
                if(input.confirm() == true){
                    list.remove(list.get(i));
                }
            }
        }
        if (count == 0){
            printer.print("Employee not found!");
        }
    }

/*--------------create------------------------------------------------------------------------*/
    //add handler
    public void create(){
        printer.enter("number of employee: ");
        int number = input.getInt();

        for (int i = 0; i < number; i++){
            printer.addMenu();
            int type = input.getIntLimit(1,3);
            switch (type){
                case 1:
                    addExp();
                    break;
                case 2:
                    addFresher();
                    break;
                case 3:
                    addIntern();
                    break;
            }
        }
    }

    //add Experience
    public void addExp(){
        Employee e = inputCommon();
        printer.enter("exp in year:");
        int year = input.getInt();
        printer.enter("skills");
        String skill = input.getString();
        list.add(new Experience(e.getId(), e.getFullName(), e.getBirthDay(), e.getPhone(), e.getEmail(), "experience", e.getCount(), year, skill));
    }

    //add Fresher
    public void addFresher(){
        Employee e = inputCommon();
        printer.enter("graduate date: ");
        String date = input.getString();
        printer.enter("graduate rank: ");
        String rank = input.getString();
        printer.enter("education: ");
        String edu = input.getString();
        list.add(new Fresher(e.getId(), e.getFullName(), e.getBirthDay(), e.getPhone(), e.getEmail(),"fresher", e.getCount(), date, rank ,edu));
    }

    //add Intern
    public void addIntern(){
        Employee e = inputCommon();
        printer.enter("major: ");
        String major = input.getString();
        printer.enter("semester: ");
        int semester = input.getInt();
        printer.enter("edu: ");
        String edu = input.getString();
        list.add(new Intern(e.getId(), e.getFullName(), e.getBirthDay(), e.getPhone(), e.getEmail(), "intern", e.getCount(), major, semester ,edu));
    }

    //input common information
    public Employee inputCommon(){
        printer.enter("employee ID: ");
        int id = input.getInt();
        while (helper.checkID(id,list)){
            printer.enter("Id is existed, please enter new id");
            id = input.getInt();
        }
        Employee e = inputUpdate();
        e.setId(id);
        e.setCount(helper.getNumber(list) + 1);
        return e;
    }

    public Employee inputUpdate(){
        Employee e = new Employee();

        printer.enter("full name: ");
        e.setFullName(input.getString());

        printer.enter("DOB: ");
        e.setBirthDay(input.getDOB());

        printer.enter("phone: ");
        e.setPhone(input.getPhone());

        printer.enter("email: ");
        e.setEmail(input.getEmail());
        return e;
    }

/*--------------update------------------------------------------------------------------------*/
    //update employee
    public void update(){
        printer.enter("id to update");
        int id = input.getInt();
        int index = helper.getIndex(id,list);
        if(index != -1){
            Employee e = inputUpdate();
            if(list.get(index) instanceof Experience){
                Experience ex = (Experience) list.get(index);
                list.set(index,new Experience(ex.getId(), e.getFullName(), e.getBirthDay(), e.getPhone(), e.getEmail(), ex.getType(), ex.getCount(), ex.getExpInYear(), ex.getProSkill()));
            }else if(list.get(index) instanceof Fresher){
                Fresher fresher = (Fresher) list.get(index);
                list.set(index,new Fresher(fresher.getId(), e.getFullName(), e.getBirthDay(), e.getPhone(), e.getEmail(), fresher.getType(), fresher.getCount(), fresher.getGraduationDate(), fresher.getRank(), fresher.getEducation()));
            }else if(list.get(index) instanceof Intern){
                Intern in = (Intern) list.get(index);
                list.set(index, new Intern(in.getId(), e.getFullName(), e.getBirthDay(), e.getPhone(), e.getEmail(), in.getType(), in.getCount(), in.getMajor(), in.getSemester(), in.getEducation()));
            }
            printer.print("Update successfully!");
        }else{
            printer.print("Employee not found!");
        }
    }
}
