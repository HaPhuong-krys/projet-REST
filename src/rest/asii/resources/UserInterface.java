package rest.asii.resources;

import rest.asii.dao.*;
import rest.asii.model.*;

public interface UserInterface {

	User findById(int id);
	User findByName(String nom);
	
	User modifierUser(User user);
	User supprimerUser(User user);
}
