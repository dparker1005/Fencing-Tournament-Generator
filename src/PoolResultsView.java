import java.awt.Container;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class PoolResultsView extends JFrame 
{
	String tournamentName;
	Fencer[] fencers;
	Fencer[] sortedFencers;
	int numberOfPeople;
	File file;
	PoolView pool;
	JMenuBar mbar;
	
	public PoolResultsView(String tournamentNameIn, Fencer[] fencersIn, File fileIn, PoolView viewIn)
	{
		tournamentName = tournamentNameIn;
		fencers = fencersIn;
		numberOfPeople = -1+fencers.length;
		file = fileIn;
		pool =viewIn;
		
		setTitle( tournamentName );
		Container c = getContentPane();
		c.setLayout( new GridLayout(numberOfPeople+1,6));
		
		//Update Fencers
		pool.setVictories();
		pool.setPointsScored();
		pool.setPointsLost();
		pool.setIndicator();
		
		//Make menu bar
		mbar = new JMenuBar();
		JMenuItem mnuSave = new JMenuItem("Save");
		JMenuItem mnuPools = new JMenuItem("Pools");
		JMenuItem mnuPrint = new JMenuItem("Print");
		mbar.add(mnuSave);
		mbar.add(mnuPrint);
		mbar.add(mnuPools);
		this.setJMenuBar(mbar);
		
		mnuSave.addActionListener(new CommandUpdateFencers(pool, numberOfPeople, fencers, file, tournamentName, pool.fencerScores, "save", this));
		mnuPrint.addActionListener(new CommandPrintResults(this));
		mnuPools.addActionListener(new CommandPools(this, file));
		
		//Sort fencers and save array
		sortedFencers=fencers;
		for(int index = 0; index<numberOfPeople-1; index++)
		{
			Fencer test = sortedFencers[index];
			int setNum = index;
			for(int scan = index+1; scan < numberOfPeople; scan++)
			{
				if(sortedFencers[scan].victories>test.victories)
				{
					test = sortedFencers[scan];
					setNum = scan;
				}
				else if(sortedFencers[scan].victories==test.victories)
				{
					if(sortedFencers[scan].ind>test.ind)
					{
						test = sortedFencers[scan];
						setNum = scan;
					}
					else if(sortedFencers[scan].ind==test.ind)
					{
						if(sortedFencers[scan].ts>test.ts)
						{
							test = sortedFencers[scan];
							setNum = scan;
						}
					}
				}
			}
			Fencer temp = sortedFencers[index];
			sortedFencers[index]=test;
			sortedFencers[setNum]=temp;
		}
		
		//Add to gui
		c.add(new JLabel("Place"));
		c.add(new JLabel("Name"));
		c.add(new JLabel("Victories"));
		c.add(new JLabel("TS"));
		c.add(new JLabel("TR"));
		c.add(new JLabel("IND"));
		
		for(int x = 0;x<=numberOfPeople-1 ;x++)
		{
			c.add(new JLabel(""+(x+1)));
			c.add(new JLabel(""+sortedFencers[x].name));
			c.add(new JLabel(""+sortedFencers[x].victories));
			c.add(new JLabel(""+sortedFencers[x].ts));
			c.add(new JLabel(""+sortedFencers[x].tr));
			c.add(new JLabel(""+sortedFencers[x].ind));
		}
		
		setSize( 500, 300 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	public void HideWindow()
	{
		this.setVisible(false);
	}
	
}
