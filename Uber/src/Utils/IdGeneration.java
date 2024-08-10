package Utils;

import java.util.UUID;

public class IdGeneration {
    public static String generateID(){
        return UUID.randomUUID().toString();
    }
}
