
import data.Address;
import data.Client;
import exception.CheckFilePathException;
import exception.FileParceException;
import parser.XMLDataParser;
import task.CountFloor;
import task.DublicateAddress;
import java.io.File;


public class IDEMain {
    public static void main(String[] args) throws FileParceException, CheckFilePathException {
        XMLDataParser parser = new XMLDataParser();
        parser.parseClient(new File("client.xml"));
        parser.parseAddress(new File("address.xml"));
        /////// вывод результата парсинга
        parser.print();
        //////////////////////////////////////////

        /////// доп задача №2
        DublicateAddress dublicateAddress = new DublicateAddress();
        dublicateAddress.findDublicateAddress(parser.getParserClient().getClients(), parser.getParserAddress().getAddress());
        ////////////////////////////////////////////////////////////////////////

        //////////// доп задача №3
        CountFloor count = new CountFloor();
        count.CountingFloor(parser.getParserAddress().getAddress());
    }
}
