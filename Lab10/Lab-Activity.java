package programs;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WhoisClient {
    public static void main(String[] args) {
        final String WHOIS_SERVER = "whois.internic.net";
        final int WHOIS_PORT = 43;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter domain name (e.g., example.com): ");
        String domain = sc.nextLine();

        try (
            // 1️⃣ Connect to WHOIS server on port 43
            Socket socket = new Socket(WHOIS_SERVER, WHOIS_PORT);

            // 2️⃣ Create input/output streams
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
        ) {
            // 3️⃣ Send the domain name followed by CRLF (\r\n)
            domain = domain + "\r\n";
            out.write(domain.getBytes());
            out.flush();

            // 4️⃣ Read and display the WHOIS response
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            System.out.println("\n===== WHOIS Information for " + domain.trim() + " =====");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: Unknown host - " + WHOIS_SERVER);
        } catch (IOException e) {
            System.out.println("Error: Unable to connect or read data from WHOIS server.");
        } finally {
            sc.close();
        }
    }
}
