import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CommandLoadTournament implements ActionListener 
{
	IntroView view;
	
	public CommandLoadTournament(IntroView viewIn)
	{
		view = viewIn;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		FileFilter filter = new CSVFileFilter();
		
		JFileChooser chooser = new JFileChooser(); 
		chooser.addChoosableFileFilter(filter);
		 int returnVal = chooser.showOpenDialog(view);
		 if(returnVal == JFileChooser.APPROVE_OPTION) 
		 {
		       view.HideWindow();
		       new CSVReader(chooser.getSelectedFile());
		 }
		
	}

}
