package programs;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FindIPAddress {
    public static void main(String[] args) {
        try {
            // 1️⃣ Display your computer’s IP address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Your Computer Name: " + localHost.getHostName());
            System.out.println("Your IP Address: " + localHost.getHostAddress());

            // 2️⃣ Accept domain name from user
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter a domain name (e.g., www.google.com): ");
            String domain = sc.nextLine();

            // 3️⃣ Print all IP addresses of that domain
            System.out.println("\nIP Addresses for " + domain + ":");
            InetAddress[] addresses = InetAddress.getAllByName(domain);

            for (InetAddress addr : addresses) {
                System.out.println(addr.getHostAddress());
            }

            sc.close();
        } 
        catch (UnknownHostException e) {
            System.out.println("Could not find the IP address. Please check the domain name.");
        }
    }
}
