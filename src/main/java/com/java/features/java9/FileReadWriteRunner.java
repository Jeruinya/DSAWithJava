package com.java.features.java9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Files.writeString() and files.readString() methods were introduced in java 11
public class FileReadWriteRunner {
    public  static  void  main(String args[]) throws IOException {
        Path path= Paths.get("./resources/ABC.txt");
        String fileContent= Files.readString(path);
        System.out.print(fileContent);

        String newFileContent= fileContent.replace("Kamlesh","Rohan");
        Path filePath= Paths.get("./resources/ABCD.txt");
        Files.writeString(filePath,newFileContent);
    }
}
