package panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MainClasses.InfoEntry;
import MainClasses.MainFrame;

public class FindVehiclePanel extends ParentPanel {

	public FindVehiclePanel(MainFrame frame) {
		super(frame, "Find Vehicle");
		instanceName = "findVehicle";
		
		JPanel container = new JPanel(new GridBagLayout());
		container.setBackground(Color.WHITE);
		GridBagConstraints gc = new GridBagConstraints();
		
		JPanel selections = new JPanel();
		selections.setLayout(new BoxLayout(selections, BoxLayout.Y_AXIS));
		
		JScrollPane scrollBox = new JScrollPane(selections);
		JPanel selectors = new JPanel(new GridBagLayout());
		selectors.setBorder(new EmptyBorder(5, 5, 5, 5));
		selectors.setBackground(Color.WHITE);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 10;
		gc.weighty = 0;
		
		JLabel vType = new JLabel("Search by:  ");
		String[] vSelections = { "Number Plate", "ID", "Colour", "Price", "Year", "Vehicle Type"};
		JComboBox vBox = new JComboBox(vSelections);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 10;
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		selectors.add(vType, gc);
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		selectors.add(vBox, gc);
		
		JLabel numPlateLabel = new JLabel("Enter Number Plate:  ");
		
		gc.gridy = 3;
		gc.fill = GridBagConstraints.NONE;
		gc.weighty = 1;
		JTextField numPlateField = new JTextField(10);
		selectors.add(numPlateLabel, gc);
		gc.gridy = 4;
		selectors.add(numPlateField, gc);
		
		vBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				String selected = (String) vBox.getSelectedItem();
				switch(selected) {
					case "Number Plate":
						numPlateLabel.setText("Enter Number Plate:  ");
						break;
					case "ID":
						numPlateLabel.setText("Enter ID:  ");
						break;
					case "Colour":
						numPlateLabel.setText("Enter Colour:  ");
						break;
					case "Price":
						numPlateLabel.setText("Enter Price:  ");
						break;
					case "Year":
						numPlateLabel.setText("Enter Year:  ");
						break;
					case "Vehicle Type":
						numPlateLabel.setText("Select Vehicle Type:  ");
						break;
					default:
						break;
				}
			}
			
		});
		
		JButton button = new JButton("Search");
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				String selected = (String) vBox.getSelectedItem();
				selections.removeAll();
				ArrayList<ArrayList<InfoEntry>> entries = null;
				
				switch(selected) {
				case "Number Plate":
					entries = frame.getMuseum().getByNumberPlate(numPlateField.getText());
					break;
				case "ID":
					entries = frame.getMuseum().getByID(numPlateField.getText());
					break;
				case "Colour":
					entries = frame.getMuseum().getByColour(numPlateField.getText());
					break;
				case "Price":
					entries = frame.getMuseum().getByPrice(numPlateField.getText());
					break;
				case "Year":
					entries = frame.getMuseum().getByYear(numPlateField.getText());
					break;
				case "Vehicle Type":
					entries = frame.getMuseum().getByType(numPlateField.getText());
					break;
				default:
					break;
				}
				
				int count = 0;
				for(ArrayList<InfoEntry> entry : entries) {
					JPanel vehicleEntry = new JPanel(new GridLayout(5, 4));
					vehicleEntry.setBorder(new EmptyBorder(20, 20, 20, 20));
					for(InfoEntry item : entry) {
							JLabel name = new JLabel(item.getName());
							JLabel value = new JLabel(item.getValue());
							
							name.setAlignmentX(JLabel.CENTER_ALIGNMENT);
							value.setAlignmentX(JLabel.CENTER_ALIGNMENT);
							
							if(count % 2 == 0) {
								name.setForeground(Color.WHITE);
								value.setForeground(Color.WHITE);
							} else {
								name.setForeground(Color.BLACK);
								value.setForeground(Color.BLACK);
							}
							
							vehicleEntry.add(name);
							vehicleEntry.add(value);
						}
						
						if(count % 2 == 0) {
							vehicleEntry.setBackground(new Color(100, 100, 100));
						} else {
							vehicleEntry.setBackground(Color.WHITE);
						}
						
						selections.add(vehicleEntry);
						count++;
					}
				
				selections.revalidate();
				selections.repaint();
			}
			
		});
		
		gc.gridx = 2;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LAST_LINE_END;

		gc.weightx = 1;
		gc.weighty = 1;
		selectors.add(button, gc);
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1;
		gc.weighty = .8;
		
		
		container.add(selectors, gc);
		gc.weighty = 10;
		gc.gridy = 2;
		
		container.add(scrollBox, gc);
		add(container);
	}
	
}
