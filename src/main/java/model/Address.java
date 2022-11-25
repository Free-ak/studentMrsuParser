package model;
import java.lang.String;

public class Address
{
    int id;           // идентификатор
    String city;         // город
    String street;       // улица
    int house;        // дом
    int floor;        // этаж
    int flatNumber;   // квартира

    public Address(int id,String city,String street,int house, int floor,int flatNumber )
    {
        this.id=id ;
        this.city=city;
        this.street=street;
        this.house=house;
        this.floor=floor;
        this.flatNumber=flatNumber;
    }
    public void Output()
    {
        System.out.printf("id - %d\n%d %s  \n%s\nfloor - %d  flat number - %d\n\n", id, house, street, city.toUpperCase(), floor, flatNumber);
    }

    public String getStreet() {
        return street;
    }

    public int getFloor()
    {
        return floor;
    }
    public int getId()
    {
        return id;
    }
}