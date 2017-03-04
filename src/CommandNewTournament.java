import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CommandNewTournament implements ActionListener 
{
	IntroView view;
	public CommandNewTournament(IntroView viewIn) 
	{
		view = viewIn;
	}
	
	public void actionPerformed(ActionEvent target) 
	{
		view.HideWindow();
		new NewTournamentView();
	}
}