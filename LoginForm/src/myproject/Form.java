package myproject;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;

public class Form {
	
	public static ArrayList<String> ID = new ArrayList<String>();
	public static ArrayList<String> PW = new ArrayList<String>();

	JTextField t1 = new JTextField(11);
	JTextField t2 = new JTextField(11);
	
	public JPanel buildForm()
	{
		JPanel j = new JPanel();
		
		LoginSignUpActionListener lsu = new LoginSignUpActionListener();
		
		JPanel jsub = new JPanel();
		jsub.setLayout(new BorderLayout());
		
		JPanel j1 = new JPanel();
		j1.add(new JLabel("아이디     "));
		j1.add(t1);
		
		JPanel j2 = new JPanel();
		j2.add(new JLabel("패스워드 "));
		j2.add(t2);
		
		JPanel j3 = new JPanel();
		j3.setLayout(new FlowLayout());
		JButton login = new JButton("로그인");
		JButton signup = new JButton("회원가입");
		
		login.addActionListener(lsu);
		j3.add(login);
		signup.addActionListener(lsu);
		j3.add(signup);
		
		jsub.add(j1, BorderLayout.NORTH);
		jsub.add(j2, BorderLayout.SOUTH);
		j.add(jsub, BorderLayout.CENTER);
		j.add(j3, BorderLayout.SOUTH);
		
		return j;
	}
	
	public class LoginSignUpActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			ID.add("hi");
			PW.add("me");
			boolean id_success = false;
			boolean pw_success = false;
			switch(cmd)
			{
			case "로그인":
				Iterator<String> idit = ID.iterator();
				Iterator<String> pwit = PW.iterator();
				
				String id = t1.getText();
				String pw = t2.getText();
				
				while(idit.hasNext())
				{
					if(id.equals(idit.next()))
					{
						id_success = true;	
					}
				}
				while(pwit.hasNext())
				{
					if(pw.equals(pwit.next()))
					{
						pw_success = true;	
					}
				}
				
				if ((id_success==true)&&(pw_success==true))
					JOptionPane.showMessageDialog(null, "로그인 성공!", "Login", JOptionPane.PLAIN_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "로그인 실패\n"
						+ "ID/PW 확인 혹은 회원가입 필요", "Login", JOptionPane.PLAIN_MESSAGE);
				break;
			case "회원가입":
				buildSignUp();
				break;
			}
		}
	}
	
	void buildSignUp()
	{
		new SignUp();
	}
}