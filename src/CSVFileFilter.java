import javax.swing.filechooser.*;
import java.io.File;

public class CSVFileFilter extends FileFilter 
{

	public boolean	accept(File f) 
	   {
	       String name = f.getName().toLowerCase();
	       return name.endsWith( ".csv" );
	   }
	public String getDescription()
	{ 
		return "CSV File"; 
	}
}
