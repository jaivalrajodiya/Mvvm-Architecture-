package easyearn.reward.dailybonus.mvvmarchitectureexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("test.php")
    Call<User> getUsers();
}
