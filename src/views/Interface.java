package views;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.Controller;

public class Interface extends JFrame {

	JPanel panel;
	JTextArea queryText;
	Controller controller;
	JScrollPane scroll;
	JSplitPane splitPane;
	ResultSet result;
	ResultSetMetaData metaData;

	public Interface() throws SQLException {
		super();
		this.setTitle("Request Tester");
		controller = new Controller();
		JButton button;
		JToolBar toolbar = new JToolBar();
		button = new JButton("Run query", new ImageIcon("icons/play.png"));
		toolbar.add(button);
		this.add(toolbar, BorderLayout.NORTH);
		this.add(createMainPanel(), BorderLayout.CENTER);
		this.setSize(1200, 700);
		this.setVisible(true);
		this.setResizable(false);
		setButton(button, this);
	}

	public JPanel createMainPanel() {
		panel = new JPanel();
		queryText = new JTextArea();
		queryText.setColumns(95);
		queryText.setRows(10);
		queryText.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 15));
		Object[] columns = { "Column_1", "Column_2", "Column_3" };
		Object[][] data = { { "data", "data", "data" }, { "data", "data", "data" }, { "data", "data", "data" },
				{ "data", "data", "data" }, { "data", "data", "data" }, { "data", "data", "data" },
				{ "data", "data", "data" }, { "data", "data", "data" }, { "data", "data", "data" },
				{ "data", "data", "data" }, { "data", "data", "data" }, { "data", "data", "data" },
				{ "data", "data", "data" }, { "data", "data", "data" }, { "data", "data", "data" },
				{ "data", "data", "data" }, { "data", "data", "data" }, { "data", "data", "data" },
				{ "data", "data", "data" }, { "data", "data", "data" }, { "data", "data", "data" } };
		scroll = new JScrollPane(new JTable(data, columns));
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, queryText, scroll);
		panel.add(splitPane);
		return panel;
	}

	public void setButton(JButton button, JFrame f) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = queryText.getText();
				String error;
				if (!query.equals("")) {
					try {
						controller.executeQuery(query);
						if (controller.getError() != null && controller.getError().equals("")) {
							result = controller.getResult();
							metaData = controller.getMetaData();
							redrawTable(result, metaData);
						} else {
							JOptionPane.showMessageDialog(f, "Une erreur est survenue", "Alert", JOptionPane.WARNING_MESSAGE);
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(f, "Please, provide a query.", "Alert", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
	}

	public void redrawTable(ResultSet result, ResultSetMetaData metaDta) throws SQLException {

		Object[] column = new Object[metaData.getColumnCount()];

		for (int i = 1; i <= metaData.getColumnCount(); i++)
			column[i - 1] = metaData.getColumnName(i);

		result.last();
		int rowCount = result.getRow();
		Object[][] data = new Object[result.getRow()][metaDta.getColumnCount()];

		result.beforeFirst();
		int j = 1;

		while (result.next()) {
			for (int i = 1; i <= metaDta.getColumnCount(); i++)
				data[j - 1][i - 1] = result.getObject(i);

			j++;
		}

		panel.removeAll();

		scroll = new JScrollPane(new JTable(data, column));
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, queryText, scroll);
		panel.add(splitPane);
		panel.revalidate();

	}

}
