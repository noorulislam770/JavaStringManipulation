import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import  java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
    public static void main(String[] args) {
    try {


        URL url = new URL("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String inputLine ;
        StringBuilder content = new StringBuilder();
        Pattern hrefPattern = Pattern.compile("href\\s*=\\s*\"([^\"]*)\"");

        while ((inputLine = in.readLine()) != null) {
//            System.out.println(inputLine);
            Matcher hrefMatcher = hrefPattern.matcher(inputLine);
            while (hrefMatcher.find()) {
                content.append(hrefMatcher.group(1)).append("\n");
            }

        }

        in.close();


    String pageContent = content.toString();
    Pattern pattern = Pattern.compile("www\\.youtube\\.com");
    Matcher matcher = pattern.matcher(pageContent);
    boolean found = false;

    while (matcher.find()) {
        int start = matcher.start();
        int end = pageContent.indexOf("\n", start);
        if (end == -1) {
            end = pageContent.length() ;
        }
        System.out.println(pageContent.substring(start,end ));
        found = true;

    }

    if (!found) {
        System.out.println("No match found");
    }



    }catch (Exception e) {
        e.printStackTrace();
    }
    }








}
