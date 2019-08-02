import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Paul Kunda
 * A personal slip class demo using itext legacy
 * Currently the file saving only works for Windows user
 * for linux and other OS you've to work around the fileStream line to make work in your work space.
 * This example shows how to implement the alignment using the legacy itext.
 */

public class APersonalSlip {


    public static void main(String[] args){

        try {

            //Variables of the employee
            String employeeName = "Paul Kunda";

            String addressOfEmployee = "21st Street";
            String nrcNumber = "481971/61/1";



            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);

            java.util.Date d = new java.util.Date(calendar.getTimeInMillis());
            String month = new SimpleDateFormat("MMMM").format(d);

            //Saving the file to your documents folder
            //System.getProperty gets the pc username
            OutputStream file = new FileOutputStream(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\AWorkingPersonalSlip.pdf"));

            //Create Document
            Document document = new Document();
            Paragraph paragraph;

            PdfWriter writer =  PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph());

            //getting the image in this example my image was saved in the project folder
            Image imageZo = Image.getInstance("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\IntelliJProjects\\ExampleAreaPDF\\student.jpg");

            //Align the image to the right of the document
            imageZo.scaleToFit(120f, 120f);
            imageZo.setAlignment(10);
            paragraph = new Paragraph("DEMO ");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            paragraph = new Paragraph("Pay Slip for the of "+ month + " "+currentYear,FontFactory.getFont(FontFactory.HELVETICA,10));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            //Adding the image to the document object.
            document.add(imageZo);



            Chunk glue = new Chunk(new VerticalPositionMark());
            Paragraph p = new Paragraph("Company Address \n Road and Stuff");
            p.add(new Chunk(glue));
            p.add(" ");

            document.add(p);
            //Create Table here
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(2); // Code 1
            table.getDefaultCell().setBorder(0);






            table.addCell(new Phrase("Name of Employee: "+employeeName, FontFactory.getFont(FontFactory.COURIER,10)));
            table.addCell(new Phrase("Address of Employee: "+addressOfEmployee, FontFactory.getFont(FontFactory.COURIER,10)));

            table.addCell(new Phrase("NRC NUMBER: "+nrcNumber, FontFactory.getFont(FontFactory.COURIER,10)));
            table.addCell(new Phrase("Mode Of Payment: "+addressOfEmployee, FontFactory.getFont(FontFactory.COURIER,10)));

            table.addCell(new Phrase("Employee Number#: "+addressOfEmployee, FontFactory.getFont(FontFactory.COURIER,10)));
            //if Mode is bank add the following
            //Bank account
            table.addCell(new Phrase("Back Account Number: "+addressOfEmployee, FontFactory.getFont(FontFactory.COURIER,10)));


            table.addCell(new Phrase("JOB TITLE: "+nrcNumber, FontFactory.getFont(FontFactory.COURIER,10)));
            table.addCell(new Phrase("Mode Of Payment: "+addressOfEmployee, FontFactory.getFont(FontFactory.COURIER,10)));
            table.addCell(new Phrase("DEPT: "+nrcNumber, FontFactory.getFont(FontFactory.COURIER,10)));
            table.addCell(new Phrase("Mode Of Payment: "+addressOfEmployee, FontFactory.getFont(FontFactory.COURIER,10)));





            //add table to the thing
            document.add(table);


            document.add(Chunk.NEWLINE);
            PdfPTable innerTableOne = new PdfPTable(2);
            innerTableOne.getDefaultCell().setBorder(0);
            innerTableOne.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);



            innerTableOne.addCell(new Phrase("INCOME ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));

            innerTableOne.addCell(new Phrase("Gross Pay: ", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("ZMK 14,000", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase("ALLOWANCES ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase("Medical Allowance: ", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("ZMK 14,000", FontFactory.getFont(FontFactory.COURIER,10)));

            innerTableOne.addCell(new Phrase("Housing Allowance: ", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("ZMK 14,000", FontFactory.getFont(FontFactory.COURIER,10)));

            innerTableOne.addCell(new Phrase("Transport: ", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("ZMK 14,000", FontFactory.getFont(FontFactory.COURIER,10)));

            innerTableOne.addCell(new Phrase("Total Overtime: ", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("ZMK 14,000", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase("DEDUCTION ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase("Reason", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("Amount", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase("Coming Late and stuff", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("ZMK 14,000", FontFactory.getFont(FontFactory.COURIER,10)));


            //Check for leave details here

            innerTableOne.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase("LEAVE", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase("Reason", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("Amount", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));




            innerTableOne.addCell(new Phrase("Coming Late and stuff", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("ZMK 14,000", FontFactory.getFont(FontFactory.COURIER,10)));


            //IF TICKED
            innerTableOne.addCell(new Phrase("TAXES", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));


            innerTableOne.addCell(new Phrase("NAPSA: ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("ZMK 120 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("PAYE: ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            innerTableOne.addCell(new Phrase("ZML 2000 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));


            innerTableOne.addCell(new Phrase("_________________________________", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("___________________________", FontFactory.getFont(FontFactory.COURIER,10)));

            innerTableOne.addCell(new Phrase("Net Pay", FontFactory.getFont(FontFactory.COURIER_OBLIQUE,10)));
            innerTableOne.addCell(new Phrase("ZMK 14,000", FontFactory.getFont(FontFactory.COURIER,10)));

            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
            innerTableOne.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));

            innerTableOne.addCell(new Phrase("Employee Signature:______________________", FontFactory.getFont(FontFactory.COURIER_OBLIQUE,10)));
            innerTableOne.addCell(new Phrase("Employer Signature:______________________", FontFactory.getFont(FontFactory.COURIER,10)));
            //add table to the thing
            document.add(innerTableOne);
            //Create Table here





            HeaderFooterPageEvent event = new HeaderFooterPageEvent();
           writer.setPageEvent(event);

            document.close();
            System.out.println("It's okay");






        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }


    }

}

