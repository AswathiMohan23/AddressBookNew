package com.java;


import java.util.*;

public class AddressBookMain {
    static ArrayList<String> addressBook = new ArrayList<>();
    static ArrayList<String> newAddressBook = new ArrayList<String>();
    static Map<ArrayList, String> map = new HashMap<>();
    static ArrayList<String> nameList = new ArrayList<>();
    static ArrayList<ArrayList> list=new ArrayList<>();
    static Dictionary dict = new Hashtable();
    static Dictionary stateDict = new Hashtable();
    static Dictionary cityDict = new Hashtable();





    static Scanner sc = new Scanner(System.in);
    static Details person1 = new Details("tom", "john", "Trivandrum", "1234", "912345678");
    static Details person2 = new Details("Anna", "Maria", "Bangalore", "1564", "923456781");
    static Details person3 = new Details("Linda", "Thomas", "Kozhikode", "1564", "923456781");


    public static void main(String[] args) {
        System.out.println("\n======================================= Welcome to Address Book =========================================");
        System.out.println("\nchoose the option (1 or 2) which u need : " +
                "\n\t\t\t1 : enter details from console\n\t\t\t2 : find a person by name\n\t\t\t" + "3 : delete details by using name\n");
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
        searching();
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

            System.out.println("Enter the city : ");
            String city = sc.next();
            System.out.println("Enter the state : ");
            String state = sc.next();
            System.out.println("Enter the zipCode : ");
            String zipCode = sc.next();
            System.out.println("Enter the mobile number : ");
            String mobileNumber = sc.next();
            addingMultipleAddressBook(count, firstName, lastName, city,state, zipCode, mobileNumber);
        }
    }

    public static void addingMultipleAddressBook(int count, String firstName, String lastName, String city,String state, String zipCode, String mobileNumber) {
        ArrayList<String> addressBook = new ArrayList<>();
        addressBook.add(firstName);
        addressBook.add(lastName);
        addressBook.add(city);
        addressBook.add(state);
        addressBook.add(zipCode);
        addressBook.add(mobileNumber);
        System.out.println("AddressBook " + count + " : " + addressBook);
        nameList.add(addressBook.get(0));
        nameList.add(addressBook.get(1));
       // mapDetails.put(addressBook,details.toString());
        map.put(addressBook, state);
        dict.put(count, addressBook); // dictionary to add all the addressBooks
        list.add(addressBook);
        stateDict.put(firstName,state);
        cityDict.put(firstName,city);

    }
    public static void searching(){
        System.out.println("\nHey to know the details of people from your place, enter the name of your state /city here \n\t\t\tclick 1 : for city\n\t\t\tclick 2 : for state\n");
        int option = sc.nextInt();
        switch (option){
            case 1 : searchingCity();
                break;
            case 2 : searchingState();
                break;
        }

    }

    public static void searchingCity() {
        System.out.println("Enter the name of the city : ");
        String cityName=sc.next();
        System.out.println("\n========================================================= checkout the list of people from your city "+cityName+" ======================================================================");
        list.stream().filter(name -> name.contains(cityName)).forEach(System.out::println);
        int count= (int) list.stream().filter(name -> name.contains(cityName)).count();
        System.out.println("Do u need to check using state name ?  \n\t\t\t1 : for yes\n\t\t\t2 : to count by city Name "+cityName+"\n\t\t\t3 : for No");
        int option=sc.nextInt();
        switch (option){
            case 1 : searchingCity();
                break;
            case 2: countByCity(count,cityName);
                break;
            case 3 :
                System.out.println("ok you have chosen not to continue");
                break;
        }
    }
    public static void searchingState() {
        System.out.println("Enter the name of the state : ");
        String stateName=sc.next();
        System.out.println("\n========================================================== checkout the list of people from your state "+stateName+" ============================================================ ");
        list.stream().filter(name -> name.contains(stateName)).forEach(System.out::println);
        int count= (int) list.stream().filter(name -> name.contains(stateName)).count();
        System.out.println("Do u need to check using city name ?  \n\t\t\t1 : for yes\n\t\t\t2 : to count by state Name "+stateName+"\n\t\t\t3 : for No");
        int option=sc.nextInt();
        switch (option){
            case 1 : searchingCity();
                break;
            case 2: countByState(count,stateName);
                break;
            case 3 :
                System.out.println("ok you have chosen not to continue");
                break;
        }
    }

    public static void countByState(int count,String stateName) {
        System.out.println("count by state "+stateName+" : "+count);
        System.out.println("Do u need to check using city name ?  \n\t\t\t1 : for yes\n\t\t\t2 : for No");
        int option=sc.nextInt();
        switch (option){
            case 1 : searchingCity();
                break;
            case 2 :
                System.out.println("You have chosen not to continue");
        }

    }

    public  static void countByCity(int count,String city){
        System.out.println("count by city "+city+" : "+count);
        System.out.println("Do u need to check using state name ?  \n\t\t\t1 : for yes\n\t\t\t2 : for No");
        int option=sc.nextInt();
        switch (option){
            case 1 : searchingState();
                break;
            case 2 :
                System.out.println("You have chosen not to continue");
        }

    }
}

