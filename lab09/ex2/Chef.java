public class Chef {
    private String keyword;
    private int time;
    private Chef nextChef = null;

    public Chef(String key, int time) {
        this.setKeyword(key);
        this.setTime(time);
    }

    public void cook(String phrase) {
        if (this.nextChef != null) {
            this.nextChef.cook(phrase);
        }
        else {
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }

    public boolean canCook(String phrase, String key) {
        if (phrase.toLowerCase().contains(key.toLowerCase())) {
            return true;
        }

        return false;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public Chef getNextChef() {
        return nextChef;
    }

    public Chef setNextChef(Chef nextChef) {
        this.nextChef = nextChef;
        return this;
    }

}