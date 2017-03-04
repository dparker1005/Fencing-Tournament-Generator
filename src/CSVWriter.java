import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class CSVWriter 
{
	int numberOfPeople; 
	Fencer[] fencers;
	File file;
	String tournamentName;
	
	public CSVWriter(int numberOfPeopleIn, Fencer[] fencersIn, File fileIn, String tournamentNameIn)
	{
		numberOfPeople = numberOfPeopleIn;
		fencers = fencersIn;
		file = fileIn;
		tournamentName = tournamentNameIn;
		
		try 
		{
			FileWriter newFile = new FileWriter(file);
			PrintWriter buff = new PrintWriter(newFile);
			
			buff.println(tournamentName);
			
			for(int x = 0; x<numberOfPeople; x++)
			{
				buff.println(fencers[x].name+","+ fencers[x].vs1 +","+fencers[x].vs2+","+ fencers[x].vs3+","+ fencers[x].vs4+","+ fencers[x].vs5+","+ fencers[x].vs6+","+ fencers[x].vs7+","+ fencers[x].vs8+","+ fencers[x].vs9);
			}
			
			buff.close();
			newFile.close();
			
			new CSVReader(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
