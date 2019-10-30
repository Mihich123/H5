package mihich;

public class Next {

    private String Url;
    private String title;

    public Next() {
    }

    public Next(String url, String title) {
        Url = url;
        this.title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Next{" +
                "Url='" + Url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
