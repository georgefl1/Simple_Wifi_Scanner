
/**
 *
 * @author George Lord 2019
 */
import java.io.*;
import java.util.*;
import java.net.*;  

class Main 
{
    public static String getName(String ip){
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "nslookup " + ip);
        
        try {

		Process process = processBuilder.start();

		StringBuilder output = new StringBuilder();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

		String line;
                ArrayList<String> lines = new ArrayList<String>();
                
                int count = 0;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
                
                if (lines.size() >=4 ){
                    return lines.get(3);
                }
                else{
                    return ip;
                }
                
                

	} catch (IOException e) {
		e.printStackTrace();
        }
        return "ERROR";
        
    }
    public static void main(String[] args)throws IOException
    {
        ArrayList<String> ips = new ArrayList<String>();
        
        String sub = "192.168.1";
        
        System.out.println("Scanning IPs. Please allow up to five minutes for this process.");
        
        for (int i=1;i<255;i++){
            
            String ip=sub + "." + i;
            
            if (InetAddress.getByName(ip).isReachable(1000)){
                ips.add(ip);
            }
        }
        
        System.out.println("We found " + ips.size() + " devices on your subnet. Here are their names and IPs:");
        for (String i: ips){
            System.out.println(getName(i) + " found at IP " + i);
        }
        
    } 
} 
