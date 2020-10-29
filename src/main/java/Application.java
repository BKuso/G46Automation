import additional.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static additional.Variables.someStatic;

public class Application {

    static int a = 25 + 25;

    private final static Logger LOG = LogManager.getLogger("Основной класс приложения");

    public static void main(String[] args) {
/*
        int[][][] ints = new int[3][2][];
        ints[0][0][0] = 1;
        ints[0][1][0] = 1;

        ints[1][0][0] = 2;
        ints[1][1][0] = 2;

        ints[2][0][0] = 3;
        ints[2][1][0] = 3;
*/
        LOG.info("===START===");
/*
        for (int i = 0; i < 3; i++){
            for (int a = 0; a < 2; a++){
                System.out.println("Current: " + ints[i][a]);
            }
        }

        List<List<String>> strings = new ArrayList<>();

        List<String> listOne = new ArrayList<>();
        listOne.add("String 1");
        listOne.add("String 2");
        listOne.add("String 3");
        listOne.add("String 4");

        strings.add(listOne);

*/

        List<User> users = new ArrayList<>();

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

/*
        users.add(admin);
        users.add(businessA);
        users.add(customer);

        int[] intArray = new int[]{2, 4, 5, 6, 7, 10, 235};
        int[] ints = new int[4];

        List<Integer> intList = new ArrayList<>();
        intList.add(235);
        intList.add(7);
        intList.add(6);
        intList.add(5);
        intList.add(4);
        intList.add(2);

        intList.remove(0);
        intList.add(0, 20);

        ints[0] = 5;

     //   int b = 0;

        while (b!=6){

        }
        System.out.println("=========");

        do {
            System.out.println("Current value of b is: " + b);
            b++;
        } while (b!=6);
 */
        Calc calc = new Calc();
/*
        for (int element : intList){
            System.out.println("Result: " + calc.sum(element, 4));
        }
*/



     //   System.out.println("Our element: " + ints[0]);

      //
        LOG.info("===FINISH===");

    }

}
