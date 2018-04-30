package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Helpers.ButtonMaker;
import MainClasses.MainFrame;

public class ParentPanel extends JPanel implements ActionListener {

	// Keep reference to the frame
	protected MainFrame frame;
	
	// Hold all the navigation buttons in the JPanel
	private ArrayList<JButton> navButtons = new ArrayList<JButton>();
	
	// For managing card layout.
	protected String instanceName = "";
	
	private BorderLayout layout;
	
	protected JLabel museumNameLabel;
	
	public ParentPanel(MainFrame frame, String title) {
		this.frame = frame;
		setBackground(new Color(255, 255, 255));
		setBorder(new TitledBorder(title));
		// Add navigation bar
		
		layout = new BorderLayout(10, 10);
		
		JPanel navBar = new JPanel(new GridLayout(1, 4));
		
		setLayout(layout);
		
		navButtons.add(ButtonMaker.CreateButton("Main Menu", "mainMenu"));
		navButtons.add(ButtonMaker.CreateButton("Add Vehicle", "addVehicle"));
		navButtons.add(ButtonMaker.CreateButton("Remove Vehicle", "removeVehicle"));
		navButtons.add(ButtonMaker.CreateButton("Find Vehicle", "findVehicle"));
		navButtons.add(ButtonMaker.CreateButton("List Vehicles", "listVehicle"));
		
		JPanel titleBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		museumNameLabel = new JLabel();
		museumNameLabel.setText(frame.getMuseum().getMuseumName());
		titleBar.add(museumNameLabel);
		
		for(JButton button : navButtons) {
			button.addActionListener(this);
			navBar.add(button);
			button.setMargin(new Insets(0, 0, 0, 0));
			button.setBackground(new Color(59, 89, 182));
			button.setFocusPainted(false);
			button.setFont(new Font("Tahoma", Font.BOLD, 12));
			button.setForeground(Color.WHITE);
			button.setFocusable(false);
		}
		setBorder(new EmptyBorder(20, 20, 20, 20));
		add(navBar, BorderLayout.SOUTH);
		add(titleBar, BorderLayout.NORTH);
	}
	
	public String getInstanceName() {
		return instanceName;
	}
	
	public void SetPanel() {
		this.museumNameLabel.setText(frame.getMuseum().getMuseumName());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Checking if instance of JButton before switching layout.
		if(e.getSource() instanceof JButton) {
			frame.switchLayout(((JComponent)e.getSource()).getName());
		}
	}
}
