import java.sql.*;
import org.json.JSONObject;
import org.json.JSONArray;

public class Query_Options {
    private Connection conn;

    public Query_Options(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
    }

    public String querySet(String setName){

        String jsonString = "";
        JSONObject jsonobject = null;
        JSONArray jsonArray = new JSONArray();
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT Name, Text " +
                    "FROM Singles " +
                    "WHERE [Set] = '" + setName + "'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ResultSetMetaData metaData = rs.getMetaData();
                jsonobject = new JSONObject();

                for(int i = 0; i < metaData.getColumnCount(); i++){

                    jsonobject.put(metaData.getColumnLabel(i+1), rs.getString(i+1));

                }
                jsonArray.put(jsonobject);
            }

            if(jsonArray.length() > 0) {
                jsonString = jsonArray.toString();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(conn != null) {
                try{
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonString;
    }
}
