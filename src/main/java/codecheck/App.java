package codecheck;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
  public static void main(String[] args) throws IOException {

    for (int i = 0, l = args.length; i < l; i++) {

       String output = String.format("argv[%s]: %s", i, args[i]);

       URL url = new URL("http://challenge-server.code-check.io/api/hash");
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       conn.setRequestMethod("GET");
       conn.setDoInput(true);

       conn.connect();

       conn.disconnect();

       System.out.println(output);

        }
    }
}
