package myproject;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static myproject.Form.ID;
import static myproject.Form.PW;

public class SignUp extends JFrame{
	
	String phone[] = {"010", "011", "016", "017", "018", "019"};
	String mail[] = {"naver.com", "gmail.com", "hanmail.net", "kakao.com", "nate.com", "tistory.com"};
	
	JPanel j = new JPanel();
	
	SignUpCancelActionListener ba = new SignUpCancelActionListener();
	OverlapActionListener oa = new OverlapActionListener();
	
	JLabel j1 = new JLabel("이        름");
	JLabel j2 = new JLabel("아  이  디");
	JLabel j3 = new JLabel("비 밀 번 호");
	JLabel j4 = new JLabel("재  입  력   ");
	JLabel j5 = new JLabel("성        별     ");
	JLabel j6 = new JLabel("주민등록번호");
	JLabel j7 = new JLabel("주        소");
	JLabel j8 = new JLabel("상세주소");
	JLabel j9 = new JLabel("우편번호");
	JLabel j10 = new JLabel("전화번호");
	JLabel j11 = new JLabel("이 메 일 ");
	
	ButtonGroup bg = new ButtonGroup();
	JRadioButton r1 = new JRadioButton("남   ");
	JRadioButton r2 = new JRadioButton("여");
	String gender;
	
	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	JTextField t3 = new JTextField(9);
	JTextField t4 = new JTextField(9);
	
	JTextField t6_1 = new JTextField(8);
	JTextField t6_2 = new JTextField(8);
	
	JTextField t7 = new JTextField(20);
	JTextField t8 = new JTextField(10);
	JTextField t9 = new JTextField(7);
	JTextField t10_1 = new JTextField(6);
	JTextField t10_2 = new JTextField(7);
	JTextField t11 = new JTextField(10);
	
	JTextArea area = new JTextArea(10,20);
	
	JComboBox<String> p = new JComboBox(phone); 
	JComboBox<String> m = new JComboBox(mail); 
	
	JButton overlap = new JButton("중복체크");
	JButton SignUp = new JButton("가입하기");
	JButton Cancel = new JButton("취소");
	
	JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
	JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT)); JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
	JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT)); JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
	JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT)); JPanel p10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel p11 = new JPanel(new FlowLayout(FlowLayout.LEFT)); JPanel p12 = new JPanel();
	
	boolean exeSign = false;
	boolean exeSign_2 = false;
	
	public SignUp() 
	{	
		j.setLayout(new GridLayout(0,1));
		
		p1.add(j1); p1.add(t1);
		j.add(p1);
		p2.add(j2); p2.add(t2); overlap.addActionListener(oa); p2.add(overlap); 
		j.add(p2);
		p3.add(j3); p3.add(t3);
		j.add(p3);
		p4.add(j4); p4.add(t4);
		j.add(p4);
		p5.add(j5); bg.add(r1); bg.add(r2); p5.add(r1); p5.add(r2);
		j.add(p5);
		p6.add(j6); p6.add(t6_1); p6.add(new JLabel("-")); p6.add(t6_2);
		j.add(p6);
		p7.add(j7); p7.add(t7);
		j.add(p7);
		p8.add(j8); p8.add(t8);
		j.add(p8);
		p9.add(j9); p9.add(t9);
		j.add(p9);
		p10.add(j10); p10.add(p); p10.add(new JLabel("-")); p10.add(t10_1); p10.add(new JLabel("-")); p10.add(t10_2);
		j.add(p10);
		p11.add(j11); p11.add(t11); p11.add(new JLabel("@")); p11.add(m);
		j.add(p11);
		SignUp.addActionListener(ba);
		p12.add(SignUp);
		Cancel.addActionListener(ba);
		p12.add(Cancel);
		j.add(p12);
		add(j);
		
		buildGUI();
	}
	
	void buildGUI()
	{
		setTitle("회원가입");
		setSize(360,420);
		setLocation(590,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	void DataSave()
	{
		area.setText("");
		area.append("이름: "+t1.getText()+"\n");
		area.append("ID: "+t2.getText()+"\n");
		area.append("PW: "+t3.getText()+"\n");
		if(r1.isSelected()==true)
			gender = "남";
		if(r2.isSelected()==true)
			gender = "여";
		area.append("성별: "+gender+"\n");
		area.append("주민등록번호: "+t6_1.getText()+"-"+t6_2.getText()+"\n");
		area.append("주소: "+t7.getText()+"\n");
		area.append("상세주소: "+t8.getText()+"\n");
		area.append("우편번호: "+t9.getText()+"\n");
		area.append("전화번호: "+p.getSelectedItem().toString()+"-"+t10_1.getText()+"-"+t10_2.getText()+"\n");
		area.append("이메일: "+t11.getText()+"@"+m.getSelectedItem().toString());
		JOptionPane.showMessageDialog(null, area.getText(), "UserData", JOptionPane.PLAIN_MESSAGE);
		exeSign_2 = false;
	}
	
	void FileWriting()
	{
		try 
		{
			File fout = new File("C:\\Users\\starg\\Desktop/UserData.txt");
			
			String bData = area.getText();
			BufferedWriter out = new BufferedWriter(new FileWriter(fout));
				
			out.write(bData);
			out.close();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "저장 실패", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	public class SignUpCancelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(exeSign_2==false)
				JOptionPane.showMessageDialog(null, "ID 중복체크를 해주세요", "Error", JOptionPane.ERROR_MESSAGE);
			if(t3.getText().equals(t4.getText()))
				exeSign = true;
			else
			{
				JOptionPane.showMessageDialog(null, "재입력 비밀번호가 다릅니다.", "Error", JOptionPane.ERROR_MESSAGE);
				t4.setText("");
			}
			if(exeSign==true&&exeSign_2==true)
			{
				switch(cmd)
				{
				case "가입하기":
					ID.add(t2.getText());
					PW.add(t3.getText());
					DataSave();
					FileWriting();
				case "취소":
					dispose();
					break;
				}
			}
		}
	}
	
	public class OverlapActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = t2.getText();
			boolean id_overlap = false;
			Iterator<String> idit = ID.iterator();
			while(idit.hasNext())
			{
				if(id.equals(idit.next()))
				{
					id_overlap = true;	
				}
			}
			if(id_overlap==false)
			{
				JOptionPane.showMessageDialog(null, "사용 가능 ID", "Overlap", JOptionPane.PLAIN_MESSAGE);
				exeSign_2 = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "중복되는 ID", "Overlap", JOptionPane.ERROR_MESSAGE);
				exeSign_2 = false;
				t2.setText("");
			}
		}
	}
}
