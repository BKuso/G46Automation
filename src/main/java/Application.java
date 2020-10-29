import additional.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Application {

    static int a = 25 + 25;

    private final static Logger LOG = LogManager.getLogger("Основной класс приложения");

    public static void main(String[] args) {
        LOG.info("===START===");

        Map<String, User> userMap = new TreeMap<>();

        User admin = new User("admin", "1234qweqwe");
        User businessA = new User("businessA", "1234567qweqwe");
        User customer = new User("customer", "123qweqwe");

        userMap.put("admin", admin);
        userMap.put("businessA", businessA);
        userMap.put("customer", customer);

        int[] ints = new int[1];

        try{
            LOG.info(ints[2]);
        } catch (IndexOutOfBoundsException e){
            LOG.error("Обращение за пределами массива:", e);
        }

        for (String username : userMap.keySet()){
            User cycleUser = userMap.get(username);
            String builder = "\nCurrent user data: {" +
                    "\n" +
                    "User id: " +
                    cycleUser.getId() +
                    "\n" +
                    "Hidden Password: " +
                    cycleUser.getPassword(true) +
                    "\n}";
            LOG.info(builder);
        }
        LOG.info("===FINISH===");

    }

}
