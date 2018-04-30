package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import MainClasses.Bike;
import MainClasses.Car;
import MainClasses.MainFrame;
import MainClasses.Vehicle;

public class AddVehiclePanel extends ParentPanel {

	private JLabel vType, lPlate, year, colour, value, numDoors, numSeats, engineType, engineSize, bikeType;
	private JComboBox vBox, eBox, bBox;
	private JTextField colourBox, numDoorsField, numSeatsField;
	private JFormattedTextField valueField, manufactureYear, lPlateBox, engineSizeField;
	
	private ArrayList<JComponent> fields = new ArrayList<>();
	
	public AddVehiclePanel(MainFrame frame) {
		super(frame, "Add Vehicle");
		instanceName = "addVehicle";
		
		JPanel container = new JPanel(new BorderLayout());
		
		JPanel left = new JPanel(new GridLayout(11, 2));
		JPanel right = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		container.add(left, BorderLayout.CENTER);
		container.add(right, BorderLayout.SOUTH);
		container.setBackground(Color.WHITE);
		left.setBackground(Color.WHITE);
		right.setBackground(Color.WHITE);
		
		vType = new JLabel("Vehicle Type");
		String[] vSelections = { "Bike", "Car" };
		vBox = new JComboBox(vSelections);
		left.add(vType);
		left.add(vBox);

		DecimalFormat licenseFormat = new DecimalFormat("0000");
	    MaskFormatter licenseFormatter = null;
	    
		try {
			licenseFormatter = new MaskFormatter("UU## UUU");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
	    licenseFormatter.setValueClass(String.class);
	    
	    licenseFormatter.setAllowsInvalid(true);
	    licenseFormatter.setCommitsOnValidEdit(true);
	    
		lPlate = new JLabel("License Plate");
		lPlateBox = new JFormattedTextField(licenseFormatter);
		
		lPlateBox.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(lPlateBox.getText().length() == 4) {
					lPlateBox.setText(lPlateBox.getText() + " ");
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		left.add(lPlate);
		left.add(lPlateBox);
		
		int now = Calendar.getInstance().get(Calendar.YEAR);
		
		DecimalFormat yearFormat = new DecimalFormat("0000");
	    NumberFormatter yearFormatter = new NumberFormatter(yearFormat);
	    yearFormatter.setValueClass(Integer.class);
	    
	    yearFormatter.setMinimum(1850);
	    yearFormatter.setMaximum(now);
	    yearFormatter.setAllowsInvalid(true);
	    yearFormatter.setCommitsOnValidEdit(true);
	    
	    
		year = new JLabel("Year of Manufacture");
		manufactureYear = new JFormattedTextField(yearFormatter);
		left.add(year);
		left.add(manufactureYear);
		
		colour = new JLabel("Colour");
		colourBox = new JTextField();
		
		colourBox.addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent arg0) {
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						try {
							String up = colourBox.getText().substring(0, 1).toUpperCase() + colourBox.getText().substring(1);
							colourBox.setText(up);
						} catch(Exception ex) {
							
						}
					}
			
				});
		left.add(colour);
		left.add(colourBox);
		
		DecimalFormat format = new DecimalFormat("0.##");
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Double.class);

	    
	    formatter.setMinimum(Double.MIN_VALUE);
	    formatter.setMaximum(Double.MAX_VALUE);
	    formatter.setAllowsInvalid(true);
	    formatter.setCommitsOnValidEdit(true);
	    valueField = new JFormattedTextField(formatter);
	    
		value = new JLabel("Value");
		left.add(value);
		left.add(valueField);
		
		engineSize = new JLabel("Engine Size (L)");
		engineSizeField = new JFormattedTextField();
		left.add(engineSize);
		left.add(engineSizeField);
		
		bikeType = new JLabel("Bike Type");
		String[] bSelections = { "Sports", "Tourer", "Trials" };
		bBox = new JComboBox(bSelections);
		left.add(bikeType);
		left.add(bBox);
		
		DecimalFormat singleNumFormat = new DecimalFormat("##");
	    NumberFormatter singleNumFormatter = new NumberFormatter(singleNumFormat);
	    singleNumFormatter.setValueClass(Integer.class);
	    
	    singleNumFormatter.setMinimum(0);
	    singleNumFormatter.setMaximum(99);
	    singleNumFormatter.setAllowsInvalid(true);
	    singleNumFormatter.setCommitsOnValidEdit(true);
	    
		numDoors = new JLabel("Number of Doors");
		numDoorsField = new JFormattedTextField(singleNumFormatter);
		left.add(numDoors);
		left.add(numDoorsField);
		
		numSeats = new JLabel("Number of Seats");
		numSeatsField = new JFormattedTextField(singleNumFormatter);
		left.add(numSeats);
		left.add(numSeatsField);
		
		engineType = new JLabel("Engine Type");
		String[] eSelections = { "Petrol", "Diesel" };
		eBox = new JComboBox(eSelections);
		left.add(engineType);
		left.add(eBox);
		
		JButton add = new JButton("Add");
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Vehicle vehicle;
				
				switch(vBox.getSelectedItem().toString().toLowerCase() ) {
					case "car": 
						try {
							vehicle = new Car(lPlateBox.getText(), Integer.parseInt(manufactureYear.getText()), colourBox.getText(), 
									Double.parseDouble(valueField.getText()),  Integer.parseInt(numDoorsField.getText()),  Integer.parseInt(numSeatsField.getText()), 
									eBox.getSelectedItem().toString(), Double.parseDouble(engineSizeField.getText()), frame.getMuseum().getObjects().size());
							frame.getMuseum().addObject(vehicle);
							JOptionPane.showMessageDialog(frame.getJFrame(), "Added Car to the Museum.", "Success", JOptionPane.INFORMATION_MESSAGE);
							clearFields();
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(frame.getJFrame(), "Error adding vehicle, please check your input", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case "bike":
						try {
							vehicle = new Bike(lPlateBox.getText(), Integer.parseInt(manufactureYear.getText()), colourBox.getText(), 
									Double.parseDouble(valueField.getText()),  bBox.getSelectedItem().toString(), 
									Double.parseDouble(engineSizeField.getText()), frame.getMuseum().getObjects().size());
							frame.getMuseum().addObject(vehicle);
							JOptionPane.showMessageDialog(frame.getJFrame(), "Added Bike to the Museum", "Success", JOptionPane.INFORMATION_MESSAGE);
							clearFields();
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(frame.getJFrame(), "Error adding vehicle, please check your input", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					default:
						break;
				}
			}
			
		});
		
		right.add(add);
		
		vBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selection = (String)vBox.getSelectedItem();
				focusFields(selection);
			}
			
		});
		
		add(container);
		
		fields.addAll(Arrays.asList(vType, lPlate, year, colour, value,
				numDoors, numSeats, engineType, engineSize, bikeType, vBox, eBox, bBox, 
				lPlateBox, manufactureYear, colourBox, valueField, numDoorsField, numSeatsField, engineSizeField));
		
		vBox.setSelectedIndex(1);
		focusFields(vBox.getSelectedItem().toString().toLowerCase());

	}
	
	private void checkFields() {
		for (JComponent field : fields) {
			if(field.isEnabled()) {
				field.setVisible(true);
			} else {
				field.setVisible(false);
			}
		}
	}
	
	private void clearFields() {
		for(JComponent field : fields) {
			if(field instanceof JTextField) {
				((JTextField) field).setText("");
			}
		}
	}
	
	private void focusFields(String selection) {
		switch(selection.toLowerCase()) {
			case "car":
				
				bBox.setEnabled(false);
				bikeType.setEnabled(false);
				
				numSeatsField.setEnabled(true);
				numDoorsField.setEnabled(true);
				
				numSeats.setEnabled(true);
				numDoors.setEnabled(true);
				
				eBox.setEnabled(true);
				
				DecimalFormat doubleNumFormat = new DecimalFormat("#.##");
			    NumberFormatter doubleNumFormatter = new NumberFormatter(doubleNumFormat);
			    doubleNumFormatter.setValueClass(Double.class);
			    
			    doubleNumFormatter.setMinimum(0.0);
			    doubleNumFormatter.setMaximum(5.0);
			    doubleNumFormatter.setAllowsInvalid(true);
			    doubleNumFormatter.setCommitsOnValidEdit(true);
			    DefaultFormatterFactory factory2 = new DefaultFormatterFactory(doubleNumFormatter); 
			    engineSizeField.setFormatterFactory(factory2);
				engineType.setEnabled(true);
				
				engineSize.setText("Engine Size (L)");
				
				break;
			case "bike":
				bBox.setEnabled(true);
				bikeType.setEnabled(true);
				
				numSeatsField.setEnabled(false);
				numDoorsField.setEnabled(false);
				numSeats.setEnabled(false);
				numDoors.setEnabled(false);
				
				eBox.setEnabled(false);
				engineType.setEnabled(false);
				
				doubleNumFormat = new DecimalFormat("####");
			    doubleNumFormatter = new NumberFormatter(doubleNumFormat);
			    doubleNumFormatter.setValueClass(Integer.class);
			    
			    doubleNumFormatter.setMinimum(0);
			    doubleNumFormatter.setMaximum(2500);
			    doubleNumFormatter.setAllowsInvalid(true);
			    doubleNumFormatter.setCommitsOnValidEdit(true);
			    factory2 = new DefaultFormatterFactory(doubleNumFormatter); 
			    engineSizeField.setFormatterFactory(factory2);
			    
				engineSize.setText("Engine Size (cc)");
				break;
			default:
				break;
		}
		checkFields();
		clearFields();
	}
	
}
