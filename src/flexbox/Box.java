package flexbox;

/**
 * @author GrC-5: UP847110, UP834942, UP861233, UP841221
 * @version 1.0
 * @since 02/12/2018
 */
public abstract class Box {

    public int Grade;
    public int NumOfCol;
    public boolean RB;
    public boolean RC;
    public boolean SealableTop;
    public double Width;
    public double Length;
    public double Height;
    public int Quantity;
    public double gradeCost;
    
    /**
     * Constructor for Box.
     * @param grade the grade of cardboard of the box
     * @param numCol how many colours the box will have
     * @param rb if the cardboard box will have reinforced bottom or not
     * @param rc if the cardboard box will have reinforced corners or not
     * @param sealableT if the cardboard box being added will have a sealable top or not
     * @param width the width of the cardboard box being added
     * @param length the length of the cardboard box being added
     * @param height the height of the cardboard box being added
     * @param quantity how many of the current cardboard box being added does the user wish to add
     */
    public Box(Integer grade, Integer numCol, boolean rb, boolean rc,
            boolean sealableT, Double width, Double length, Double height, Integer quantity) {

        Grade = grade;
        NumOfCol = numCol;
        RB = rb;
        RC = rc;
        SealableTop = sealableT;
        Width = width;
        Length = length;
        Height = height;
        Quantity = quantity;
    }
 
    /**
     * accessors method to get the quantity of the box to find out how many of this box exists
     * @return the quantity of the box
     */
    public int getQuantity() {
        return Quantity;
    }
    
    /**
     * Accessors method to calculate the cost which all subclasses inherit
     * @return the final cost of the box
     */
    public double getCost() {
        //calculate the area of the faces (allFacesSize)
        double allFacesSize;
        allFacesSize = ((Length * Height) + (Length * Width) + (Width * Height)) * 2;
        
        if (Grade == 1) {
            gradeCost = allFacesSize * 0.55;
        } else if (Grade == 2) {
            gradeCost = allFacesSize * 0.65;
        } else if (Grade == 3) {
            gradeCost = allFacesSize * 0.82;
        } else if (Grade == 4) {
            gradeCost = allFacesSize * 0.98;
        } else if (Grade == 5) {
            gradeCost = allFacesSize * 1.5;
        }
        
        double finalCost = getExtraCost(gradeCost);
        return finalCost;
    }
     /**
     * Method calculates the extra cost involved 
     * @param gradeCost the extra cost calculated by the subclass
     * @return value for this is parsed into the getCost method
     */
    //all boxes have extra cost, but each extra cost would vary
    public abstract double getExtraCost(double gradeCost);
}