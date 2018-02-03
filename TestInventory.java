//**********************************************************
//
//Author: Cheung Lap Yan
//
//*********************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;

public class TestInventory {

	public static void main(String[] args) throws FileNotFoundException {
		//create inventory list object
		Inventory inv = new Inventory();
		//access file
		File dataFile = new File("src/movies_db.txt");
		// TODO: Read in the input file and populate the movieList. Manage
		// exceptions.
		// On a failed movie load print the message
		// "Exception " + e.getMessage() + " for film " + title. No loading."
		String title = "";
		//scan data
		Scanner fileInput = new Scanner(dataFile);
		while (fileInput.hasNextLine()) {
			String movieItems = fileInput.nextLine();
			//split data according to dashes and access information
			String[] movieDetails = movieItems.split("-");
			title = movieDetails[0];
			try {
				//if movie is RomCom, create new RomCom movie object and store in inventory
				if (movieDetails[4].compareTo("RomCom") == 0) {
					RomCom romComMovie = new RomCom(movieDetails[0], Integer.parseInt(movieDetails[1]),
							Integer.parseInt(movieDetails[2]), Double.parseDouble(movieDetails[3]),
							Integer.parseInt(movieDetails[5]), Integer.parseInt(movieDetails[6]));
					inv.add(romComMovie);
				//if movie is Action, create new Action movie object and store in inventory
				} else if (movieDetails[4].compareTo("Action") == 0) {
					Action actionMovie = new Action(movieDetails[0], Integer.parseInt(movieDetails[1]),
							Integer.parseInt(movieDetails[2]), Double.parseDouble(movieDetails[3]),
							Integer.parseInt(movieDetails[5]));
					inv.add(actionMovie);
				}
			} catch (IllegalArgumentException e) {
				// print the statement if an exception has been encountered
				System.out.printf("Exception %s for film: %s. No loading\n", e.getMessage(), title);
			}
		}
		fileInput.close();

		System.out.println("\nInventory should now contain file contents.");
		System.out.println(inv.toString());
		
		//adding new movies according to object type formats
		Movie starWars = new Action("Star Wars - A New Hope", 1977, 121, 3.8, 89);
		inv.add(starWars);

		Movie numberFour = new Action("I Am Number Four", 2011, 101, 3.2, 11);
		inv.add(numberFour);

		Movie someoneLikeYou = new RomCom("Someone Like You", 2011, 101, 3.2, 2, 5);
		inv.add(someoneLikeYou);

		Movie crazyStupidLove = new RomCom("Crazy, Stupid, Love 2", 2013, 113, 3.9, 1, 3);
		inv.add(crazyStupidLove);
		
		//test size
		System.out.println("Inventory should now contain 13 movies. " + (inv.size() == 13));

		if (inv.remove(crazyStupidLove.getTitle(), crazyStupidLove.getYear())) {
			System.out.println("Successfully removed 'Crazy, Stupid, Love'");
			if (!inv.remove(crazyStupidLove.getTitle(), crazyStupidLove.getYear())) {
				System.out.println("Successfully ignored second remove attempt for 'Crazy, Stupid, Love'");
			}
		}
		
		//prompt exception
		try {
			inv.add(new RomCom("27 Dresses", 2008, 103, 4.4, 1, 1));
		} catch (IllegalArgumentException e) {
			System.out.println("Successfully threw exception on invalid parameter." + e);
		}

		try {
			inv.add(someoneLikeYou);
		} catch (MovieInventoryException e) {
			System.out.println("Successfully threw exception on duplicate add attempt." + e);
		}

		System.out.println("Inventory should now contain 12 movies. " + (inv.size() == 12));

		System.out.println("Inventory should not contain 'The Matrix'? " + !inv.contains("The Matrix", 1999));
		System.out.println(
				"Inventory should not contain 'Something Borrowed'? " + !inv.contains("Something Borrowed", 2009));
		System.out.println("Inventory should not contain '27 Dressed'? " + !inv.contains("27 Dressed", 2008));
		System.out.println("\n" + inv.toString());
	}

}
