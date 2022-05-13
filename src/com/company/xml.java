package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class xml {
    public static void createXML() throws JAXBException {
        File file = new File("Cat.xml");
        JAXBContext context = JAXBContext.newInstance(catXML.class);
        Marshaller marshaller = context.createMarshaller();
        catXML cat = new catXML(3, "John");
        marshaller.marshal(cat, file);
    }

    public static void writeXML() throws JAXBException {
        File file = new File("Cat.xml");
        JAXBContext context = JAXBContext.newInstance(catXML.class);
        Marshaller marshaller = context.createMarshaller();
        Scanner in = new Scanner(System.in);
        System.out.println("Cat's name: ");
        String usrInp_1 = in.nextLine();
        System.out.println("Cat's age: ");
        int usrInp_2 = in.nextInt();
        catXML cat = new catXML(usrInp_2, usrInp_1);
        marshaller.marshal(cat, file);
    }

    public static void readXML() throws JAXBException {
        File file = new File("Cat.xml");
        JAXBContext context = JAXBContext.newInstance(catXML.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        catXML cat = (catXML) unmarshaller.unmarshal(file);
        System.out.println("Done\n" + cat);
    }

    public static void deleteXML() {

        File del = new File("Cat.xml");
        if (del.delete()) {
            System.out.println("File has been deleted");
        }
        else {
            System.out.println("File doesn't exist");
        }
    }
}
