import additional.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Application {

    static int a = 25 + 25;

    private final static Logger LOG = LogManager.getLogger("Основной класс приложения");

    public static void main(String[] args) {
        LOG.info("===BEGIN===");

        Map<String, User> userMap = new TreeMap<>();

        User admin = new User("administrator", "1234qweqwe");
        User businessA = new User("business", "1234567qweqwe");
        User customer = new User("customer", "123qweqwe");

        userMap.put("administrator", admin);
        userMap.put("business", businessA);
        userMap.put("customer", customer);

        int[] ints = new int[1];

        try{
            LOG.info(ints[2]);
        } catch (IndexOutOfBoundsException e){
            LOG.error("Обращение за пределами массива:", e);
        }

        for (String username : userMap.keySet()){
            User cycleUser = userMap.get(username);
            String builder = "\nUser data: {" +
                    "\n" +
                    "Id: " +
                    cycleUser.getId() +
                    "\n" +
                    "Hidden Password: " +
                    cycleUser.getPassword(true) +
                    "\n}";
            LOG.info(builder);
        }
        LOG.info("===END===");

    }

}
