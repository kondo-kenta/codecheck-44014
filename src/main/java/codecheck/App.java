package codecheck;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
  public static void main(String[] args) throws Exception {

    for (int i = 0, l = args.length; i < l; i++) {

       String output = String.format("argv[%s]: %s", i, args[i]);

       URL url = new URL("http://challenge-server.code-check.io/api/hash" + "?q=" + args[i]);
       HttpURLConnection conn = (HttpURLConnection)url.openConnection();
       conn.setRequestMethod("GET");
       conn.setDoOutput(false);
       conn.setDoInput(true);
       conn.connect();

       StringBuffer sb = new StringBuffer();
       String line = "";
       BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
       while ((line = br.readLine()) != null) {
           sb.append(line);
       }

       System.out.println(sb.toString());

        }
    }
}
