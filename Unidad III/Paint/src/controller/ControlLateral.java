package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import paint.Draw;

public class ControlLateral implements ActionListener {
	private Draw paint;
	public ControlLateral(Draw paint) {
		this.paint = paint;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String choose = e.getActionCommand();
		switch (choose) {
		case "DELETE":
			paint.setFlag(false);
			break;
		case "MOVE":
			paint.setFlag(true);
			break;
		default:
			break;
		}
	}
	
	
}
