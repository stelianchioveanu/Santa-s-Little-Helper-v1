package main;

import checker.Checker;
import common.Constants;
import database.Database;
import fileio.writer.Writer;
import fileio.input.InputLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws Exception {
        File directory = new File(Constants.INPUT_PATH);
        Path path = Paths.get(Constants.RESULT);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        File outputDirectory = new File(Constants.RESULT);
        for (File file : Objects.requireNonNull(outputDirectory.listFiles())) {
            if (!file.delete()) {
                System.out.println();
            }
        }

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = Constants.OUTPUT_PATH + file.getName().substring(4);
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getAbsolutePath(), filepath);
            }
        }

        Checker.calculateScore();
    }

    public static void action(final String filePath1,
                              final String filePath2) throws IOException {

        Database.getInstance().entryPoint(new InputLoader(filePath1).readData(),
                new Writer(filePath2));
    }
}
