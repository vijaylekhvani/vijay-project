import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Date;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
public class Login extends JFrame implements ActionListener {
JButton login,signup,clear;
JTextField cardnofield;
JPasswordField pinfield;
String formno;
Login(){
setTitle("Automated Teller Machine");
setLayout(null);
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel label=new JLabel(i3);
label.setBounds(70,10,100,100);
add(label);
JLabel text=new JLabel("Welcome to ATM");
text.setFont(new Font("Osword",Font.BOLD,38));
text.setBounds(200,40,400,40);
add(text);

JLabel cardno=new JLabel("Card No :");
cardno.setFont(new Font("Raleway",Font.BOLD,28));
cardno.setBounds(120,150,150,30);
add(cardno);
cardnofield=new JTextField();
cardnofield.setBounds(300,150,230,30);
cardnofield.setFont(new Font("Arial",Font.BOLD,14));
add(cardnofield);

JLabel pin=new JLabel("PIN :");
pin.setFont(new Font("Raleway",Font.BOLD,28));
pin.setBounds(120,220,250,30);
add(pin);
pinfield=new JPasswordField();
pinfield.setBounds(300,220,230,30);
pinfield.setFont(new Font("Arial",Font.BOLD,14));
add(pinfield);

login=new JButton("SIGN IN");
login.setBounds(300,300,100,30);
login.setBackground(Color.BLACK);
login.setForeground(Color.WHITE);
login.addActionListener(this);
add(login);

clear=new JButton("CLEAR");
clear.setBounds(430,300,100,30);
clear.setBackground(Color.BLACK);
clear.setForeground(Color.WHITE);
clear.addActionListener(this);
add(clear);

signup=new JButton("SIGN UP");
signup.setBounds(300,350,230,30);
signup.setBackground(Color.BLACK);
signup.setForeground(Color.WHITE);
signup.addActionListener(this);
add(signup);
getContentPane().setBackground(Color.WHITE);
setSize(800,480);
setVisible(true);
setLocation(350,200);

}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==clear){
cardnofield.setText("");
pinfield.setText("");
}else if(ae.getSource()==login){
Conn conn=new Conn();
String cardnumber=cardnofield.getText();
String pinnumber=pinfield.getText();
String query="select * from login where cardnumber='"+cardnumber+"'and pin='"+pinnumber+"'";
String query1="select * from login where formno";
try{
ResultSet r1=conn.s.executeQuery(query1);
while(r1.next()){
formno=r1.getString("formno");
}
ResultSet rs=conn.s.executeQuery(query);
if(rs.next()){
setVisible(false);
new Transactions(formno).setVisible(true);
}else{
JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
}
}catch(Exception e){
System.out.println(e);
}
}else if(ae.getSource()==signup){
setVisible(false);
new SignupOne().setVisible(true);
}
}
public static void main(String[] args){
new Login();
}
}

							//first signup page
public class SignupOne extends JFrame implements ActionListener{
long random;
JTextField t1,t2,t5,t7,t8,t9,t10;
JDateChooser dateChooser;
JButton next;
JRadioButton male,female,married,unmarried,other;
SignupOne(){
setLayout(null);
Random ran=new Random();
random=Math.abs((ran.nextLong()%9000L)+1000L);
JLabel formno=new JLabel("APPLICATION FORM NO."+random);
formno.setFont(new Font("Raleway",Font.BOLD,38));
formno.setBounds(140,20,800,40);
add(formno);

JLabel pd=new JLabel("Page 1: Personal Details");
pd.setFont(new Font("Raleway",Font.BOLD,22));
pd.setBounds(290,80,400,30);
add(pd);

JLabel name=new JLabel("Name:");
name.setFont(new Font("Raleway",Font.BOLD,20));
name.setBounds(100,140,200,30);
add(name);
t1=new JTextField();
t1.setFont(new Font("Raleway",Font.BOLD,14));
t1.setBounds(300,140,400,30);
add(t1);

JLabel fname=new JLabel("Father's Name:");
fname.setFont(new Font("Raleway",Font.BOLD,20));
fname.setBounds(100,190,200,30);
add(fname);
t2=new JTextField();
t2.setFont(new Font("Raleway",Font.BOLD,14));
t2.setBounds(300,190,400,30);
add(t2);

JLabel dob=new JLabel("Date of Birth:");
dob.setFont(new Font("Raleway",Font.BOLD,20));
dob.setBounds(100,240,200,30);
add(dob);
dateChooser=new JDateChooser();
dateChooser.setBounds(300,240,400,30);
add(dateChooser);

JLabel gender=new JLabel("Gender:");
gender.setFont(new Font("Raleway",Font.BOLD,20));
gender.setBounds(100,290,200,30);
add(gender);
male=new JRadioButton("Male");
male.setBounds(300,290,60,30);
male.setBackground(Color.WHITE);
add(male);
female=new JRadioButton("Female");
female.setBounds(450,290,120,30);
female.setBackground(Color.WHITE);
add(female);
ButtonGroup btn=new ButtonGroup();
btn.add(male);
btn.add(female);

JLabel email=new JLabel("Email Address:");
email.setFont(new Font("Raleway",Font.BOLD,20));
email.setBounds(100,340,200,30);
add(email);
t5=new JTextField();
t5.setFont(new Font("Raleway",Font.BOLD,14));
t5.setBounds(300,340,400,30);
add(t5);

JLabel marital=new JLabel("Marital Status:");
marital.setFont(new Font("Raleway",Font.BOLD,20));
marital.setBounds(100,390,200,30);
add(marital);
married=new JRadioButton("Married");
married.setBounds(300,390,100,30);
married.setBackground(Color.WHITE);
add(married);
unmarried=new JRadioButton("Unmarried");
unmarried.setBounds(450,390,100,30);
unmarried.setBackground(Color.WHITE);
add(unmarried);
other=new JRadioButton("Other");
other.setBounds(600,390,100,30);
other.setBackground(Color.WHITE);
add(other);
ButtonGroup btn2=new ButtonGroup();
btn2.add(married);
btn2.add(unmarried);
btn2.add(other);

JLabel address=new JLabel("Address:");
address.setFont(new Font("Raleway",Font.BOLD,20));
address.setBounds(100,440,200,30);
add(address);
t7=new JTextField();
t7.setFont(new Font("Raleway",Font.BOLD,14));
t7.setBounds(300,440,400,30);
add(t7);

JLabel city=new JLabel("City:");
city.setFont(new Font("Raleway",Font.BOLD,20));
city.setBounds(100,490,200,30);
add(city);
t8=new JTextField();
t8.setFont(new Font("Raleway",Font.BOLD,14));
t8.setBounds(300,490,400,30);
add(t8);

JLabel state=new JLabel("State:");
state.setFont(new Font("Raleway",Font.BOLD,20));
state.setBounds(100,540,200,30);
add(state);
t9=new JTextField();
t9.setFont(new Font("Raleway",Font.BOLD,14));
t9.setBounds(300,540,400,30);
add(t9);

JLabel pincode=new JLabel("Pin Code:");
pincode.setFont(new Font("Raleway",Font.BOLD,20));
pincode.setBounds(100,590,200,30);
add(pincode);
t10=new JTextField();
t10.setFont(new Font("Raleway",Font.BOLD,14));
t10.setBounds(300,590,400,30);
add(t10);

next=new JButton("Next");
next.setBackground(Color.BLACK);
next.setForeground(Color.WHITE);
next.setFont(new Font("Raleway",Font.BOLD,14));
next.setBounds(620,660,80,30);
next.addActionListener(this);
add(next);

getContentPane().setBackground(Color.WHITE);
setSize(850,800);
setLocation(350,10);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
String formno=""+random;
String name=t1.getText();
String fname=t2.getText();
String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
String gender=null;
if(male.isSelected()){
gender="Male";
}else if(female.isSelected()){
gender="Female";
}
String email=t5.getText();
String marital=null;
if(married.isSelected()){
marital="Married";
}else if(unmarried.isSelected()){
marital="Unmarried";
}else if(other.isSelected()){
marital="Other";
}
String address=t7.getText();
String city=t8.getText();
String state=t9.getText();
String pin=t10.getText();

try{
if(name.equals("")){
JOptionPane.showMessageDialog(null,"Name is required");
}else if(fname.equals("")){
JOptionPane.showMessageDialog(null,"Father's Name is required");
}else if(email.equals("")){
JOptionPane.showMessageDialog(null,"Email is required");
}else if(address.equals("")){
JOptionPane.showMessageDialog(null,"Address is required");
}else if(city.equals("")){
JOptionPane.showMessageDialog(null,"City is required");
}else if(state.equals("")){
JOptionPane.showMessageDialog(null,"State is required");
}else if(pin.equals("")){
JOptionPane.showMessageDialog(null,"Pin is required");
}else if(pin.length()!=6){
JOptionPane.showMessageDialog(null,"PIN is incorrect");
}
else{
Conn c=new Conn();
String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
c.s.executeUpdate(query);
setVisible(false);
new SignupTwo(formno).setVisible(true);
}
}catch(Exception e){
System.out.println(e);
}
}
public static void main(String args[]){
new SignupOne();
}
}

						//signup page 2
public class SignupTwo extends JFrame implements ActionListener{
JTextField pan,adhar;
JComboBox religion,category,income,qualification,occupation;
JButton next;
JRadioButton sno,syes,eyes,eno;
String formno;
SignupTwo(String formno){
this.formno=formno;
setLayout(null);
setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
JLabel ad=new JLabel("Page 2: Additional Details");
ad.setFont(new Font("Raleway",Font.BOLD,22));
ad.setBounds(290,80,400,30);
add(ad);

JLabel rel=new JLabel("Religion:");
rel.setFont(new Font("Raleway",Font.BOLD,20));
rel.setBounds(100,140,200,30);
add(rel);
String valRiligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
religion=new JComboBox(valRiligion);
religion.setBounds(300,140,400,30);
religion.setBackground(Color.WHITE);
add(religion);

JLabel cat=new JLabel("Category:");
cat.setFont(new Font("Raleway",Font.BOLD,20));
cat.setBounds(100,190,200,30);
add(cat);
String valCategory[]={"SC","ST","URL","OBC","Other"};
category=new JComboBox(valCategory);
category.setBounds(300,190,400,30);
category.setBackground(Color.WHITE);
add(category);

JLabel in=new JLabel("Income:");
in.setFont(new Font("Raleway",Font.BOLD,20));
in.setBounds(100,240,200,30);
add(in);
String valIncome[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
income=new JComboBox(valIncome);
income.setBounds(300,240,400,30);
income.setBackground(Color.WHITE);
add(income);

JLabel edu=new JLabel("Educational");
edu.setFont(new Font("Raleway",Font.BOLD,20));
edu.setBounds(100,290,200,30);
add(edu);
JLabel qua=new JLabel("Qualification:");
qua.setFont(new Font("Raleway",Font.BOLD,20));
qua.setBounds(100,315,200,30);
add(qua);
String valQualification[]={"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
qualification=new JComboBox(valQualification);
qualification.setBounds(300,315,400,30);
qualification.setBackground(Color.WHITE);
add(qualification);

JLabel occu=new JLabel("Occupation:");
occu.setFont(new Font("Raleway",Font.BOLD,20));
occu.setBounds(100,390,200,30);
add(occu);
String valOccupation[]={"Salaried","Self-Employed","Businessman","Student","Retired","Others"};
occupation=new JComboBox(valOccupation);
occupation.setBounds(300,390,400,30);
occupation.setBackground(Color.WHITE);
add(occupation);


JLabel pn=new JLabel("Phone No.:");
pn.setFont(new Font("Raleway",Font.BOLD,20));
pn.setBounds(100,440,200,30);
add(pn);
pan=new JTextField();
pan.setFont(new Font("Raleway",Font.BOLD,14));
pan.setBounds(300,440,400,30);
add(pan);

JLabel an=new JLabel("Adhar No.:");
an.setFont(new Font("Raleway",Font.BOLD,20));
an.setBounds(100,490,200,30);
add(an);
adhar=new JTextField();
adhar.setFont(new Font("Raleway",Font.BOLD,14));
adhar.setBounds(300,490,400,30);
add(adhar);

JLabel sc=new JLabel("Senior Citizen:");
sc.setFont(new Font("Raleway",Font.BOLD,20));
sc.setBounds(100,540,200,30);
add(sc);
syes=new JRadioButton("Yes");
syes.setBounds(300,540,60,30);
syes.setBackground(Color.WHITE);
add(syes);
sno=new JRadioButton("No");
sno.setBounds(450,540,120,30);
sno.setBackground(Color.WHITE);
add(sno);
ButtonGroup btn=new ButtonGroup();
btn.add(syes);
btn.add(sno);

JLabel ea=new JLabel("Exisiting Account:");
ea.setFont(new Font("Raleway",Font.BOLD,20));
ea.setBounds(100,590,200,30);
add(ea);
eyes=new JRadioButton("Yes");
eyes.setBounds(300,590,60,30);
eyes.setBackground(Color.WHITE);
add(eyes);
eno=new JRadioButton("No");
eno.setBounds(450,590,120,30);
eno.setBackground(Color.WHITE);
add(eno);
ButtonGroup btn2=new ButtonGroup();
btn2.add(eyes);
btn2.add(eno);

next=new JButton("Next");
next.setBackground(Color.BLACK);
next.setForeground(Color.WHITE);
next.setFont(new Font("Raleway",Font.BOLD,14));
next.setBounds(620,660,80,30);
next.addActionListener(this);
add(next);

getContentPane().setBackground(Color.WHITE);
setSize(850,800);
setLocation(350,10);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
String re=(String)religion.getSelectedItem();
String ca=(String)category.getSelectedItem();
String qu=(String)qualification.getSelectedItem();
String in=(String)income.getSelectedItem();
String oc=(String)occupation.getSelectedItem();
String sc=null;
if(syes.isSelected()){
sc="Yes";
}else if(sno.isSelected()){
sc="No";
}
String i=(String)income.getSelectedItem();
String ea=null;
if(eyes.isSelected()){
ea="Yes";
}else if(eno.isSelected()){
ea="No";
}
String pa=pan.getText();
String adh=adhar.getText();

try{
if(pa.equals("")){
JOptionPane.showMessageDialog(null,"Phone is required");
}else if(pa.length()!=10){
JOptionPane.showMessageDialog(null,"Phone is Incorrect");
}else if(adh.equals("")){
JOptionPane.showMessageDialog(null,"Adhar is required");
}else if(adh.length()!=12){
JOptionPane.showMessageDialog(null,"Adhar is Incorrect");
}else{
Conn c=new Conn();
String query2="insert into signuptwo values('"+formno+"','"+re+"','"+ca+"','"+qu+"','"+in+"','"+oc+"','"+pa+"','"+adh+"','"+sc+"','"+ea+"')";
c.s.executeUpdate(query2);
setVisible(false);
new SignupThree(formno).setVisible(true);
}
}catch(Exception e){
System.out.println(e);
}
}
public static void main(String args[]){
new SignupTwo("");
}
}

							//Signup page 3
public class SignupThree extends JFrame implements ActionListener{
JRadioButton r1,r2,r3,r4;
JCheckBox c1,c2,c3,c4,c5,c6,c7;
JButton submit;
String formno;
SignupThree(String formno){
this.formno=formno;
setLayout(null);
JLabel li=new JLabel("Page 3: Account Details");
li.setFont(new Font("Raleway",Font.BOLD,22));
li.setBounds(280,40,400,40);
add(li);

JLabel type=new JLabel("Account Type");
type.setFont(new Font("Raleway",Font.BOLD,22));
type.setBounds(100,140,200,30);
add(type);
r1=new JRadioButton("Saving Account");
r1.setFont(new Font("Raleway",Font.BOLD,16));
r1.setBackground(Color.WHITE);
r1.setBounds(100,180,150,20);
add(r1);
r2=new JRadioButton("Fixed Deposite Account");
r2.setFont(new Font("Raleway",Font.BOLD,16));
r2.setBackground(Color.WHITE);
r2.setBounds(350,180,250,20);
add(r2);
r3=new JRadioButton("Current Account");
r3.setFont(new Font("Raleway",Font.BOLD,16));
r3.setBackground(Color.WHITE);
r3.setBounds(100,220,150,20);
add(r3);
r4=new JRadioButton("Recurring Deposite Account");
r4.setFont(new Font("Raleway",Font.BOLD,16));
r4.setBackground(Color.WHITE);
r4.setBounds(350,220,250,20);
add(r4);

ButtonGroup groupaccount=new ButtonGroup();
groupaccount.add(r1);
groupaccount.add(r2);
groupaccount.add(r3);
groupaccount.add(r4);

JLabel card=new JLabel("Card Number:");
card.setFont(new Font("Raleway",Font.BOLD,22));
card.setBounds(100,300,200,30);
add(card);

JLabel number=new JLabel("xxxx-xxxx-xxxx-4104");
number.setFont(new Font("Raleway",Font.BOLD,22));
number.setBounds(330,300,300,30);
add(number);

JLabel carddetail=new JLabel("Your 16 Digit Card Number");
carddetail.setFont(new Font("Raleway",Font.BOLD,12));
carddetail.setBounds(100,330,300,20);
add(carddetail);

JLabel pin=new JLabel("PIN:");
pin.setFont(new Font("Raleway",Font.BOLD,22));
pin.setBounds(100,370,200,30);
add(pin);

JLabel pnumber=new JLabel("xxxx");
pnumber.setFont(new Font("Raleway",Font.BOLD,22));
pnumber.setBounds(330,370,300,30);
add(pnumber);

JLabel pindetail=new JLabel("Your 4 Digit PIN");
pindetail.setFont(new Font("Raleway",Font.BOLD,12));
pindetail.setBounds(100,400,300,20);
add(pindetail);

JLabel services=new JLabel("Services Required:");
services.setFont(new Font("Raleway",Font.BOLD,22));
services.setBounds(100,450,400,30);
add(services);

c1=new JCheckBox("ATM CARD");
c1.setBackground(Color.WHITE);
c1.setFont(new Font("Raleway",Font.BOLD,16));
c1.setBounds(100,500,200,30);
add(c1);

c2=new JCheckBox("Internet Banking");
c2.setBackground(Color.WHITE);
c2.setFont(new Font("Raleway",Font.BOLD,16));
c2.setBounds(350,500,200,30);
add(c2);

c3=new JCheckBox("Mobile Banking");
c3.setBackground(Color.WHITE);
c3.setFont(new Font("Raleway",Font.BOLD,16));
c3.setBounds(100,550,200,30);
add(c3);

c4=new JCheckBox("EMAIL & SMS Alerts");
c4.setBackground(Color.WHITE);
c4.setFont(new Font("Raleway",Font.BOLD,16));
c4.setBounds(350,550,200,30);
add(c4);

c5=new JCheckBox("Cheque Book");
c5.setBackground(Color.WHITE);
c5.setFont(new Font("Raleway",Font.BOLD,16));
c5.setBounds(100,600,200,30);
add(c5);

c6=new JCheckBox("E-Statement");
c6.setBackground(Color.WHITE);
c6.setFont(new Font("Raleway",Font.BOLD,16));
c6.setBounds(350,600,200,30);
add(c6);

c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
c7.setBackground(Color.WHITE);
c7.setFont(new Font("Raleway",Font.BOLD,12));
c7.setBounds(100,680,600,30);
add(c7);

submit=new JButton("SUBMIT");
submit.setBackground(Color.BLACK);
submit.setForeground(Color.WHITE);
submit.setFont(new Font("Raleway",Font.BOLD,14));
submit.setBounds(350,720,100,30);
submit.addActionListener(this);
add(submit);


getContentPane().setBackground(Color.WHITE);

setSize(850,820);
setLocation(350,0);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==submit){
String accounttype=null;
if(r1.isSelected()){
accounttype="Saving Account";
}else if(r2.isSelected()){
accounttype="Fixed Deposite Account";
}else if(r3.isSelected()){
accounttype="Current Account";
}else if(r4.isSelected()){
accounttype="Recurring Deposite Account";
}
Random random=new Random();
String cardnumber=""+Math.abs((random.nextLong()%9000000L)+5040936000000000L);
String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000l);
String facility="";
if(c1.isSelected()){
facility=facility+" ATM Card";
}else if(c2.isSelected()){
facility=facility+" Internet Banking";
}else if(c3.isSelected()){
facility=facility+" Mobile Banking";
}else if(c4.isSelected()){
facility=facility+" EMAIL & SMS Alerts";
}else if(c5.isSelected()){
facility=facility+" Chaque Book";
}else if(c6.isSelected()){
facility=facility+" E-Statement";
}
if(ae.getSource()==submit){
try{
if(accounttype.equals("")){
JOptionPane.showMessageDialog(null,"Account Type is Required");
}else {
Conn c=new Conn();
String query3="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
String query4="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
c.s.executeUpdate(query3);
c.s.executeUpdate(query4);
JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\n PIN:"+pinnumber);
setVisible(false);
new Login().setVisible(true);
}
}catch(Exception e){
System.out.println(e);
}
}
}
}
public static void main(String[] args){
new SignupThree("");
}
}

								//connection
public class Conn{
Connection c;
Statement s;
public Conn(){
try{
c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","vijay");
s=c.createStatement();
}catch(Exception e){
System.out.println(e);
}
}
public static void main(String[] args){
new Conn();
}
}		
								//Transaction page
public class Transactions extends JFrame implements ActionListener{
JButton deposite,withdrawl,fastcash,statement,pinchange,balanceenquiry,exit;
String formno;
Transactions(String formno){
this.formno=formno;
setLayout(null);
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);

JLabel text=new JLabel("Please Select Your Transaction");
text.setBounds(210,300,700,35);
text.setForeground(Color.WHITE);
text.setFont(new Font("Raleway",Font.BOLD,16));
image.add(text);

deposite=new JButton("Deposite");
deposite.setBounds(170,415,150,30);
deposite.addActionListener(this);
image.add(deposite);

withdrawl=new JButton("Cash Withdrawl");
withdrawl.setBounds(355,415,150,30);
withdrawl.addActionListener(this);
image.add(withdrawl);

fastcash=new JButton("Fast Cash");
fastcash.setBounds(170,450,150,30);
fastcash.addActionListener(this);
image.add(fastcash);

statement=new JButton("Mini Statement");
statement.setBounds(355,450,150,30);
statement.addActionListener(this);
image.add(statement);

pinchange=new JButton("Pin Change");
pinchange.setBounds(170,485,150,30);
pinchange.addActionListener(this);
image.add(pinchange);

balanceenquiry=new JButton("Balance Enquiry");
balanceenquiry.setBounds(355,485,150,30);
balanceenquiry.addActionListener(this);
image.add(balanceenquiry);

exit=new JButton("Exit");
exit.setBounds(355,520,150,30);
exit.addActionListener(this);
image.add(exit);

setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==exit){
System.exit(0);
}else if(ae.getSource()==deposite){
setVisible(false);
new Deposite(formno).setVisible(true);
}else if(ae.getSource()==withdrawl){
setVisible(false);
new Withdrawl(formno).setVisible(true);
}else if(ae.getSource()==fastcash){
setVisible(false);
new FastCash(formno).setVisible(true);
}else if(ae.getSource()==pinchange){
setVisible(false);
new PinChange(formno).setVisible(true);
}else if(ae.getSource()==balanceenquiry){
setVisible(false);
new BalanceEnquiry(formno).setVisible(true);
}else if(ae.getSource()==statement){
new MiniStatement(formno).setVisible(true);
}
}
public static void main(String[] args){
new Transactions("");
}
}

								//Deposite page
public class Deposite extends JFrame implements ActionListener{
JButton deposite,back;
JTextField amount;
String formno;
Deposite(String formno){
this.formno=formno;
setLayout(null);
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);

JLabel text=new JLabel("Enter Your Ammount");
text.setForeground(Color.WHITE);
text.setBounds(170,300,400,20);
text.setFont(new Font("Raleway",Font.BOLD,16));
image.add(text);
amount=new JTextField();
amount.setFont(new Font("Raleway",Font.BOLD,22));
amount.setBounds(170,350,320,30);
image.add(amount);

deposite=new JButton("Deposite");
deposite.setBounds(355,485,150,30);
deposite.addActionListener(this);
image.add(deposite);

back=new JButton("Back");
back.setBounds(355,520,150,30);
back.addActionListener(this);
image.add(back);

setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==deposite){
String number=amount.getText();
Date date=new Date();
if(number.equals("")){
JOptionPane.showMessageDialog(null, "Please Enter The Ammount");
}else{
try{
Conn conn=new Conn();
String query="insert into bank values('"+formno+"','"+date+"','deposite','"+number+"')";
conn.s.executeUpdate(query);
JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
setVisible(false);
new Transactions(formno).setVisible(true);
}catch(Exception e){
System.out.println(e);
}
}
}else if(ae.getSource()==back){
setVisible(false);
new Transactions(formno).setVisible(true);
}
}
public static void main(String[] args){
new Deposite("");
}
}
				
							//withdrawl page
public class Withdrawl extends JFrame implements ActionListener{
JButton withdrawl,back;
JTextField amount;
String formno;
Withdrawl( String formno){
this.formno=formno;
setLayout(null);
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);

JLabel text=new JLabel("Enter Your Ammount");
text.setForeground(Color.WHITE);
text.setBounds(170,300,400,20);
text.setFont(new Font("Raleway",Font.BOLD,16));
image.add(text);
amount=new JTextField();
amount.setFont(new Font("Raleway",Font.BOLD,22));
amount.setBounds(170,350,320,30);
image.add(amount);

withdrawl=new JButton("Withdrawl");
withdrawl.setBounds(355,485,150,30);
withdrawl.addActionListener(this);
image.add(withdrawl);

back=new JButton("Back");
back.setBounds(355,520,150,30);
back.addActionListener(this);
image.add(back);

setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==withdrawl){
String number=amount.getText();
Date date=new Date();
if(number.equals("")){
JOptionPane.showMessageDialog(null, "Please Enter The Ammount");
}else{
try{
Conn conn=new Conn();
ResultSet rs=conn.s.executeQuery("select * from bank where formno='"+formno+"'");
int balance=0;
while(rs.next()){
if(rs.getString("type").equals("deposite")){
balance+=Integer.parseInt(rs.getString("amount"));
}else{
balance-=Integer.parseInt(rs.getString("amount"));
}
}
if(ae.getSource()!=back && balance <Integer.parseInt(number)){
JOptionPane.showMessageDialog(null,"Insufficient Balace");
return;
}
String query="insert into bank values('"+formno+"','"+date+"','Withdrawl','"+number+"')";
conn.s.executeUpdate(query);
JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawled Successfully");
setVisible(false);
new Transactions(formno).setVisible(true);
}catch(Exception e){
System.out.println(e);
}
}
}else if(ae.getSource()==back){
setVisible(false);
new Transactions(formno).setVisible(true);
}
}
public static void main(String[] args){
new Withdrawl("");
}
}

								//Fast Cash page
public class FastCash extends JFrame implements ActionListener{
JButton deposite,withdrawl,fastcash,statement,pinchange,balanceenquiry,exit;
String formno;
FastCash(String formno){
this.formno=formno;
setLayout(null);
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);

JLabel text=new JLabel("Select Withdrawl Ammount");
text.setBounds(210,300,700,35);
text.setForeground(Color.WHITE);
text.setFont(new Font("Raleway",Font.BOLD,16));
image.add(text);

deposite=new JButton("Rs 100");
deposite.setBounds(170,415,150,30);
deposite.addActionListener(this);
image.add(deposite);

withdrawl=new JButton("Rs 500");
withdrawl.setBounds(355,415,150,30);
withdrawl.addActionListener(this);
image.add(withdrawl);

fastcash=new JButton("Rs 1000");
fastcash.setBounds(170,450,150,30);
fastcash.addActionListener(this);
image.add(fastcash);

statement=new JButton("Rs 2000");
statement.setBounds(355,450,150,30);
statement.addActionListener(this);
image.add(statement);

pinchange=new JButton("Rs 5000");
pinchange.setBounds(170,485,150,30);
pinchange.addActionListener(this);
image.add(pinchange);

balanceenquiry=new JButton("Rs 10000");
balanceenquiry.setBounds(355,485,150,30);
balanceenquiry.addActionListener(this);
image.add(balanceenquiry);

exit=new JButton("BACK");
exit.setBounds(355,520,150,30);
exit.addActionListener(this);
image.add(exit);

setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==exit){
setVisible(false);
new Transactions(formno).setVisible(true);
}else{
String amount=((JButton)ae.getSource()).getText().substring(3);
Conn c=new Conn();
try{
ResultSet rs=c.s.executeQuery("select * from bank where formno='"+formno+"'");
int balance=0;
while(rs.next()){
if(rs.getString("type").equals("deposite")){
balance+=Integer.parseInt(rs.getString("amount"));
}else{
balance-=Integer.parseInt(rs.getString("amount"));
}
}
if(ae.getSource()!=exit && balance <Integer.parseInt(amount)){
JOptionPane.showMessageDialog(null,"Insufficient Balace");
return;
}
Date date=new Date();
String query="insert into bank values('"+formno+"','"+date+"','Withdrawl','"+amount+"')";
c.s.executeUpdate(query);
JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawled Successfully");
setVisible(false);
new Transactions(formno).setVisible(true);
}catch(Exception e){
System.out.println(e);
}
}
}
public static void main(String[] args){
new FastCash("");
}
}

							//PIN Change page
public class PinChange extends JFrame implements ActionListener{
JPasswordField pin,repin;
JButton change,back;
String formno;
PinChange(String formno){
setLayout(null);
this.formno=formno;
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);

JLabel text=new JLabel("Change Your PIN");
text.setBounds(250,280,500,35);
text.setForeground(Color.WHITE);
text.setFont(new Font("Raleway",Font.BOLD,16));
image.add(text);

JLabel pintext=new JLabel("New PIN:");
pintext.setBounds(165,320,180,25);
pintext.setForeground(Color.WHITE);
pintext.setFont(new Font("Raleway",Font.BOLD,16));
image.add(pintext);

pin=new JPasswordField();
pin.setFont(new Font("Raleway",Font.BOLD,22));
pin.setBounds(330,320,180,25);
image.add(pin);

JLabel repintext=new JLabel("Re-Enter New PIN:");
repintext.setBounds(165,360,180,25);
repintext.setForeground(Color.WHITE);
repintext.setFont(new Font("Raleway",Font.BOLD,16));
image.add(repintext);

repin=new JPasswordField();
repin.setFont(new Font("Raleway",Font.BOLD,22));
repin.setBounds(330,360,180,25);
image.add(repin);

change=new JButton("CHANGE");
change.setBounds(355,485,150,30);
change.addActionListener(this);
image.add(change);

back=new JButton("BACK");
back.setBounds(355,520,150,30);
back.addActionListener(this);
image.add(back);

setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==change){
try{
String npin=pin.getText();
String rpin=repin.getText();
if(!npin.equals(rpin)){
JOptionPane.showMessageDialog(null,"Entered PIN Does Not Match");
return;
}
if(npin.equals("")){
JOptionPane.showMessageDialog(null,"Please Enter New PIN");
return;
}
if(rpin.equals("")){
JOptionPane.showMessageDialog(null,"Please Enter Re-PIN");
return;
}
Conn conn=new Conn();
String query2="update login set pin='"+rpin+"' where formno='"+formno+"'";
String query3="update signupthree set pin='"+rpin+"' where formno='"+formno+"'";
conn.s.executeUpdate(query2);
conn.s.executeUpdate(query3);
JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
}catch(Exception e){
System.out.println(e);
}
}else{
setVisible(false);
new Transactions(formno).setVisible(true);
}
}
public static void main(String[] args){
new PinChange("").setVisible(true);
}
}

							//Balance Enquiry
public class BalanceEnquiry extends JFrame implements ActionListener{
String formno;
JButton back;
BalanceEnquiry(String formno){
setLayout(null);
this.formno=formno;
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);

back=new JButton("BACK");
back.setBounds(355,520,150,30);
back.addActionListener(this);
image.add(back);

Conn c=new Conn();
int balance=0;
try{
ResultSet rs=c.s.executeQuery("select * from bank where formno='"+formno+"'");
while(rs.next()){
if(rs.getString("type").equals("deposite")){
balance+=Integer.parseInt(rs.getString("amount"));
}else{
balance-=Integer.parseInt(rs.getString("amount"));
}
}
}catch(Exception e){
System.out.println(e);
}

JLabel text=new JLabel("Your Current Account Balance is Rs "+balance);
text.setBounds(170,300,400,20);
text.setForeground(Color.WHITE);
image.add(text);

setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
setVisible(false);
new Transactions(formno).setVisible(true);
}
public static void main(String[] args){
new BalanceEnquiry("");
}
}

							//mini statement
public class MiniStatement extends JFrame{
String formno;
MiniStatement(String formno){
this.formno=formno;
setTitle("Mini Statement");
setLayout(null);

JLabel mini=new JLabel();
add(mini);

JLabel bank=new JLabel("Indian Bank");
bank.setBounds(150,20,100,20);
add(bank);

JLabel card=new JLabel();
card.setBounds(20,80,300,20);
add(card);

JLabel balance=new JLabel();
balance.setBounds(20,400,300,20);
add(balance);

try{
Conn conn=new Conn();
ResultSet rs=conn.s.executeQuery("select * from login where formno='"+formno+"'");
while(rs.next()){
card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
}
}catch(Exception e){
System.out.println(e);
}

try{
Conn conn=new Conn();
int bal=0;
ResultSet rs=conn.s.executeQuery("select * from bank where formno='"+formno+"'");
while(rs.next()){
mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
if(rs.getString("type").equals("deposite")){
bal+=Integer.parseInt(rs.getString("amount"));
}else{
bal-=Integer.parseInt(rs.getString("amount"));
}
}
balance.setText("Your Current Balance is Rs "+bal);
}catch(Exception e){
System.out.println(e);
}
mini.setBounds(20,140,400,200);

setSize(400,600);
setLocation(20,20);
getContentPane().setBackground(Color.WHITE);
setVisible(true);
}
public static void main(String[] args){
new MiniStatement("");
}
}