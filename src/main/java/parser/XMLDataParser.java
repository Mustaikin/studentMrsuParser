package parser;

import data.Address;
import data.Client;
import exception.CheckFilePathException;
import exception.FileParceException;

import java.io.File;

public class XMLDataParser{
    private XMLParserClient parserClient;
    private XMLParserAddress parserAddress;
    public XMLDataParser(){
        this.parserClient = new XMLParserClient();
        this.parserAddress = new XMLParserAddress();
    }
    public void parseClient(File file) throws FileParceException, CheckFilePathException {
        parserClient.parse(file);
    }
    public void parseAddress(File file) throws CheckFilePathException, FileParceException {
        parserAddress.parse(file);
    }

    public XMLParserClient getParserClient() {
        return parserClient;
    }

    public void setParserClient(XMLParserClient parserClient) {
        this.parserClient = parserClient;
    }

    public XMLParserAddress getParserAddress() {
        return parserAddress;
    }

    public void setParserAddress(XMLParserAddress parserAddress) {
        this.parserAddress = parserAddress;
    }

    public void  print() {
        for (Client client : parserClient.getClients()) {
            System.out.println(client);
        }
        System.out.println("\n");
        System.out.println();
        for (Address address : parserAddress.getAddress()) {
            System.out.println(address);
        }
        System.out.println("\n");
        System.out.println();
    }
}
