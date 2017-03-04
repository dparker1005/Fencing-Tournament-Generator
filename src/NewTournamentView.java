import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NewTournamentView extends JFrame 
{
	JLabel lbTournamentName = new JLabel("Tournament Name:");
	JTextField tfTournamentName = new JTextField(20);
	
	JButton btAdd = new JButton("Add Fencer");
	JButton btDelete = new JButton("Remove Fencer");
	
	int numberOfFencers = 7;
	JTextField fencers[] = new JTextField[9];
	
	/*
	JTextField fencer1 = new JTextField(20);
	JTextField fencer2 = new JTextField(20);
	JTextField fencer3 = new JTextField(20);
	JTextField fencer4 = new JTextField(20);
	JTextField fencer5 = new JTextField(20);
	JTextField fencer6 = new JTextField(20);
	JTextField fencer7 = new JTextField(20);
	JTextField fencer8 = new JTextField(20);
	JTextField fencer9 = new JTextField(20);
	*/
	
	JButton btBack = new JButton("Back");
	JButton btStart = new JButton("Start Competition");
	
	
	public NewTournamentView()
	{
		setTitle( "New Tournament" );
		Container c = getContentPane();
		c.setLayout( new BorderLayout());
		
		for(int x=0;x<=8;x++)
		{
			fencers[x] = new JTextField(20);
		}
		
		fencers[0].setText("Fencer 1");
		fencers[1].setText("Fencer 2");
		fencers[2].setText("Fencer 3");
		fencers[3].setText("Fencer 4");
		fencers[4].setText("Fencer 5");
		fencers[5].setText("Fencer 6");
		fencers[6].setText("Fencer 7");
		fencers[7].setText("Fencer 8");
		fencers[8].setText("Fencer 9");
		
		
		JPanel tournamentName = new JPanel(new GridLayout(1,2));
		tournamentName.add(lbTournamentName);
		tournamentName.add(tfTournamentName);
		c.add(tournamentName, BorderLayout.NORTH);
		
		JPanel listOfFencers = new JPanel(new BorderLayout());
		JPanel listOfFencersButtons = new JPanel(new GridLayout(1,2));
		listOfFencersButtons.add(btAdd);
		listOfFencersButtons.add(btDelete);
		btAdd.addActionListener(new CommandAddFencer(this));
		btDelete.addActionListener(new CommandRemoveFencer(this));
		listOfFencers.add(listOfFencersButtons, BorderLayout.NORTH);
		
		JPanel listOfFencersList = new JPanel(new GridLayout(9,1));
		listOfFencersList.add(fencers[0]);
		listOfFencersList.add(fencers[1]);
		listOfFencersList.add(fencers[2]);
		listOfFencersList.add(fencers[3]);
		listOfFencersList.add(fencers[4]);
		listOfFencersList.add(fencers[5]);
		listOfFencersList.add(fencers[6]);
		listOfFencersList.add(fencers[7]);
		listOfFencersList.add(fencers[8]);
		
		fencers[7].setVisible(false);
		fencers[8].setVisible(false);
		
		listOfFencers.add(listOfFencersList);
		c.add(listOfFencers);
		
		JPanel otherButtons = new JPanel(new GridLayout(1,2));
		otherButtons.add(btBack);
		btBack.addActionListener(new CommandBack(this));
		otherButtons.add(btStart);
		btStart.addActionListener(new CommandStartTournament(this));
		c.add(otherButtons, BorderLayout.SOUTH);
		
		
		setSize( 500, 300 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	public void HideWindow()
	{
		setVisible(false);
	}

	public void AddFencer() 
	{
		if(numberOfFencers<=8)
		{
			fencers[numberOfFencers].setVisible(true);
			numberOfFencers++;
		}
	}

	public void RemoveFencer() 
	{
		if(numberOfFencers>=4)
		{
			fencers[numberOfFencers-1].setVisible(false);
			numberOfFencers--;
		}
	}
	

	public void start(File writeMe) 
	{
		try 
		{
			writeMe.createNewFile();
			
			FileWriter file = new FileWriter(writeMe.getAbsolutePath());
			PrintWriter buff = new PrintWriter(file);
			
			buff.println(tfTournamentName.getText());
			
			for(int x = 0; x<numberOfFencers; x++)
			{
				buff.println(fencers[x].getText());
			}
			
			buff.close();
			file.close();
			setVisible(false);
			new CSVReader(writeMe);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	public void commaError()
	{
		JOptionPane.showMessageDialog(this,"Please do not have commas in the tournament name or the names of the fencers.");
	}
	public void emptyError()
	{
		JOptionPane.showMessageDialog(this,"Please make sure that all fields are filled.");
	}
}
