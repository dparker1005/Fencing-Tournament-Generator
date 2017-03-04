import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;


public class CommandAddFencer implements ActionListener {

	NewTournamentView view;
	
	public CommandAddFencer(NewTournamentView viewIn)
	{
		view = viewIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		view.AddFencer();
	}
	
}
