import java.io.*;
import java.util.*;

// Contact class to represent individual contacts
class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
    }
}

// AddressBook class to manage the collection of contacts
class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}

// AddressBookSystem class to interact with the Address Book System
public class AddressBookSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        boolean running = true;
        while (running) {
            System.out.println("Address Book System Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addContact(addressBook);
                    break;
                case 2:
                    removeContact(addressBook);
                    break;
                case 3:
                    searchContact(addressBook);
                    break;
                case 4:
                    displayAllContacts(addressBook);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addContact(AddressBook addressBook) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber, emailAddress);
        addressBook.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private static void removeContact(AddressBook addressBook) {
        System.out.print("Enter name of the contact to remove: ");
        String name = scanner.nextLine();
        Contact contactToRemove = addressBook.searchContact(name);
        if (contactToRemove != null) {
            addressBook.removeContact(contactToRemove);
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void searchContact(AddressBook addressBook) {
        System.out.print("Enter name of the contact to search: ");
        String name = scanner.nextLine();
        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            System.out.println("Contact found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void displayAllContacts(AddressBook addressBook) {
        List<Contact> contacts = addressBook.getContacts();
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("All contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}
