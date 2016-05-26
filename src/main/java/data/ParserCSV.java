/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nazar
 */
public class ParserCSV {

    public static JsonArray parse(InputStream inStream){
        String line = "";
        String spliteBy = ",";
        JsonArray ja = new JsonArray();
        int count = 0;
        Gson json = new Gson();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(inStream))){

            while(((line = br.readLine()) !=  null)
                    && count<10){
                    String[] userData = line.split(spliteBy);
                    ja.add(UserASM.toJson(UserASM.user.crateUser(userData)));
                    count++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ja;
    }

    public static ArrayList<User> parseAll(InputStream inStream){
        String line;
        String spliteBy = ",";
        ArrayList<User> result = new ArrayList<>();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(inStream))){

            while((line = br.readLine()) !=  null){
                    String[] userData = line.split(spliteBy);
                    result.add(UserASM.user.crateUser(userData));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
