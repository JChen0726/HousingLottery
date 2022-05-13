import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class dataInput {
    //for production purposes:
    private ArrayList<Student> StudentMasterList = new ArrayList<Student>();
    private ArrayList<Dorm> DormMasterList = new ArrayList<Dorm>();

    //basic get methods
    public ArrayList<Student> getStudentMasterList() {return StudentMasterList;}
    public ArrayList<Dorm> getDormMasterList() {return DormMasterList;}
    
    dataInput() {
        inputStudentData();
        dormInput();
    }

    private ArrayList inputStudentData() {
        ArrayList<ArrayList<Object>> rawStudentData = new ArrayList<>();
        try {
            Scanner studentInput = new Scanner(new File("/Users/brynkerslake/Documents/GitHub/HousingLottery/StudentTestData.csv"));
            studentInput.useDelimiter(",,,");
            for (int i = 0; i < 38; i++) { // 40 being the number of students
                try {
                    //lambda that splits the next inout into an arraylist
                    ArrayList<Object> x = Arrays.stream(studentInput.next().split(",")).map(String::strip).collect(Collectors.toCollection(ArrayList::new));
                    rawStudentData.add(x);
                }
                catch (Exception e) {
                    }
                } //takes data from csv, puts into rawstudentdata

        //assumes data format is: [[name, new/old, domestic/international, gender, [choices]], [name, etc], ...]
        for (ArrayList<Object> objects : rawStudentData) {
            System.out.println(objects);
            Student curstu = new Student();
            curstu.setEmail(String.valueOf(objects.get(0)));
            curstu.setGrade(Integer.parseInt(objects.get(1).toString()));
            curstu.setInternational(objects.get(2).toString().equals("International"));
            curstu.setGender(String.valueOf(objects.get(3)));
            ArrayList<Integer> choices = objects.stream().filter(x -> x instanceof Integer).map(x -> (Integer) x).collect(Collectors.toCollection(ArrayList::new));
            curstu.setScores(choices);
            StudentMasterList.add(curstu);
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        return StudentMasterList;
    }

    private ArrayList<Dorm> dormInput(){
        ArrayList<Dorm> list = new ArrayList();
        try{
            Scanner s = new Scanner(new File("/Users/brynkerslake/Documents/GitHub/HousingLottery/RoomTestData.csv"));
            s.useDelimiter(",,,");
            for (int m = 0; m < 16; m++) { // 16 being the number of dorms
                ArrayList <ArrayList> sublist = new ArrayList<>();
                ArrayList <Object> subsublist = new ArrayList<>();
                String[] x = s.next().split(",");
                for (String p: x) {
                    subsublist.add(p.strip());
                }
                int k = 0;
                while (k < subsublist.size()-1) {
                    ArrayList <Object>tem = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {
                        tem.add(subsublist.get(k + i));
                    }
                    sublist.add(tem);
                    k += 3;
                }
                for (int i = 0; i < sublist.size(); i++) {
                    Dorm d = new Dorm(sublist.get(i).get(0).toString(),sublist.size(),sublist.get(i).get(2).toString());
                    System.out.println(sublist.get(i));
                    d.setRooms(sublist);
                    list.add(d);
                }
            }
            return list;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}

