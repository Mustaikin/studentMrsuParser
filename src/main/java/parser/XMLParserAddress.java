package parser;

import data.Address;
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

public class XMLParserAddress implements Parser {
    private List<Address> address;

    public XMLParserAddress() {
        this.address = new ArrayList<>();
    }

    @Override
    public void parse(File file) throws CheckFilePathException, FileParceException {
        address = readAddress(file);
    }

    private List<Address> readAddress(File file) throws FileParceException, CheckFilePathException {
        List<Address> ListAddress = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new CheckFilePathException();
        } catch (XMLStreamException e) {
            throw new FileParceException();
        }

        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT && parser.getLocalName().equals("address")) {
                    Address address = new Address();
                    address.setId(Integer.parseInt(parser.getAttributeValue(null, "id")));
                    address.setCity(parser.getAttributeValue(null, "city"));
                    address.setStreet(parser.getAttributeValue(null, "street"));
                    address.setHouse(Integer.parseInt(parser.getAttributeValue(null, "house")));
                    address.setFloor(Integer.parseInt(parser.getAttributeValue(null, "floor")));
                    address.setFlatNumber(Integer.parseInt(parser.getAttributeValue(null, "flatNumber")));
                    ListAddress.add(address);
                }
            }
        } catch (XMLStreamException e) {
            throw new FileParceException();
        }
        return ListAddress;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}

