package bll.util;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TicketsToFileWriter {

    public static void main(String[] args) throws IOException {

        var fileName = System.getProperty("user.home") + "/Desktop/testFile";

        try (var fr = new FileWriter(fileName, StandardCharsets.UTF_8)) {

            fr.write("Today is a sunny day" +
                    " also its a rainy day" +
                    ", those 2 can coexist");
            fr.write("test 2");
        }
    }
}