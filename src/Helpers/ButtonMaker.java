package Helpers;

import javax.swing.JButton;

public class ButtonMaker {

	public static JButton CreateButton(String buttonLabel, String buttonName) {
		JButton button = new JButton();
		button.setLabel(buttonLabel);
		button.setName(buttonName);
		return button;
	}
	
}
