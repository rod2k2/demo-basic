package io;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileTest {
    public static void main(String[] args) {


        try( InputStream fis = FileTest.class.getClassLoader().getResourceAsStream("../resources/sample.csv") ) {

            List<String> lines = IOUtils.readLines(fis, "UTF-8");
            lines.stream().forEach(x-> System.out.println(x));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
