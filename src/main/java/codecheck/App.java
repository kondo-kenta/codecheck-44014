package codecheck;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
  public static void main(String[] args) throws Exception {

    for (int i = 0, l = args.length; i < l; i++) {

       String queri = args[i];
       queri = queri.replace(" ", "%20");
       queri = queri.replace("'", "%27");
       queri = queri.replace("+", "%2B");

       URL url = new URL("http://challenge-server.code-check.io/api/hash" + "?q=" + queri);

       //System.out.println(url);

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

       String output = sb.toString();

       //System.out.println(output);

       System.out.println(output.substring(output.lastIndexOf(":")+2,output.lastIndexOf("}")-1));

        }
    }
}
