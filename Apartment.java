import java.util.List;
import java.util.ArrayList;

 /*This is an apartment class which samplifies a real apartment*/
    
public class Apartment {
    private String name;    
    private List<String> rooms;
    private int bedrooms;
    private int bathrooms;
              
   Apartment (String name,int bedrooms, int bathrooms) {
        this.name = name;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        rooms = new ArrayList<String>();
        createRooms();
   }
    
   public void createRooms() {
        
       for (int i = 0; i < bedrooms; i++) {
           rooms.add("Bedroom" + i);
        }
        
       for (int i = 0; i < bathrooms; i++) {
           rooms.add("Bathroom" + i);
        }
        rooms.add("Livingroom0");
        rooms.add("Kitchen0");
   }

   public String getName() {
		return name;	
   }

   public List<String>getRooms () {
		return rooms;
    }	

}