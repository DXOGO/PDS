// Decorador de TextReader

public class TextReaderDecorator implements TextReaderInterface{
    private TextReaderInterface textReader;

    TextReaderDecorator(TextReaderInterface r) {
        this.textReader = r;
    }

    public boolean hasNext() {
        return this.textReader.hasNext();
    }

    public String next() {
        return this.textReader.next();
    }

    public void resetReader() {
        this.textReader.resetReader();
    }
}
