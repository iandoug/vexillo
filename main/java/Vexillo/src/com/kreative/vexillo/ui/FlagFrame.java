package com.kreative.vexillo.ui;

import java.io.File;
import javax.swing.JFrame;
import com.kreative.vexillo.core.Flag;

public class FlagFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private final FlagPanel panel;
	
	public FlagFrame(File parent, Flag flag) {
		this(flag.getName(), parent, flag);
	}
	
	public FlagFrame(String title, File parent, Flag flag) {
		super(title);
		setJMenuBar(new FlagMenuBar(this));
		panel = new FlagPanel(parent, flag);
		setContentPane(panel);
		pack();
	}
	
	public File getParentFile() {
		return panel.getParentFile();
	}
	
	public Flag getFlag() {
		return panel.getFlag();
	}
	
	public void setFlag(File parent, Flag flag) {
		panel.setFlag(parent, flag);
		pack();
	}
}