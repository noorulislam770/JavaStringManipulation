public class Part2 {
    public static void main(String[] args) {
        testFindGeneSimple();
    }

    public static void testFindGeneSimple() {
        System.out.println("Find Gene Simple Text");
        System.out.println(findGeneSimple ("ATGAAATGTATTAGATGGTABTTAGGTAGATGAGTATTATAA","ATG","TAA"));
        System.out.println(findGeneSimple ("ATGAAATGTTTAGATGGTABTTAGGATAGATGAGTATTATAA","ATG","TAA"));
        System.out.println(findGeneSimple ("TATGATCATATAGATATGATATAGAGAAGTAGATATTAT","ATG","TAA"));
        System.out.println(findGeneSimple ("aAGGATAGATGAGTATTATAA","AAG","TAA"));
        System.out.println(findGeneSimple ("ATGAAATGTATTAGATGGTABTT","ATG","TAA"));
        System.out.println(findGeneSimple ("ATGAAATGTATTAGAAA","ATG","TAA"));


    }



    public static String findGeneSimple(String dna,String startCodon, String stopCodon) {
        boolean uppercase = Character.isUpperCase(dna.charAt(0));
        if (uppercase) {
            dna = dna.toUpperCase();
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        else {
            dna = dna.toLowerCase();
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        String result = "";
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            return "Gene Not Found";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (stopIndex == -1) {
            return "Gene Not Found";
        }
        double difference = stopIndex - startIndex;
        System.out.println("difference " + difference);
        if ((stopIndex - startIndex) % 3 == 0) {

            result = dna.substring(startIndex, stopIndex + 3);
        } else {
            return "Invalid DNA sequence!";
        }
        return result;
    }


}
