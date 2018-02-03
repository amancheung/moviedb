//**********************************************************
//
//Author: Cheung Lap Yan
//
//*********************************************************

public class RomCom extends Movie{
	private int jerks;
	private int friendZones;
	
	//getting and setters for data
	public int getJerks(){
		return this.jerks;
	}
	
	public void setJerks(int jerks){
		if (jerks>=1&&jerks<=11){
			this.jerks=jerks;
		} else {
			throw new IllegalArgumentException ("Invlaid jerks");
		}
	}
	
	public int getFriendZones(){
		return this.friendZones;
	}
	
	public void setFriendZones(int friendZones){
		if (friendZones>=1&&friendZones<=11){
			this.friendZones=friendZones;
		} else {
			throw new IllegalArgumentException ("Invlaid friendzones");
		}
	}
	
	//constructor for RomCom object
	public RomCom(String title, int year, int duration, double rating, int jerks, int friendZones) {
		super(rating, year, duration, title);
		setJerks(jerks);
		setFriendZones(friendZones);
	}
	
	//overriding toString method
	public String toString(){
		return super.toString()+String.format(", jerks: %d, friendzones: %d", this.jerks, this.friendZones);
	}
	
	//overriding getPrice method
	public double getPrice(){
		return  (this.jerks + this.friendZones + this.year - this.duration) / 100.0;
	}
}
