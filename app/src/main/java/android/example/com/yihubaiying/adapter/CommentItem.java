package android.example.com.yihubaiying.adapter;

/**
 * Created by Thingvellir on 2017/11/9.
 */

public class CommentItem {
    private int ImageResourceId;
    private String nickname;
    private String time;
    private String content;
    private int goodPicId;

    public CommentItem(int imageResourceId, String nickname, String time, String content, int goodPicId) {
        ImageResourceId = imageResourceId;
        this.nickname = nickname;
        this.time = time;
        this.content = content;
        this.goodPicId = goodPicId;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGoodPicId() {
        return goodPicId;
    }

    public void setGoodPicId(int goodPicId) {
        this.goodPicId = goodPicId;
    }
}
