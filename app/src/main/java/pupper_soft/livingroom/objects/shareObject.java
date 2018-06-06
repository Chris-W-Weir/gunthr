package pupper_soft.livingroom.objects;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class shareObject {
    private final String TAG = shareObject.class.getSimpleName();
    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        Log.d(TAG, "My url is now " + url);
        this.url = url;
    }
}

