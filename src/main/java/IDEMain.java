
import data.Address;
import data.Client;
import parser.XMLDataParser;
import task.DublicateAddress;

import java.io.File;
import java.util.List;

public class IDEMain {
    public static void main(String[] args) {
        XMLDataParser parser = new XMLDataParser();
        parser.parseClient(new File("client.xml"));
        parser.parseAddress(new File("address.xml"));
        List<Client> ListClients = parser.getParserClient().getClients();
        List<Address> ListAddress = parser.getParserAddress().getAddress();
        for (Client client : ListClients) {
            System.out.println(client);
        }
        System.out.println();
        System.out.println();
        for (Address addr : ListAddress) {
            System.out.println(addr);
        }
        System.out.println();
        System.out.println();
        DublicateAddress dublicateAddress = new DublicateAddress();
        dublicateAddress.findDublicateAddress(ListClients, ListAddress);
    }
}
