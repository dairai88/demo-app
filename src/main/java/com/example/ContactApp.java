package com.example;

import java.util.Scanner;

public class ContactApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] contacts = new String[100];

    public static void main(String[] args) {

        int count = 0;

        while (true) {
            System.out.println("Contact Application");

            System.out.println();

            System.out.println("1. Create a contact");
            System.out.println("2. Get a contact");
            System.out.println("3. Update a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Retrieve all contacts");
            System.out.println("6. Exit contact app");

            System.out.println();
            System.out.print("Enter your choice (1-6): ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    String firstName = promptMessage("Enter contact's first name: ");
                    String lastName = promptMessage("Enter contact's last name: ");
                    String company = promptMessage("Enter contact's company: ");
                    String email = promptMessage("Enter contact's email: ");
                    String phone = promptMessage("Enter contact's phone: ");

                    createContact(count, firstName, lastName, company, email, phone);
                    count++;
                    break;
                case 2:
                    int contactId = Integer.parseInt(promptMessage("Enter contact's id to create: "));
                    String contactInfo = getContact(contactId);
                    System.out.println(contactInfo);
                    break;
                case 3:
                    contactId = Integer.parseInt(promptMessage("Enter contact's id to update: "));
                    String property = promptMessage(
                            "Enter the property of contact to update (company, email, phone): ");
                    String value = promptMessage("Enter new " + property + " for contact: ");
                    updateContact(contactId, property, value);
                    break;
                case 4:
                    contactId = Integer.parseInt(promptMessage("Enter contact's id to delete: "));
                    deleteContact(contactId);
                    break;
                case 5:
                    getAllContacts();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.err.println("Please select choice between 1 and 6");
                    break;
            }

            System.out.println();
        }
    }

    public static String createContact(int contactId, String firstName, String lastName, String company, String email,
            String phone) {
        String contact = (contactId + 1) + "::" + firstName + "::" + lastName + "::" + company + "::" + email + "::" + phone;
        contacts[contactId] = contact;
        return contact;
    }

    public static String getContact(int contactId) {
        String contactInfo = null;
        for (String contact : contacts) {
            if (contact != null && !contact.equals("")) {
                String[] parts = contact.split("::");
                if (contactId == Integer.parseInt(parts[0])) {
                    contactInfo = "contact name: " + parts[1] + " " + parts[2] + ", contact company: " + parts[3]
                            + ", contact email: " + parts[4] + ", contact phone: " + parts[5];
                    break;
                }
            }
        }

        return contactInfo;
    }

    public static String updateContact(int contactId, String property, String value) {
        String contact = null;
        for (String c : contacts) {
            if (c != null && !c.equals("")) {
                String[] parts = c.split("::");
                if (contactId == Integer.parseInt(parts[0])) {
                    contact = c;
                    break;
                }
            }
        }
        if (contact == null) {
            return "No contact with contactId " + contactId + " found.";
        }

        String[] parts = contact.split("::");
        String updated = "contact name: " + parts[1] + " " + parts[2] + ", contact company: " + parts[3]
                + ", contact email: " + parts[4] + ", contact phone: " + parts[5];
        switch (property) {
            case "company":
                updated = "contact name: " + parts[1] + " " + parts[2] + ", contact company: " + value
                        + ", contact email: " + parts[4] + ", contact phone: " + parts[5];
                break;
            case "email":
                updated = "contact name: " + parts[1] + " " + parts[2] + ", contact company: " + parts[3]
                        + ", contact email: " + value + ", contact phone: " + parts[5];
                break;
            case "phone":
                updated = "contact name: " + parts[1] + " " + parts[2] + ", contact company: " + parts[3]
                        + ", contact email: " + parts[4] + ", contact phone: " + value;
                break;
        }
        return updated;
    }

    public static boolean deleteContact(int contactId) {
        boolean deleted = false;
        for (int i = 0; i < contacts.length; i++) {
            String contact = contacts[i];
            if (contact != null && !contact.equals("")) {
                String[] parts = contact.split("::");
                if (contactId == Integer.parseInt(parts[0])) {
                    contacts[i] = null;
                    deleted = true;
                }
            }
        }
        return deleted;
    }

    public static void getAllContacts() {
        for (String contact : contacts) {
            if (contact != null && !contact.equals("")) {
                String[] parts = contact.split("::");
                System.out.println("contact name: " + parts[1] + " " + parts[2] + ", contact company: " + parts[3]
                        + ", contact email: " + parts[4] + ", contact phone: " + parts[5]);
            }
        }
    }

    public static String promptMessage(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int countContacts() {
        int count = 0;
        for (String contact : contacts) {
            if (contact != null && !contact.equals("")) {
                count++;
            }
        }
        return count;
    }

}
