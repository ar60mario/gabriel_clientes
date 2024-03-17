/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.frame;

import com.factura.entities.DatosFc;
import com.factura.entities.DatosFcRenglones;
import com.factura.structure.Constantes;
import com.factura.main.MainFrame;
import com.factura.util.DesktopApi;
import com.factura.util.PDFBuilder;
import com.factura.util.UtilFrame;
import com.itextpdf.text.DocumentException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author argia
 */
public class NuevaCompleta2Frame extends javax.swing.JFrame {

//    private DecimalFormat dfs = new DecimalFormat("0000");
//    private DecimalFormat dfn = new DecimalFormat("00000000");
//    private DecimalFormat dfc = new DecimalFormat("00000");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form NuevaCompletaFrame
     */
    public NuevaCompleta2Frame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        calcularBtn = new javax.swing.JButton();
        pdfBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        fechaTxt = new javax.swing.JTextField();
        nombreClienteTxt = new javax.swing.JTextField();
        domicilioTxt = new javax.swing.JTextField();
        cuitTxt = new javax.swing.JTextField();
        condicionTxt = new javax.swing.JTextField();
        agregarBtn = new javax.swing.JButton();
        borrarBtn = new javax.swing.JButton();
        totalTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("COMPLETAR DATOS PARA FACTURA EN PDF");

        jLabel6.setText("FECHA:");

        jLabel10.setText("RAZÓN SOCIAL CLIENTE:");

        jLabel11.setText("DOMICILIO CLIENTE:");

        jLabel12.setText("CUIT CLIENTE:");

        jLabel13.setText("CONDICIÓN FRENTE AL IVA:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTO/SERVICIO", "PRECIO"
            }
        ));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        jLabel14.setText("TOTAL:");

        calcularBtn.setText("CALCULAR");
        calcularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularBtnActionPerformed(evt);
            }
        });

        pdfBtn.setText("PDF");
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        nombreClienteTxt.setText("CLIENTE");
        nombreClienteTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreClienteTxtKeyPressed(evt);
            }
        });

        domicilioTxt.setText("DOMICILIO");
        domicilioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                domicilioTxtKeyPressed(evt);
            }
        });

        cuitTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuitTxt.setText("CUIT");
        cuitTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cuitTxtKeyPressed(evt);
            }
        });

        condicionTxt.setText("CONDICION");
        condicionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                condicionTxtKeyPressed(evt);
            }
        });

        agregarBtn.setText("AGREGAR LINEA");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });

        borrarBtn.setText("BORRAR LINEA");
        borrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarBtnActionPerformed(evt);
            }
        });

        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(domicilioTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                                                .addComponent(nombreClienteTxt))
                                            .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(condicionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pdfBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agregarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(borrarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(calcularBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nombreClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(domicilioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(condicionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(agregarBtn)
                    .addComponent(borrarBtn)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcularBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdfBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                nombreClienteTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaTxtKeyPressed

    private void nombreClienteTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreClienteTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!nombreClienteTxt.getText().isEmpty()) {
                domicilioTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_nombreClienteTxtKeyPressed

    private void domicilioTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_domicilioTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!domicilioTxt.getText().isEmpty()) {
                cuitTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_domicilioTxtKeyPressed

    private void condicionTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_condicionTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!condicionTxt.getText().isEmpty()) {
                agregarLinea();
                tabla.requestFocus();
            }
        }
    }//GEN-LAST:event_condicionTxtKeyPressed

    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed
        pdf();
    }//GEN-LAST:event_pdfBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        agregarLinea();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void borrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarBtnActionPerformed
        borrarLinea();
    }//GEN-LAST:event_borrarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void calcularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularBtnActionPerformed
        calcular();
    }//GEN-LAST:event_calcularBtnActionPerformed

    private void cuitTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuitTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!cuitTxt.getText().isEmpty()) {
                condicionTxt.requestFocus();
            } else {
                cuitTxt.setText("00-00000000-0");
                cuitTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_cuitTxtKeyPressed

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
            java.util.logging.Logger.getLogger(NuevaCompleta2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaCompleta2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaCompleta2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaCompleta2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaCompleta2Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JButton borrarBtn;
    private javax.swing.JButton calcularBtn;
    private javax.swing.JTextField condicionTxt;
    private javax.swing.JTextField cuitTxt;
    private javax.swing.JTextField domicilioTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreClienteTxt;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        fechaTxt.setText("");
        condicionTxt.setText("Consumidor Final");
        cuitTxt.setText("");
        domicilioTxt.setText(" Capital Federal - Ciudad de Buenos Aires");
        nombreClienteTxt.setText("Consorcio ");
        totalTxt.setText("");
        UtilFrame.limpiarTabla(tabla);
    }

    private void pdf() {
        if (validar()) {

            Random rnd = new Random();
            Double cae3 = rnd.nextDouble() * (99999);
            //más 10 días para fecha vencim cae
            Date fecha = new Date();
            try {
                fecha = sdf.parse(fechaTxt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(NuevaCompleta2Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            calendar.add(Calendar.DATE, 10);
            Date fecha2 = calendar.getTime();
            Double to = Double.valueOf(totalTxt.getText().replace(",", "."));
            Integer numFc = getNumeroFactura();
            DatosFc df = new DatosFc();
            df.setCae(cae3.intValue());
            df.setCliente(nombreClienteTxt.getText());
            df.setCondicion(condicionTxt.getText());
            df.setCuit(cuitTxt.getText());
            df.setDomicilio(domicilioTxt.getText());
            df.setFecha(fecha);
            df.setNumero(numFc);
            df.setTotal(to);
            df.setVencimCae(fecha2);
            List<DatosFcRenglones> dfr = new ArrayList<>();
            int rows = tabla.getRowCount();
            for (int i = 0; i < rows; i++) {
                DatosFcRenglones dfr1 = new DatosFcRenglones();
                dfr1.setDetalle(tabla.getValueAt(i, 0).toString());
                if (!tabla.getValueAt(i, 1).toString().isEmpty()) {
                    Double im = Double.valueOf(tabla.getValueAt(i, 1).toString().replace(",", "."));
                    dfr1.setImporte(im);
                } else {
                    dfr1.setImporte(0.0);
                }
                dfr.add(dfr1);
            }
            try {
                File fc = new PDFBuilder().armarFacturaC(df, dfr);
                DesktopApi.open(fc);
            } catch (DocumentException ex) {
                Logger.getLogger(NuevaCompleta2Frame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(NuevaCompleta2Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            volver();
        }
    }

    private void agregarLinea() {
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        Object o[] = new Object[2];
        o[0] = "";
        o[1] = "";
        tbl.addRow(o);
        tabla.setModel(tbl);
    }

    private void borrarLinea() {
        int row = tabla.getSelectedRow();
        int rows = tabla.getSelectedRowCount();
        if (rows > 1) {
            JOptionPane.showMessageDialog(this, "SOLO ELIMINA DE A UN RENGLON");
            return;
        }
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR LINEA A BORRAR");
            return;
        }
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        tbl.removeRow(row);
        tabla.setModel(tbl);
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void calcular() {
        Double total = 0.0;
        int rows = tabla.getRowCount();
        if (rows < 1) {
            JOptionPane.showMessageDialog(this, "NO TIENE RENGLONES LA FACTURA");
            return;
        }
        for (int i = 0; i < rows; i++) {
            int col = 1;
            int row = i;
            String valor = tabla.getValueAt(row, col).toString();
            if (!valor.isEmpty()) {
                Double importe = Double.valueOf(valor.replace(",", "."));
                total += importe;
            }
        }
        totalTxt.setText(df.format(total));
    }

    private boolean validar() {
        if (fechaTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ERROR EN FECHA");
            fechaTxt.requestFocus();
            return false;
        }
        if (nombreClienteTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "INGRESE UNA RAZON SOCIAL");
            nombreClienteTxt.requestFocus();
            return false;
        }
        if (domicilioTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "INGRESE UN DOMICILIO");
            domicilioTxt.requestFocus();
            return false;
        }
        int largoD = domicilioTxt.getText().length();

        if (largoD > 60) {
            int sobra1 = largoD - 60;
            JOptionPane.showMessageDialog(this, "RECORTE EL DOMICILIO EN " + sobra1);
            return false;
        }
        int rows = tabla.getRowCount();
        if (rows < 1) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR DETALLE DE LA FACTURA E IMPORTES");
            tabla.requestFocus();
            return false;
        }
        Boolean sigue = true;
        for (int i = 0; i < rows; i++) {

            if (tabla.getValueAt(i, 0).toString().isEmpty()) {
                int r = i + 1;
                JOptionPane.showMessageDialog(this, "RENGLON VACIO SIN TEXTO NRO: " + r);
                sigue = false;
            } else {
                int largo = tabla.getValueAt(i, 0).toString().length();
                if (largo > 37) {
                    int sobra = largo - 37;
                    JOptionPane.showMessageDialog(this, "RENGLON EXEDIDO EN LARGO " + sobra + "LIN: " + i);
                    sigue = false;
                }
            }
        }
        if (!sigue) {
            return false;
        }
        calcular();
        return true;
    }

    public Integer getNumeroFactura() {
        Integer num = 0;
        String ruta1 = "c:/ventasGa/temp/numero_fc.txt";
        File archivo1 = new File(ruta1);
        FileReader fr;
        try {
            fr = new FileReader(archivo1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        BufferedReader br = new BufferedReader(fr);
        String linea;
        try {
            linea = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        Integer nm = Integer.valueOf(linea);
        nm += 1;
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw1;
        try {
            bw1 = new BufferedWriter(new FileWriter(archivo1));
        } catch (IOException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        try {
            bw1.write(nm.toString());
        } catch (IOException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        try {
            bw1.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return nm;
    }
}
