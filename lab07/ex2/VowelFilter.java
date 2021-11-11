public class VowelFilter extends TextReaderDecorator{
    VowelFilter(TextReaderInterface reader) {
        super(reader);
    }

    public String next() {
        String ret = super.next();
        ret = ret.replaceAll("[aeiouAEIOU]+", "");
        return ret;
    }
}
