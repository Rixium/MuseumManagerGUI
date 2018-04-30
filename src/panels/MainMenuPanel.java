package panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import MainClasses.MainFrame;


public class MainMenuPanel extends ParentPanel implements ActionListener {

	public MainMenuPanel(MainFrame frame) {
		super(frame, "Main Menu");
		instanceName = "mainMenu";
		
		JPanel container = new JPanel(new BorderLayout());
		
		JPanel left = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel right = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		container.add(left, BorderLayout.NORTH);
		container.add(right, BorderLayout.CENTER);
		
		
		JLabel label = new JLabel();
		label.setText("Museum Name: ");
		
		JTextField field = new JTextField(15);
		field.setName("museumName");
		field.addActionListener(this);
		
		JTextArea tarea = new JTextArea();
		tarea.setText("Welcome to the Museum Management system."
		+ " From the menu, you can access many areas, where you can management showcased objects, "
		+ "You can also access any object with the find form. "
		+ "If you wish to remove an object from the museum, you can do that using the remove form, with the objects unique ID.");

		tarea.setWrapStyleWord(true);
		tarea.setLineWrap(true);
		tarea.setPreferredSize(new Dimension(400, 100));
		tarea.setOpaque(false);
		tarea.setEditable(false);
		tarea.setFocusable(false);
		    
		left.add(label);
		left.add(field);
		right.add(tarea);
		
		add(container, BorderLayout.CENTER);
		container.setBackground(new Color(255, 255, 255));
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		super.actionPerformed(evt);
		String src = ((JComponent)evt.getSource()).getName();
		if(src.equals("museumName")) {
			JTextField field = (JTextField)evt.getSource();
			frame.getMuseum().setMuseumName(field.getText());
			this.museumNameLabel.setText(field.getText());
		}
	}
}
