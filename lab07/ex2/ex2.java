public class ex2 {
    public static void main(String[] args) {
        TextReaderInterface reader = new TextReader("testFile.txt");
        while (reader.hasNext()) {
            System.out.println(reader.next());
            System.out.println("---------------------------");
        }
        reader.resetReader();
        TextReaderInterface reader_filter = new TermFilter(reader);
        int limit = 0;
        while (reader_filter.hasNext() && limit < 20) {
            limit++;
            System.out.println(reader_filter.next());
            System.out.println("---------------------------");
        }

        System.out.println("--------------------------------------------------");

        reader.resetReader();
        TextReaderInterface normalization_filter = new NormalizationFilter(reader);
        while (normalization_filter.hasNext()) {
            System.out.println(normalization_filter.next());
            System.out.println("---------------------------");
        }

        System.out.println("--------------------------------------------------");

        normalization_filter.resetReader();
        TextReaderInterface capitalization_filter = new CapitalizationFilter(normalization_filter);
        limit = 0;
        while (capitalization_filter.hasNext() && limit < 20) {
            limit++;
            System.out.println(capitalization_filter.next());
            System.out.println("---------------------------");
        }

        normalization_filter.resetReader();
        TextReaderInterface vowel_filter = new VowelFilter(normalization_filter);
        while (vowel_filter.hasNext()) {
            System.out.println(vowel_filter.next());
            System.out.println("---------------------------");
        }
    }
}
