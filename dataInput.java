import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class dataInput {
    //for production purposes:
    private ArrayList<Student> StudentMasterList;
    private ArrayList<Dorm> DormMasterList;

    //for testing purposes:
    public ArrayList<String> roomsPublicTest = new ArrayList<>();
    public ArrayList<Student> master; //change to private later


    //basic get methods
    public ArrayList<Student> getStudentMasterList() {return StudentMasterList;}
    public ArrayList<Dorm> getDormMasterList() {return DormMasterList;}
    
    dataInput() {
        //code creates test data, NOT FOR PRODUCTION
        /*
        for (int i = 1; i < 21; i++) {roomsPublicTest.add(Integer.toString(i));}
        master = new ArrayList<>();
        Random rand = new Random();
        for (int q = 0; q < 20; q++) {
            Student s = new Student();
            //s.setEmail(stringmaker() + "@taboracademy.org");
            //s.setRoomPreference(rand.nextInt(1,5), rand.nextInt(1,5), rand.nextInt(1,5));
            //s.setSleepinghabit(rand.nextInt(1,5), rand.nextInt(1,5));
            s.setStrings(make_strings_for_testing() + "@taboracademy.org");
            s.setRoomChoices(String.valueOf(rand.nextInt(1, 21)), String.valueOf(rand.nextInt(1, 21)), String.valueOf(rand.nextInt(1, 21)), String.valueOf(rand.nextInt(1, 21)));
            ArrayList<Integer> j = new ArrayList<>();
            for(int i = 0; i < 6; i++) {
                j.add(rand.nextInt(1,5));
            }
            s.setScores(j);
            s.setInternational(Math.random() < 0.5);
            master.add(s);
            
        }*/
        new Core(StudentMasterList, DormMasterList);
    }

    private ArrayList input_data_from_ollys_excel_program(ArrayList<ArrayList<Object>> olly_master_list) {
        for (ArrayList<Object> objects : olly_master_list) {
            Student curstu = new Student();
            curstu.setStrings((String) objects.get(0));
            ArrayList<Integer> tempArr = new ArrayList<>();
            for (int i : (ArrayList<Integer>) objects.get(1)) {
                tempArr.add(i);
            }
            curstu.setScores(tempArr);
            StudentMasterList.add(curstu);
        }

        return StudentMasterList;
    }

    
    private void txtmake() { //for testing dorms
        Random rand = new Random();
        try {
            FileWriter writer = new FileWriter("matsu.txt");
            writer.write("Matsumura\n");
            writer.write("20\n");
            writer.write("Male\n");
            for (int i = 1; i <= 20; i++) {
                writer.write(String.valueOf(i) + " " + (rand.nextInt(2) + 1) + "\n");
            }
            writer.write(",");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void DormInput(String[] args){
        ArrayList list = new ArrayList();
        try{
            Scanner s = new Scanner(new File("/Users/yangzijian/Desktop/JAVA/Final Project/out/production/Final Project/RoomList - Sheet1.csv"));
            s.useDelimiter(",,,");
            for (int m = 0; m < 16; m++) {
                ArrayList <Object> sublist = new ArrayList<>();
                ArrayList <Object> subsublist = new ArrayList<>();
                String[] x = s.next().split(",");
                for (String p: x) {
                    subsublist.add(p.strip());
                }
                int k = 0;
                while(k < subsublist.size()-1){
                    ArrayList tem = new ArrayList();
                    for (int i = 0; i < 3; i++) {
                        tem.add(subsublist.get(k + i));
                    }
                    sublist.add(tem);
                    k += 3;
                }
                list.add(sublist);
            }
            System.out.println(list);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void readtxt(){ //for reading in dorm/rooms
        try{
            Scanner t = new Scanner(new File("/Users/brynkerslake/Desktop/JAVA/Final Project/matsu.txt"));
            ArrayList<ArrayList> outer = new ArrayList();
            ArrayList<String> inner = new ArrayList();
            while(t.hasNextLine()&&t.next()!=","){
                inner.add(t.nextLine());
                outer.add(inner);
                inner.clear();
            }
            System.out.println(outer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    /*
    private static String make_strings_for_testing() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 8;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }*/
}

