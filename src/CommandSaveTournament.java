import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class CommandSaveTournament implements ActionListener 
{
	int numberOfPeople = 0;
	Fencer[] fencers;
	File file;
	String tournamentName;
	
	public CommandSaveTournament(int numberIn, Fencer[] fencersIn, File fileIn, String tournamentNameIn)
	{
		numberOfPeople = numberIn;
		fencers = fencersIn;
		file = fileIn;
		tournamentName = tournamentNameIn;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		new CSVWriter(numberOfPeople, fencers, file, tournamentName);

	}

}
