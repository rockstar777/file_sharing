package file_sharing;



import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JTextField;


class Record
{
   String filename;
   String Date_Time;
   String Status;
   String User;

  public Record(String filename, String Date_Time, String Status, String User)
  {
       this.filename = filename;
       this.Date_Time = Date_Time;
       this.Status = Status;
       this.User = User;
  }
  
  @Override
  public String toString() 
  {
       return (filename+
                   "\t  "+ Date_Time +
                   "\t"+ Status +
                   "\t  " + User);
  }
  
}



public class hi extends javax.swing.JFrame {
 ArrayList<Record> record = new ArrayList<Record>();
 String get_txt="";
    /**
     * Creates new form hi
     */
    public hi() {
        initComponents();
        this.search_txt_fil.setText("");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        search_txt_fil = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        History_table = new javax.swing.JTable();
        Search_txt = new javax.swing.JButton();
        Filter_items = new javax.swing.JComboBox<>();
        Filter = new javax.swing.JButton();
        Cancel_button = new javax.swing.JButton();
         jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         search_txt_fil.setText("textField1");
         
        
       search_txt_fil.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                get_txt =  search_txt_fil.getText();
                search_txt_fil.setText(get_txt);
                
            }
        });
       Search_txt.setText("Search");
        Search_txt.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
             get_txt =  search_txt_fil.getText();
             System.out.println(get_txt+"-----?");
  //                Search_txtActionPerformed(evt);
             Object obj [][]= new Object [1000][5];
             ArrayList<Object> hhh=new ArrayList<Object>();
  //                ArrayList<String> array_list = new ArrayList<String>();
            try{
              FileInputStream fstream = new FileInputStream("E:\\file_sharing\\File_Sharing\\File.log");
              DataInputStream in = new DataInputStream(fstream);
              BufferedReader br = new BufferedReader(new InputStreamReader(in));
              String strLine;
              // Record[] record = new Record[5];
  //                  ArrayList<Record> record = new ArrayList<Record>();
              int i=0,j=0;

                    while ((strLine = br.readLine()) != null){
                          
                        if(j%2!=0){
                        String[] tokens = strLine.split("  ");
                          System.out.println(strLine);
                        if(tokens[1].contains(get_txt)||tokens[2].contains(get_txt)||tokens[3].contains(get_txt)||tokens[4].contains(get_txt)){  
                            obj[i][0] = tokens[1];
                            String g [] = tokens[2].split(" ");
                            obj[i][1] = g[0];
                            obj[i][2] = g[1];
                            obj[i][3] = tokens[3];
                            obj[i][4] = tokens[4];
                            System.out.println(tokens[1]+" "+tokens[2]+" "+tokens[3]+" "+tokens[4]);
                           i++;
                        }
                       } 
                        j++;
                    }
                in.close();
            }
            catch (Exception e)
            {
              System.err.println("Error: " + e.getMessage());
            } 

            History_table.setModel(new javax.swing.table.DefaultTableModel(
               obj,
                new String [] {
                    "File", "Date", "Time", "action","User"
                }
            ));
          }
        });



        Filter_items.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "name", "Date", "User"}));

                Object obj [][]= new Object [1000][5];
                try
                {
                  FileInputStream fstream = new FileInputStream("E:\\file_sharing\\File_Sharing\\File.log");
                  DataInputStream in = new DataInputStream(fstream);
                  BufferedReader br = new BufferedReader(new InputStreamReader(in));
                  String strLine;
                  int i=0,j=0;
                  
                       while ((strLine = br.readLine()) != null)  
                          {
                                  if(j%2!=0){
                            String[] tokens = strLine.split("  ");
                            obj[i][0] = tokens[1];
                            String g [] = tokens[2].split(" ");
                            obj[i][1] = g[0];
                            obj[i][2] = g[1];
                            obj[i][3] = tokens[3];
                            obj[i][4] = tokens[4];
                            record.add(new Record(tokens[1],tokens[2],tokens[3],tokens[4]));//process record , etc
                            i++;
                                  }
                                  j++;
                          }
                    in.close();
                }
                catch (Exception e)
                {
                  System.err.println("Error: " + e.getMessage());
                } 

        History_table.setModel(new javax.swing.table.DefaultTableModel(
           obj,
            new String [] {
                "File", "Date", "Time", "action","User"
            }
        ));
        jScrollPane1.setViewportView(History_table);
        
        Filter.setText("Sort by");
        Filter.addActionListener(new java.awt.event.ActionListener() {
//            private Object javax;
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
//                FilterActionPerformed(evt);
                if(Filter_items.getItemAt(Filter_items.getSelectedIndex()).endsWith("name")){
                    
                    Collections.sort(record, new NameComparator());
                    Object obj1 [][] = new Object[1000][5];
                    for(int i=0;i<record.size();i++){
                        obj1[i][0] = record.get(i).filename;
                            String g [] = record.get(i).Date_Time.split(" ");
                            obj1[i][1] = g[0];
                            obj1[i][2] = g[1];
                            obj1[i][3] = record.get(i).Status;
                            obj1[i][4] = record.get(i).User;
                    }
                    
                    History_table.setModel(new javax.swing.table.DefaultTableModel(
                        obj1,
                        new String [] {
                            "File", "Date", "Time","Action","from"
                        }
                    ));
                }
//                    System.out.println("Fdsfs")
                else if(Filter_items.getItemAt(Filter_items.getSelectedIndex()).endsWith("Date")){
                    Collections.sort(record,new DateModifiedComparator());
                     Object obj1 [][] = new Object[1000][5];
                    for(int i=0;i<record.size();i++){
                        obj1[i][0] = record.get(i).filename;
                            String g [] = record.get(i).Date_Time.split(" ");
                            obj1[i][1] = g[0];
                            obj1[i][2] = g[1];
                            obj1[i][3] = record.get(i).Status;
                            obj1[i][4] = record.get(i).User;
                    }
                    History_table.setModel(new javax.swing.table.DefaultTableModel(
                        obj1,
                        new String [] {
                            "File", "Date", "Time","Action","from"
                        }
                    ));
                }
                else if(Filter_items.getItemAt(Filter_items.getSelectedIndex()).endsWith("User")){
                    Collections.sort(record,new userNameComparator()); 
                    Object obj1 [][] = new Object[1000][5];
                    for(int i=0;i<record.size();i++){
                        obj1[i][0] = record.get(i).filename;
                            String g [] = record.get(i).Date_Time.split(" ");
                            obj1[i][1] = g[0];
                            obj1[i][2] = g[1];
                            obj1[i][3] = record.get(i).Status;
                            obj1[i][4] = record.get(i).User;
                    }
                    History_table.setModel(new javax.swing.table.DefaultTableModel(
                        obj1,
                        new String [] {
                           "File", "Date", "Time","Action","from"
                        }
                    )); 
                }
            }
        });
         


        Cancel_button.setText("Cancel");
        Cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel_buttonActionPerformed(evt);
            }
        });
        jButton1.setText("reverse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                System.out.println("***********-------."+check);
                if(check==0){
                    Object obj12 [][] = new Object[1000][5];
                            for(int i=record.size()-1;i>=0;i--){
                                System.out.println("--->"+record.get(i));
                                obj12[record.size()-1-i][0] = record.get(i).filename;
                                    String g [] = record.get(i).Date_Time.split(" ");
                                    obj12[record.size()-1-i][1] = g[0];
                                    obj12[record.size()-1-i][2] = g[1];
                                    obj12[record.size()-1-i][3] = record.get(i).Status;
                                    obj12[record.size()-1-i][4] = record.get(i).User;
//                                    System.out.println(obj1[i][0]+" --  >"+obj1[i][1]+" --  >"+obj1[i][2]+" --  >"+obj1[i][3]+" --  >"+obj1[i][4]+" --  >");
                            }
                            History_table.setModel(new javax.swing.table.DefaultTableModel(
                                obj12,
                                new String [] {
                                   "File", "Date", "Time","Action","from"
                                }
                            )); 
                            check=1;
                }
                else{
                     Object obj1 [][] = new Object[record.size()][5];
                     for(int i=0;i<record.size();i++){
                        System.out.println("--->"+record.get(i));
                        obj1[i][0] = record.get(i).filename;
                        String g [] = record.get(i).Date_Time.split(" ");
                        obj1[i][1] = g[0];
                        obj1[i][2] = g[1];
                        obj1[i][3] = record.get(i).Status;
                        obj1[i][4] = record.get(i).User;
//                                    System.out.println(obj1[i][0]+" --  >"+obj1[i][1]+" --  >"+obj1[i][2]+" --  >"+obj1[i][3]+" --  >"+obj1[i][4]+" --  >");
                    }
                    History_table.setModel(new javax.swing.table.DefaultTableModel(
                        obj1,
                        new String [] {
                           "File", "Date", "Time","Action","from"
                        }
                    )); 
                    check=0;
                }
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search_txt_fil, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Search_txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filter_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Filter)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cancel_button)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cancel_button)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Filter)
                            .addComponent(jButton1)
                            .addComponent(Filter_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search_txt)
                            .addComponent(search_txt_fil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
    }                                        

    private void search_txt_filActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        
    }   
                                       
    private void Cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        this.dispose();
    }       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(hi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Cancel_button;
    private javax.swing.JButton Filter;
    private javax.swing.JComboBox<String> Filter_items;
    private javax.swing.JTable History_table;
    private javax.swing.JButton Search_txt;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField search_txt_fil;
    private java.awt.TextArea textArea1;
    private javax.swing.JButton jButton1;
    int check=0;
    // End of variables declaration                   
}



class NameComparator implements Comparator<Record>{  

  public int compare(Record e1, Record e2){
          return e1.filename.compareToIgnoreCase(e2.filename);
     }
}  

class DateModifiedComparator implements Comparator<Record>{  

      DateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  @Override
  public int compare(Record o1, Record o2) {
    // TODO Auto-generated method stub
    try {
            return f.parse(o1.Date_Time).compareTo(f.parse(o2.Date_Time));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    
  }
}  

class  userNameComparator implements Comparator<Record>{  

   public int compare(Record e1, Record e2) 
        {
            return e1.User.compareToIgnoreCase(e2.User);
        }
}  
