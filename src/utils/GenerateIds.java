package utils;

import java.util.Random;

public class GenerateIds {

    public static String GenerateMessageId(){
        String id = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 16;

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(id.length());
            char randomChar = id.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();

    }
}
