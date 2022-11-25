package parser;

import model.Address;
import model.Client;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser implements Parser
{
    @Override
    public List<Address> parseAddress (File file) throws FileNotFoundException, XMLStreamException
    {
        return readAddress(file);
    }
    @Override
    public List<Client> parseClient(File file) throws FileNotFoundException, XMLStreamException
    {
        return readClient(file);
    }
    private List<Address> readAddress(File file)
    {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }


        try {
            List<Address> addresses = new ArrayList<Address>();
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equalsIgnoreCase("address"))
                    {
                        var id = Integer.parseInt(parser.getAttributeValue(0));
                        var city = parser.getAttributeValue(1);
                        var street = parser.getAttributeValue(2);
                        var house = Integer.parseInt(parser.getAttributeValue(3));
                        var floor = Integer.parseInt(parser.getAttributeValue(4));
                        var flatNumber = Integer.parseInt(parser.getAttributeValue(5));
                        Address t = new Address(id, city, street, house, floor, flatNumber);
                        addresses.add(t);
                    }
                }
            }
            return addresses;
        } catch (XMLStreamException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Client> readClient(File file)
    {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        try
        {
            List<Client> resultList = new ArrayList<Client>();
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equalsIgnoreCase("client"))
                    {
                        var id = Integer.parseInt(parser.getAttributeValue(0));
                        var name = parser.getAttributeValue(1);
                        var personnelNumber = parser.getAttributeValue(2);
                        var addressId = Integer.parseInt(parser.getAttributeValue(3));
                        Client t = new Client(id, name, personnelNumber, addressId);
                        resultList.add(t);
                    }
                }
            }
            return resultList;
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
