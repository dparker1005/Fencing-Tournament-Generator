import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class IntroView extends JFrame 
{
	JButton btNew = new JButton("New Tournament");
	JButton btLoad = new JButton("Load Tournament");
	public IntroView()
	{
		setTitle( "Fencing Tournament Generator" );
		Container c = getContentPane();
		c.setLayout( new GridLayout(2,1) );
				
		c.add(btNew);
		btNew.addActionListener(new CommandNewTournament(this));
		c.add(btLoad);
		btLoad.addActionListener(new CommandLoadTournament(this));
		
		setSize( 300, 100 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	public void HideWindow()
	{
		setVisible(false);
	}
}
