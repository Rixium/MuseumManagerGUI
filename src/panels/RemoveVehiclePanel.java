package panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import MainClasses.MainFrame;

public class RemoveVehiclePanel extends ParentPanel {

	JPanel container;
	JLabel confirmMessage = new JLabel("");
	
	public RemoveVehiclePanel(MainFrame frame) {
		super(frame, "Remove Vehicle");
		instanceName = "removeVehicle";
		
		container = new JPanel();
		container.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		
		
		JTextArea tarea = new JTextArea("Insert the vehicle ID, and click remove to remove the vehicle from the museum. The vehicle ID can be found using the List Vehicles, or Find Vehicle menu.");
		tarea.setWrapStyleWord(true);
		tarea.setLineWrap(true);
		tarea.setOpaque(false);
		tarea.setEditable(false);
		tarea.setFocusable(false);

		JLabel label = new JLabel("Vehicle ID  ");
		JTextField field = new JTextField(15);
		

		JButton button = new JButton("Remove");
		container.setBackground(Color.WHITE);
		
		
		/// Text area layout ////////////////
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridwidth = 2;
		gc.weightx = 1;
		gc.weighty = 2;
		container.add(tarea, gc);
		
		/// Label Layout ///////////////////
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 0;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.weightx = .1;
		gc.weighty = .1;
		container.add(label, gc);
		gc.weightx = 1;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		/// Field layout ///////////////////
		container.add(field, gc);

		gc.gridy = 2;
		gc.weighty = 10;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		container.add(confirmMessage, gc);
		
		/// Button Layout //////////////////
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.weightx = .2;
		gc.weighty = .2;
		
		container.add(button, gc);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int num = -1;
				
				try {
					num = Integer.parseInt(field.getText());
				} catch(Exception ex) {
					confirmMessage.setText("Input Error!");
					confirmMessage.setForeground(new Color(200, 100, 100));
				}
				
				if(num != -1) {
					if(frame.getMuseum().removeObject(num)) {
						confirmMessage.setText("Successfully Removed");
						confirmMessage.setForeground(new Color(100, 200, 100));
					} else {
						confirmMessage.setText("Object Not Found!");
						confirmMessage.setForeground(new Color(200, 100, 100));
					}
				}
				
				field.setText("");
			}
			
		});
		
		add(container);
	}
	
	@Override
	public void SetPanel() {
		super.SetPanel();
		confirmMessage.setText("");
	}
	
}
