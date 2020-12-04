package utilities;

import beans.Contact;
import objects.ContactList;
import services.ContentControl;
import ui.AppFrame;

public class AppContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Octane Project Model...");
		System.out.println("This is from the App Container main method...");
		
		ContactList contactList = new ContactList();
		ContentControl contentControl = new ContentControl(contactList);
		AppFrame appFrame = new AppFrame("Contacts");
		Contact contact1 = new Contact("Gokul", "11, K street", "4455", "chennai");
		Contact contact2 = new Contact("Gears", "12, K street", "4561", "chicago");
		
		contentControl.addToContactList(contact1);
		contentControl.addToContactList(contact2);
		
		String result = contentControl.display();
		
		appFrame.setText(result);
	}

}
