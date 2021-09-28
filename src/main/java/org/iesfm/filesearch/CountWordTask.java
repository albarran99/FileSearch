package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class CountWordTask implements Runnable {

    private static Logger log = LoggerFactory.getLogger(CountWordTask.class);

    private File file;
    private String word;

    private int occurences = 0;
    private FileUtils fileUtils = new FileUtils();

    public CountWordTask(File file, String word) {
        this.file = file;
        this.word = word;
    }

    @Override
    public void run() {
        occurences = fileUtils.countTextOccurrences(file, word);
        log.info("En el archivo " + file.getName() + " aparece " + occurences);
    }

    public int getOccurences() {
        return occurences;
    }
}
