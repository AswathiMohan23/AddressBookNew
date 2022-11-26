package com.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookWriteToFile {
    public static String ADDRESS_BOOK_FILE_NAME="addressBookFileName.txt";

    public static void writingData (List<ArrayList> list){
        StringBuffer addressBookBuffer= new StringBuffer();
        list.forEach(contact->{
            addressBookBuffer.append(list);
        });
        try {
            Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME),addressBookBuffer.toString().getBytes());
        }catch (IOException e){
            System.out.println("exception");
        }

    }

}
