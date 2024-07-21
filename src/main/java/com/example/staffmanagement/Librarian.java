package com.example.staffmanagement;

public class Librarian extends Staff {

    public Librarian(String staffID, String username, String password, String firstName, String lastName, String email, String phoneNo) {
        super(staffID, username, password, firstName, lastName, email, phoneNo);
    }

    public void manageLibraryResources() {
        // Logic for managing library resources
    }
}
