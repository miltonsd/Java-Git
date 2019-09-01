package entities;

public interface Entity 
{   
	
	//Enum Estados
	public static enum States 
	{
		Deleted,
		New,
		Modified,
		Unmodified,
	
	}
	
	
	//Metodos
	public default  States getState() 
    {return null;}
	public default  void setState(States state) 
    {
		
    }
	
	public default  Object getID() 
	{
     return null;
	}
	public default void setID(Object id)
	{
		
	}

}
