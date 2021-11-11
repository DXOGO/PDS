public class CapitalizationFilter extends TextReaderDecorator{
    private int wordsRead;
    private String[] paragraphWords = null;

    public CapitalizationFilter(TextReaderInterface reader) {
        super(reader);        
        this.wordsRead = 0;
    }

    public boolean hasNext() {
        if (super.hasNext()) {
            return true;
        } else if (this.paragraphWords != null && this.wordsRead < this.paragraphWords.length) {
            // não há mais paragrafos, mas ainda não li todas as palavras deste
            return true;
        } else {
            return false;
        }
    }

    public String next() {
        // Falta tirar os acentos e a pontuação, não sei como fazer?
        if (this.paragraphWords != null && this.wordsRead < this.paragraphWords.length) {
            // vou acabar este paragrafo
            this.wordsRead++;
            String word = this.paragraphWords[this.wordsRead - 1];
            word = String.valueOf(Character.toUpperCase(word.charAt(0))) + word.substring(1, word.length()-1).toLowerCase() + String.valueOf(Character.toUpperCase(word.charAt(word.length()-1)));
            return word;
        } else if (super.hasNext()) {
            this.paragraphWords = super.next().split(" ");
            this.wordsRead = 1;
            String word = this.paragraphWords[this.wordsRead - 1];
            word = String.valueOf(Character.toUpperCase(word.charAt(0))) + word.substring(1, word.length()-1).toLowerCase() + String.valueOf(Character.toUpperCase(word.charAt(word.length()-1)));
            return word;
        } else {
            return null;
        }
    }
}