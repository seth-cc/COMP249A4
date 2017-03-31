import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private PrintWriter writer = null;
    private LineNumberReader reader = null; // A class provided by java.io that extends BufferedReader, can read specific lines

    public void write(String file, String content) {
        try {
            writer = new PrintWriter(new FileOutputStream(file, true));
            writer.write(content + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file!");
        } finally {
            writer.close();
        }
    }

    public String readLine(String file, int line) {
        try {
            reader = new LineNumberReader(new FileReader(file));
            for (int i = 0; i < line; i++) {
                reader.readLine();
            }
            return reader.readLine();
        } catch (FileNotFoundException e) {
            System.out.print("readLine: File not found!");
            return "";
        } catch (IOException e) {
            System.out.print("readLine: IOException! " + e.getMessage());
            return "";
        }
//        finally {
//            try {
//                reader.close();
//            } catch (IOException e2) {
//                System.out.println(e2.getMessage());
//            }
//        }
    }

    public String[] readAll(String file) {

        ArrayList<String> output = new ArrayList<>();
        try {
            reader = new LineNumberReader(new FileReader(file));

            String line = reader.readLine();
            while (line != null) {
                output.add(line);

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.print("readEach: File not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        finally {
//            try {
//                reader.close();
//            } catch (IOException e2) {
//                System.out.println(e2.getMessage());
//            }
//        }
        return output.toArray(new String[output.size()]);
    }

    public void removeLine(String file, int id) {

        String[] contents = readAll(file);
        if (contents.length == 0) {
            System.out.println("removeLine: File is empty!");
        } else {
            // New file that will later be renamed to the original filename.
            File temp = new File("database/file.tmp");
            for (String content : contents) {
                int stringId = Integer.parseInt(content.substring(0, content.indexOf(",")));
                if (stringId != id) {
                    write("database/file.tmp", content);
                }
            }
            // Delete the original file
            File f = new File(file);
            if (!f.delete()) {
                System.out.println("removeLine: Could not delete original file!");
            }
            //Rename the new file to the filename the original file had.
            if (!temp.renameTo(new File(file)))
                System.out.println("removeLine: Could not rename file!");
        }


    }
}

