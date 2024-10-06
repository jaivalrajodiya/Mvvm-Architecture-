package easyearn.reward.dailybonus.mvvmarchitectureexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;

    TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUsers().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User users) {
                if (users != null) {
                    StringBuilder builder = new StringBuilder();

                    name.setText(users.getName());
                    email.setText(users.getEmail());

                } else {
                    name.setText("Failed to load data");
                    email.setText("Failed to load data");
                }
            }
        });
    }
}