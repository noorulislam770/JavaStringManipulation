// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        String  s = "dukeprogramming";

        String x = s.substring(4,7);
        System.out.println(x);
        System.out.println(s.length());
        System.out.println(s.indexOf("program"));
        System.out.println(s.indexOf("g",8));
        System.out.println(s.startsWith("duke"));
        System.out.println(s.endsWith("king"));


        // String res = findGeneSimple ("ATGAAATGTATTAGAACTGGTATTAGGATAGATGAGTATTATAA");
        System.out.println(findGeneSimple ("ATGAAATGTATTAGATGGTABTTAGGATAGATGAGTATTATAA"));
        System.out.println(findGeneSimple ("AGAAATAGTATTAGATAGGTATTAGGATAAGATAGAGTATTATAA"));
        System.out.println(findGeneSimple ("ATGAAATGTATTAGATGGTATTAGGATAGATGAGTATTATA"));
    }

    public static String findGeneSimple(String dna) {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1 ) {
            return  "Gene Not Found";
        }
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if(stopIndex == -1) {
            return "Gene Not Found";
        }
        double difference = stopIndex - startIndex;
        System.out.println("difference " + difference);
        if ((stopIndex  - startIndex) % 3 == 0){

            result = dna.substring(startIndex, stopIndex + 3);
        }else {
            return "Invalid DNA sequence!";
        }



        return result;
    }


}