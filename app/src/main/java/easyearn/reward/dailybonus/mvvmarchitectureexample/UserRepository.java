package easyearn.reward.dailybonus.mvvmarchitectureexample;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {
    private static final String BASE_URL = "https://api.example.com/";
    private ApiService apiService;

    public UserRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void getUsers(Callback<User> callback) {
        Call<User> call = apiService.getUsers();
        call.enqueue(callback);
    }
}
