package service;

import model.Employee;

import java.util.ArrayList;

public class Helper {
    public int getNumber(ArrayList<Employee> list){
        return list.size();
    }

    public boolean checkID(int id, ArrayList<Employee> list){
        for (Employee e : list) {
            if(e.getId()==(id)){
                return true;
            }
        }
        return false;
    }

    public int getIndex(int id, ArrayList<Employee> list){
        for (Employee e : list) {
            if(e.getId()==(id)){
                return list.indexOf(e);
            }
        }
        return -1;
    }
}
