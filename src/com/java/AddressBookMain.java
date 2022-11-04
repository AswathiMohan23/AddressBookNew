package com.java;

import java.util.*;

public class AddressBookMain {

    static Scanner sc = new Scanner(System.in);
    static Details person1 = new Details("tom", "john", "Trivandrum", "1234", "912345678");
    static Details person2 = new Details("Anna", "Maria", "Bangalore", "1564", "923456781");
    static Details person3 = new Details("Linda", "Thomas", "Kozhikode", "1564", "923456781");
    static int count=0;
    static ArrayList<String> addressBook=new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        System.out.println("choose the option (1 or 2) which u need : " +
                "\n1 : enter details from console\n2 : find a person by name\n"+"3 : delete details by using name\n");
        int option = sc.nextInt();
        System.out.println("Address book contacts :\n" + person1.toString() + "\n" + person2.toString() + "\n" + person3.toString());

        switch (option) {
            case 1:
                enterTheDetails();
                break;
            case 2:
                System.out.println("select the name : ");
                String byName = sc.next().toUpperCase();
                searchByName(byName);
                break;
            case 3:
                System.out.println("select the name : ");
                byName = sc.next().toUpperCase();
                delete(byName);
        }
    }
    public static void savedDetails(String name) {
        if (name.equals(person1.getFirstName().toUpperCase()))
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person1.toString()+"\n");
        else if (name.equals(person2.getFirstName().toUpperCase()))
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person2.toString()+"\n");
        else if (name.equals(person3.getFirstName().toUpperCase()))
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person3.toString()+"\n");
        else
            System.out.println("wrong entry");
    }

    public static void searchByName(String byName) {
        savedDetails(byName);
    }
    public static void delete(String name){
        if (name.equals(person1.getFirstName().toUpperCase())) {
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person1.toString() + "\n");
            System.out.println("deleting details of "+name+"...........\n");
            System.out.println("Updated address book :\n========================\n\n" +person2.toString()+"\n"+person3.toString()+"\n");
        }else if (name.equals(person2.getFirstName().toUpperCase())) {
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person2.toString() + "\n");
            System.out.println("deleting details of "+name+"...........\n");
            System.out.println("Updated address book :\n========================\n\n" +person1.toString()+"\n"+person3.toString()+"\n");
        }else if (name.equals(person3.getFirstName().toUpperCase())) {
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person3.toString() + "\n");
            System.out.println("deleting details of "+name+"...........\n");
            System.out.println("Updated address book :\n==========================\n\n" +person1.toString()+"\n"+person2.toString());
        }else
            System.out.println("wrong entry");
    }


    public static void enterTheDetails() {
        System.out.println("Enter the First name : ");
        String firstName = sc.next();
        System.out.println("Enter the 2nd name : ");
        String lastName = sc.next();
        System.out.println("Enter the address : ");
        String address = sc.next();
        System.out.println("Enter the zipCode : ");
        String zipCode = sc.next();
        System.out.println("Enter the mobile number : ");
        String mobileNumber = sc.next();
        /*Details details = new Details(firstName, address, zipCode, mobileNumber, lastName);
        System.out.println("Personal details : " + details.toString());*/
        addingMultipleAddressBook(firstName,lastName,address,zipCode,mobileNumber);

    }

    public static void addingMultipleAddressBook(String firstName, String lastName, String address, String zipCode, String mobileNumber) {
        count++;
        addressBook.add(firstName);
        addressBook.add(lastName);
        addressBook.add(address);
        addressBook.add(zipCode);
        addressBook.add(mobileNumber);
        System.out.println("AddressBook "+1+" : "+addressBook);
    }
}
