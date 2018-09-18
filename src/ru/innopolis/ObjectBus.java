package ru.innopolis;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.util.Objects;

@XmlType(name = "bus")
@XmlRootElement()
public class ObjectBus {
    private String name;
    private int whils;
    private int seat;
    private String color;

    public ObjectBus(String name, int whils, int seat, String color) {
        this.name = name;
        this.whils = whils;
        this.seat = seat;
        this.color = color;
    }

    public ObjectBus() {
    }

    void serialize(Object object, String file) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectBus.class);
        Marshaller marshaller = jaxbContext.createMarshaller();//объект, выполняющий сериализацию
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            marshaller.marshal(object, fileWriter);//сама сериализация

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    Object deSerialize(String file) throws JAXBException, FileNotFoundException {

        FileReader reader = new FileReader(file);

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectBus.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); //объект, выполняющий десериализацию
        ObjectBus bus = (ObjectBus) unmarshaller.unmarshal(reader); //десериализация

        return bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBus objectBus = (ObjectBus) o;
        return whils == objectBus.whils &&
                seat == objectBus.seat &&
                Objects.equals(name, objectBus.name) &&
                Objects.equals(color, objectBus.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, whils, seat, color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWhils() {
        return whils;
    }

    public void setWhils(int whils) {
        this.whils = whils;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}