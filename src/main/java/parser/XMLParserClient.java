package parser;

import data.Client;
import exception.CheckFilePathException;
import exception.FileParceException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLParserClient implements Parser{
    private List<Client> clients;
    @Override
    public void parse(File file) throws FileParceException, CheckFilePathException {
        this.clients = readClient(file);
    }
    private List<Client> readClient(File file) throws FileParceException, CheckFilePathException {
        List<Client> listClient = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (XMLStreamException e) {
            throw new FileParceException();
        } catch (FileNotFoundException e) {
            throw new CheckFilePathException();
        }
        try{
            while(true){
                assert parser != null;
                if(!parser.hasNext()) break;
                int event = parser.next();
                if(event == XMLStreamConstants.START_ELEMENT && parser.getLocalName().equals("client")){
                    Client client = new Client();
                    client.setId(Integer.parseInt(parser.getAttributeValue(null, "id")));
                    client.setName(parser.getAttributeValue(null, "name"));
                    client.setPersonnelNumber(parser.getAttributeValue(null, "personnelNumber"));
                    client.setAddressId(Integer.parseInt(parser.getAttributeValue(null,"addressId")));
                    listClient.add(client);
                }
            }
        } catch (XMLStreamException e) {
            throw new FileParceException();
        }

        return listClient;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
