
import cpit380practice.Picture;
import java.awt.Image;
import javax.swing.ImageIcon;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mjed
 */
public class CustomHistogramView extends javax.swing.JPanel {

    /**
     * Creates new form CustomHistogramView
     */
    public CustomHistogramView(String name, Picture pic) {
        initComponents();
        this.setName(name);
        Image img = (pic.getImage()).getScaledInstance(512, 512, Image.SCALE_SMOOTH);
        imgLabel.setIcon(new ImageIcon(img));
        nameLabel.setText("Histogram for: " + name);
        this.setVisible(true);
        this.show();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();

        imgLabel.setText("T");
        imgLabel.setMaximumSize(new java.awt.Dimension(512, 512));
        imgLabel.setMinimumSize(new java.awt.Dimension(512, 512));
        imgLabel.setPreferredSize(new java.awt.Dimension(512, 512));

        nameLabel.setText("Histogram for: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(nameLabel)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nameLabel)
                .addGap(18, 18, 18)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}