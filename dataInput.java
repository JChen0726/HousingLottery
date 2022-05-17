import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class dataInput {

    //for production purposes:
    private final ArrayList <Student> StudentMasterList = new ArrayList<>();
    private ArrayList <Dorm> DormMasterList = new ArrayList<>();

    //basic get methods
    public ArrayList <Student> getStudentMasterList() {return StudentMasterList;}
    public ArrayList <Dorm> getDormMasterList() {return DormMasterList;}
    
    dataInput() {
        inputStudentData();
        dormInput(2);
    }

    private void inputStudentData() {
        ArrayList <ArrayList<Object>> rawStudentData = new ArrayList<>();
        try {
            Scanner studentInput = new Scanner(new File("/Users/justinchen/Documents/GitHub/HousingLottery/StudentTestData.csv"));
            studentInput.useDelimiter(",,,");
            for (int i = 0; i < 38; i++) { // 40 being the number of students
                try {
                    //lambda that splits the next inout into an arraylist
                    ArrayList <Object> x = Arrays.stream(studentInput.next().split(",")).map(String::strip).collect(Collectors.toCollection(ArrayList::new));
                    rawStudentData.add(x);
                }
                catch (Exception e) {
                    e.getCause();
                    }
                } //takes data from csv, puts into rawstudentdata

        //assumes data format is: [[name, new/old, domestic/international, gender, [choices]], [name, etc], ...]
        for (ArrayList <Object> objects : rawStudentData) {

            Student curstu = new Student();
            curstu.setEmail(String.valueOf(objects.get(0)));
            curstu.setGrade(Integer.parseInt(objects.get(1).toString()));
            curstu.setInternational(objects.get(2).toString().equals("International"));
            curstu.setGender(String.valueOf(objects.get(3)));
            ArrayList <Integer> choices = objects.stream().filter(x -> x instanceof Integer).map(x -> (Integer) x).collect(Collectors.toCollection(ArrayList::new));
            curstu.setScores(choices);
            StudentMasterList.add(curstu);
        }
        } catch (FileNotFoundException e) {
        e.printStackTrace();}
    }

    private void dormInput(int numDorms){
        //olly bro what are these variable names...
        ArrayList <Dorm> list = new ArrayList<>();
        try{
            Scanner s = new Scanner(new File("/Users/justinchen/Documents/GitHub/HousingLottery/RoomTestData.csv"));
            s.useDelimiter(",,,");
            for (int m = 0; m < numDorms; m++) { // 16 being the number of dorms
                ArrayList <ArrayList<String>> sublist = new ArrayList<>();
                ArrayList <Object> subsublist = new ArrayList<>();
                String[] x = s.next().split(",");
                for (String p: x) {
                    subsublist.add(p.strip());
                }
                int k = 0;
                while (k < subsublist.size()-1) {
                    ArrayList <String> tem = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {
                        tem.add((String) subsublist.get(k + i));
                    }
                    sublist.add(tem);
                    k += 3;
                }
                // find name of dorm, create dorm and room objects
                StringBuilder name = new StringBuilder();
                for (int i = 0; i < sublist.get(0).size(); i++) {
                    if (Character.isDigit(sublist.get(0).get(0).charAt(i))) {
                        break;
                    }
                    name.append(sublist.get(0).get(0).charAt(i));
                }
                Dorm d = new Dorm(name.toString(),sublist.size(),sublist.get(0).get(1));
                d.setRooms(sublist);
                list.add(d);
            }
            DormMasterList = list;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

