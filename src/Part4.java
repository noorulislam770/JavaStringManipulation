import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import  java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
    public static void main(String[] args) {
        try {


            URL url = new URL("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
    //            System.out.println(inputLine);
                content.append(inputLine);
            }

            in.close();
            String rawContent = content.toString().toLowerCase();
    //        System.out.println(rawContent);
    //        System.out.println(content.toString());

            List<String> links = new ArrayList<>();

            while (true) {

                boolean containsLink = rawContent.contains("youtube.com");
    //            System.out.println(containsLink);
                if (containsLink) {
                    int startIndex = rawContent.indexOf("youtube.com");
                    int endIndex = rawContent.indexOf("\"", startIndex);
                    String link = rawContent.substring(startIndex, endIndex);
                    link = "www." + link;
                    links.add(link);
                    rawContent = rawContent.substring(endIndex+1);
                }
                else {
                    break;
            }

    //        System.out.println(rawContent);
            for (int i =0; i < links.size(); i++ ) {
                String link = links.get(i);
                System.out.println(link);
            }
        }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
