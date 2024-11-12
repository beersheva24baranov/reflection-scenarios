package reflection;

import java.lang.reflect.Constructor;

public class Main {
    private static final String BASE_PACKAGE = "telran.reflection";
    
        @SuppressWarnings("unchecked")
        public static void main(String[] args) {
            String className = "";
            try {
                if (args.length != 3) {
                    throw new IllegalArgumentException(
                            "There should be three arguments: class name, specific string for a sportsman, sportsman name");
                }
                className = BASE_PACKAGE + "." + args[0];
            Class<Sportsman> clazz = (Class<Sportsman>) Class.forName(className);
            Constructor<Sportsman> constructor = clazz.getConstructor(String.class, String.class);
            Sportsman sportsman = constructor.newInstance(args[1], args[2]);
            sportsman.action();
        } catch (ClassNotFoundException e) {
            System.out.println(className + " Class not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}