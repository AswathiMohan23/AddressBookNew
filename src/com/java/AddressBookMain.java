package com.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookMain {
    static ArrayList<String> addressBook = new ArrayList<>();
    static ArrayList<String> newAddressBook = new ArrayList<String>();
    static Map<ArrayList, String> map = new HashMap<>();
    static Map<ArrayList, String> mapDetails = new HashMap<>();
    static ArrayList<String> nameList = new ArrayList<>();
    static ArrayList<ArrayList> list=new ArrayList<>();



    static Scanner sc = new Scanner(System.in);
    static Details person1 = new Details("tom", "john", "Trivandrum", "1234", "912345678");
    static Details person2 = new Details("Anna", "Maria", "Bangalore", "1564", "923456781");
    static Details person3 = new Details("Linda", "Thomas", "Kozhikode", "1564", "923456781");
    static Dictionary dict = new Hashtable();


    public static void main(String[] args) {
        System.out.println("======================================= Welcome to Address Book =========================================");
        System.out.println("\nchoose the option (1 or 2) which u need : " +
                "\n1 : enter details from console\n2 : find a person by name\n" + "3 : delete details by using name\n");
        int option = sc.nextInt();
        System.out.println("Address book contacts :\n\n" + person1.toString() + "\n" + person2.toString() + "\n" + person3.toString());

        switch (option) {
            case 1:
                System.out.println("\n\nenter the no of addressBooks needed : ");
                int limit = sc.nextInt();
                for (int count = 1; count <= limit; count++)
                    enterTheDetails(count);
                System.out.println("\nDictionary of AddressBook : " + dict);
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
        searchingState();
    }

    public static void savedDetails(String name) {
        if (name.equals(person1.getFirstName().toUpperCase()))
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person1.toString() + "\n");
        else if (name.equals(person2.getFirstName().toUpperCase()))
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person2.toString() + "\n");
        else if (name.equals(person3.getFirstName().toUpperCase()))
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person3.toString() + "\n");
        else
            System.out.println("wrong entry");
    }

    public static void searchByName(String byName) {
        savedDetails(byName);
    }

    public static void delete(String name) {
        if (name.equals(person1.getFirstName().toUpperCase())) {
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person1.toString() + "\n");
            System.out.println("deleting details of " + name + "...........\n");
            System.out.println("Updated address book :\n========================\n\n" + person2.toString() + "\n" + person3.toString() + "\n");
        } else if (name.equals(person2.getFirstName().toUpperCase())) {
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person2.toString() + "\n");
            System.out.println("deleting details of " + name + "...........\n");
            System.out.println("Updated address book :\n========================\n\n" + person1.toString() + "\n" + person3.toString() + "\n");
        } else if (name.equals(person3.getFirstName().toUpperCase())) {
            System.out.println("\nThe searched name is " + name + " and the details are : " +
                    "\n=================================================\n\n" + person3.toString() + "\n");
            System.out.println("deleting details of " + name + "...........\n");
            System.out.println("Updated address book :\n==========================\n\n" + person1.toString() + "\n" + person2.toString());
        } else
            System.out.println("wrong entry");
    }

    public static void enterTheDetails(int count) {
        System.out.println("Enter the First name : ");
        String firstName = sc.next();
        System.out.println("Enter the 2nd name : ");
        String lastName = sc.next();
        if ((nameList.contains(firstName)) && (nameList.contains(lastName))) {
            System.out.println("sorry try again the name already exists");
        } else {

            System.out.println("Enter the address : ");
            String address = sc.next();
            System.out.println("Enter the zipCode : ");
            String zipCode = sc.next();
            System.out.println("Enter the mobile number : ");
            String mobileNumber = sc.next();
            addingMultipleAddressBook(count, firstName, lastName, address, zipCode, mobileNumber);
        }
    }

    public static void addingMultipleAddressBook(int count, String firstName, String lastName, String address, String zipCode, String mobileNumber) {
        ArrayList<String> addressBook = new ArrayList<>();
        addressBook.add(firstName);
        addressBook.add(lastName);
        addressBook.add(address);
        addressBook.add(zipCode);
        addressBook.add(mobileNumber);
        Details details=new Details();
        details.setFirstName(firstName);
        details.setFirstName(lastName);
        details.setAddress(address);
        details.setAddress(zipCode);
        details.setFirstName(mobileNumber);
        System.out.println("AddressBook " + count + " : " + addressBook);
        nameList.add(addressBook.get(0));
        nameList.add(addressBook.get(1));
       // mapDetails.put(addressBook,details.toString());
        map.put(addressBook, address);
        dict.put(count, addressBook);
        list.add(addressBook);
    }

    public static void searchingState() {
       System.out.println("\nHey to know the details of people from your place, enter the name of your state here \n=====> ");
        String stateName = sc.next();
        list.stream().filter(name -> name.contains(stateName)).forEach(System.out::println);
        System.out.println("\n checkout the list of people from your place \n=====> ");
        }

        //List<String> stringList =addressBook.stream().filter(name -> addressBook.contains(stateName)).toList();


    }

