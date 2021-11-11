import java.util.List;

public class Movie {

    // more important
    private final String title;
    private final int year;
    private final Person director;
    
    // less important
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder{
        // more important
        private String title;
        private int year;
        private Person director;

        // less important
        private Person writer = null;
        private String series = "";
        private List<Person> cast = null;
        private List<Place> locations = null;
        private List<String> languages = null;
        private List<String> genres = null;
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;

        public Builder(String title, int year, Person director){
            this.title = title;
            this.year = year;
            this.director = director;
        }

        public Builder writer(Person w){
            this.writer = w;
            return this;
        }

        public Builder series(String s){
            this.series = s;
            return this;
        }
        
        public Builder cast(List<Person> c){
            this.cast = c;
            return this;
        }

        public Builder locations(List<Place> loc){
            this.locations = loc;
            return this;
        }

        public Builder languages(List<String> lang){
            this.languages = lang;
            return this;
        }

        public Builder genres(List<String> gen){
            this.genres = gen;
            return this;
        }

        public Builder isTelevision(boolean isTv){
            this.isTelevision = isTv;
            return this;
        }

        public Builder isNetflix(boolean isNf){
            this.isNetflix = isNf;
            return this;
        }

        public Builder isIndependent(boolean isInd){
            this.isIndependent = isInd;
            return this;
        }

        //calls the movie builder
        public Movie build() {
            return new Movie(this);
        }

    }

    private Movie(Builder builder) {
        this.title = builder.title;
        this.year = builder.year;
        this.director = builder.director;
        this.writer = builder.writer;
        this.series = builder.series;
        this.cast = builder.cast;
        this.locations = builder.locations;
        this.languages = builder.languages;
        this.genres = builder.genres;
        this.isTelevision = builder.isTelevision;
        this.isNetflix = builder.isNetflix;
        this.isIndependent = builder.isIndependent;
    }
} 