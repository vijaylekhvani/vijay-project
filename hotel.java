import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
JButton next;
HotelManagementSystem(){
setLayout(null);
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
JLabel image=new JLabel(i1);
image.setBounds(0,0,1366,565);
add(image);

JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
text.setBounds(20,430,1000,90);
text.setForeground(Color.WHITE);
text.setFont(new Font("Raleway",Font.BOLD,50));
image.add(text);

next=new JButton("NEXT");
next.setBackground(Color.WHITE);
next.setBounds(1150,450,150,50);
next.setFont(new Font("Raleway",Font.BOLD,24));
next.addActionListener(this);
image.add(next);

setSize(1366,565);
setLocation(100,100);
setVisible(true);
while(true){
text.setVisible(false);
try{
Thread.sleep(500);
}catch(Exception e){
System.out.println(e);
}
text.setVisible(true);
try{
Thread.sleep(500);
}catch(Exception e){
System.out.println(e);
}
}
}
public void actionPerformed(ActionEvent ae){
setVisible(false);
new Login();
}
public static void main(String[] args){
new HotelManagementSystem();
}
}

									//Login page
public class Login extends JFrame implements ActionListener{
JButton login,cancel;
JTextField user;
JPasswordField pass;
Login(){
setLayout(null);
JLabel username=new JLabel("Username:");
username.setBounds(50,50,100,30);
username.setFont(new Font("Raleway",Font.BOLD,16));
add(username);
user=new JTextField();
user.setBounds(200,50,200,30);
user.setFont(new Font("Raleway",Font.BOLD,16));
add(user);

JLabel password=new JLabel("Password:");
password.setBounds(50,120,100,30);
password.setFont(new Font("Raleway",Font.BOLD,16));
add(password);
pass=new JPasswordField();
pass.setBounds(200,120,200,30);
pass.setFont(new Font("Raleway",Font.BOLD,16));
add(pass);

login=new JButton("LOGIN");
login.setBounds(50,200,170,40);
login.setFont(new Font("Raleway",Font.BOLD,16));
login.setBackground(Color.BLACK);
login.setForeground(Color.WHITE);
login.addActionListener(this);
add(login);

cancel=new JButton("CANCEL");
cancel.setBounds(240,200,170,40);
cancel.setFont(new Font("Raleway",Font.BOLD,16));
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
cancel.addActionListener(this);
add(cancel);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel label=new JLabel(i3);
label.setBounds(450,50,200,200);
add(label);

setSize(700,350);
setLocation(350,200);
getContentPane().setBackground(Color.WHITE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==login){
String username=user.getText();
String password=pass.getText();
try{
Conn conn=new Conn();
String query="select * from login where username='"+username+"' and password='"+password+"'";
ResultSet rs=conn.s.executeQuery(query);
if(rs.next()){
setVisible(false);
new Dashboard();
}else{
JOptionPane.showMessageDialog(null,"Username and Password is Incorrect");
}
}catch(Exception e){
System.out.println(e);
}
}else if(ae.getSource()==cancel){
System.exit(0);
}
}
public static void main(String[] args){
new Login();
}
}

								// Deshboard page
public class Dashboard extends JFrame implements ActionListener{
JMenuItem addemployee,addrooms,adddrivers,reception;
Dashboard(){
setLayout(null);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel label=new JLabel(i3);
label.setBounds(0,0,1550,1000);
add(label);

JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
text.setBounds(400,80,1000,50);
text.setFont(new Font("Raleway",Font.BOLD,45));
text.setForeground(Color.WHITE);
label.add(text);

JMenuBar mb=new JMenuBar();
mb.setBounds(0,0,1550,30);
label.add(mb);

JMenu hotel=new JMenu("HOTEL MANAGEMENT");
hotel.setForeground(Color.RED);
mb.add(hotel);
reception=new JMenuItem("RECEPTION");
reception.addActionListener(this);
hotel.add(reception);

JMenu admin=new JMenu("ADMIN");
admin.setForeground(Color.BLUE);
mb.add(admin);
addemployee=new JMenuItem("ADD EMPLOYEE");
addemployee.addActionListener(this);
admin.add(addemployee);
addrooms=new JMenuItem("ADD ROOMS");
addrooms.addActionListener(this);
admin.add(addrooms);
adddrivers=new JMenuItem("ADD DRIVERS");
adddrivers.addActionListener(this);
admin.add(adddrivers);

setBounds(0,0,1550,1000);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==addemployee){
new AddEmployee();
}else if(ae.getSource()==addrooms){
new AddRooms();
}else if(ae.getSource()==adddrivers){
new AddDrivers();
}else if(ae.getSource()==reception){
new Reception();
}
}
public static void main(String[] args){
new Dashboard();
}
}

							//connection
public class Conn{
Connection c;
Statement s;
public Conn(){
try{
c=DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","vijay");
s=c.createStatement();
}catch(Exception e){
System.out.println(e);
}
}
public static void main(String[] args){
new Conn();
}
}

							//Add Employee page
public class AddEmployee extends JFrame implements ActionListener{
JButton submit;
JTextField nfield,afield,sfield,adfield,pfield,efield;
JComboBox jfield;
JRadioButton male,female;
AddEmployee(){
setLayout(null);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel label=new JLabel(i3);
label.setBounds(450,80,400,400);
add(label);

JLabel title=new JLabel("ADD EMPLOYEE DETAILS");
title.setBounds(300,10,400,30);
title.setFont(new Font("Raleway",Font.BOLD,28));
title.setForeground(Color.BLUE);
add(title);

JLabel name=new JLabel("NAME:");
name.setBounds(70,50,100,30);
name.setFont(new Font("Raleway",Font.BOLD,18));
add(name);
nfield=new JTextField();
nfield.setBounds(200,50,200,30);
nfield.setFont(new Font("Raleway",Font.BOLD,16));
add(nfield);

JLabel age=new JLabel("AGE:");
age.setBounds(70,100,100,30);
age.setFont(new Font("Raleway",Font.BOLD,18));
add(age);
afield=new JTextField();
afield.setBounds(200,100,200,30);
afield.setFont(new Font("Raleway",Font.BOLD,16));
add(afield);

JLabel gender=new JLabel("GENDER:");
gender.setBounds(70,150,100,30);
gender.setFont(new Font("Raleway",Font.BOLD,18));
add(gender);
male=new JRadioButton("MALE");
male.setBounds(200,150,60,30);
male.setBackground(Color.WHITE);
add(male);
female=new JRadioButton("FEMALE");
female.setBounds(330,150,120,30);
female.setBackground(Color.WHITE);
add(female);
ButtonGroup btn=new ButtonGroup();
btn.add(male);
btn.add(female);

JLabel job=new JLabel("JOB:");
job.setBounds(70,200,100,30);
job.setFont(new Font("Raleway",Font.BOLD,18));
add(job);
String jobValue[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waiteress","Manager","Accountent"};
jfield=new JComboBox(jobValue);
jfield.setBounds(200,200,200,30);
jfield.setBackground(Color.WHITE);
add(jfield);

JLabel salary=new JLabel("SALARY:");
salary.setBounds(70,250,100,30);
salary.setFont(new Font("Raleway",Font.BOLD,18));
add(salary);
sfield=new JTextField();
sfield.setBounds(200,250,200,30);
sfield.setFont(new Font("Raleway",Font.BOLD,16));
add(sfield);

JLabel phone=new JLabel("PHONE:");
phone.setBounds(70,300,100,30);
phone.setFont(new Font("Raleway",Font.BOLD,18));
add(phone);
pfield=new JTextField();
pfield.setBounds(200,300,200,30);
pfield.setFont(new Font("Raleway",Font.BOLD,16));
add(pfield);


JLabel email=new JLabel("EMAIL:");
email.setBounds(70,350,100,30);
email.setFont(new Font("Raleway",Font.BOLD,18));
add(email);
efield=new JTextField();
efield.setBounds(200,350,200,30);
efield.setFont(new Font("Raleway",Font.BOLD,16));
add(efield);

JLabel adhar=new JLabel("ADHAR:");
adhar.setBounds(70,400,100,30);
adhar.setFont(new Font("Raleway",Font.BOLD,18));
add(adhar);
adfield=new JTextField();
adfield.setBounds(200,400,200,30);
adfield.setFont(new Font("Raleway",Font.BOLD,16));
add(adfield);

submit=new JButton("SUBMIT");
submit.setBounds(200,450,200,30);
submit.setBackground(Color.BLACK);
submit.setForeground(Color.WHITE);
submit.setFont(new Font("Raleway",Font.BOLD,16));
submit.addActionListener(this);
add(submit);

setSize(900,600);
setLocation(300,200);
getContentPane().setBackground(Color.WHITE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
try{
String name=nfield.getText();
String age=afield.getText();
String salary=sfield.getText();
String email=efield.getText();
String phone=pfield.getText();
String adhar=adfield.getText();
String gender=null;
if(male.isSelected()){
gender="MALE";
}else if(female.isSelected()){
gender="FEMALE";
}
String job=(String)jfield.getSelectedItem();
Conn conn=new Conn();
String query="insert into employee values('"+name+"','"+age+"','"+salary+"','"+email+"','"+phone+"','"+adhar+"','"+gender+"','"+job+"')";
conn.s.executeUpdate(query);
JOptionPane.showMessageDialog(null,"Employee Added Successfully");
setVisible(false);
}catch(Exception e){
System.out.println(e);
}
}
public static void main(String[] args){
new AddEmployee();
}
}
	
								//Add Rooms
public class AddRooms extends JFrame implements ActionListener{
JButton submit,cancel;
JTextField room,pri;
JComboBox cse,ave,bte;
AddRooms(){
setLayout(null);
JLabel title=new JLabel("ADD ROOMS");
title.setBounds(150,30,200,30);
title.setFont(new Font("Raleway",Font.BOLD,22));
title.setForeground(Color.BLUE);
add(title);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
Image i2=i1.getImage().getScaledInstance(773,653,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel label=new JLabel(i3);
label.setBounds(400,30,550,390);
add(label);

JLabel roomno=new JLabel("ROOM NO:");
roomno.setBounds(50,100,100,30);
roomno.setFont(new Font("Raleway",Font.BOLD,13));
add(roomno);
room=new JTextField();
room.setBounds(170,100,200,30);
room.setFont(new Font("Raleway",Font.BOLD,11));
add(room);

JLabel available=new JLabel("AVAILABLE:");
available.setBounds(50,160,100,30);
available.setFont(new Font("Raleway",Font.BOLD,13));
add(available);
String availablevalue[]={"Available","Unavailable"};
ave=new JComboBox(availablevalue);
ave.setBounds(170,160,200,30);
ave.setBackground(Color.WHITE);
add(ave);

JLabel cs=new JLabel("Cleaning Status:");
cs.setBounds(50,220,150,30);
cs.setFont(new Font("Raleway",Font.BOLD,13));
add(cs);
String csvalue[]={"Clean","Dirty"};
cse=new JComboBox(csvalue);
cse.setBounds(170,220,200,30);
cse.setBackground(Color.WHITE);
add(cse);

JLabel price=new JLabel("PRICE:");
price.setBounds(50,280,100,30);
price.setFont(new Font("Raleway",Font.BOLD,13));
add(price);
pri=new JTextField();
pri.setBounds(170,280,200,30);
pri.setFont(new Font("Raleway",Font.BOLD,11));
add(pri);

JLabel bt=new JLabel("BAD TYPE:");
bt.setBounds(50,340,100,30);
bt.setFont(new Font("Raleway",Font.BOLD,13));
add(bt);
String btvalue[]={"Sigle Bad","Double Bad"};
bte=new JComboBox(btvalue);
bte.setBounds(170,340,200,30);
bte.setBackground(Color.WHITE);
add(bte);

submit=new JButton("ADD ROOM");
submit.setBounds(50,400,130,30);
submit.setBackground(Color.BLACK);
submit.setForeground(Color.WHITE);
submit.setFont(new Font("Raleway",Font.BOLD,13));
submit.addActionListener(this);
add(submit);

cancel=new JButton("CANCEL");
cancel.setBounds(210,400,130,30);
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
cancel.setFont(new Font("Raleway",Font.BOLD,13));
cancel.addActionListener(this);
add(cancel);

setSize(1000,500);
setLocation(300,200);
getContentPane().setBackground(Color.WHITE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==submit){
String roomno=room.getText();
String available=(String)ave.getSelectedItem();
String cleaningstatus=(String)cse.getSelectedItem();
String price=pri.getText();
String badtype=(String)bte.getSelectedItem();
try{
Conn conn=new Conn();
String query="insert into room values('"+roomno+"','"+available+"','"+cleaningstatus+"','"+price+"','"+badtype+"')";
conn.s.executeUpdate(query);
JOptionPane.showMessageDialog(null,"New Room Added Successfully");
setVisible(false);
}catch(Exception e){
System.out.println(e);
}
}else if(ae.getSource()==cancel){
setVisible(false);
}
}
public static void main(String[] args){
new AddRooms();
}
}	

							//Add driver
public class AddDrivers extends JFrame implements ActionListener{
JButton submit,cancel;
JTextField nfield,afield,company,model,lfield;
JComboBox gcombo,ave;
AddDrivers(){
setLayout(null);
JLabel title=new JLabel("ADD DRIVERS");
title.setBounds(150,30,200,30);
title.setFont(new Font("Raleway",Font.BOLD,22));
title.setForeground(Color.BLUE);
add(title);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
Image i2=i1.getImage().getScaledInstance(773,653,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel label=new JLabel(i3);
label.setBounds(400,80,550,390);
add(label);

JLabel name=new JLabel("NAME:");
name.setBounds(50,100,100,30);
name.setFont(new Font("Raleway",Font.BOLD,13));
add(name);
nfield=new JTextField();
nfield.setBounds(170,100,200,30);
nfield.setFont(new Font("Raleway",Font.BOLD,11));
add(nfield);

JLabel age=new JLabel("AGE:");
age.setBounds(50,150,100,30);
age.setFont(new Font("Raleway",Font.BOLD,13));
add(age);
afield=new JTextField();
afield.setBounds(170,150,200,30);
afield.setFont(new Font("Raleway",Font.BOLD,11));
add(afield);

JLabel gender=new JLabel("GENDER:");
gender.setBounds(50,200,150,30);
gender.setFont(new Font("Raleway",Font.BOLD,13));
add(gender);
String gendervalue[]={"Male","Female"};
gcombo=new JComboBox(gendervalue);
gcombo.setBounds(170,200,200,30);
gcombo.setBackground(Color.WHITE);
add(gcombo);

JLabel car=new JLabel("CAR COMPANY:");
car.setBounds(50,250,100,30);
car.setFont(new Font("Raleway",Font.BOLD,13));
add(car);
company=new JTextField();
company.setBounds(170,250,200,30);
company.setFont(new Font("Raleway",Font.BOLD,11));
add(company);

JLabel carmodel=new JLabel("CAR MODEL:");
carmodel.setBounds(50,300,100,30);
carmodel.setFont(new Font("Raleway",Font.BOLD,13));
add(carmodel);
model=new JTextField();
model.setBounds(170,300,200,30);
model.setBackground(Color.WHITE);
add(model);

JLabel available=new JLabel("AVAILABLE:");
available.setBounds(50,350,100,30);
available.setFont(new Font("Raleway",Font.BOLD,13));
add(available);
String availablevalue[]={"Available","Unavailable"};
ave=new JComboBox(availablevalue);
ave.setBounds(170,350,200,30);
ave.setBackground(Color.WHITE);
add(ave);

JLabel location=new JLabel("LOCATION:");
location.setBounds(50,400,100,30);
location.setFont(new Font("Raleway",Font.BOLD,13));
add(location);
lfield=new JTextField();
lfield.setBounds(170,400,200,30);
lfield.setFont(new Font("Raleway",Font.BOLD,11));
add(lfield);

submit=new JButton("ADD DRIVER");
submit.setBounds(50,450,130,30);
submit.setBackground(Color.BLACK);
submit.setForeground(Color.WHITE);
submit.setFont(new Font("Raleway",Font.BOLD,13));
submit.addActionListener(this);
add(submit);

cancel=new JButton("CANCEL");
cancel.setBounds(210,450,130,30);
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
cancel.setFont(new Font("Raleway",Font.BOLD,13));
cancel.addActionListener(this);
add(cancel);

setSize(1000,550);
setLocation(300,200);
getContentPane().setBackground(Color.WHITE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==submit){
String name=nfield.getText();
String age=afield.getText();
String gender=(String)gcombo.getSelectedItem();
String carcompany=company.getText();
String carmodel=model.getText();
String available=(String)ave.getSelectedItem();
String location=lfield.getText();
try{
Conn conn=new Conn();
String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+available+"','"+location+"')";
conn.s.executeUpdate(query);
JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
setVisible(false);
}catch(Exception e){
System.out.println(e);
}
}else if(ae.getSource()==cancel){
setVisible(false);
}
}
public static void main(String[] args){
new AddDrivers();
}
}

							//Reception page
public class Reception extends JFrame implements ActionListener{
JButton form,room,department,employee,customer,manager,checkout,update,updateroom,pickup,search,logout;
Reception(){
setLayout(null);
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
Image i2=i1.getImage().getScaledInstance(550,480,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel label=new JLabel(i3);
label.setBounds(300,30,550,480);
add(label);

form=new JButton("NEW CUSTOMER FORM");
form.setBounds(20,30,250,30);
form.setBackground(Color.BLACK);
form.setForeground(Color.WHITE);
form.setFont(new Font("Raleway",Font.BOLD,12));
form.addActionListener(this);
add(form);

room=new JButton("ROOMS");
room.setBounds(20,70,250,30);
room.setBackground(Color.BLACK);
room.setForeground(Color.WHITE);
room.setFont(new Font("Raleway",Font.BOLD,12));
room.addActionListener(this);
add(room);

department=new JButton("DEPARTMENT");
department.setBounds(20,110,250,30);
department.setBackground(Color.BLACK);
department.setForeground(Color.WHITE);
department.setFont(new Font("Raleway",Font.BOLD,12));
department.addActionListener(this);
add(department);

employee=new JButton("ALL EMPLOYEE INFO");
employee.setBounds(20,150,250,30);
employee.setBackground(Color.BLACK);
employee.setForeground(Color.WHITE);
employee.setFont(new Font("Raleway",Font.BOLD,12));
employee.addActionListener(this);
add(employee);

customer=new JButton("CUTOMER INFO");
customer.setBounds(20,190,250,30);
customer.setBackground(Color.BLACK);
customer.setForeground(Color.WHITE);
customer.setFont(new Font("Raleway",Font.BOLD,12));
customer.addActionListener(this);
add(customer);

JButton manager=new JButton("MANAGER INFO");
manager.setBounds(20,230,250,30);
manager.setBackground(Color.BLACK);
manager.setForeground(Color.WHITE);
manager.setFont(new Font("Raleway",Font.BOLD,12));
manager.addActionListener(this);
add(manager);

checkout=new JButton("CHECK OUT");
checkout.setBounds(20,270,250,30);
checkout.setBackground(Color.BLACK);
checkout.setForeground(Color.WHITE);
checkout.setFont(new Font("Raleway",Font.BOLD,12));
checkout.addActionListener(this);
add(checkout);

update=new JButton("UPDATE STATUS");
update.setBounds(20,310,250,30);
update.setBackground(Color.BLACK);
update.setForeground(Color.WHITE);
update.setFont(new Font("Raleway",Font.BOLD,12));
update.addActionListener(this);
add(update);

updateroom=new JButton("UPDATE ROOM STATUS");
updateroom.setBounds(20,350,250,30);
updateroom.setBackground(Color.BLACK);
updateroom.setForeground(Color.WHITE);
updateroom.setFont(new Font("Raleway",Font.BOLD,12));
updateroom.addActionListener(this);
add(updateroom);

pickup=new JButton("PICK UP SERCICE");
pickup.setBounds(20,390,250,30);
pickup.setBackground(Color.BLACK);
pickup.setForeground(Color.WHITE);
pickup.setFont(new Font("Raleway",Font.BOLD,12));
pickup.addActionListener(this);
add(pickup);

search=new JButton("SEARCH ROOMS");
search.setBounds(20,430,250,30);
search.setBackground(Color.BLACK);
search.setForeground(Color.WHITE);
search.setFont(new Font("Raleway",Font.BOLD,12));
search.addActionListener(this);
add(search);

logout=new JButton("LOGOUT");
logout.setBounds(20,470,250,30);
logout.setBackground(Color.BLACK);
logout.setForeground(Color.WHITE);
logout.setFont(new Font("Raleway",Font.BOLD,12));
logout.addActionListener(this);
add(logout);

setSize(900,570);
setLocation(300,200);
getContentPane().setBackground(Color.WHITE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){

}
public static void main(String [] args){
new Reception();
}
}	