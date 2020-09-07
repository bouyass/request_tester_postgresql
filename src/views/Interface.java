package views;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Interface extends JFrame{
	
	public Interface() {
		super();
		this.setTitle("Request Tester");
		JButton button;
		JTextField queryText = new JTextField();
		queryText.setSize(300, 100);
		JToolBar toolbar = new JToolBar();
		button = new JButton("Run query",new ImageIcon("icons/play.png"));
		toolbar.add(button);
        this.add(toolbar, BorderLayout.NORTH);
        this.add(queryText, BorderLayout.CENTER);
		this.setSize(1200, 700);
		this.setVisible(true);
	}

}
