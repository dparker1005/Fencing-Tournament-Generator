
public class Fencer 
{
	int id = 0;
	String name = "";

	int vs1 =-1;
	int vs2 =-1;
	int vs3 =-1;
	int vs4 =-1;
	int vs5 =-1;
	int vs6 =-1;
	int vs7 =-1;
	int vs8 =-1;
	int vs9 =-1;
	
	int victories;
	int ts; 
	int tr;
	int ind;
	
	public Fencer()
	{
		
	}
	
	public Fencer(int idIn, String nameIn, int f1In,int f2In,int f3In,int f4In,int f5In,int f6In,int f7In,int f8In,int f9In)
	{
		id = idIn;
		name = nameIn;
		
		vs1 = f1In;
		vs2 = f2In;
		vs3 = f3In;
		vs4 = f4In;
		vs5 = f5In;
		vs6 = f6In;
		vs7 = f7In;
		vs8 = f8In;
		vs9 = f9In;
	}
	
	public void setInd()
	{
		ind = ts-tr;
	}
}