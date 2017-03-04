import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class CommandPools implements ActionListener 
{
	PoolResultsView view;
	File file;
	
	public CommandPools(PoolResultsView viewIn, File fileIn) 
	{
		view = viewIn;
		file = fileIn;
	}
	
	public void actionPerformed(ActionEvent target) 
	{
		view.HideWindow();
		new CSVReader(file );
	}
}
