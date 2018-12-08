package flexbox;

/**
 * @author GrC-5: UP847110, UP834942, UP861233, UP841221
 * @version 1.0
 * @since 02/12/2018
 */
public class Main {
    /**
     * @param args the command line arguments
     * Main method initialises the the JFrame user interface 
     */
    public static void main(String[] args) {
        //intialise the user interface class which is the JFrame
        UserInterface flexBox = new UserInterface();
        flexBox.setResizable(false);
        flexBox.setVisible(true);        
    }   
}