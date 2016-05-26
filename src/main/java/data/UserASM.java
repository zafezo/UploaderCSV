package data;

import com.google.gson.JsonObject;

/**
 * Created by swen on 5/19/16.
 */
public class UserASM {

   public static UserASM user = new UserASM();

   private UserASM(){};

   public User crateUser(String first_name, String last_name, String email, String gender) {
      User temp = new User();
      temp.setFirst_name(first_name);
      temp.setLast_name( last_name);
      temp.setEmail(email);
      temp.setGender(gender);
      return temp;
   }

   public User crateUser(String[] userData){
      User temp = new User();
      temp.setFirst_name(userData[0]);
      temp.setLast_name( userData[1]);
      temp.setEmail(userData[2]);
      temp.setGender(userData[3]);
      return temp;
   }

    public static JsonObject toJson(User user){
       JsonObject temp = new JsonObject();
       temp.addProperty("id", user.getId());
       temp.addProperty("firstName", user.getFirst_name());
       temp.addProperty("lastName", user.getLast_name());
       temp.addProperty("email", user.getEmail());
       temp.addProperty("gender", user.getGender());
       return temp;
   }
}
