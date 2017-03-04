import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PoolView extends JFrame 
{
	/*
	 * lbNames[x] = new JLabel(fields[0]);
    			namePanel.add(lbNames[x]);
	 */
	
	int numberOfPeople = 0;
	
	JLabel[] lbNames;
	
	JTextField[][] fencerScores;
	
	String tournamentName;
	Fencer[] fencers;
	
	File file;
	
	JMenuBar mbar;
	public PoolView(String tournamentNameIn, Fencer[] fencersIn, File fileIn)
	{
		tournamentName = tournamentNameIn;
		fencers = fencersIn;
		numberOfPeople = -1+fencers.length;
		file = fileIn;
		lbNames = new JLabel[numberOfPeople+1];
		fencerScores = new JTextField[numberOfPeople][numberOfPeople];
		//System.out.println(numberOfPeople);
		//JFrame Setup
		setTitle( tournamentName );
		Container c = getContentPane();
		c.setLayout( new GridLayout(1,2));
				
		//Menu Bar
		//I'm not sure if I should use a single dropdown or if that would look weird...
		mbar = new JMenuBar();
		JMenuItem mnuSave = new JMenuItem("Save");
		JMenuItem mnuResults = new JMenuItem("Results");
		JMenuItem mnuPrint = new JMenuItem("Print");
		mbar.add(mnuSave);
		mbar.add(mnuPrint);
		mbar.add(mnuResults);
		this.setJMenuBar(mbar);
		
		mnuSave.addActionListener(new CommandUpdateFencers(this, numberOfPeople, fencers, file, tournamentName, fencerScores, "save"));
		mnuResults.addActionListener(new CommandUpdateFencers(this, numberOfPeople, fencers, file, tournamentName, fencerScores, "results"));
		mnuPrint.addActionListener(new CommandPrintPools(this));

		//Name Panel
		JPanel namePanel = new JPanel(new GridLayout(numberOfPeople+1,1));
		lbNames[0] = new JLabel("Names:");
		namePanel.add(lbNames[0]);
		
		for(int x=1; x<=numberOfPeople; x++)
		{
			//System.out.println(fencers[x-1].name);
			lbNames[x] = new JLabel(fencers[x-1].name);
			namePanel.add(lbNames[x]);
		}
		
		/*
		//Fill Array fencerScores
		for(int x = 0; x<numberOfPeople; x++)
		{
			fencerScores[x] = new JTextField[numberOfPeople];
					for(int y = 0; x<1; x++)
					{
						fencerScores[x][y] = new JTextField(20);
					}
		}
		*/
		
		//Scores Panel
		JPanel scoresPanel = new JPanel(new GridLayout(numberOfPeople+1,numberOfPeople));
		
		for(int x=1; x<= numberOfPeople; x++)
		{
			scoresPanel.add(new JLabel("   "+x));
		}
	
		for(int x = 0; x<numberOfPeople; x++)
		{
			fencerScores[x] = new JTextField[numberOfPeople];
					for(int y = 0; y<numberOfPeople; y++)
					{
						fencerScores[x][y] = new JTextField(20);
						scoresPanel.add(fencerScores[x][y]);
					}
			//Insert Scores to Sheet		
			switch(numberOfPeople)
			{
			case 9: 
				if(fencers[x].vs9 != -1)fencerScores[x][8].setText(fencers[x].vs9+"");
			case 8: 
				if(fencers[x].vs8 != -1)fencerScores[x][7].setText(fencers[x].vs8+"");
			case 7: 
				if(fencers[x].vs7 != -1)fencerScores[x][6].setText(fencers[x].vs7+"");
			case 6: 
				if(fencers[x].vs6 != -1)fencerScores[x][5].setText(fencers[x].vs6+"");
			case 5: 
				if(fencers[x].vs5 != -1)fencerScores[x][4].setText(fencers[x].vs5+"");
			case 4: 
				if(fencers[x].vs4 != -1)fencerScores[x][3].setText(fencers[x].vs4+"");
			}
			if(fencers[x].vs3 != -1)fencerScores[x][2].setText(fencers[x].vs3+"");
			if(fencers[x].vs2 != -1)fencerScores[x][1].setText(fencers[x].vs2+"");
			if(fencers[x].vs1 != -1)fencerScores[x][0].setText(fencers[x].vs1+"");
		}
		
		for(int x = 0; x<numberOfPeople; x++)
		{
					for(int y = 0; y<numberOfPeople; y++)
					{
						if(x==y)
						{
							fencerScores[x][y].setText("/#/");
						}
					}
		}
		
		//Add to JFrame
		c.add(namePanel);
		c.add(scoresPanel);
		
		//Other JFrame Stuff
		setSize( 500, 300 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	public void setVictories()
	{
		for(int row = 0; row<numberOfPeople; row++)
		{
			int x = 0;	
			
			for(int y = 0; y<numberOfPeople; y++)
			{
				if(fencerScores[row][y].getText().equals("5"))
				{
					x++;
				}
			}
			fencers[row].victories=x;
		}
	}
	
	public void setPointsScored()
	{
		for(int row = 0; row<numberOfPeople; row++)
		{
			int points = 0;	
			
			for(int y = 0; y<numberOfPeople; y++)
			{
				if(row!=y){points=points+Integer.parseInt(fencerScores[row][y].getText());}
			}
			
			fencers[row].ts = points;
		}

	}
	
	public void setPointsLost()
	{
		for(int row = 0; row<numberOfPeople; row++)
		{
			int points = 0;	
			
			for(int y = 0; y<numberOfPeople; y++)
			{
				if(row!=y){points=points+Integer.parseInt(fencerScores[y][row].getText());}
			}
			
			fencers[row].tr = points;
		}
	}
	
	public void setIndicator()
	{
		for(int row = 0; row<numberOfPeople; row++)
		{
			fencers[row].setInd();
		}
	}
	
	public void HideWindow()
	{
		this.setVisible(false);
	}
}
