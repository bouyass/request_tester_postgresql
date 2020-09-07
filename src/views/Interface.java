package views;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Interface extends JFrame{
	
	JPanel panel;
	
	public Interface() {
		super();
		this.setTitle("Request Tester");
		JButton button;
		JToolBar toolbar = new JToolBar();
		button = new JButton("Run query",new ImageIcon("icons/play.png"));
		toolbar.add(button);
        this.add(toolbar, BorderLayout.NORTH);
        this.add(createMainPanel(), BorderLayout.CENTER);
		this.setSize(1200, 700);
		this.setVisible(true);
	}
	
	public JPanel createMainPanel() {
		panel = new JPanel();
		JTextArea queryText = new JTextArea();
		queryText.setColumns(95);
		queryText.setRows(10);
		queryText.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,15));
		JTable table = new JTable();
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,queryText,table);
		panel.add(splitPane);
		return panel;
	}

}
