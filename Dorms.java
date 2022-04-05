public class Dorms {
    String name;
    int totalRooms;
    public Dorms(String name, int totalRooms){
        this.name = name;
        this.totalRooms = totalRooms;
    }

    public String toString (){
        return name;
    }

    public int getTotalRooms(){
        return totalRooms;
    }


}
