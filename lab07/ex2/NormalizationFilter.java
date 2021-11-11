import java.text.Normalizer;

public class NormalizationFilter extends TextReaderDecorator{

    public NormalizationFilter(TextReaderInterface reader) {
        super(reader);
    }

    public String next() {
        String ret = super.next();
        ret  = Normalizer.normalize(ret, Normalizer.Form.NFKD);
        ret = ret.replaceAll("[^\\p{ASCII}]", "");
        ret = ret.replaceAll("[.!?\\-,]", "");
        return ret;
    }
}
