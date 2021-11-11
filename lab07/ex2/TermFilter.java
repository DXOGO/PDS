public class TermFilter extends TextReaderDecorator {
    private int wordsRead;
    private String[] paragraphWords = null;

    public TermFilter(TextReaderInterface reader) {
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
        if (!this.hasNext()) {
            return null;
        }

        if (this.paragraphWords != null && this.wordsRead < this.paragraphWords.length) {
            // vou acabar este paragrafo
            this.wordsRead++;
            return this.paragraphWords[this.wordsRead - 1];
        } else if (super.hasNext()) {
            this.paragraphWords = super.next().split(" ");
            this.wordsRead = 1;
            return this.paragraphWords[0];
        } else {
            return null;
        }
    }
}
