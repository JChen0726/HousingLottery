public class Dorms {
    String name;
    int  gender;
    int totalRooms;
    public Dorms(String name, int totalRooms, int gender){
        this.name = name;
        this.totalRooms = totalRooms;
        this.gender = gender;
    }
    public String toString (){
        return name;
    }

    public int getTotalRooms(){
        return totalRooms;
    }


}
