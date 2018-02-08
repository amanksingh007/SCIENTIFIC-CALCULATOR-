import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author welcome
 */
public class conversion extends javax.swing.JFrame{
    /**
     * Creates new form conversion
     */
    public conversion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cb1 = new javax.swing.JComboBox<>();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        cb2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 0, 0));

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE", "meter", "centimeter", "kilometer", "mile", "farenheit", "kelvin", "celcius", "hour", "minute", "seconds", "milimeter", "feet", "inches", "kilogram", "gram", "miligram", "hectare", " " }));
        cb1.setToolTipText("choose your input unit");
        cb1.setAutoscrolls(true);

        t1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        t1.setToolTipText("enter your scalar");

        t2.setEditable(false);
        t2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        t2.setText(" ");

        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE", "meter", "centimeter", "kilometer", "mile", "farenheit", "kelvin", "celcius", "hour", "minute", "seconds", "milimeter", "feet", "inches", "kilogram", "gram", "miligram", "hectare", " " }));
        cb2.setToolTipText("choose your output unit");

        jButton1.setText(" RESULT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(" EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(" BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb1, 0, 133, Short.MAX_VALUE)
                            .addComponent(t1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton2)
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(t2)
                        .addComponent(cb2, 0, 134, Short.MAX_VALUE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t2)
                    .addComponent(t1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String in=t1.getText();
        String inunit = (cb1.getSelectedItem()).toString();
        String outunit=(cb2.getSelectedItem()).toString();
        System.out.println(inunit+" "+outunit);
        double val=Double.parseDouble(in);
        if(inunit.equals("meter") && outunit.equals("centimeter")){
          double res=val*100;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("meter") && outunit.equals("millimeter")){
          double res=val*1000;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("kilometer") && outunit.equals("meter")){
          double res=val*1000;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("meter") && outunit.equals("kilometer")){
          double res=val/1000;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("centimeter") && outunit.equals("meter")){
          double res=val/100;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("centimeter") && outunit.equals("kilometer")){
          double res=val/100000;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("feet") && outunit.equals("inches")){
          double res=val*12;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("inches") && outunit.equals("feet")){
          double res=val/12;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("meter") && outunit.equals("feet")){
          double res=val*3.28084;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("meter") && outunit.equals("inches")){
          double res=val*39.3701;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("feet") && outunit.equals("meter")){
          double res=val*0.3048;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("inches") && outunit.equals("meter")){
          double res=val*0.0254;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("inches") && outunit.equals("centimeter")){
          double res=val*0.0254*100;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("inches") && outunit.equals("millimeter")){
          double res=val*0.01*1000;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("mile") && outunit.equals("kilometer")){
          double res=val*1.60934;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("celcius") && outunit.equals("farenheit")){
          double res=val*9/5 + 32;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("celcius") && outunit.equals("kelvin")){
          double res=val+ 273.15;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("celcius") && outunit.equals("Rankine")){
          double res=(val + 273.15) * 9/5;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("Farenheit") && outunit.equals("celcius")){
          double res= (val - 32) * 5/9;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("Farenheit") && outunit.equals("kelvine")){
          double res=(val + 459.67)*5/9;
          t2.setText(""+res);
        }
        else
        if(inunit.equals("Farenheit") && outunit.equals("Rankine")){
          double res=(val + 459.67)*5/9;
          t2.setText(""+res);
        }
        else{
            JOptionPane.showMessageDialog(null,"WRONG SELECTION");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    new advance().setVisible(true);
    this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(conversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(conversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(conversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(conversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new conversion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}
