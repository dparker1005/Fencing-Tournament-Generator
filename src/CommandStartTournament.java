import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CommandStartTournament implements ActionListener 
{
	NewTournamentView view;
	
	public CommandStartTournament(NewTournamentView viewIn)
	{
		view = viewIn;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(view.tfTournamentName.getText().equals("")){view.emptyError();return;}
		for(int x=0; x<9; x++)
		{
			if(view.fencers[x].getText().equals("")){view.emptyError();return;}
		}
		
		char test = (",").charAt(0);
		if(view.tfTournamentName.getText().indexOf(test) != -1){view.commaError();return;}
		for(int x=0; x<9; x++)
		{
			if(view.fencers[x].getText().indexOf(test) != -1){view.commaError();return;}
		}
		
		FileFilter filter = new CSVFileFilter();
		
		JFileChooser chooser = new JFileChooser(); 
		chooser.addChoosableFileFilter(filter);
		int returnVal = chooser.showSaveDialog(view);    
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{    
			File writeMe = chooser.getSelectedFile();
			String path = writeMe.getAbsolutePath();
			//System.out.println("You chose to save this file: " +  path );  
			if(!writeMe.getName().endsWith(".csv"))
			{
				System.out.println("Adding .csv");
				writeMe = new File(writeMe.getAbsoluteFile()+".csv");
				System.out.println("New Name: "+writeMe.getAbsoluteFile());
				/*
				if(!newFile.exists())
				{
					if(writeMe.renameTo(newFile));
					{
						System.out.println("File Renamed: "+writeMe.getName());
					}
				}
				*/
			}
			if(writeMe.exists())
			{
				int confirm = JOptionPane.showConfirmDialog(view, "This file already Exists. Would you like to say anyway?"); 
				if(confirm == 0)
				{
					view.start(writeMe);
				}
				else{return;}
			}
			view.start(writeMe);
			
		}
	}
}
