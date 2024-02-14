package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for contact App.
 */
public class ContactAppTest {

    @Test
    public void testCreateAndGetContact() {

        int contactId = 1;
        String firstName = "Ada";
        String lastName = "Lovelace";
        String company = "Babbage Industries";
        String email = "ada@example.com";
        String phone = "424-1337";

        // Create contact
        String expected = "2::Ada::Lovelace::Babbage Industries::ada@example.com::424-1337";
        String result = ContactApp.createContact(contactId, firstName, lastName, company, email, phone);
        assertEquals(expected, result);

        // Get contact
        expected = "contact name: Ada Lovelace, contact company: Babbage Industries, contact email: ada@example.com, contact phone: 424-1337";
        result = ContactApp.getContact(2);
        assertEquals(expected, result);
    }

    @Test
    public void testUpdateContact() {
        int contactId = 11;
        String firstName = "Samantha";
        String lastName = "Carter";
        String company = "Stargate LLC";
        String email = "sam.carter@example.com";
        String phone = "555-555-5555";

        // Create contact
        String expected = "12::Samantha::Carter::Stargate LLC::sam.carter@example.com::555-555-5555";
        String result = ContactApp.createContact(contactId, firstName, lastName, company, email, phone);
        assertEquals(expected, result);

        // Update contact (email)
        String property = "email";
        String value = "sam.carter@test.com";
        expected = "contact name: Samantha Carter, contact company: Stargate LLC, contact email: sam.carter@test.com, contact phone: 555-555-5555";
        result = ContactApp.updateContact(12, property, value);
        assertEquals(expected, result);

        // Update contact (email) with not existed contactId
        expected = "No contact with contactId 13 found.";
        result = ContactApp.updateContact(13, property, value);
        assertEquals(expected, result);
    }

    @Test
    public void testDeleteContact() {
        int contactId = 21;
        String firstName = "Leo";
        String lastName = "Sun";
        String company = "Wiley Edge";
        String email = "leo@example.com";
        String phone = "555-666-7777";

        // Create contact
        String expected = "22::Leo::Sun::Wiley Edge::leo@example.com::555-666-7777";
        String result = ContactApp.createContact(contactId, firstName, lastName, company, email, phone);
        assertEquals(expected, result);

        // Delete contact
        boolean deleted = ContactApp.deleteContact(22);
        assertTrue(deleted);

        deleted = ContactApp.deleteContact(23);
        assertFalse(deleted);
    }
}
