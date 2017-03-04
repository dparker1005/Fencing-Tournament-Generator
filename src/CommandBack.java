import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CommandBack implements ActionListener 
{
	NewTournamentView view;
	public CommandBack(NewTournamentView viewIn) 
	{
		view = viewIn;
	}
	
	public void actionPerformed(ActionEvent target) 
	{
		view.HideWindow();
		new IntroView();
	}
}