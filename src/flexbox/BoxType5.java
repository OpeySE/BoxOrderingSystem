package flexbox;

/**
 * @author GrC-5: UP847110, UP834942, UP861233, UP841221
 * @version 1.0
 * @since 02/12/2018
 */
public class BoxType5 extends Box {
/** Constructor
 * @param grade the grade of cardboard of the box
 * @param numCol how many colours the box will have
 * @param rb if the cardboard box will have reinforced bottom or not
 * @param rc if the cardboard box will have reinforced corners or not
 * @param sealableT if the cardboard box will have a sealable top or not
 * @param width the width of the cardboard box
 * @param length the length of the cardboard box
 * @param height the height of the cardboard box
 * @param quantity how many of the current cardboard box there will be
 */
    public BoxType5(Integer grade, Integer  numCol, boolean rb, boolean rc, 
            boolean sealableT, Double width, Double length, Double height, Integer quantity) {
        super(grade, numCol, rb, rc, sealableT, width, length, height, quantity);
    }

    @Override
    
     /**
     * Method calculates the extra cost involved 
     */
    public double getExtraCost(double gradeCost) {
        double extraCost = 0;
        
        if(super.NumOfCol == 1){
            extraCost += (gradeCost * 0.12);
        } 
        if(super.NumOfCol == 2){
            extraCost += (gradeCost * 0.15);
        }
        if(super.RB == true){
            extraCost += (gradeCost * 0.13);
        } if(super.RC == true){
            extraCost += (gradeCost * 0.12);
        } if(super.SealableTop == true){
            extraCost += (gradeCost * 0.1);
        }
        
        gradeCost = gradeCost + extraCost;
        
        //round to 3 dp then 2 dp to get the precise amount
        gradeCost = (double) (Math.round(gradeCost*100))/100;
        
        return gradeCost;
    }
}