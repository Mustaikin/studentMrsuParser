package exception;

public class FileParceException extends Exception{
    private final String getMessage = "Error Parce";
    public FileParceException(){
        System.out.println(getMessage);
    }
}
