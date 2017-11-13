package android.example.com.yihubaiying.adapter;

/**
 * Created by Thingvellir on 2017/11/9.
 */

public class News {
    private String title;
    private String source;
    private String liuliang;
    private int ImageResourceId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLiuliang() {
        return liuliang;
    }

    public void setLiuliang(String liuliang) {
        this.liuliang = liuliang;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }

    public News(String title, String source, String liuliang, int imageResourceId) {
        this.title = title;
        this.source = source;
        this.liuliang = liuliang;
        ImageResourceId = imageResourceId;
    }
}
