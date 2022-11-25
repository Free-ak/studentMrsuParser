import model.Address;
import model.Client;
import parser.XMLParser;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IDEMain {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException
    {
        XMLParser xmlParser = new XMLParser();
        var p= xmlParser.parseAddress(new File(new File("").getAbsolutePath()+"//address.xml"));
        var w= xmlParser.parseClient(new File(new File("").getAbsolutePath()+"//client.xml"));


        Collection<String> listone=new ArrayList<>();
        for ( Address t:p)
        {
            listone.add(t.getStreet());
        }
        Set<String> duplicates= new HashSet<>(listone);
        System.out.printf("One:%s%nTwo:%s%n",listone, duplicates);


        List<Integer> floor= new ArrayList<>() ;
        Map<Integer,Integer> map= new HashMap<>();
        Integer values=0;
        for (Address A:p )
        {
            for (Client C:w)
            {
                map.put(A.getFloor(),values);
                if(C.getAddressId()==A.getId() )
                {
                    map.put(A.getFloor(),values++);
                }
            }
            values=0;
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            Integer key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println("On the floor:"+ key+" lives:"+ value+ "  people");
        }
    }
}
