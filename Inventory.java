//**********************************************************
//
//Author: Cheung Lap Yan
//
//*********************************************************

import java.util.ArrayList;
import java.util.Collections;

public class Inventory{
	//setup array list
	ArrayList<Movie> movieList = new ArrayList<Movie>();
	//save index for movie object if needed
	int containIndex;
	
	//create add method and allow for exception
	public void add(Movie movie){
		if (contains(movie.getTitle(),movie.getYear())==false){
			//check year
			movieList.add(movie);
			//sort movies
			Collections.sort(movieList);
		} else {
			throw new MovieInventoryException (movie.getTitle());
		}
	}
	
	//remove movie method
	public boolean remove(String title, int year){
		if (contains(title,year)){
			movieList.remove(containIndex);
			//sort movies
			Collections.sort(movieList);
			return true;
		} 
		return false;
	}
	
	//check elements method
	public boolean contains(String title, int year){
		for (int i=0;i<movieList.size();i++){
			if (movieList.get(i).getTitle()==title&&movieList.get(i).getYear()==year){
				containIndex=i;
				return true;
			} 
		}
		return false;
	}
	
	//check size method
	public int size(){
		return movieList.size();
	}
		
	//toString method to display all movies in inventory
	public String toString(){
		String allMovies="";
		for (int i=0;i<movieList.size();i++){
			allMovies+=((i+1)+". "+movieList.get(i).toString()+"\n");
		}
		return allMovies;
	}
	
}
