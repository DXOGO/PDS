abstract class tipoProduto {

    public abstract void draw();

    public abstract float getWeight();

    private static StringBuffer indent = new StringBuffer();

    public StringBuffer getIndent(){
        return indent;
    }
}
