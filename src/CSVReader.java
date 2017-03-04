import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;



public class CSVReader 
{
	Fencer[] fencers;
	String tournamentName = "";

	public CSVReader(File file)
	{
		String path = file.getAbsolutePath();
		LineNumberReader  lnr = null;
		try 
		{
		//following 2 lines of code from stackoverflow.com
		lnr = new LineNumberReader(new FileReader(file));
			lnr.skip(Long.MAX_VALUE);
		} 
		catch ( FileNotFoundException ex )
        {
            System.out.println( "Error Reading File." + ex.getMessage() );
        }
        catch ( IOException ex )
        {
            System.out.println( "Error Reading File" + ex.getMessage() );
        }
		int numberOfLines=lnr.getLineNumber();
		
		fencers = new Fencer[numberOfLines];
		
		try
		{
			FileReader fileReader = new FileReader(file.getAbsolutePath());
			BufferedReader buffer = new BufferedReader( fileReader );
			
			tournamentName = buffer.readLine().split(",")[0];
			
			int x=0;
			String line = buffer.readLine();
			//System.out.println( "reading line >> " + line );
			while ( line != null)
            {
                String[] fields = line.split( "," );
    		//	System.out.println( "number of tokens in line >> " + fields.length );
                
                int score1=-1;
                int score2=-1;
                int score3=-1;
                int score4=-1;
                int score5=-1;
                int score6=-1;
                int score7=-1;
                int score8=-1;
                int score9=-1;
                
                switch(fields.length)
                {
                case 10:
                if(fields[9]!=null)score9=Integer.parseInt(fields[9]);
                case 9:
                if(fields[8]!=null)score8=Integer.parseInt(fields[8]);
                case 8:
                if(fields[7]!=null)score7=Integer.parseInt(fields[7]);
                case 7:
                if(fields[6]!=null)score6=Integer.parseInt(fields[6]);
                case 6:
                if(fields[5]!=null)score5=Integer.parseInt(fields[5]);
                case 5:
                if(fields[4]!=null)score4=Integer.parseInt(fields[4]);
                case 4:
                if(fields[3]!=null)score3=Integer.parseInt(fields[3]);
                case 3:
                if(fields[2]!=null)score2=Integer.parseInt(fields[2]);
                case 2:
                if(fields[1]!=null)score1=Integer.parseInt(fields[1]);
                }
                
                fencers[x] = new Fencer(x+1, fields[0],score1, score2, score3, score4, score5, score6, score7, score8, score9);
    			x++;
    			line = buffer.readLine();
            }
            buffer.close(); 
            fileReader.close();
        }
        catch ( FileNotFoundException ex )
        {
            System.out.println( "Error Reading File." + ex.getMessage() );
        }
        catch ( IOException ex )
        {
            System.out.println( "Error Reading File" + ex.getMessage() );
        }
		new PoolView(tournamentName, fencers, file);
	}
}
