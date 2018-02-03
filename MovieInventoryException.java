//**********************************************************
//
//Author: Cheung Lap Yan
//
//*********************************************************

public class MovieInventoryException extends RuntimeException{
	public MovieInventoryException ( String title ) {
		super ('"'+ title + '"'+" already in inventory. " );
		}
}
