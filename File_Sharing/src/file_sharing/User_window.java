/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_sharing;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author rockstar
 */
public class User_window extends javax.swing.JFrame {

    /**
     * Creates new form User_window
     */
    public Socket socket            = null;
    DataInputStream dis = null;
    DataOutputStream dos = null;
    String rcv = "";
    String user;
    public User_window() {
        initComponents();
    }
public User_window(Socket socket ,String user) {
        initComponents();
        this.socket=socket;
         this.user = user;
        this.clientchat();
        this.username.setText(user);
       
    }
public void print(){
     this.chat_area.append(rcv+"\n");
}
public void clientchat() {
    try{
    this.dis = new DataInputStream(this.socket.getInputStream());
    this.dos = new DataOutputStream(this.socket.getOutputStream());
    
    // sendMessage thread
    
    // readMessage thread
    Thread sendMessage = new Thread(new Runnable()
    {
        @Override
        public void run() {
            try {
               
                String name = user;
                dos.writeUTF(name);
            } catch (IOException e) {
                e.printStackTrace();
        }}});
        sendMessage.start();
        
    Thread readMessage;
        readMessage = new Thread(new Runnable()
        {
            
            @Override
            
            public void run() {
                
                while (true) {
                    try {
                        // read the message sent to this client
                        rcv = dis.readUTF();
                        System.out.println(rcv);
                        print();
                    } catch (IOException e) {
                        
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
    
    readMessage.start();
    
    }
    catch(IOException e){}
	}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chat_area = new javax.swing.JTextArea();
        chat_text = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        disconnect = new javax.swing.JButton();
        history = new javax.swing.JButton();
        watch_video = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chat_area.setColumns(20);
        chat_area.setRows(5);
        chat_area.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                chat_areaInputMethodTextChanged(evt);
            }
        });
        chat_area.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                chat_areaPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(chat_area);

        chat_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chat_textActionPerformed(evt);
            }
        });

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        disconnect.setText("Disconnect");
        disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectActionPerformed(evt);
            }
        });

        history.setText("History");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });

        watch_video.setText("Watch Video");
        watch_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watch_videoActionPerformed(evt);
            }
        });

        jLabel1.setText("Username::");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                usernamePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(disconnect, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chat_text, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(send))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(history)
                        .addGap(31, 31, 31)
                        .addComponent(watch_video)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(disconnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(history)
                    .addComponent(watch_video))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chat_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        msg=this.chat_text.getText();
        chat_text.setText("");
       
    
        Thread sendMessage = new Thread(new Runnable()
    {
        @Override
        public void run() {
            /*
            }*/
            
            
                
                // read the message to deliver.
                
                
                try {
                    // write on the output stream
                    if(msg!=null){
                    dos.writeUTF(msg);
                   
                    
                    
                   
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    
                }
               
            
        }
    });
         sendMessage.start();
        
    }//GEN-LAST:event_sendActionPerformed

    private void chat_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chat_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chat_textActionPerformed

    private void disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disconnectActionPerformed

    private void watch_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watch_videoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_watch_videoActionPerformed

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        // TODO add your handling code here:
        hi h = new hi();
        h.setVisible(true);
    }//GEN-LAST:event_historyActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_usernameActionPerformed

    private void chat_areaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_chat_areaPropertyChange
        // TODO add your handling code here:
      
    }//GEN-LAST:event_chat_areaPropertyChange

    private void chat_areaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_chat_areaInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chat_areaInputMethodTextChanged

    private void usernamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_usernamePropertyChange
        // TODO add your handling code here:
        this.username.setEditable(false);
        
    }//GEN-LAST:event_usernamePropertyChange

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
            java.util.logging.Logger.getLogger(User_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_window().setVisible(true);
            }
        });
    }
    private String msg;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chat_area;
    private javax.swing.JTextField chat_text;
    private javax.swing.JButton disconnect;
    private javax.swing.JButton history;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton send;
    private javax.swing.JTextField username;
    private javax.swing.JButton watch_video;
    // End of variables declaration//GEN-END:variables
}