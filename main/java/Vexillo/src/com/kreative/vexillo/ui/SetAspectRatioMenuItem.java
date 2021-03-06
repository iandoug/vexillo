package com.kreative.vexillo.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class SetAspectRatioMenuItem extends JMenuItem {
	private static final long serialVersionUID = 1L;
	
	public SetAspectRatioMenuItem(String text, int mn, int acc, final FlagFrame frame, final int n, final int d) {
		setText(text);
		if (mn != 0 && !OSUtils.isMacOS()) setMnemonic(mn);
		if (acc != 0) setAccelerator(KeyStroke.getKeyStroke(acc, 0));
		if (frame == null) {
			setEnabled(false);
		} else {
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					frame.setAspectRatio(n, d);
				}
			});
		}
	}
}