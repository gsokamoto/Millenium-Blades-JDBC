import java.util.*;


public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String path = "C:\\Users\\Shu\\Documents\\AccessDBs\\Millenium_Blades_Db.accdb";

            String url = "jdbc:ucanaccess://" + path;

            Scanner userInput = new Scanner(System.in);

            Query_Options QO = new Query_Options(url);

            System.out.println(QO.querySet("Black Flags, Black Waters"));


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
