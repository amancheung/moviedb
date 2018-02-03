//**********************************************************
//
//Author: Cheung Lap Yan
//
//*********************************************************

public abstract class Movie implements Comparable<Movie>{
	private double rating;
	protected final int year;
	protected final int duration;
	protected final String title;
	
	//set rating and throw exception if rating is invalid
	public void setRating(double rating){
		if (rating>=0 && rating<=4.0){
			this.rating=rating;
		} else {
			throw new  IllegalArgumentException("Invalid rating");
		}
	}
	
	//getter for rating
	public double getRating(){
		return this.rating;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public int getDuration(){
		return this.year;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	//constructor for movie abstract object
	public Movie(double rating, int year, int duration, String title){
		setRating(rating);
		if (year<1870&&year>2015){
			throw new IllegalArgumentException("Invalid year");
		} else {
			this.year=year;
		}
		if (duration<0){
			throw new IllegalArgumentException("Invalid duration");
		} else {
			this.duration=duration;
		}
		if (title==null){
			throw new IllegalArgumentException("Invalid title");
		} else {
			this.title=title;
		}
	}
	
	//abstract method for price
	public abstract double getPrice();
	
	//toString method
	public String toString(){
		return String.format("%s: %d, rating: %f, price: %f", this.title, this.year, this.rating, this.getPrice());
		
	}
	
	//retrofit compareTo method
	public int compareTo(Movie movie){
		//sort movie year ascendingly
		if (movie.year>this.year){
			return -1;
		} else if (movie.year==this.year){
			//if movies' years are the same, sort by rating ascendingly
			if (movie.rating>this.rating){
				return -1;
			} else if (movie.rating<this.rating){
				return 1;
			} else if (movie.rating==this.rating){
				return 0;
			}
		} else {
		return 1;
		}
		return 0;
	}
}
