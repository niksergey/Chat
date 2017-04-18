import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by sergey on 17.04.17.
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5555)) {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String header = "[" + new Date() + "] User1: ";
                System.out.print(header);
                Scanner sc = new Scanner(System.in);
                String request = sc.nextLine();

                bufferedWriter.write(header + request + "\n");
                bufferedWriter.flush();
                if (request.equals("stop"))
                    break;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
