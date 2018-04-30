package MainClasses;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import panels.AddVehiclePanel;
import panels.FindVehiclePanel;
import panels.ListVehiclePanel;
import panels.MainMenuPanel;
import panels.ParentPanel;
import panels.RemoveVehiclePanel;

public class MainFrame {

	HashMap<String, ParentPanel> panels = new HashMap<String, ParentPanel>();
	JFrame frame = new JFrame();
	CardLayout layout = null;
	Museum museum;
	ParentPanel currentPanel;
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	public MainFrame() {
		museum = new Museum("Unnamed", "Vehicle");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Museum Manager");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);

		frame.setBackground(new Color(255, 255, 255));
		layout = new CardLayout();
		frame.setLayout(layout);
		
		panels.put("mainMenu", new MainMenuPanel(this));
		panels.put("addVehicle", new AddVehiclePanel(this));
		panels.put("findVehicle", new FindVehiclePanel(this));
		panels.put("listVehicle", new ListVehiclePanel(this));
		panels.put("removeVehicle", new RemoveVehiclePanel(this));

		
		for(String key : panels.keySet()) {
			ParentPanel panel = panels.get(key);
			frame.add(panel, panel.getInstanceName());
		}
		
		currentPanel = panels.get("mainMenu");
		switchLayout("mainMenu");
		frame.setVisible(true);		
	}

	public JFrame getJFrame() {
		return frame;
	}
	
	public Museum getMuseum() {
		return museum;
	}
	
	public void switchLayout(String instanceName) {
		layout.show(frame.getContentPane(), instanceName);
		currentPanel = panels.get(instanceName);
		currentPanel.SetPanel();
	}
	
}
