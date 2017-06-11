import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
*A building class that displays a GUI containing apartments. You can turn on/off the lights in any room
*of each apartment by clicking the corresponding botton for that room. The current status of the light 
*will be displayed in the text terminal.
*/
public class BuildingGUI2
{

    private JFrame frame;
    private List<Apartment> apartments;
    
    /**
     * Constructor for objects of class BuildingGUI
     */
    public BuildingGUI2()
    {
        apartments = createApartments();
        makeFrame(); 
    }

	public static void main(String []args) {
		BuildingGUI2 b = new BuildingGUI2();
	}

    /**
     * Create apartments and puts them into the building's apartment's list
     */
    private List<Apartment> createApartments() {
        List<Apartment> apartmentList = new ArrayList<Apartment>();
        apartmentList.add(new Apartment("Green Family",3,1));
        apartmentList.add(new Apartment("Smith Family",4,2));
        apartmentList.add(new Apartment("Braun Family",5,2));
        apartmentList.add(new Apartment("Gold Family",6,2));
        apartmentList.add(new Apartment("Silver Family",3,2));
        
        return apartmentList;
    }
    
    /**
     * Creates the frame for the building
     */
    private void makeFrame() {
	frame = new JFrame("Royal Building");
        makeButtons(frame);
        Container contentPane = frame.getContentPane();
        frame.pack();
        frame.setVisible(true);
	frame.setSize(600,450);
    }
    
    /**
     * Creates buttons representing a light switch for each room in each apartment.
     */
    private void makeButtons(JFrame frame){
        JPanel generalPanel = new JPanel();
        generalPanel.setLayout(new GridLayout());
        frame.setContentPane(generalPanel);
        JPanel jp;
        JButton button;
        
        for(final Apartment apartment: apartments) {  
            jp = new JPanel();
            jp.setLayout(new FlowLayout());
            JLabel jl = new JLabel(apartment.getName());
            jp.add(jl);
            Iterator<String> it = apartment.getRooms().iterator();
            while (it.hasNext()) {
                button = new JButton(it.next());
                button.addActionListener(new ActionListener() {
                    boolean on = false;
                    public void actionPerformed(ActionEvent e) {  
                            if(on == false) {
                            System.out.println("Light turned on for " + e.getActionCommand() +
                            " in the " + apartment.getName() + "'s apartment");
                            on = true;
                        }                        
                            else  if(on == true) {
                            System.out.println("Light turned off for " + e.getActionCommand() +
                            " in the " + apartment.getName() + "'s apartment");
                            on = false;
                        }
                    }
                });
                jp.add(button);
            }
            generalPanel.add(jp);
        }
               
        
    }
}
