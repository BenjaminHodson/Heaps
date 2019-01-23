/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheOr
 */
public class Main extends javax.swing.JFrame {

    FileReader file;
    BufferedReader br;
    static PrintWriter writer;
    static ArrayList<String> cmd = new ArrayList<>();

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    public static BinomialHeap buildBinomialHeap(String name, int pos) {
        BinomialHeap h = new BinomialHeap(name.toUpperCase());
        pos++;
        for (int i = pos; i < cmd.size(); i++) {

            if (cmd.get(i).contains("ins")) {
                h.insert(Integer.parseInt(cmd.get(i).substring(4)));
            }
            if (cmd.get(i).contains("rem")) {
                h.extractMin();
            }
            if (cmd.get(i).contains("print")) {
                //when a 'print' String is seen. access HashMap ,'bhList', by heap name(ex. 'A', 'B', 'C') to return a BinaryHeap object and use its printHeap() function
                String grabHeapName = cmd.get(i).substring(6).toUpperCase();
                if (BinomialHeap.BinHeapList.get(grabHeapName) == null) {
                    writer.println();
                    writer.println();
                    writer.println("Heap " + grabHeapName + " not Found!");
                    writer.println();
                } else {
                    BinomialHeap.BinHeapList.get(grabHeapName.toUpperCase()).printHeap();
                }
            }
            if (cmd.get(i).contains("sort")) {
                h.sort(Integer.parseInt(cmd.get(i).substring(5)));
            }
            if (cmd.get(i).contains("heap")) {
                //recursively builds heaps. Add as many as you want to the text file
                buildBinomialHeap(cmd.get(i).substring(5), i);
                break;
            }

            if (cmd.get(i).contains("merge")) {
                String grabBinomial[] = cmd.get(i).substring(5).split(",");
                for (String s : grabBinomial) {
                    System.out.println(s.substring(1));
                }
                String grabFirst = grabBinomial[0].substring(1).toUpperCase();
                BinomialHeap getHeap1 = BinomialHeap.BinHeapList.get(grabFirst);
                String grabSecond = grabBinomial[1].substring(1).toUpperCase();
                BinomialHeap getHeap2 = BinomialHeap.BinHeapList.get(grabSecond);
                String grabThird = grabBinomial[2].substring(1).toUpperCase();
                while (getHeap1.Nodes != null) {
                     getHeap1.merge(getHeap2.Nodes.sibling);
                     getHeap1.merge(getHeap2.Nodes.child);
                }
                
                getHeap1.printHeap();
                
            }

        }

        return h;
    }

    public static BinaryHeap buildBinaryHeap(String name, int pos) {   //recursively builds heaps and performs heap functions 
        BinaryHeap h = new BinaryHeap(40, name.toUpperCase());
        pos++;
        for (int i = pos; i < cmd.size(); i++) {

            if (cmd.get(i).contains("ins")) {
                h.insert(Integer.parseInt(cmd.get(i).substring(4)));
            }
            if (cmd.get(i).contains("rem")) {
                h.deleteTop();
            }
            if (cmd.get(i).contains("print")) {
                //when a 'print' String is seen. access HashMap ,'bhList', by heap name(ex. 'A', 'B', 'C') to return a BinaryHeap object and use its printHeap() function
                String grabHeapName = cmd.get(i).substring(6).toUpperCase();
                if (BinaryHeap.bhList.get(grabHeapName) == null) {
                    writer.println("Heap " + grabHeapName + " not Found!");
                    writer.println();
                } else {
                    BinaryHeap.bhList.get(grabHeapName.toUpperCase()).printHeap();
                }
            }
            if (cmd.get(i).contains("sort")) {
                h.sort(Integer.parseInt(cmd.get(i).substring(5)));
            }
            if (cmd.get(i).contains("heap")) {
                //recursively builds heaps. Add as many as you want to the text file
                buildBinaryHeap(cmd.get(i).substring(5), i);
                break;
            }

            if (cmd.get(i).contains("merge")) {
                String grabBinary[] = cmd.get(i).substring(5).split(",");
                for (String s : grabBinary) {
                    System.out.println(s.substring(1));
                }
                String grabFirst = grabBinary[0].substring(1).toUpperCase();
                String grabSecond = grabBinary[1].substring(1).toUpperCase();
                String grabThird = grabBinary[2].substring(1).toUpperCase();
                BinaryHeap.merge(BinaryHeap.bhList.get(grabFirst), BinaryHeap.bhList.get(grabSecond), BinaryHeap.bhList.get(grabThird)).printHeap();
            }

        }

        return h;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fChooserActionPerformed
        File f = fChooser.getSelectedFile().getAbsoluteFile();
        try {
            file = new FileReader(f);
            br = new BufferedReader(file);
            writer = new PrintWriter("Brady.txt");
            String line;
            while ((line = br.readLine()) != null) {
                cmd.add(line.toLowerCase());
            }

            //checks the type of heap(MIN/MAX), then calls buildHeap() to begin recursively building heaps as necessary. ***this method is found above***
            if ("binary".equals(cmd.get(0)) && "min".equals(cmd.get(1))) {
                buildBinaryHeap(cmd.get(2).substring(5), 2);
            }

            if ("binary".equals(cmd.get(0)) && "max".equals(cmd.get(1))) {
                buildBinaryHeap(cmd.get(2).substring(5), 2);
            }

            if ("binomial".equals(cmd.get(0)) && "min".equals(cmd.get(1))) {
                buildBinomialHeap(cmd.get(2).substring(5), 2);
            }

        } catch (Exception e) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, e);
        }

        writer.close();


    }//GEN-LAST:event_fChooserActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fChooser;
    // End of variables declaration//GEN-END:variables
}
