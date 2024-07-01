package parser;

import exception.CheckFilePathException;
import exception.FileParceException;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public interface Parser {
    void parse(File file) throws FileNotFoundException, XMLStreamException, FileParceException, CheckFilePathException;
}
