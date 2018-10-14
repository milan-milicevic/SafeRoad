package WebAPI;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Acer on 20.11.2017..
 */

public interface RetroApi {

    @Headers("Accept: application/json")
    @GET("api/data")
    Call<JsonObject> getData();

    //data from API
    @Headers("Accept: application/json")
    @GET("api/users")
    Call<JsonArray> getAllUsers(@Header("Authorization") String aut);
    @Headers("Accept: application/json")
    @GET("api/users/")
    Call<JsonObject> getUser(@Header("Authorization") String aut, @Query("id") Integer id);
    @Headers("Accept: application/json")
    @POST("api/users/create")
    Call<JsonObject> createUser(@Header("Authorization") String aut, @Body JsonObject korisnik);
    @Headers("Accept: application/json")
    @PATCH("api/users/{user}")
    Call<JsonObject> updateUser(@Header("Authorization") String aut, @Path("user") String id, @Body JsonObject korisnik);
    @Headers("Accept: application/json")
    @PATCH("api/users/{user}/password")
    Call<JsonObject> updateUserPassword(@Header("Authorization") String aut, @Path("user") String id, @Body JsonObject korisnik);
    @Headers("Accept: application/json")
    @DELETE("api/users/{user}")
    Call<JsonObject> deleteUser(@Header("Authorization") String aut,@Path("user") String id);
    @POST("login")
    Call<JsonObject>  login(@Body JsonObject objekt);


    //logs
    @Headers("Accept: application/json")
    @GET("api/logs")
    Call<JsonArray> getLogs(@Header("Authorization") String aut);
    @Headers("Accept: application/json")
    @POST("api/users/{user_id}/logs")
    Call<JsonObject> makeLog(@Path(value = "user_id", encoded = true) String userId, @Header("Authorization") String aut, @Body JsonObject log);
    @Headers("Accept: application/json")
    @GET("api/users/{user_id}/Logs")
    Call<JsonArray> getUserLogs(@Path(value = "user_id", encoded = true) String userId,@Header("Authorization") String aut);
    @Headers("Accept: application/json")
    @GET("api/users/{user_id}/Logs/")
    Call<JsonObject> getUserLog(@Path(value = "user_id", encoded = true) String userId,@Header("Authorization") String aut, @Query("Log_id") Integer log_id);

    //password
    @Headers("Accept: application/json")
    @GET("api/passwords")
    Call<JsonObject> getPassword(@Header("Authorization") String aut);
    @Headers("Accept: application/json")
    @POST("api/passwords")
    Call<JsonObject> setPassword(@Header("Authorization") String aut, @Body JsonObject password);

    //token
    @POST("/oauth/token")
    Call<JsonObject> setToken(@Body JsonObject param);


}
