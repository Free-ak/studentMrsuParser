package parser;

import model.Address;
import model.Client;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public interface Parser
{
List<Client> parseClient(File file) throws FileNotFoundException, XMLStreamException;
List<Address> parseAddress(File file) throws FileNotFoundException, XMLStreamException;
}
