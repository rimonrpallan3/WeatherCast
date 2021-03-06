package com.rimon.weathercast.webservices;


import com.rimon.weathercast.activity.landing.model.CurrentWeather;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.rimon.weathercast.appconfig.Constances.API.API_GET_WEATHER;

public interface WebServices {

    @GET(API_GET_WEATHER)
    Observable<CurrentWeather> getForecastList(@Query("key") String key, @Query("q") String loc, @Query("days") String num);


/*
    @FormUrlEncoded
    @POST("home")
    Observable<MainList> doGetDetails1(@Nullable @Field("user_id") Integer userID);


    @GET("listings/{limit}/{offset}")
    Observable<MainList> updateHouseList(@Path("limit") int limit, @Path("offset") int offset);

    @FormUrlEncoded
    @POST("propertyLike")
    Observable<LikeUnLike> propertyLike(@Nullable @Field("user_id") Integer userID,
                                        @Nullable @Field("property_id") Integer propertyID);

    @FormUrlEncoded
    @POST("propertyUnlike")
    Observable<LikeUnLike> propertyUnlike(@Nullable @Field("user_id") Integer email,
                                          @Nullable @Field("property_id") Integer papropertyIDsswd);


    @FormUrlEncoded
    @POST("listings/{propertyId}")
    Observable<HomeDetails> doGetHomeDetails(@Path("propertyId") int propertyId,
                                             @Nullable @Field("user_id") Integer userID);

    @FormUrlEncoded
    @POST("calenderRates")
    Observable<PriceDetails> getPriceDetails(@Nullable @Field("property_id") Integer propertyId,
                                             @Nullable @Field("guests_num") Integer guestNo,
                                             @Nullable @Field("checkin") String checkin,
                                             @Nullable @Field("checkout") String checkout,
                                             @Nullable @Field("user_id") Integer userID);

    @FormUrlEncoded
    @POST("listings/{limit}/{offset}/{typeId}")
    Observable<TypedDetail> doGetTypedDetails(@Path("limit") int limit,
                                              @Path("offset") int offset,
                                              @Path("typeId") int typeId,
                                              @Nullable @Field("user_id") Integer userID);

    @FormUrlEncoded
    @POST("locationwise")
    Observable<ArrayList<LocDetails>> getLocDetails(@Nullable @Field("user_id") Integer userID,
                                                    @Nullable @Field("location") String locName);

    @FormUrlEncoded
    @POST("LikedListings")
    Observable<ArrayList<FavDetail>> getFavDetails(@Nullable @Field("user_id") Integer userID);


    @FormUrlEncoded
    @POST("mobileLogin")
    public Observable<UserDetails> loginNormalUser(@Nullable @Field("email") String email,
                                                   @Nullable @Field("password") String passwd,
                                                   @Nullable @Field("login_type") String type,
                                                   @Nullable @Field("fcm") String fireBaseToken);

    @FormUrlEncoded
    @POST("mobileLogin")
    public Observable<UserDetails> loginGoogleUser(@Nullable @Field("email") String email,
                                                   @Nullable @Field("login_type") String type,
                                                   @Nullable @Field("profile_image") String imageP,
                                                   @Nullable @Field("phonenumber") String mobNo,
                                                   @Nullable @Field("userName") String userName,
                                                   @Nullable @Field("googleId") String googleId,
                                                   @Nullable @Field("fcm") String fireBaseToken);

    @FormUrlEncoded
    @POST("mobileLogin")
    public Observable<UserDetails> loginFBUser(@Nullable @Field("email") String email,
                                               @Nullable @Field("login_type") String type,
                                               @Nullable @Field("profile_image") String imageP,
                                               @Nullable @Field("phonenumber") String mobNo,
                                               @Nullable @Field("userName") String userName,
                                               @Nullable @Field("token") String fireBaseToken);

    @FormUrlEncoded
    @POST("createUser")
    public Observable<UserDetails> registerUser(@Nullable @Field("first_name") String fname,
                                                @Nullable @Field("last_name") String lname,
                                                @Nullable @Field("password") String password,
                                                @Nullable @Field("email") String email,
                                                @Nullable @Field("phone_num") String phone,
                                                @Nullable @Field("date_of_birth") String dob,
                                                @Nullable @Field("login_type") String type);


    @FormUrlEncoded
    @POST("createUser")
    public Observable<UserDetails> updateProfile(@Nullable @Field("first_name") String fname,
                                                 @Nullable @Field("last_name") String lname,
                                                 @Nullable @Field("user_id") int userId);

    @FormUrlEncoded
    @POST("myProfile")
    public Observable<UserPropertyDetails> getPropertiesDetail(@Nullable @Field("user_id") int userId);*/

}
