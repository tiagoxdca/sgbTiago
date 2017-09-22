package persistence;

import java.util.ArrayList;
import java.util.List;

import models.Client;


public class Persistence {

	private static List<Client>  clientBag = new ArrayList<Client>();
	
	public static Client addClient(Client c) {
		clientBag.add(c);
		return c;
	}

	public static List<Client> getClientBag() {
		return clientBag;
	}
	
	

}
