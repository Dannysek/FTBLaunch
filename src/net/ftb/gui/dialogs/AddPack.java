package net.ftb.gui.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import net.ftb.data.ModPack;
import net.ftb.data.Settings;
import net.ftb.util.ErrorUtils;

public class AddPack extends JDialog {
	public AddPack() {
		getContentPane().setLayout(null);
		setBounds(300, 300, 300, 120);

		textField = new JTextField();
		textField.setBounds(10, 11, 264, 30);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 52, 126, 23);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(/*DownloadUtils.staticFileExists(textField.getText() + ".xml") && */!textField.getText().isEmpty()) {
					System.out.println("Adding: " + textField.getText());
					ModPack.loadXml(new String[]{textField.getText() + ".xml"});
					Settings.getSettings().addPrivatePack(textField.getText());
					Settings.getSettings().save();
					setVisible(false);
				} else {
					ErrorUtils.tossError("Invalid Private Pack.");
				}
			}
		});
		getContentPane().add(btnAdd);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(146, 52, 128, 23);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		getContentPane().add(btnCancel);
		getRootPane().setDefaultButton(btnAdd);
	}
	private static final long serialVersionUID = 1L;
	private JTextField textField;
}
