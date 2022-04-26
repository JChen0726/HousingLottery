public class Room {
    private String name;
    private boolean isSingle;
    private boolean isFull;
    private Student[] Students;

    Room(String name, int numPeople){
        this.name = name;
        if (numPeople == 1){
            isSingle = true;
            Students = new Student[1];
        }else{
            isSingle = false;
            Students = new Student[2];
        }
    }
    public String toString(){
        return name;
    } // this method returns name of the room when printing Room object, might

    // change that later.
    public void assignPersonToRoom(Student student){
        if(!isFull&& Students[0]==null){
            Students[0] = student;
            if(isSingle){
                isFull = true;
            }
        }else if(!isFull && Students[1]==null){
            Students[1] = student;
        }else {
            isFull = true;
            System.out.println("Room is full"); // to GUI?
        }
    }
    
    public void removePersonFromRoom(Student student){
        if(Students[0]==student){
            Students[0] = null;
        }else if(Students[1]==student){
            Students[1] = null;
        }else {
            System.out.println("Student not found"); // to GUI?
        }
    }


}



