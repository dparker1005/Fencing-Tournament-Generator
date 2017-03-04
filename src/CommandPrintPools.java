import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;


public class CommandPrintPools implements ActionListener 
{
	Component comp;
	
	public CommandPrintPools(PoolView pool)
	{
		pool.setJMenuBar(null);
		comp = pool;
		pool.setJMenuBar(pool.mbar);
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(new PrintPools(comp));
		if(pj.printDialog())
		{
			try
			{
				pj.print();
			}
			
			catch(PrinterException e1)
			{
				System.out.println(e1);
			}
		}	

	}

}
