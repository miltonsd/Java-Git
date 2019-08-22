package entities;

public class Entity 
{   //constructor
	public Entity()
	{
		this.setState(States.New);
		
	}

	//variables
	private States _State;
	private int _ID;
	
	
	//propiedades
	public States getState() 
{
		return _State;
	}
	public void setState(States State) 
{
		this._State=State;
	}
	public int getID()
 {
		return this._ID;
	}
    public void setID(int id) 
	{
		this._ID=id;
	}
	public enum States 
	{
		Deleted,
		New,
		Modified,
		Unmodified,
		
		
		
		
		
	}
	

}
