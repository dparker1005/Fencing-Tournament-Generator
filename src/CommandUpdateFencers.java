import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CommandUpdateFencers implements ActionListener {

	int numberOfPeople = 0;
	Fencer[] fencers;
	File file;
	String tournamentName;
	JTextField[][] fencerScores;
	String todo;
	PoolView view;
	PoolResultsView results = null;
	
	public CommandUpdateFencers(PoolView viewIn, int numberIn, Fencer[] fencersIn, File fileIn, String tournamentNameIn,JTextField[][] fencerScoresIn, String todoIn)
	{
		view = viewIn;
		numberOfPeople = numberIn;
		fencers = fencersIn;
		file = fileIn;
		tournamentName = tournamentNameIn;
		fencerScores = fencerScoresIn;
		todo = todoIn;
	}
	
	public CommandUpdateFencers(PoolView viewIn, int numberIn, Fencer[] fencersIn, File fileIn, String tournamentNameIn,JTextField[][] fencerScoresIn, String todoIn, PoolResultsView resultsIn)
	{
		view = viewIn;
		numberOfPeople = numberIn;
		fencers = fencersIn;
		file = fileIn;
		tournamentName = tournamentNameIn;
		fencerScores = fencerScoresIn;
		todo = todoIn;
		results = resultsIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int x = 0; x<numberOfPeople; x++)
		{
			switch(numberOfPeople)
			{
			case 9:
			if(x==8){fencers[x].vs9=-1;}
			else if(isInt(fencerScores[x][8].getText())){fencers[x].vs9 = Integer.parseInt(fencerScores[x][8].getText());}
			else{fencers[x].vs9=-1;}
			
			case 8:
				if(x==7){fencers[x].vs8=-1;}
				else if(isInt(fencerScores[x][7].getText())){fencers[x].vs8 = Integer.parseInt(fencerScores[x][7].getText());}
				else{fencers[x].vs8=-1;}
				
			case 7:
				if(x==6){fencers[x].vs7=-1;}
				else if(isInt(fencerScores[x][6].getText())){fencers[x].vs7 = Integer.parseInt(fencerScores[x][6].getText());}
				else{fencers[x].vs7=-1;}
				
			case 6:
				if(x==5){fencers[x].vs6=-1;}
				else if(isInt(fencerScores[x][5].getText())){fencers[x].vs6 = Integer.parseInt(fencerScores[x][5].getText());}
				else{fencers[x].vs6=-1;}
			
			case 5:
				if(x==4){fencers[x].vs5=-1;}
				else if(isInt(fencerScores[x][4].getText())){fencers[x].vs5 = Integer.parseInt(fencerScores[x][4].getText());}
				else{fencers[x].vs5=-1;}
				
			case 4:
				if(x==3){fencers[x].vs4=-1;}
				else if(isInt(fencerScores[x][3].getText())){fencers[x].vs4 = Integer.parseInt(fencerScores[x][3].getText());}
				else{fencers[x].vs4=-1;}
				
			case 3:
				if(x==2){fencers[x].vs3=-1;}
				else if(isInt(fencerScores[x][2].getText())){fencers[x].vs3 = Integer.parseInt(fencerScores[x][2].getText());}
				else{fencers[x].vs3=-1;}
			case 2:
				if(x==1){fencers[x].vs2=-1;}
				else if(isInt(fencerScores[x][1].getText())){fencers[x].vs2 = Integer.parseInt(fencerScores[x][1].getText());}
				else{fencers[x].vs2=-1;}
				
			case 1:
				if(x==0){fencers[x].vs1=-1;}
				else if(isInt(fencerScores[x][0].getText())){fencers[x].vs1 = Integer.parseInt(fencerScores[x][0].getText());}
				else{fencers[x].vs1=-1;}
				
			}
		}
		if(todo.equals("save"))
		{
			if(results!=null)
			{
				results.HideWindow();
			}
			view.HideWindow();
			new CSVWriter(numberOfPeople, fencers, file, tournamentName);
		}
		if(todo.equals("results"))
		{
			if(isValidScores())
			{
				view.HideWindow();
				new PoolResultsView(tournamentName,fencers,file,view);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter valid scores up to 5.");
				view.HideWindow();
				new CSVWriter(numberOfPeople, fencers, file, tournamentName);
			}
		}
		
	}
	
	public boolean isValidScores()
	{
		for(int x=0; x<numberOfPeople; x++)
		{
			for(int y=0; y<numberOfPeople; y++)
			{
				if(x==y){continue;}
				if(isScore(fencerScores[x][y].getText())){continue;}
				else{return false;}
			}
		}
		return true;
	}
	
	public boolean isInt(String string)
	{
		if(string.length() == 0){return false;}
		
		String goodCharacters = "0123456789";
		for(int charIndex=0; charIndex<string.length(); charIndex++)
		{
			char testLetter = string.charAt(charIndex);
			if(goodCharacters.indexOf(testLetter) == -1)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean isScore(String string)
	{
		if(string.length() == 1)
		{
			String goodCharacters = "012345";
			char testLetter = string.charAt(0);
			if(goodCharacters.indexOf(testLetter) == -1)
			{
				return false;
			}
			return true;
		}
		else{return false;}
		
	
		
	}

}
