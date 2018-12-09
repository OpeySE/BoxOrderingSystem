package flexbox;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 * @author GrC-5: UP847110, UP834942, UP861233, UP841221
 * @version 1.0
 * @since 02/12/2018
 */
public class UserInterface extends javax.swing.JFrame {

    public DefaultTableModel model;
    private final ArrayList<Box> boxArray;
    private final ArrayList<Integer> prevQty;
    private final double totalCost;
    private final ArrayList<Double> boxCost;

    //instance variables
    private double size;
    private int type;
    private int grade;
    private int quantity;
    private int colour;
    private boolean bottom;
    private boolean corner;
    private boolean sealable;
    private Double height;
    private Double length;
    private Double width;

    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
        model = (DefaultTableModel) jTable.getModel();

        //prevent the user from adding their own values into the table
        jTable.setDefaultEditor(Object.class, null);

        boxArray = new ArrayList<>();
        prevQty = new ArrayList<>();
        totalCost = 0;
        boxCost = new ArrayList<>();

        //center the text inside the total cost field
        totalTF.setHorizontalAlignment(JTextField.CENTER);

        //set the constraints
        ((SpinnerNumberModel) Grade.getModel()).setMaximum(5);
        ((SpinnerNumberModel) Grade.getModel()).setMinimum(0);
        ((SpinnerNumberModel) Quantity.getModel()).setMinimum(0);
    }

    /**
     * This method creates and adds the box to the box array list. It then also
     * calls the get cost method from the box superclass and adds the value of
     * that to the box cost array list
     *
     * @param type the type of the cardboard box being added
     * @param grade the grade of cardboard of the box being added
     * @param colour how many colours the cardboard box being added will have,
     * either 0,1 or 2
     * @param rb if the cardboard box being added will have reinforced bottom or
     * not
     * @param rc if the cardboard box being added will have reinforced corners
     * or not
     * @param sealableT if the cardboard box being added will have a sealable
     * top or not
     * @param width the width of the cardboard box being added
     * @param length the length of the cardboard box being added
     * @param height the height of the cardboard box being added
     * @param quantity how many of the current cardboard box being added does
     * the user wish to add
     */
    public void addType(Integer type, Integer grade, Integer colour, boolean rb, boolean rc,
            boolean sealableT, Double width, Double length, Double height, Integer quantity) {
        //convert these value from boxes to their values
        prevQty.add(quantity);

        for (int i = 0; i < quantity; i++) {
            //subclass in a super class of box
            if (type == 1) {
                boxArray.add(new BoxType1(grade, colour, bottom, corner, sealable, width, length, height, quantity));
                //get the last inserted value cost, which is the box we just created
                boxCost.add(boxArray.get(boxArray.size() - 1).getCost());
            } else if (type == 2) {
                boxArray.add(new BoxType2(grade, colour, bottom, corner, sealable, width, length, height, quantity));
                //get the last inserted value cost, which is the box we just created
                boxCost.add(boxArray.get(boxArray.size() - 1).getCost());
            } else if (type == 3) {
                boxArray.add(new BoxType3(grade, colour, bottom, corner, sealable, width, length, height, quantity));
                //get the last inserted value cost, which is the box we just created
                boxCost.add(boxArray.get(boxArray.size() - 1).getCost());
            } else if (type == 4) {
                boxArray.add(new BoxType4(grade, colour, bottom, corner, sealable, width, length, height, quantity));
                //get the last inserted value cost, which is the box we just created
                boxCost.add(boxArray.get(boxArray.size() - 1).getCost());
            } else if (type == 5) {
                boxArray.add(new BoxType5(grade, colour, bottom, corner, sealable, width, length, height, quantity));
                //get the last inserted value cost, which is the box we just created
                boxCost.add(boxArray.get(boxArray.size() - 1).getCost());
            }
        }
        getCostOfBoxes(boxArray);
    }

    /**
     * Calculates the total cost of all the boxes within the box cost array list
     *
     * @param list takes the boxArray array list as a parameter
     */
    public void getCostOfBoxes(ArrayList list) {
        //iterate through the cost array and get the total cost
        double boxArrayCost = 0;
        for (int i = 0; i < boxArray.size(); i++) {
            boxArrayCost += boxCost.get(i);
        }

        boxArrayCost = (double) (Math.round(boxArrayCost * 100)) / 100;
        String cost = "£" + boxArrayCost;
        totalTF.setText(cost);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        Width = new javax.swing.JTextField();
        Length = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Quantity = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ReinforcedBottoms = new javax.swing.JCheckBox();
        ReinforcedCorners = new javax.swing.JCheckBox();
        SealableTop = new javax.swing.JCheckBox();
        Remove = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        totalTF = new javax.swing.JTextField();
        Colour = new javax.swing.JComboBox<>();
        Grade = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        deleteSelectedBox = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Height:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Length:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Width:");

        Height.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeightActionPerformed(evt);
            }
        });

        Width.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Width.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WidthActionPerformed(evt);
            }
        });

        Length.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Length.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LengthActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Grade:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Reinforced Bottoms:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Reinforced Corners:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sealable Top:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Number of Colours:");

        ReinforcedBottoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReinforcedBottomsActionPerformed(evt);
            }
        });

        Remove.setBackground(new java.awt.Color(255, 255, 0));
        Remove.setText("REMOVE LAST ORDERED");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(255, 153, 153));
        Clear.setText("DELETE ALL ORDERED");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Total Cost");

        totalTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTFActionPerformed(evt);
            }
        });

        Colour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        Colour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColourActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grade", "NumOfColours", "Reinforced Bottom", "Reinforced Corner", "Sealable Top", "Width", "Length", "Height", "Quantity", "Box Cost"
            }
        ));
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FlexBox Ordering System");

        Add.setBackground(new java.awt.Color(0, 255, 0));
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(153, 204, 255));
        removeButton.setText("RESET INPUTS");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        deleteSelectedBox.setBackground(new java.awt.Color(255, 153, 0));
        deleteSelectedBox.setText("DELETE ONE SELECTED INPUT");
        deleteSelectedBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Length, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Width, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ReinforcedBottoms)
                                    .addComponent(ReinforcedCorners, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Colour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SealableTop))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(Remove, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteSelectedBox, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(503, 503, 503))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Length, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ReinforcedBottoms)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(SealableTop))
                                .addGap(1, 1, 1)))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(Width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(ReinforcedCorners))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(1, 1, 1)))
                            .addComponent(Colour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Add)
                        .addGap(6, 6, 6)
                        .addComponent(Remove)
                        .addGap(8, 8, 8)
                        .addComponent(deleteSelectedBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Clear)
                        .addGap(40, 40, 40)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeightActionPerformed

    private void WidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WidthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WidthActionPerformed

    private void LengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LengthActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        int numOfRows = model.getRowCount();
        boolean run = true;
        try {
            model.removeRow(numOfRows - 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There is no box to remove");
            run = false;
        }

        if (run) {
            //method to get the last inserted quantity
            int lastInsertedQty = prevQty.size() - 1;
            lastInsertedQty = prevQty.get(lastInsertedQty);

            //minus by 1 because array starts at 0
            int arraySize = boxArray.size();
            arraySize--;
            for (int i = 0; i < lastInsertedQty; i++) {
                //remove cost from boxCost and the box from the boxArray
                boxCost.remove(arraySize - i);
                boxArray.remove(arraySize - i);
            }

            //remove the last element inserted
            int removeLastInsertBox = prevQty.size() - 1;
            prevQty.remove(removeLastInsertBox);
            getCostOfBoxes(boxArray);
        }
    }//GEN-LAST:event_RemoveActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        int numOfRows = model.getRowCount();
        boolean run = true;
        try {
            model.removeRow(numOfRows - 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There is no box to delete");
            run = false;
        }

        if (run) {
            //remove all boxes from the model
            for (int i = 0; i < numOfRows - 1; i++) {
                model.removeRow(0);
            }
            //reset the array and the cost
            int numPrevQty = prevQty.size();
            for (int i = 0; i < numPrevQty; i++) {
                prevQty.remove(0);
            }

            int boxCostSize = boxCost.size();
            for (int i = 0; i < boxCostSize; i++) {
                boxArray.remove(0);
                boxCost.remove(0);
            }

            totalTF.setText("£0.00");
        }
    }//GEN-LAST:event_ClearActionPerformed

    private void totalTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTFActionPerformed

    private void ReinforcedBottomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReinforcedBottomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReinforcedBottomsActionPerformed

    private void ColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColourActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        //this will filter the user inputs
        type = -19;
        boolean run = true;

        try {
            //spinner, combo box(colour) & check box
            grade = (int) Grade.getValue();
            quantity = (int) Quantity.getValue();
            colour = Colour.getSelectedIndex();
            bottom = ReinforcedBottoms.isSelected();
            corner = ReinforcedCorners.isSelected();
            sealable = SealableTop.isSelected();
            //text field
            height = Double.parseDouble(Height.getText());
            length = Double.parseDouble(Length.getText());
            width = Double.parseDouble(Width.getText());

            if (height > 5 || height < 0.25) {
                JOptionPane.showMessageDialog(this, "Height must be less than 5 meters and greater than 0.25 meters",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                run = false;
            } else if (length > 5 || length < 0.25) {
                JOptionPane.showMessageDialog(this, "Length must be less than 5 meters and greater than 0.25 meters",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                run = false;
            } else if (width > 5 || width < 0.25) {
                JOptionPane.showMessageDialog(this, "Width must be less than 5 meters and greater than 0.25 meters",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                run = false;
            } else if (width == 0 || length == 0 || height == 0) {
                JOptionPane.showMessageDialog(this, "Height, length and width must be greater than 0",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                run = false;
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please fill out the height, length and width with positive numbers",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            run = false;
        }

        if (run) {
            try {
                //filter the inputs and determine the type
                if (grade == 0) {
                    JOptionPane.showMessageDialog(this, "Grade should be greater than 0",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else if (quantity == 0) {
                    JOptionPane.showMessageDialog(this, "Quantity should be greater than 0",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }

                if (grade == 1) {
                    if (colour == 0 && bottom == false && corner == false) {
                        type = 1;
                    } else {
                        JOptionPane.showMessageDialog(this, "Grade 1 must have: 0 colours, no reinforced bottom and no reinforced corner",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }

                if (grade == 2) {
                    if (colour == 0 && bottom == false && corner == false) {
                        type = 1;
                    } else if (colour == 1 && bottom == false && corner == false) {
                        type = 2;
                    } else if (colour == 2 && bottom == false && corner == false) {
                        type = 3;
                    } else if (colour == 2 && bottom == true && corner == false) {
                        type = 4;
                    } else if (colour == 0 && (corner == true || bottom == true)) {
                        JOptionPane.showMessageDialog(this, "Grade 2 with colour 0 can not have: reinforced bottom or reinforced corner",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } else if (colour == 1 && (corner == true || bottom == true)) {
                        JOptionPane.showMessageDialog(this, "Grade 2 with colour 1 can not have: reinforced bottom or reinforced corner",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } else if (colour == 2 && corner == true) {
                        JOptionPane.showMessageDialog(this, "Grade 2 with colour 2 can not have: reinforced corners",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }

                if (grade == 3) {
                    if (colour == 0 && bottom == false && corner == false) {
                        type = 1;
                    } else if (colour == 1 && bottom == false && corner == false) {
                        type = 2;
                    } else if (colour == 2 && bottom == false && corner == false) {
                        type = 3;
                    } else if (colour == 2 && bottom == true && corner == false) {
                        type = 4;
                    } else if (colour == 2 && bottom == true && corner == true) {
                        type = 5;
                    } else if (colour == 0 && (corner == true || bottom == true)) {
                        JOptionPane.showMessageDialog(this, "Grade 3 with colour 0 must have: no reinforced bottom and no reinforced corner",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } else if (colour == 1 && (corner == true || bottom == true)) {
                        JOptionPane.showMessageDialog(this, "Grade 3 with colour 1 must have: no reinforced bottom and no reinforced corner",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } else if (colour == 2 && bottom == false && corner == true) {
                        JOptionPane.showMessageDialog(this, "Grade 3 with colour 2 can not have reinforced corner without reinforced bottoms.",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }

                }

                if (grade == 4) {
                    if (colour == 1 && bottom == false && corner == false) {
                        type = 2;
                    } else if (colour == 2 && bottom == false && corner == false) {
                        type = 3;
                    } else if (colour == 2 && bottom == true && corner == false) {
                        type = 4;
                    } else if (colour == 2 && bottom == true && corner == true) {
                        type = 5;
                    } else if (colour == 0) {
                        JOptionPane.showMessageDialog(this, "Grade 4 can not have colour 0",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } else if (colour == 1 && (corner == true || bottom == true)) {
                        JOptionPane.showMessageDialog(this, "Grade 4 with colour 1 must have: no reinforced bottom and no reinforced corner",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } else if (colour == 2 && bottom == false && corner == true) {
                        JOptionPane.showMessageDialog(this, "Grade 4 with colour 2 can not have reinforced corner without reinforced bottoms.",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }

                if (grade == 5) {
                    if (colour != 2) {
                        JOptionPane.showMessageDialog(this, "Grade 5 must have: 2 colours",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } else if (colour == 2 && bottom == false && corner == false) {
                        type = 3;
                    } else if (colour == 2 && bottom == true && corner == false) {
                        type = 4;
                    } else if (colour == 2 && bottom == true && corner == true) {
                        type = 5;
                    } else if (colour == 2 && bottom == false && corner == true) {
                        JOptionPane.showMessageDialog(this, "Grade 5 with colour 2 can not have reinforced corner without reinforced bottoms.",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (type != -19 && quantity > 0) {
            //add the new box to the array
            addType(type, grade, colour, bottom, corner, sealable, width, length, height, quantity);
            Double addedBoxCost = (boxArray.get(boxArray.size() - 1).getCost()) * quantity;
            addedBoxCost = (double) (Math.round(addedBoxCost * 100)) / 100;

            //add the inputs into the table
            model.addRow(new Object[]{
                grade,
                colour,
                bottom,
                corner,
                sealable,
                width,
                length,
                height,
                quantity,
                addedBoxCost
            });
        }

    }//GEN-LAST:event_AddActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        //spinner
        Grade.setValue(0);
        Quantity.setValue(0);

        //combo box(colour)
        Colour.setSelectedIndex(0);

        //check box
        ReinforcedBottoms.setSelected(false);
        ReinforcedCorners.setSelected(false);
        SealableTop.setSelected(false);

        //text field        
        Height.setText(" ");
        Length.setText(" ");
        Width.setText(" ");
    }//GEN-LAST:event_removeButtonActionPerformed

    private void deleteSelectedBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedBoxActionPerformed
        int SelectedRowIndex = -19;
        boolean run = true;

        //delete a selected input
        try {
            //check to see if the selected value is smaller than the number of rows
            //SelectedRowIndex starts from 0
            SelectedRowIndex = jTable.getSelectedRow();
            model.removeRow(SelectedRowIndex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "You have not selected a box to remove");
            run = false;
        }

        //check there is a box selected to be removed
        if (run && SelectedRowIndex != -19) {
            //get the quantity of the value selected
            int qty = prevQty.get(SelectedRowIndex);

            //remove the box and cost in the correct position
            if (SelectedRowIndex > 0) {
                int startRemove = 0;
                //this gets the quantity order by the box selected
                prevQty.get(SelectedRowIndex);

                //this adds all the values before you get to the actual quantity
                for (int i = 0; i < SelectedRowIndex; i++) {
                    //since it is counting it will start from 1
                    startRemove += prevQty.get(i);
                }

                //starts removal position
                for (int i = 0; i < qty; i++) {
                    //remove cost from boxCost
                    boxCost.remove(startRemove);
                    //remove the oop box
                    boxArray.remove(startRemove);
                }
            }

            if (SelectedRowIndex == 0) {
                for (int i = 0; i < qty; i++) {
                    //remove cost from boxCost
                    boxCost.remove(SelectedRowIndex);
                    //remove the oop box
                    boxArray.remove(SelectedRowIndex);
                }
            }

            prevQty.remove(SelectedRowIndex);
            getCostOfBoxes(boxArray);
        }

    }//GEN-LAST:event_deleteSelectedBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Clear;
    private javax.swing.JComboBox<String> Colour;
    private javax.swing.JSpinner Grade;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField Length;
    private javax.swing.JSpinner Quantity;
    private javax.swing.JCheckBox ReinforcedBottoms;
    private javax.swing.JCheckBox ReinforcedCorners;
    private javax.swing.JButton Remove;
    private javax.swing.JCheckBox SealableTop;
    private javax.swing.JTextField Width;
    private javax.swing.JButton deleteSelectedBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField totalTF;
    // End of variables declaration//GEN-END:variables
}
