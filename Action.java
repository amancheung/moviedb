//**********************************************************
//
//Author: Cheung Lap Yan
//
//*********************************************************

public class Action extends Movie{
	
	//datafield
	private int explosions;
	
	//getter for explosions
	public int getExplosions(){
		return this.explosions;
	}
	
	//setter for valid values
	public void setExplosions(int explosions){
		if (explosions>=1&&explosions<=100){
			this.explosions=explosions;
		} else {
			//exception if invalid
			throw new IllegalArgumentException("Invalid explosion");
		}
	}
	
	//constructor
	public Action(String title, int year, int duration, double rating, int explosions){
		super(rating, year, duration, title);
		setExplosions(explosions);
	}
	
	//override to string
	public String toString(){
		return super.toString()+String.format(", explosions: %d", this.explosions);
	}
	
	//specific getPrice method
	public double getPrice(){
		return  (this.year + this.explosions * this.duration)/1000.0;
	}
}
