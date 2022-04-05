public class Rooms {
    String name;
    boolean isSingle;
    boolean isFull;
    Student[] arr;

    Rooms(String name, int numPeople){
        this.name = name;
        if (numPeople == 1){
            isSingle = true;
            arr = new Student[1];
        }else{
            isSingle = false;
            arr = new Student[2];
        }
    }
    public String toString(){
        return name;
    } // this method returns name of the room when printing Room object, might

    // change that later.
    public void assignPersonToRoom(Student student){
        if(!isFull&& arr[0]==null){
            arr[0] = student;
            if(isSingle){
                isFull = true;
            }
        }else if(!isFull && arr[1]==null){
            arr[1] = student;
        }else {
            isFull = true;
            System.out.println("Room is full"); // to GUI?
        }
    }

    public void removePersonFromRoom(Student student){
        if(arr[0]==student){
            arr[0] = null;
        }else if(arr[1]==student){
            arr[1] = null;
        }else {
            System.out.println("Student not found"); // to GUI?
        }
    }



}



