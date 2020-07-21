
package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JavaProject implements ActionListener {
    
    JLabel Rolln,Fname,Lname,Marks,Blank,Blank1,Blank2,Blank3,Blank4,Blank5,Blank6,English,Maths,Physics;
    JLabel Lrolln,Lfname,Llname,Lmarks,Leng,Lmaths,Lphy,Lper,Lgrade,Lresult;
    JLabel rval,fval,lval,eval,mval,pval,perval,gradeval,resultval;
    
    JTextField txtroll,txtfname,txtlname,txtenglish,txtmaths,txtphysics;
    JButton Addbtn,Updatebtn,Deletebtn,Prevbtn,Nextbtn,Firstbtn,Lastbtn,Clearbtn;
    
    ResultSet rs;
    String uroll,ufname,ulname,ueng,umath,uphy;

   public static void main(String[] args) {
       
       JavaProject obj=new JavaProject();
       obj.display();
        
    }
   public void display()
   {
       JFrame frame=new JFrame("Result Management System");
       
       JPanel pnlInput=new JPanel(new GridLayout(8,2));
       
       Rolln=new JLabel("ROLL NO:");
       txtroll=new JTextField(10);
       
       Fname=new JLabel("FIRST NAME:");
       txtfname=new JTextField(15);
       
       Lname=new JLabel("LAST NAME:");
       txtlname=new JTextField(15);
       
       Marks=new JLabel("MARKS OBTAINED (M.M:100):");
       Blank=new JLabel("");
       English=new JLabel("ENGLISH");
       txtenglish=new JTextField(10);
       
       Maths=new JLabel("MATHEMATICS");
       txtmaths=new JTextField(10);
       
       Physics=new JLabel("PHYSICS");
       txtphysics=new JTextField(10);
       
       pnlInput.add(Rolln);
       pnlInput.add(txtroll);
       pnlInput.add(Fname);
       pnlInput.add(txtfname);
       pnlInput.add(Lname);
       pnlInput.add(txtlname);
       pnlInput.add(Marks);
       pnlInput.add(Blank);
       pnlInput.add(English);
       pnlInput.add(txtenglish);
       pnlInput.add(Maths);
       pnlInput.add(txtmaths);
       pnlInput.add(Physics);
       pnlInput.add(txtphysics);
       
        JPanel pnlButton = new JPanel(new GridLayout());
        
        Addbtn=new JButton("ADD");
        Addbtn.addActionListener(this);
        Addbtn.setForeground(Color.BLUE);
        Updatebtn=new JButton("UPDATE");
        Updatebtn.addActionListener(this);
        Updatebtn.setForeground(Color.BLUE);
        Deletebtn=new JButton("DELETE");
        Deletebtn.addActionListener(this);
        Deletebtn.setForeground(Color.red);
        Clearbtn=new JButton("CLEAR");
        Clearbtn.addActionListener(this);
        Clearbtn.setForeground(Color.red);
        
        Nextbtn=new JButton("NEXT");
        Nextbtn.setActionCommand("NEXT");
        Nextbtn.addActionListener(this);
        Nextbtn.setForeground(Color.BLUE);
        Prevbtn=new JButton("PREVIOUS");
        Prevbtn.setActionCommand("PREVIOUS");
        Prevbtn.addActionListener(this);
        Prevbtn.setForeground(Color.BLUE);
        
        Firstbtn=new JButton("FIRST");
        Firstbtn.setActionCommand("FIRST");
        Firstbtn.addActionListener(this);
        Firstbtn.setForeground(Color.BLUE);
        Lastbtn=new JButton("LAST");
        Lastbtn.setActionCommand("LAST");
        Lastbtn.addActionListener(this);
        Lastbtn.setForeground(Color.BLUE);
        
        pnlButton.add(Firstbtn);
        pnlButton.add(Prevbtn);
        pnlButton.add(Addbtn);
        pnlButton.add(Deletebtn);
        pnlButton.add(Clearbtn);
        pnlButton.add(Updatebtn);
        pnlButton.add(Nextbtn);
        pnlButton.add(Lastbtn);
        
        JPanel pnlResult=new JPanel(new GridLayout(13,2));
        
        Lrolln=new JLabel("ROLL NO:");
        rval=new JLabel("-");
        Lfname=new JLabel("FIRST NAME:");
        fval=new JLabel("-");
        Llname=new JLabel("LAST NAME:");
        lval=new JLabel("-");
        Blank3=new JLabel("");
        Blank4=new JLabel("");
        Lmarks=new JLabel("MARKS OBTAINED:");
        Blank=new JLabel("");
        Leng=new JLabel("ENGLISH:");
        eval=new JLabel("-");
        Lmaths=new JLabel("MATHEMATICS:");
        mval=new JLabel("-");
        Lphy=new JLabel("PHYSICS:");
        pval=new JLabel("-");
        Blank1=new JLabel("");
        Blank2=new JLabel("");
        Lper=new JLabel("PERCENTAGE:");
        perval=new JLabel("-");
        Lgrade=new JLabel("GRADE:");
        gradeval=new JLabel("-");
        Blank5=new JLabel("");
        Blank6=new JLabel("");
        Lresult=new JLabel("RESULT:");
        resultval=new JLabel("-");
       
        pnlResult.add(Lrolln);
        pnlResult.add(rval);
        pnlResult.add(Lfname);
        pnlResult.add(fval);
        pnlResult.add(Llname);
        pnlResult.add(lval);
        pnlResult.add(Blank3);
        pnlResult.add(Blank4);
        pnlResult.add(Lmarks);
        pnlResult.add(Blank);
        pnlResult.add(Leng);
        pnlResult.add(eval);
        pnlResult.add(Lmaths);
        pnlResult.add(mval);
        pnlResult.add(Lphy);
        pnlResult.add(pval);
        pnlResult.add(Blank1);
        pnlResult.add(Blank2);
        pnlResult.add(Lper);
        pnlResult.add(perval);
        pnlResult.add(Lgrade);
        pnlResult.add(gradeval);
        pnlResult.add(Blank5);
        pnlResult.add(Blank6);
        pnlResult.add(Lresult);
        pnlResult.add(resultval);
        
        Container cn=frame.getContentPane();
        cn.setLayout(new BoxLayout(cn,BoxLayout.Y_AXIS));
        
        frame.add(pnlInput);
        frame.add(pnlButton);
        frame.add(pnlResult);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
   }
   

    @Override
    public void actionPerformed(ActionEvent evt) {
        
        String action=evt.getActionCommand();
        if(action.equals("ADD"))
        {
            addrecord();
        }
        else if(action.equals("UPDATE"))
        {
            updaterecord();
        }
        else if(action.equals("DELETE"))
        {
            deleterecord();
        }
        else if(action.equals("PREVIOUS"))
        {
            prerecord();
        }
        else if(action.equals("NEXT"))
        {
            nextrecord();
        }
        else if(action.equals("FIRST"))
        {
            firstrecord();
        }
        else if (action.equals("LAST"))
        {
            lastrecord();
        }
        else if(action.equals("CLEAR"))
        {
            clearAll();
        }
    }
  public void addrecord()
  {
      try
      {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/devdb","username","password");
          
           uroll=txtroll.getText();
           ufname=txtfname.getText();
           ulname=txtlname.getText();
           ueng=txtenglish.getText();
           umath=txtmaths.getText();
           uphy=txtphysics.getText();
          
          PreparedStatement st=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?,?)");
          st.setString(1, uroll);
          st.setString(2, ufname);
          st.setString(3, ulname);
          st.setString(4, ueng);
          st.setString(5, umath);
          st.setString(6, uphy);
          
          st.executeUpdate();
          
          
          JOptionPane.showMessageDialog(null,"Record Added Succesfully","Added", JOptionPane.INFORMATION_MESSAGE);
          clearAll();
          
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
      }
  }
  public void updaterecord()
  {
      try
      {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/devdb","username","password");
          
           uroll=txtroll.getText();
           ufname=txtfname.getText();
           ulname=txtlname.getText();
           ueng=txtenglish.getText();
           umath=txtmaths.getText();
           uphy=txtphysics.getText();
           
          
          PreparedStatement st=con.prepareStatement("UPDATE STUDENT SET FNAME=?,LNAME=?,ENGLISH=?,MATHS=?,PHYSICS=? WHERE ROLLN=?");
          st.setString(1,ufname);
          st.setString(2,ulname);
          st.setString(3,ueng);
          st.setString(4,umath);
          st.setString(5,uphy);
          st.setString(6, uroll);
          st.executeUpdate();
          
           JOptionPane.showMessageDialog(null,"Record Updated Succesfully","Updated", JOptionPane.INFORMATION_MESSAGE);
           clearAll();
   
       }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
      }
  }
  
  public void deleterecord()
  {
      try
      {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/devdb","username","password");
          
           uroll=txtroll.getText();
           ufname=txtfname.getText();
           ulname=txtlname.getText();
           ueng=txtenglish.getText();
           umath=txtmaths.getText();
           uphy=txtphysics.getText();
           
           PreparedStatement st=con.prepareStatement("DELETE FROM STUDENT WHERE ROLLN=?");
           st.setString(1, uroll);
           st.executeUpdate();
           
           JOptionPane.showMessageDialog(null,"Record Deleted Succesfully","Deleted", JOptionPane.INFORMATION_MESSAGE);
           clearAll();
           
  }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
      }
  }
  
  public void prerecord()
  {
      try{
          if(rs==null)
          {
              Class.forName("org.apache.derby.jdbc.ClientDriver");
              Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/devdb","username","password");
              
              String sql="SELECT * FROM STUDENT";
              Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
              rs=st.executeQuery(sql);
          }
          if(rs.previous())
          {
              fillvalues();
          }
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      }
  }
  
  public void nextrecord()
  {
      try{
          if(rs==null)
          {
              Class.forName("org.apache.derby.jdbc.ClientDriver");
              Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/devdb","username","password");
              
              String sql="SELECT * FROM STUDENT";
              Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
              rs=st.executeQuery(sql);
          }
          if(rs.next())
          {
              fillvalues();
          }
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      }
  }
  
  public void lastrecord()
  {
      try{
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/devdb","username","password");
          
          String sql="SELECT * FROM STUDENT";
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
          rs=st.executeQuery(sql);
          rs.last();
          fillvalues();
          
          
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      }
      
  }
  
  public void firstrecord()
  {
      try{
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/devdb","username","password");
          
          String sql="SELECT * FROM STUDENT";
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
          rs=st.executeQuery(sql);
          rs.first();
          fillvalues();
          
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      }
  }
  
  public void fillvalues() throws Exception
  {
      
      String Rolln=rs.getString("Rolln");
      String Fname=rs.getString("Fname");
      String Lname=rs.getString("Lname");
      Integer Eng=rs.getInt("English");
      Integer Maths=rs.getInt("Maths");
      Integer Phy=rs.getInt("Physics");
      
      Double s=(Eng+Maths+Phy)/300d;
      Double per=s*100;
      Double f1=Math.ceil(per);
      String perc=f1.toString();
      perval.setText(perc+" %"); 
      
      rval.setText(Rolln);
      fval.setText(Fname);
      lval.setText(Lname);
     String e= Eng.toString();
      eval.setText(e);
     String m=Maths.toString();
      mval.setText(m);
     String p=Phy.toString();
      pval.setText(p);
    
      if(per<100 && per>80)
          gradeval.setText("A");
      else if(per<80 && per>60)
          gradeval.setText("B");
      else if(per<60 && per>40)
          gradeval.setText("C");
      else if(per<40 && per>20)
          gradeval.setText("D");
      else
          gradeval.setText("E");
      
      if(per<100 && per>40)
          resultval.setText("PASS");
      else
          resultval.setText("FAIL"); 
  
      
  }
  
  public void clearAll()
  {
      txtroll.setText("");
      txtfname.setText("");
      txtlname.setText("");
      txtenglish.setText("");
      txtmaths.setText("");
      txtphysics.setText("");
      
  }
}


    