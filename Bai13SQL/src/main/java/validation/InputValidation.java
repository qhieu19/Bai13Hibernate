package validation;

import exception.PhoneNumberException;

import java.util.Scanner;

public class InputValidation {
    private final Scanner sc = new Scanner(System.in);
    public int getInt(){
        while (true){
            try {
            String result = sc.nextLine();
                int a = Integer.parseInt(result.trim());
                if(a<0){
                    System.out.println("Error: Number < 0\nPlease input again: ");
                }else
                return a;
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage() + "\nPlease input again: ");
            }
        }
    }

    public boolean confirm(){
        while (true){
            System.out.println("Are you sure? (y/n)");
            String result = getString();
            if(result.toLowerCase().equals("y")){return true;}
            if(result.toLowerCase().equals("n")){return false;}
        }
    }

    public int getIntLimit(int min, int max){
        while (true){
            try {
                String result = sc.nextLine();
                int a = Integer.parseInt(result.trim());
                if(a<0){
                    System.out.println("Error: Number < 0\nPlease input again: ");
                }else if(a < min || a > max){
                    System.out.println("Out of range, please choose ["+min+"-"+max+"]");
                }
                else
                    return a;
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage() + "\nPlease input again: ");
            }
        }
    }

    public String getString(){
        while(true){
            try {
                String result = sc.nextLine();
                if(result.equals("") || result.length() == 0){
                    System.out.println("Please input again:");
                }else{
                    return result.trim();
                }
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage() + "\nPlease input again: ");
            }
        }
    }

    public String getEmail(){
        while(true){
            try {
                String result = sc.nextLine();
                if(result.equals("") || result.length() == 0){
                    System.out.println("Please input again:");
                }else if(!result.matches("^(.+)@(.+)$")){
                    System.out.println("Not an valid email, please input again:");
                }
                else{
                    return result.trim();
                }
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage() + "\nPlease input again: ");
            }
        }
    }
    public String getDOB(){
        while(true){
            try {
                String result = sc.nextLine();
                if(result.equals("") || result.length() == 0){
                    System.out.println("Please input again:");
                }else if(!result.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-((19|2[0-9])[0-9]{2})$")){
                    System.out.println("Not an valid DOB, please input again:");
                }
                else{
                    return result;
                }
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage() + "\nPlease input again: ");
            }
        }
    }

    public String getPhone(){
        while(true){
            try {
                String result = sc.nextLine();
                if(result.equals("") || result.length() == 0){
                    System.out.println("Please input again:");
                }else if(result.length() != 10){
                    throw new PhoneNumberException("invalid phone");
                }else{
                    return result.trim();
                }
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage() + "\nPlease input again: ");
            }
        }
    }
}
