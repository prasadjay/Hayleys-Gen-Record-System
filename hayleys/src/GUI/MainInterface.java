/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akhila
 */
public class MainInterface extends javax.swing.JFrame {
    
    Dbconnect db1 = new Dbconnect();
    Connection con1 = db1.connect();

    /**
     * Creates new form MainInterface
     */
    public MainInterface() {
        initComponents();
        
        // load gen ID
        
        String queryLab="select count(*) as 'field' from jobs";
        int n=1;
       
        
        ResultSet count = db1.executeSQLQuery(queryLab);
        
        try
        {
            if(count.next())
            {
                n += Integer.parseInt(count.getString("field"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Found!", 1);
        }
        
        
        this.jTextField1.setText("Gen"+Integer.toString(n));
        
        // load delete table
        
        String query1 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where job_Life = 'ON'";
       
        
        ResultSet result= db1.executeSQLQuery(query1);

        try {

                int columCount = 0;
                ResultSetMetaData rsmd = result.getMetaData();
                Vector myVector = new Vector();
                columCount = rsmd.getColumnCount();
                for (int i = 1; i <= columCount; i++) {
                    myVector.add(rsmd.getColumnLabel(i));
                }
                DefaultTableModel amodel = new DefaultTableModel(myVector, 0)/*0=row count*/ {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        //all cells false
                        return false;
                    }
                };


                while (result.next()) {
                    String[] rowData = new String[columCount];
                    for (int i = 1; i <= columCount; i++) {
                        if (i == 1) {
                            String id = result.getString(i);
                            rowData[i - 1] = id.toUpperCase();
                        } else {
                            rowData[i - 1] = result.getString(i);
                        }
                    }
                    amodel.addRow(rowData);
                }

                jTable1.setModel(amodel);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error in Showing Data", "Medicare Health Centre", 1);
            }
        
        
        //load edit jobs
        
          //String query11 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where s1_Status ='pending' OR i1_Status = 'pending' OR s2_Status ='pending' OR i2_Status = 'pending' OR s3_Status ='pending' OR i3_Status = 'pending' OR s4_Status ='pending' OR i4_Status = 'pending' OR s5_Status ='pending' OR i5_Status = 'pending' AND i5_Status != 'deleted' ";
       
        String query11 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where job_Status = 'pending' AND job_life = 'ON'";
        
        ResultSet resultt= db1.executeSQLQuery(query11);

        try {

                int columCount = 0;
                ResultSetMetaData rsmd = resultt.getMetaData();
                Vector myVector = new Vector();
                columCount = rsmd.getColumnCount();
                for (int i = 1; i <= columCount; i++) {
                    myVector.add(rsmd.getColumnLabel(i));
                }
                DefaultTableModel amodel = new DefaultTableModel(myVector, 0)/*0=row count*/ {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        //all cells false
                        return false;
                    }
                };


                while (resultt.next()) {
                    String[] rowData = new String[columCount];
                    for (int i = 1; i <= columCount; i++) {
                        if (i == 1) {
                            String id = resultt.getString(i);
                            rowData[i - 1] = id.toUpperCase();
                        } else {
                            rowData[i - 1] = resultt.getString(i);
                        }
                    }
                    amodel.addRow(rowData);
                }

                jTable5.setModel(amodel);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error in Showing Data", "Medicare Health Centre", 1);
            }
        
        //load completed jobs
        
         String query111 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where job_Status = 'finished' AND job_life = 'ON'";
       
        
        ResultSet result3= db1.executeSQLQuery(query111);

        try {

                int columCount = 0;
                ResultSetMetaData rsmd = result3.getMetaData();
                Vector myVector = new Vector();
                columCount = rsmd.getColumnCount();
                for (int i = 1; i <= columCount; i++) {
                    myVector.add(rsmd.getColumnLabel(i));
                }
                DefaultTableModel amodel = new DefaultTableModel(myVector, 0)/*0=row count*/ {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        //all cells false
                        return false;
                    }
                };


                while (result3.next()) {
                    String[] rowData = new String[columCount];
                    for (int i = 1; i <= columCount; i++) {
                        if (i == 1) {
                            String id = result3.getString(i);
                            rowData[i - 1] = id.toUpperCase();
                        } else {
                            rowData[i - 1] = result3.getString(i);
                        }
                    }
                    amodel.addRow(rowData);
                }

                jTable4.setModel(amodel);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error in Showing Data", "Medicare Health Centre", 1);
            }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jTextField30 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome!");

        jLabel1.setText("Job ID");

        jTextField1.setEditable(false);

        jLabel2.setText("Customer Name");

        jLabel3.setText("Engine");

        jLabel4.setText("KVA");

        jLabel5.setText("Service Count");

        jLabel6.setText("Inspection Count");

        jLabel7.setText("Start Date");

        jLabel8.setText("End Date");

        jButton1.setText("Show Dates");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Service 1 ");

        jLabel10.setText("Inspection 1");

        jLabel11.setText("Planned");

        jLabel13.setText("Planned");

        jLabel15.setText("Service 2");

        jLabel16.setText("Inspection 2");

        jLabel17.setText("Service 3");

        jLabel18.setText("Inspection 3");

        jLabel19.setText("Service 4");

        jLabel20.setText("Inspection 4");

        jLabel21.setText("Service 5");

        jLabel22.setText("Inspection 5");

        jButton2.setText("Add Job");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(56, 56, 56))))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel11)
                .addGap(448, 448, 448)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(265, 265, 265)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 302, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jButton1))
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Job", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton4.setText("Refresh Feed");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel23.setText("Enter Job ID to be deleted OR to view detailed info");

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("View Detailed Info");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel23)
                .addGap(27, 27, 27)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton6)
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Remove Job", jPanel2);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jButton8.setText("Refresh Feed");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel25.setText("Enter Job ID to view more");

        jButton11.setText("View");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jButton11)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("View Completed Jobs", jPanel5);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jButton9.setText("Refresh Feed");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel24.setText("Enter Job ID to be edited");

        jButton10.setText("Edit");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton10)
                .addContainerGap(345, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jButton10)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("View and Mark Pending Jobs", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

        SaveData.setData(this.jTextField30.getText().toString());
        EditProjects one = new EditProjects();
        one.setVisible(true);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

      //  String query1 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where s1_Status ='pending' OR i1_Status = 'pending' OR s2_Status ='pending' OR i2_Status = 'pending' OR s3_Status ='pending' OR i3_Status = 'pending' OR s4_Status ='pending' OR i4_Status = 'pending' OR s5_Status ='pending' OR i5_Status = 'pending' AND i5_Status != 'FINISHED' AND i5_Status != 'deleted' ";

        String query1 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where job_Status = 'pending' AND job_life = 'ON'";
        ResultSet result= db1.executeSQLQuery(query1);

        try {

            int columCount = 0;
            ResultSetMetaData rsmd = result.getMetaData();
            Vector myVector = new Vector();
            columCount = rsmd.getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                myVector.add(rsmd.getColumnLabel(i));
            }
            DefaultTableModel amodel = new DefaultTableModel(myVector, 0)/*0=row count*/ {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            while (result.next()) {
                String[] rowData = new String[columCount];
                for (int i = 1; i <= columCount; i++) {
                    if (i == 1) {
                        String id = result.getString(i);
                        rowData[i - 1] = id.toUpperCase();
                    } else {
                        rowData[i - 1] = result.getString(i);
                    }
                }
                amodel.addRow(rowData);
            }

            jTable5.setModel(amodel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in Showing Data", "Medicare Health Centre", 1);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
        SaveData.setData(this.jTextField31.getText().toString());
        ViewDetailedProject one = new ViewDetailedProject();
        one.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        //String query1 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where s1_Status ='YES' AND s2_Status ='YES' AND s3_Status ='YES' AND s4_Status ='YES' AND s5_Status ='YES' AND i1_Status ='YES' AND i2_Status ='YES' AND i3_Status ='YES' AND i4_Status ='YES' AND i5_Status ='YES' ";

        String query1 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where job_Status = 'finished' AND job_life = 'ON'";

        ResultSet result= db1.executeSQLQuery(query1);

        try {

            int columCount = 0;
            ResultSetMetaData rsmd = result.getMetaData();
            Vector myVector = new Vector();
            columCount = rsmd.getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                myVector.add(rsmd.getColumnLabel(i));
            }
            DefaultTableModel amodel = new DefaultTableModel(myVector, 0)/*0=row count*/ {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            while (result.next()) {
                String[] rowData = new String[columCount];
                for (int i = 1; i <= columCount; i++) {
                    if (i == 1) {
                        String id = result.getString(i);
                        rowData[i - 1] = id.toUpperCase();
                    } else {
                        rowData[i - 1] = result.getString(i);
                    }
                }
                amodel.addRow(rowData);
            }

            jTable4.setModel(amodel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in Showing Data", "Medicare Health Centre", 1);
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        String query = "update jobs set job_life = 'OFF' where jobID = '"+this.jTextField29.getText()+"'";

        int x = db1.executeNonQuery(query);

        if(x==-1)
        JOptionPane.showMessageDialog(null, "Error in Database. Please Reconnect! ","Error!", 1);
        else
        JOptionPane.showMessageDialog(null, "Records removed sucessfully! ","Sucessful!", 1);

        String query1 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where  job_Life = 'ON'";

        ResultSet result= db1.executeSQLQuery(query1);

        try {

            int columCount = 0;
            ResultSetMetaData rsmd = result.getMetaData();
            Vector myVector = new Vector();
            columCount = rsmd.getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                myVector.add(rsmd.getColumnLabel(i));
            }
            DefaultTableModel amodel = new DefaultTableModel(myVector, 0)/*0=row count*/ {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            while (result.next()) {
                String[] rowData = new String[columCount];
                for (int i = 1; i <= columCount; i++) {
                    if (i == 1) {
                        String id = result.getString(i);
                        rowData[i - 1] = id.toUpperCase();
                    } else {
                        rowData[i - 1] = result.getString(i);
                    }
                }
                amodel.addRow(rowData);
            }

            jTable1.setModel(amodel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in Showing Data", "Medicare Health Centre", 1);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        String query1 = "select jobID, custName, enginee, kva, serviceCount, inspectionCount  from jobs where job_Life = 'ON' ";

        ResultSet result= db1.executeSQLQuery(query1);

        try {

            int columCount = 0;
            ResultSetMetaData rsmd = result.getMetaData();
            Vector myVector = new Vector();
            columCount = rsmd.getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                myVector.add(rsmd.getColumnLabel(i));
            }
            DefaultTableModel amodel = new DefaultTableModel(myVector, 0)/*0=row count*/ {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            while (result.next()) {
                String[] rowData = new String[columCount];
                for (int i = 1; i <= columCount; i++) {
                    if (i == 1) {
                        String id = result.getString(i);
                        rowData[i - 1] = id.toUpperCase();
                    } else {
                        rowData[i - 1] = result.getString(i);
                    }
                }
                amodel.addRow(rowData);
            }

            jTable1.setModel(amodel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in Showing Data", "Medicare Health Centre", 1);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        this.jTextField3.setText("");
        this.jTextField4.setText("");
        this.jTextField5.setText("");
        this.jTextField6.setText("");
        this.jTextField9.setText("");
        this.jTextField11.setText("");
        this.jTextField13.setText("");
        this.jTextField15.setText("");
        this.jTextField17.setText("");
        this.jTextField19.setText("");
        this.jTextField21.setText("");
        this.jTextField22.setText("");
        this.jTextField23.setText("");
        this.jTextField24.setText("");

        // load gen ID

        String queryLab="select count(*) as 'field' from jobs";
        int n=1;

        ResultSet count = db1.executeSQLQuery(queryLab);

        try
        {
            if(count.next())
            {
                n += Integer.parseInt(count.getString("field"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Exception Found!", 1);
        }

        this.jTextField1.setText("Gen"+Integer.toString(n));

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        //inserting data in to database

        String jobID = this.jTextField1.getText().toString();
        String custName = this.jTextField2.getText().toString();
        String enginee = this.jTextField3.getText().toString();
        String kva = this.jTextField4.getText().toString();
        String serviceCount = this.jTextField5.getText().toString();
        String inspectionCount = this.jTextField6.getText().toString();
        String startDate = Integer.toString(this.jDateChooser1.getDate().getYear()+1900)+"/"+Integer.toString(this.jDateChooser1.getDate().getMonth()+1)+"/"+Integer.toString(this.jDateChooser1.getDate().getDate());
        String endDate = Integer.toString(this.jDateChooser2.getDate().getYear()+1900)+"/"+Integer.toString(this.jDateChooser2.getDate().getMonth()+1)+"/"+Integer.toString(this.jDateChooser2.getDate().getDate());
        String s1 = this.jTextField9.getText().toString();
        String i1 = this.jTextField11.getText().toString();
        String s2 = this.jTextField13.getText().toString();
        String i2 = this.jTextField21.getText().toString();
        String s3 = this.jTextField15.getText().toString();
        String i3 = this.jTextField22.getText().toString();
        String s4 = this.jTextField17.getText().toString();
        String i4 = this.jTextField23.getText().toString();
        String s5 = this.jTextField19.getText().toString();
        String i5 = this.jTextField24.getText().toString();
        String pending = "pending";
        String stat = "NO";
        String life = "ON";

        if(jobID.equals("") || custName.equals("") || enginee.equals("") || kva.equals("") || serviceCount.equals("")|| inspectionCount.equals("")|| startDate.equals("") || endDate.equals("") )
        {
            JOptionPane.showMessageDialog(null, "Please Insert Required Fields ","Require Fields", 1);
        }
        else
        {

            String query1 = "insert into jobs values('"+jobID+"','" +custName+"','" + enginee+"','" +kva+"','" +serviceCount+"','" +inspectionCount+"', '"+startDate+"', '"+endDate+"', '"+s1+"', '"+pending+"', '"+stat+"', '"+i1+"', '"+pending+"', '"+stat+"', '"+s2+"', '"+pending+"', '"+stat+"', '"+i2+"', '"+pending+"', '"+stat+"', '"+s3+"', '"+pending+"', '"+stat+"', '"+i3+"', '"+pending+"', '"+stat+"', '"+s4+"', '"+pending+"', '"+stat+"', '"+i4+"', '"+pending+"', '"+stat+"', '"+s5+"', '"+pending+"', '"+stat+"', '"+i5+"', '"+pending+"', '"+stat+"', '"+pending+"', '"+life+"' )";

            int x = db1.executeNonQuery(query1);

            if(x>0)
            JOptionPane.showMessageDialog(null, "Records inserted sucessfully! ","Sucessful!", 1);
            else
            JOptionPane.showMessageDialog(null, "Error in Database. Please Reconnect! ","Error!", 1);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int sc = Integer.parseInt(this.jTextField5.getText().toString())-1;
        int ic = Integer.parseInt(this.jTextField6.getText().toString());

        /*
        boolean blsc1=false;
        boolean blsc2=false;
        boolean blsc3=false;
        boolean blsc4=false;
        boolean blsc5=false;

        boolean blic1=false;
        boolean blic2=false;
        boolean blic3=false;
        boolean blic4=false;
        boolean blic5=false;

        */
        boolean[] blsc = new boolean[5];
        boolean[] blic = new boolean[5];

        //assign booleans for service count

        if(sc==0)
        {
            blsc[0]=false;
            blsc[1]=false;
            blsc[2]=false;
            blsc[3]=false;
            blsc[4]=false;
        }

        if(sc==1)
        {
            blsc[0]=true;
            blsc[1]=false;
            blsc[2]=false;
            blsc[3]=false;
            blsc[4]=false;
        }

        if(sc==2)
        {
            blsc[0]=true;
            blsc[1]=true;
            blsc[2]=false;
            blsc[3]=false;
            blsc[4]=false;
        }

        if(sc==3)
        {
            blsc[0]=true;
            blsc[1]=true;
            blsc[2]=true;
            blsc[3]=false;
            blsc[4]=false;
        }

        if(sc==4)
        {
            blsc[0]=true;
            blsc[1]=true;
            blsc[2]=true;
            blsc[3]=true;
            blsc[4]=false;
        }

        if(sc==5)
        {
            blsc[0]=true;
            blsc[1]=true;
            blsc[2]=true;
            blsc[3]=true;
            blsc[4]=true;
        }

        //assign booleans for inspections count

        if(ic==0)
        {
            blic[0]=false;
            blic[1]=false;
            blic[2]=false;
            blic[3]=false;
            blic[4]=false;
        }

        if(ic==1)
        {
            blic[0]=true;
            blic[1]=false;
            blic[2]=false;
            blic[3]=false;
            blic[4]=false;
        }

        if(ic==2)
        {
            blic[0]=true;
            blic[1]=true;
            blic[2]=false;
            blic[4]=false;
            blic[4]=false;
        }

        if(ic==3)
        {
            blic[0]=true;
            blic[1]=true;
            blic[2]=true;
            blic[3]=false;
            blic[4]=false;
        }

        if(ic==4)
        {
            blic[0]=true;
            blic[1]=true;
            blic[2]=true;
            blic[3]=true;
            blic[4]=false;
        }

        if(ic==5)
        {
            blic[0]=true;
            blic[1]=true;
            blic[2]=true;
            blic[3]=true;
            blic[4]=true;
        }

        // enging assigning all boolean figures

        //getting the time period in days

        int days = getNoOfDays(this.jDateChooser1.getDate(), this.jDateChooser2.getDate());

        int noOfJobs = sc+ic+1;

        int betweenSessions = days/noOfJobs;

        System.out.println("No of days = "+noOfJobs);

        System.out.println("betwen days = " + betweenSessions );

        Date d = new Date(this.jDateChooser1.getDate().getYear(), this.jDateChooser1.getDate().getMonth(), this.jDateChooser1.getDate().getDate());

        Calendar c = Calendar.getInstance();
        c.setTime(d);

        //c.add(Calendar.DATE, 3);
        // System.out.println(c.getTime().getDate());
        // c.add(Calendar.DATE, 3);
        // System.out.println(c.getTime().getDate());

        String[] stic = new String[5];
        String[] stsc = new String[5];

        for(int x=0; x<=4; x++)
        {
            stic[x]=" ";
            stsc[x]=" ";
        }

        int sumSessions = betweenSessions;

        loop1:for(int x=0; x<=4; x++)
        {
            if(blic[x]==true && blsc[x]==true)
            {
                c.add(Calendar.DATE, sumSessions);
                stic[x] = Integer.toString(c.getTime().getYear()+1900)+"/"+Integer.toString(c.getTime().getMonth()+1)+"/"+Integer.toString(c.getTime().getDate());
                c.add(Calendar.DATE, sumSessions);
                stsc[x] = Integer.toString(c.getTime().getYear()+1900)+"/"+Integer.toString(c.getTime().getMonth()+1)+"/"+Integer.toString(c.getTime().getDate());
            }
            if(blic[x]==true && blsc[x]==false)
            {
                c.add(Calendar.DATE, sumSessions);
                stic[x] = Integer.toString(c.getTime().getYear()+1900)+"/"+Integer.toString(c.getTime().getMonth()+1)+"/"+Integer.toString(c.getTime().getDate());
                stsc[x] = "Not Available";
            }
            if(blic[x]==false && blsc[x]==true)
            {
                c.add(Calendar.DATE, sumSessions);
                stsc[x] = Integer.toString(c.getTime().getYear()+1900)+"/"+Integer.toString(c.getTime().getMonth()+1)+"/"+Integer.toString(c.getTime().getDate());
                stic[x] = "Not Available";
            }
            if(blic[x]==false && blsc[x]==false)
            {
                stsc[x] = "Not Available";
                stic[x] = "Not Available";
                //break loop1;
            }
        }

        for(int x=0; x<=4; x++)
        {
            System.out.println(stic[x]);
            System.out.println(stsc[x]);
        }

        this.jTextField9.setText(Integer.toString(this.jDateChooser1.getDate().getYear()+1900)+"/"+Integer.toString(this.jDateChooser1.getDate().getMonth()+1)+"/"+Integer.toString(this.jDateChooser1.getDate().getDate()));

        this.jTextField11.setText(stic[0]);
        this.jTextField13.setText(stsc[0]);
        this.jTextField15.setText(stsc[1]);
        this.jTextField17.setText(stsc[2]);
        this.jTextField19.setText(stsc[3]);
        this.jTextField21.setText(stic[1]);
        this.jTextField22.setText(stic[2]);
        this.jTextField23.setText(stic[3]);
        this.jTextField24.setText(stic[4]);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        SaveData.setData(this.jTextField29.getText().toString());
        ViewDetailedProject one = new ViewDetailedProject();
        one.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    public int getNoOfDays(Date date1, Date date2)
{       
    //if date2 is more in the future than date1 then the result will be negative
    //if date1 is more in the future than date2 then the result will be positive.

    return (int)((date2.getTime() - date1.getTime()) / (1000*60*60*24l));
}
    
    public Date getCreatedDate()
    {
      return new Date();  
    }
    
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
