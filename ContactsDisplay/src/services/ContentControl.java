package services;

import java.util.ArrayList;

import beans.Contact;
import objects.ContactList;

public class ContentControl {
	
	private ContactList contactList;
	
	public ContentControl(ContactList contactList){
		this.contactList = contactList;
	}

	public void addToContactList(Contact c) {
		this.contactList.add(c);
	}
	
	public String display() {
		ArrayList<Contact> contactList = this.contactList;
		String result = "";
		for(Contact c : contactList)
			result += "Name: " + c.getName() + "\nAddress: " + c.getAddress() + "\nPhone: " + c.getContactNumber() + "\nCity: " + c.getCity() + "\n\n";
		return result;
	}
}
