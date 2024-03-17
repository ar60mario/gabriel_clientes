/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.util;

import com.itextpdf.text.DocumentException;
import com.factura.entities.DatosFc;
import com.factura.entities.DatosFcRenglones;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author argia
 */
public class PDFBuilder {

    private DecimalFormat dfs = new DecimalFormat("0000");
    private DecimalFormat dfn = new DecimalFormat("00000000");
    private DecimalFormat dfc = new DecimalFormat("00000");
    private DecimalFormat df_n = new DecimalFormat("#0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final BaseColor FONDO_BLANCO = WebColors.getRGBColor("#FFFFFF");
    private final BaseColor NEGRO = WebColors.getRGBColor("#000000");
//    private final BaseColor GRIS = WebColors.getRGBColor("#2F4F4F");
    private final int BOLD = Font.BOLD;
    private final int PLAIN = Font.PLAIN;

    public File armarFacturaC(DatosFc df, List<DatosFcRenglones> renglones)
            throws FileNotFoundException, DocumentException, Exception {
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 1241, (float) 1756);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 10, 10, 10);
        pdf.setMarginMirroringTopBottom(true);
        String archPdf = "c:/ventasGa/data/facturas/fc_C_"
                + df.getCuit()
                + "_" + dfn.format(df.getNumero())
                + ".pdf";
        FileOutputStream ficheroPdf = new FileOutputStream(archPdf);
        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);
        pdf.open();
        PdfPTable encabe = new PdfPTable(2);
        encabe.setWidthPercentage(100);

        float[] anchos = new float[2];
        anchos[0] = 57;
        anchos[1] = 43;
        encabe.setWidths(anchos);
        String nroFc = "Punto de Venta: " + dfs.format(7) + " Comp.Nro: " + dfn.format(df.getNumero());
        String fechaEmi = "Fecha de Emisión: " + sdf.format(df.getFecha());
        String fechasServicio = sdf.format(df.getFecha());
        for (int i = 0; i < 10; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        }
        PdfPCell encab1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, BOLD, NEGRO)));
        PdfPCell encab2 = new PdfPCell(new Paragraph(nroFc, FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell encab3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, BOLD, NEGRO)));
        PdfPCell encab4 = new PdfPCell(new Paragraph(fechaEmi, FontFactory.getFont("arial", 22, BOLD, NEGRO)));
//        PdfPCell encab1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, BOLD, NEGRO)));
//        PdfPCell encab2 = new PdfPCell(new Paragraph(nroFc, FontFactory.getFont("arial", 11, BOLD, NEGRO)));
//        PdfPCell encab3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, BOLD, NEGRO)));
//        PdfPCell encab4 = new PdfPCell(new Paragraph(fechaEmi, FontFactory.getFont("arial", 11, BOLD, NEGRO)));
        encab1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encab2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encab3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encab4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encabe.addCell(encab1).setBorder(PdfPCell.NO_BORDER);
        encabe.addCell(encab2).setBorder(PdfPCell.NO_BORDER);
        encabe.addCell(encab3).setBorder(PdfPCell.NO_BORDER);
        encabe.addCell(encab4).setBorder(PdfPCell.NO_BORDER);
        pdf.add(encabe);
//        pieCaeFc.addCell(pieCaeFc6).setBorder(PdfPCell.NO_BORDER);
//        pieCaeFc.addCell(pieCaeFc7).setBorder(PdfPCell.NO_BORDER);
//        pieCaeFc.addCell(pieCaeFc8).setBorder(PdfPCell.NO_BORDER);
//        pieCaeFc.addCell(pieCaeFc9).setBorder(PdfPCell.NO_BORDER);
        for (int i = 0; i < 7; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 11, PLAIN, FONDO_BLANCO)));
        }

        PdfPTable encabe2 = new PdfPTable(4);
        encabe2.setWidthPercentage(100);
        float[] anchos2 = new float[4];
        anchos2[0] = 35;
        anchos2[1] = 36;
        anchos2[2] = 26;
        anchos2[3] = 3;
        encabe2.setWidths(anchos2);
        PdfPCell enca1 = new PdfPCell(new Paragraph(fechasServicio, FontFactory.getFont("arial", 22, PLAIN, NEGRO)));
        PdfPCell enca2 = new PdfPCell(new Paragraph(fechasServicio, FontFactory.getFont("arial", 22, PLAIN, NEGRO)));
        PdfPCell enca3 = new PdfPCell(new Paragraph(fechasServicio, FontFactory.getFont("arial", 22, PLAIN, NEGRO)));
        PdfPCell enca4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, PLAIN, NEGRO)));
        enca1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        enca2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        enca3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        enca4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        encabe2.addCell(enca1).setBorder(PdfPCell.NO_BORDER);
        encabe2.addCell(enca2).setBorder(PdfPCell.NO_BORDER);
        encabe2.addCell(enca3).setBorder(PdfPCell.NO_BORDER);
        encabe2.addCell(enca4).setBorder(PdfPCell.NO_BORDER);
        pdf.add(encabe2);

//        for(int i = 0; i < 4;i++){
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 10, PLAIN, FONDO_BLANCO)));
//        }
        PdfPTable encabe3 = new PdfPTable(4);
        encabe3.setWidthPercentage(100);
        float[] anchos3 = new float[4];
        anchos3[0] = 10;
        anchos3[1] = 20;
        anchos3[2] = 30;
        anchos3[3] = 40;
        encabe3.setWidths(anchos3);
        PdfPCell enca3_1 = new PdfPCell(new Paragraph("     CUIT:", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell enca3_2 = new PdfPCell(new Paragraph(df.getCuit(), FontFactory.getFont("arial", 22, PLAIN, NEGRO)));
        PdfPCell enca3_3 = new PdfPCell(new Paragraph(" Apellido y Nombre/Razón Social:", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell enca3_4 = new PdfPCell(new Paragraph(df.getCliente(), FontFactory.getFont("arial", 22, PLAIN, NEGRO)));
        enca3_1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca3_2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca3_3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca3_4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encabe3.addCell(enca3_1).setBorder(PdfPCell.NO_BORDER);
        encabe3.addCell(enca3_2).setBorder(PdfPCell.NO_BORDER);
        encabe3.addCell(enca3_3).setBorder(PdfPCell.NO_BORDER);
        encabe3.addCell(enca3_4).setBorder(PdfPCell.NO_BORDER);
        pdf.add(encabe3);

        PdfPTable encabe4 = new PdfPTable(4);
        encabe4.setWidthPercentage(100);
        float[] anchos4 = new float[4];
        anchos4[0] = 25;
        anchos4[1] = 16;
        anchos4[2] = 10;
        anchos4[3] = 49;
        encabe4.setWidths(anchos4);
        PdfPCell enca4_1 = new PdfPCell(new Paragraph("     Condición frente al IVA:", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell enca4_2 = new PdfPCell(new Paragraph(df.getCondicion(), FontFactory.getFont("arial", 22, PLAIN, NEGRO)));
        PdfPCell enca4_3 = new PdfPCell(new Paragraph("Domicilio:", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell enca4_4 = new PdfPCell(new Paragraph(df.getDomicilio(), FontFactory.getFont("arial", 22, PLAIN, NEGRO)));
        enca4_1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca4_2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca4_3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca4_4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encabe4.addCell(enca4_1).setBorder(PdfPCell.NO_BORDER);
        encabe4.addCell(enca4_2).setBorder(PdfPCell.NO_BORDER);
        encabe4.addCell(enca4_3).setBorder(PdfPCell.NO_BORDER);
        encabe4.addCell(enca4_4).setBorder(PdfPCell.NO_BORDER);
        pdf.add(encabe4);

        PdfPTable encabe5 = new PdfPTable(4);
        encabe5.setWidthPercentage(100);
        float[] anchos5 = new float[4];
        anchos5[0] = 23;
        anchos5[1] = 17;
        anchos5[2] = 9;
        anchos5[3] = 51;
        encabe5.setWidths(anchos5);
        PdfPCell enca5_1 = new PdfPCell(new Paragraph("     Condición de venta:", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell enca5_2 = new PdfPCell(new Paragraph("Contado", FontFactory.getFont("arial", 22, PLAIN, NEGRO)));
        PdfPCell enca5_3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, BOLD, NEGRO)));
        PdfPCell enca5_4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, PLAIN, NEGRO)));
        enca5_1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca5_2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca5_3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        enca5_4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        encabe5.addCell(enca5_1).setBorder(PdfPCell.NO_BORDER);
        encabe5.addCell(enca5_2).setBorder(PdfPCell.NO_BORDER);
        encabe5.addCell(enca5_3).setBorder(PdfPCell.NO_BORDER);
        encabe5.addCell(enca5_4).setBorder(PdfPCell.NO_BORDER);
        pdf.add(encabe5);

        for (int i = 0; i < 5; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 10, PLAIN, FONDO_BLANCO)));
        }
        for (DatosFcRenglones dfr : renglones) {
            PdfPTable detalle = new PdfPTable(9);
            detalle.setWidthPercentage(100);
            float[] anchosD = new float[9];
            anchosD[0] = 9;
            anchosD[1] = 27;
            anchosD[2] = 8;
            anchosD[3] = 8;
            anchosD[4] = 13;
            anchosD[5] = 4;
            anchosD[6] = 14;
            anchosD[7] = 15;
            anchosD[8] = 2;
            detalle.setWidths(anchosD);

            String str1 = dfr.getDetalle();
            Double dou1 = dfr.getImporte();
            String str2;
            String str3;
            String str4;
            String str5;
            if (dou1 > 0.00) {
                str2 = df_n.format(dou1);
                str3 = "1.00";
                str4 = "unidades";
                str5 = "0.00";
            } else {
                str2 = " ";
                str3 = " ";
                str4 = " ";
                str5 = " ";
            }
            PdfPCell deta1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 18, BOLD, NEGRO)));
            PdfPCell deta2 = new PdfPCell(new Paragraph(str1, FontFactory.getFont("arial", 18, PLAIN, NEGRO)));
            PdfPCell deta3 = new PdfPCell(new Paragraph(str3, FontFactory.getFont("arial", 18, BOLD, NEGRO)));
            PdfPCell deta4 = new PdfPCell(new Paragraph(str4, FontFactory.getFont("arial", 18, PLAIN, NEGRO)));
            PdfPCell deta5 = new PdfPCell(new Paragraph(str2, FontFactory.getFont("arial", 18, PLAIN, NEGRO)));
            PdfPCell deta6 = new PdfPCell(new Paragraph(" " + str5, FontFactory.getFont("arial", 18, PLAIN, NEGRO)));
            PdfPCell deta7 = new PdfPCell(new Paragraph(str5, FontFactory.getFont("arial", 18, PLAIN, NEGRO)));
            PdfPCell deta8 = new PdfPCell(new Paragraph(str2, FontFactory.getFont("arial", 18, PLAIN, NEGRO)));
            PdfPCell deta9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 18, PLAIN, NEGRO)));
            deta1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            deta2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            deta3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            deta4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            deta5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            deta6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            deta7.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            deta8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            deta9.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            detalle.addCell(deta1).setBorder(PdfPCell.NO_BORDER);
            detalle.addCell(deta2).setBorder(PdfPCell.NO_BORDER);
            detalle.addCell(deta3).setBorder(PdfPCell.NO_BORDER);
            detalle.addCell(deta4).setBorder(PdfPCell.NO_BORDER);
            detalle.addCell(deta5).setBorder(PdfPCell.NO_BORDER);
            detalle.addCell(deta6).setBorder(PdfPCell.NO_BORDER);
            detalle.addCell(deta7).setBorder(PdfPCell.NO_BORDER);
            detalle.addCell(deta8).setBorder(PdfPCell.NO_BORDER);
            detalle.addCell(deta9).setBorder(PdfPCell.NO_BORDER);
            pdf.add(detalle);
        }
        Integer limite = 27 - renglones.size();
        for (int i = 0; i < limite; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));
        }
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 14, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 10, PLAIN, FONDO_BLANCO)));
        PdfPTable pie1 = new PdfPTable(3);
        pie1.setWidthPercentage(100);
        float[] anchosP = new float[3];
        anchosP[0] = 85;
        anchosP[1] = 10;
        anchosP[2] = 5;

        pie1.setWidths(anchosP);
        PdfPCell pie1_1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell pie1_2 = new PdfPCell(new Paragraph(df_n.format(df.getTotal()), FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell pie1_3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 22, BOLD, NEGRO)));

        pie1_1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie1_2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pie1_3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        pie1.addCell(pie1_1).setBorder(PdfPCell.NO_BORDER);
        pie1.addCell(pie1_2).setBorder(PdfPCell.NO_BORDER);
        pie1.addCell(pie1_3).setBorder(PdfPCell.NO_BORDER);

        pdf.add(pie1);
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 18, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 18, PLAIN, FONDO_BLANCO)));
        pdf.add(pie1);
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 20, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 22, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 20, PLAIN, FONDO_BLANCO)));

        String n_cae = "735864175" + dfc.format(df.getCae());
        String fv_cae = sdf.format(df.getVencimCae());

        PdfPTable pie2 = new PdfPTable(4);
        pie2.setWidthPercentage(100);
        float[] anchosP2 = new float[4];
        anchosP2[0] = 51;
        anchosP2[1] = 24;
        anchosP2[2] = 20;
        anchosP2[3] = 5;

        pie2.setWidths(anchosP2);
        PdfPCell pie2_1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell pie2_2 = new PdfPCell(new Paragraph(" CAE NRO°:", FontFactory.getFont("arial", 20, BOLD, NEGRO)));
        PdfPCell pie2_3 = new PdfPCell(new Paragraph("  " + n_cae, FontFactory.getFont("arial", 20, PLAIN, NEGRO)));
        PdfPCell pie2_4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell pie2_5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 22, BOLD, NEGRO)));
        PdfPCell pie2_6 = new PdfPCell(new Paragraph(" Fecha de Vto. de CAE:", FontFactory.getFont("arial", 20, BOLD, NEGRO)));
        PdfPCell pie2_7 = new PdfPCell(new Paragraph("  " + fv_cae, FontFactory.getFont("arial", 20, PLAIN, NEGRO)));
        PdfPCell pie2_8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 22, BOLD, NEGRO)));

        pie2_1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2_2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pie2_3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2_4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pie2_5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pie2_6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pie2_7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pie2_8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        pie2.addCell(pie2_1).setBorder(PdfPCell.NO_BORDER);
        pie2.addCell(pie2_2).setBorder(PdfPCell.NO_BORDER);
        pie2.addCell(pie2_3).setBorder(PdfPCell.NO_BORDER);
        pie2.addCell(pie2_4).setBorder(PdfPCell.NO_BORDER);
        pie2.addCell(pie2_5).setBorder(PdfPCell.NO_BORDER);
        pie2.addCell(pie2_6).setBorder(PdfPCell.NO_BORDER);
        pie2.addCell(pie2_7).setBorder(PdfPCell.NO_BORDER);
        pie2.addCell(pie2_8).setBorder(PdfPCell.NO_BORDER);

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 9, PLAIN, FONDO_BLANCO)));
        pdf.add(pie2);

//        try {
//            ImageIcon ii = new ImageIcon("c:/ventasGa/img/fcG3.png");
//            BufferedImage bi = new BufferedImage(690, 976, BufferedImage.TYPE_INT_RGB);
//            Graphics2D g2d = (Graphics2D) bi.createGraphics();
//            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
//                    RenderingHints.VALUE_RENDER_QUALITY));
//            boolean b = g2d.drawImage(ii.getImage(), 0, 0, 690, 976, null);
//            System.out.println(b);
//            ImageIO.write(bi, "jpg", new File("c:/ventasGa/tmp/fcG3.jpg"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Cargar imagen
//Image image = Image.load("aspose-logo.jpg");
//
//// Definir nuevas dimensiones
//image.resize(300, 300);
//
//// Guardar imagen
//image.save("SimpleResizing_out.jpg");

        Image img2 = Image.getInstance("c:/ventasGa/img/fcG3_md.png");
//        Image img3 = img2.getImage().getScaledInstance(690, 976, Image.s);
        img2.setAbsolutePosition(0f, 2f);
        pdf.add(img2);
        /*
        ImageIcon img2 = new Image.getInstance("c:/ventasGa/img/fcG2.png");
        Image img3 = img2.getScaledInstance(690, 976, Image.SCALE_SMOTH);
        img2.setAbsolutePosition(1f, 1f);
        pdf.add(img2);
         */
        pdf.close();
        return new File(archPdf);
    }
}
