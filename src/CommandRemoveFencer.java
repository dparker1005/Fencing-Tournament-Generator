import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;


public class CommandRemoveFencer implements ActionListener {

	NewTournamentView view;
	
	public CommandRemoveFencer(NewTournamentView viewIn)
	{
		view = viewIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		view.RemoveFencer();
	}
	
}
