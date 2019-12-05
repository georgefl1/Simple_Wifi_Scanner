
/**
 *
 * @author George Lord 2019
 */
import java.io.*;
class Main 
{
    public static void main(String[] args)throws IOException
    { 
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("C:\\Users\\basic\\OneDrive\\Desktop\\Wifiscript\\src\\main\\java\\Script.bat");
        
        try {

		Process process = processBuilder.start();

		StringBuilder output = new StringBuilder();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

		String line;
                int count = 0;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
                        if (line.contains("static") || line.contains("dynamic")){
                            count++;
                        }
		}
                Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"echo There are " + count + " visible online devices connected to this network && PAUSE\"");
        

		int exitVal = process.waitFor();
		if (exitVal == 0) {
			System.exit(0);
		}

	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    } 
} 
