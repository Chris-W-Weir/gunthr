package pupper_soft.livingroom.interfaces;

import pupper_soft.livingroom.objects.shareObject;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface shareApi {
    @Headers("Content-Type: application/json")
    @POST("/link")
    Call<shareObject> shareLink(@Body shareObject link);
}
