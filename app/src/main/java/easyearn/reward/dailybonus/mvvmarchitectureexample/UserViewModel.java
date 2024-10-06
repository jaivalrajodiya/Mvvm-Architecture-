package easyearn.reward.dailybonus.mvvmarchitectureexample;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {
    private MutableLiveData<User> users;
    private UserRepository userRepository;

    public UserViewModel() {
        userRepository = new UserRepository();
        users = new MutableLiveData<>();
    }

    public LiveData<User> getUsers() {
        loadUsers();
        return users;
    }

    private void loadUsers() {
        userRepository.getUsers(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    users.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle error here
                users.setValue(null);
            }
        });
    }
}
