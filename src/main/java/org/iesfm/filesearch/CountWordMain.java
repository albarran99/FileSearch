package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class CountWordMain {

    private static Logger log = LoggerFactory.getLogger(CountWordMain.class);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        log.info("Introduce un directorio");
        String folderPath = scanner.nextLine();
        log.info("Introduce una palabra a buscar");
        String word = scanner.nextLine();

        File folder = new File(folderPath);

        File[] files = folder.listFiles();
        int occurrences = 0;
        for (File file : files) {
            CountWordTask countWordTask = new CountWordTask(file, word);
            Thread countWordThread = new Thread(countWordTask);
            countWordThread.start();
            try {
                countWordThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            occurrences += countWordTask.getOccurences();
        }

        log.info("La palabra " + word +" aparece " + occurrences);
    }
}
