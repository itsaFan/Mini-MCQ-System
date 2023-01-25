package structure;

import java.io.File;

public class FileConfig {

    private String directory;
    private String extension;
    private File[] files;

    public FileConfig(String directory, String extension) {
        this.directory = directory;
        this.extension = extension;
    }

    public File[] getQuestionFile() {
        File file = new File(directory);
        this.files = file.listFiles((dir, filename) -> filename.toLowerCase().endsWith(extension));
        return files;
    }

    public void displayAllFiles() {
        try {
            System.out.println("Choose your Multiple Choice Question Set.\nThe Options are : ");
            for (int i = 0; i < files.length; i++) {
                System.out.print((i+1) + " - ");
                System.out.println(files[i].getName());
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }




}
