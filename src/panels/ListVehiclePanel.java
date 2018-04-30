package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import MainClasses.InfoEntry;
import MainClasses.MainFrame;
import MainClasses.Vehicle;

public class ListVehiclePanel extends ParentPanel {

	private JPanel container;
	
	public ListVehiclePanel(MainFrame frame) {
		super(frame, "List Vehicles");
		instanceName = "listVehicle";
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(container);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	@Override
	public void SetPanel() {
		super.SetPanel();
		container.removeAll();
		for(int i = 0; i < frame.getMuseum().getObjects().size(); i++) {
			JPanel vehicleEntry = new JPanel(new GridLayout(5, 4));
			vehicleEntry.setBorder(new EmptyBorder(20, 20, 20, 20));
			Vehicle v = (Vehicle)frame.getMuseum().getObjects().get(i);
			ArrayList<InfoEntry> list = v.getInfo();
			for(InfoEntry item : list) {
				JLabel name = new JLabel(item.getName());
				JLabel value = new JLabel(item.getValue());
				
				name.setAlignmentX(JLabel.CENTER_ALIGNMENT);
				value.setAlignmentX(JLabel.CENTER_ALIGNMENT);
				
				if(i % 2 == 0) {
					name.setForeground(Color.WHITE);
					value.setForeground(Color.WHITE);
				} else {
					name.setForeground(Color.BLACK);
					value.setForeground(Color.BLACK);
				}
				
				vehicleEntry.add(name);
				vehicleEntry.add(value);
			}
			
			if(i % 2 == 0) {
				vehicleEntry.setBackground(new Color(100, 100, 100));
			} else {
				vehicleEntry.setBackground(Color.WHITE);
			}
			
			container.add(vehicleEntry);
		}
	}
	
}
