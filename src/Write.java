import javax.swing.*;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Write {
    public static void createNew(String filePath, String content, int enterOne, boolean enterFalse, boolean askedEnterFalse) throws IOException, InterruptedException{
        try {
            Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.CREATE_NEW);
        }
        catch (FileAlreadyExistsException err) {
            if (!enterFalse && !askedEnterFalse) {
                enterFalse = wantsToReplace();
            }

            if (!enterFalse) {
                String newFilePath = filePath.substring(0, filePath.length() - 5);
                if (newFilePath.endsWith(")")) {
                    int endIndex = newFilePath.length() - 1;
                    boolean indexFound = false;
                    for (int i = newFilePath.length() - 1; !indexFound; i--) {
                        if (newFilePath.charAt(i) == '(') {
                            endIndex = i;
                            indexFound = true;
                        }
                    }
                    newFilePath = newFilePath.substring(0, endIndex);
                }

                newFilePath = newFilePath + "(" + enterOne + ").jvto";
                enterOne++;
                createNew(newFilePath, content, enterOne, enterFalse, true);
            }
            else {
                Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.CREATE);
            }
        }
    }

    private static boolean wantsToReplace(){
        String message = "This file already exists. Do you want to replace it?\n" +
                "  - select NO to create new indexed file\n" +
                "  - select YES to replace the file\n";
        int option = JOptionPane.showConfirmDialog(null, message, "File already exists", JOptionPane.YES_NO_OPTION);
        if(option==0) return true;
        return false;
    }
}
