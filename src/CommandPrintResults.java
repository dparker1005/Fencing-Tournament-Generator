import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;


public class CommandPrintResults implements ActionListener 
{
	Component comp;
	
	public CommandPrintResults(PoolResultsView res)
	{
		res.setJMenuBar(null);
		comp = res;
		res.setJMenuBar(res.mbar);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(new PrintResults(comp));
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
