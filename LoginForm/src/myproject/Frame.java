package myproject;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame {
	
	public static void main(String[] args) 
	{
		new Frame();
	}
	
	public Frame()
	{
		setTitle("로그인/회원가입");
		setSize(280,180);
		setLocation(200,200);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildForm();
		buildMenu();
		setVisible(true);
	}	
	
	void buildForm()
	{
		add(new Form().buildForm(), BorderLayout.CENTER);
	}
	
	void buildMenu()
	{
		setJMenuBar(new Menu().buildMenu());
	}
}