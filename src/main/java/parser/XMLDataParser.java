package parser;

import java.io.File;

public class XMLDataParser{
    private XMLParserClient parserClient;
    private XMLParserAddress parserAddress;
    public XMLDataParser(){
        this.parserClient = new XMLParserClient();
        this.parserAddress = new XMLParserAddress();
    }
    public void parseClient(File file){
        parserClient.parse(file);
    }
    public void parseAddress(File file){
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
}
