public class Part3 {
    public static void main(String[] args) {
        testing();
    }



    public static boolean twoOccurances(String chars, String text){
        if(text.contains(chars)) {
            return true;
        }
        return false;
    }

    public  static String lastPart(String subPart, String text){
        int index = text.indexOf(subPart);
        if (index == text.length() - 1) {
            return "";
        }
        return text.substring(index+subPart.length());

    }

    public  static  void testing() {
        System.out.println(twoOccurances("abc", "a word of art is abc"));
        System.out.println(twoOccurances("cde", "a word of art is abc"));
        System.out.println(twoOccurances("abcd", "a word of art is  abcd efh hij klm mnop qrst uvw xyz"));

        System.out.println("--------------------------------------------");
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("car","bomcarararara"));
        System.out.println(lastPart("ram","programming "));
        System.out.println(lastPart("cat","banana"));

    }



}
