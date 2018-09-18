package ru.innopolis;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        ObjectBus bus = new ObjectBus("Электробус", 4, 10, "белый");

        bus.serialize(bus, "sources/notes.txt");
        ObjectBus restoredBus = (ObjectBus) bus.deSerialize("sources/notes.txt");
        System.out.println(bus.equals(restoredBus));
    }
}


