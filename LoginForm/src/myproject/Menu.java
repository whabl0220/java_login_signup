package myproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu {
	
	public JMenuBar buildMenu()
	{
		class MenuActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				switch(cmd)
				{
				case "Profile":
					JOptionPane.showMessageDialog(null, "학번: 2171210\n이름: 유혁상\n학과: 컴퓨터공학과", "Profile", JOptionPane.PLAIN_MESSAGE);
					break;
				case "Contact":
					JOptionPane.showMessageDialog(null, "Email: stargalaxy1579@gmail.com\nPhone: 010-2392-9658", "Contact", JOptionPane.PLAIN_MESSAGE);
					break;
				case "Introduce":
					JOptionPane.showMessageDialog(null, "로그인과 회원가입 기능이 구현되어있는 프로그램입니다.\n"
							+ "회원가입 기록이 있으면 로그인에 성공하고\n"
							+ "그렇지 않다면 먼저 회원가입을 해야 합니다.", "Introduce", JOptionPane.PLAIN_MESSAGE);
					break;
				}
			}
		}
		
		MenuActionListener ma = new MenuActionListener();
				
		JMenuBar mb = new JMenuBar();
		
		JMenu Author = new JMenu("Author");
		JMenuItem profile = new JMenuItem("Profile");
		profile.addActionListener(ma);
		JMenuItem contact = new JMenuItem("Contact");
		contact.addActionListener(ma);
		Author.add(profile);
		Author.add(contact);
		mb.add(Author);
		
		JMenu Intro = new JMenu("Help");
		JMenuItem intro = new JMenuItem("Introduce");
		intro.addActionListener(ma);
		Intro.add(intro);
		mb.add(Intro);
		
		return mb;
	}
}