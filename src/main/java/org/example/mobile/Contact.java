package org.example.mobile;

import java.util.Objects;
import java.util.SplittableRandom;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name,phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(name, contact.name) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    //createContact iki parametre alan bir metod olmalı.(Name ve phoneNumber ikiside String olmalı)
    // aldığı iki değeri kullanarak bir Contact instance oluşturmalı ve bunu dönmeli.
    //createContact metodu static olmalı.
}
