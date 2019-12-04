
/**
 *
 * @author George Lord 2019
 */
class Main 
{
    public static void main(String[] args) 
    { 
        try
        { 
           Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"echo You can find the current known devices and their assigned IP and MAC adresses on your network below: && arp -a\"");
        } 
        catch (Exception e) 
        { 
            System.out.println("Hey, something went wrong and we can't seem to open CMD. Please try again."); 
            e.printStackTrace(); 
        } 
    } 
} 
