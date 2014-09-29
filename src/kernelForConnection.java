/**
 * Created by m.vlasova on 25.09.2014.
 */
import com.mongodb.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;
import java.util.*;



public class kernelForConnection {
    static String user, password, nameDB;
    DB db;

    public void main(String args[]){

    }

    public Boolean connectToDB(){
        try{
            user = "admin";
            password = "admin";
            nameDB = "test";

            Mongo m = new Mongo( "localhost", 27017 );
            db = m.getDB(nameDB );


            db.authenticate(user, password.toCharArray());

            return true;

        }catch(UnknownHostException e){
            return false;
        }
    }

    public Boolean setToDB(String name){
        try{
            BasicDBObject human = new BasicDBObject();
            human.put("name", "Alexander");
            db.getCollection(name).insert(human);

            return true;
        }catch(Exception e){
            return false;
        }


    }

    public Boolean getFirstFromDB(String txt){

        try{
            BasicDBObject human = new BasicDBObject();
            human.put("name", "test");
            System.out.print(db.getCollection("testData").findOne(human));
            return  true;
        }catch (Exception e){
          return false;
        }


    }

    public Boolean getFromDB(String txt){
        List<String> findCollection = new ArrayList<String>();


        try{
            BasicDBObject human = new BasicDBObject();
            human.put("name", "Alexander");
            DBCursor cursor = db.getCollection("testData").find(human);

            while (cursor.hasNext()) {
                DBObject dbo = cursor.next();
                findCollection.add(dbo.get("name").toString());
            }


            System.out.println(findCollection);
            return  true;
        }catch (Exception e){
            return false;
        }


    }

    public Boolean removeFromDB(String txt){

        try{

            BasicDBObject human = new BasicDBObject();
            human.put("name", "test2");
            db.getCollection("testData").remove(human);
            return  true;
        }catch (Exception e){
            return false;
        }


    }

}
