package ua.com.alevel.entity;

public class Genre {
    private String genreName;
    private String genreId;
    private int amount;

    public static Object genreId() {
        return genreId();
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreName='" + genreName + '\'' +
                ", genreId='" + genreId + '\'' +
                ", amount=" + amount +
                '}';
    }

}
