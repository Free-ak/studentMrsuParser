package model;
import java.lang.String;

public class Client
{
    int id;              // идентификатор
    String name;            // ФИО
    String personnelNumber; // персональный номер
    int address;         // адресс проживания

    public Client(int Id, String Name, String PersonnelNumber, int AddressId) {
        id = Id;
        name = Name;
        personnelNumber = PersonnelNumber;
        address = AddressId;
    }

    public int getAddressId()
    {
        return address;
    }

    public void Output()
    {
        System.out.printf("%d %s\n %d %s\n\n ", id, personnelNumber, address, name);
    }
}
