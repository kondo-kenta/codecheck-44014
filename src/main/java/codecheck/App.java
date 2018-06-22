package codecheck;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.PrintWriter;

public class App {
  public static void main(String[] args) throws Exception {

    for (int i = 0, l = args.length; i < l; i++) {

       String output = String.format("argv[%s]: %s", i, args[i]);

       URL url = new URL("http://challenge-server.code-check.io/api/hash");
       HttpURLConnection conn = (HttpURLConnection)url.openConnection();
       conn.setRequestMethod("GET");
       conn.setDoInput(true);
       conn.connect();

       PrintWriter out = new PrintWriter(conn.getOutputStream());
       out.write(output);
       out.flush();
       out.close();
       
       InputStream in = conn.getInputStream();

       System.out.println(output);

        }
    }
}
