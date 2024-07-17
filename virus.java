import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class virus{
    private static final String SIGNATURES_FILE = "virus_signatures.txt";

    public static void main(String[] args) {
        String targetFile = "file_to_scan.txt";

        try {
            // Load virus signatures from the file
            String[] virusSignatures = loadSignatures();

            // Scan the target file for virus signatures
            boolean isInfected = scanFile(targetFile, virusSignatures);

            if (isInfected) {
                System.out.println("Infected file detected: " + targetFile);
            } else {
                System.out.println("No viruses found in: " + targetFile);
            }
        } catch (IOException e) {
            System.err.println("Error while scanning the file: " + e.getMessage());
        }
    }

    private static String[] loadSignatures() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(SIGNATURES_FILE));
        String line;
        String signatures = "";

        while ((line = reader.readLine()) != null) {
            signatures += line + "\n";
        }

        reader.close();

        // Split signatures into individual lines and return as an array
        return signatures.split("\n");
    }

    private static boolean scanFile(String targetFile, String[] virusSignatures) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(targetFile));
        String line;

        while ((line = reader.readLine()) != null) {
            // Check if the line matches any of the virus signatures
            for (String signature : virusSignatures) {
                if (line.contains(signature)) {
                    reader.close();
                    return true;
                }
            }
        }

        reader.close();
        return false;
}
}