package service;

public class Printer {
    public void chooseMenu(){
        System.out.println("1. Display");
        System.out.println("2. Add employee");
        System.out.println("3. Update employee");
        System.out.println("4. Delete employee");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }

    public void searchMenu(){
        System.out.println("1. Show all employees");
        System.out.println("2. Show experience");
        System.out.println("3. Show fresher");
        System.out.println("4. Show intern");
        System.out.print("Your choice: ");
    }

    public void addMenu(){
        System.out.println("Choose type: ");
        System.out.println("1. For experience");
        System.out.println("2. For fresher");
        System.out.println("3. For intern");
        System.out.print("Your choice: ");
    }

    public void display(String types){
        System.out.println("All " + types);
    }

    public void enter(String msg){
        System.out.println("Enter " + msg);
    }

    public void print(String msg){System.out.println(msg);}

    public void printInLine(String msg){System.out.print(msg);}
    }


