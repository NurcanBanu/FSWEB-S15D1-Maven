package org.example.mobile;

import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact (Contact contact) {
        if (contact == null || contact.getName() == null || contact.getPhoneNumber() == null) {
            return false;
        }
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        return this.myContacts.add(contact);
    }

    public int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i <myContacts.size();i++) {
            Contact contact = myContacts.get(i);
            if(contact.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if(index <= 0) {
            return false;
        }
        this.myContacts.set(index, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (contact == null || findContact(contact) < 0) {
            return false;
        }
        return this.myContacts.remove(contact);
    }

    public Contact queryContact(String contactName) {
        int contactIndex = findContact(contactName);
        if (contactIndex < 0) {
            return null;
        }
        return this.myContacts.get(contactIndex);
    }

    public void printContacts() {
        for (int i = 0; i <myContacts.size();i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i+1) + ", " + contact.getName() + " -> " + contact.getPhoneNumber());
            }
        }
    }

    // Contact listede yoksa Contact objesini listeye ekleyip true varsa false değeri döner.
    //updateContact Contact türünde iki parametre alır. Contact lardan biri eskisi biri yenisinin
    // değerini tutar. Boolean bir değer döner. Eğer Contact listede varsa ve doğru bir şekilde
    // update edilirse true değer döner. Aksi durumda false değeri döner.
    //removeContact Contact türünde bir parametre alır. Eğer Contact listede varsa ve başarılı
    // bir şekilde silinirse true aksi durumda false değeri döner.,
    //queryContact String tipinde bir değer alır ve Contact türünde bir değer döndürür.
    // String parametre Contact ismini içerir. Eğer ilgili isimdeki Contact listede varsa ilgili
    // Contact objesini döndürür. Yoksa null döndürür
    //printContact parametre almaz return değeri de yoktur. Contactların tamamını aşağıdaki
    // formattaki gibi listeler. Contact List:
    //Bob -> 31415926
    //Alice -> 16180339
    //Tom -> 11235813
    //Jane -> 23571113


