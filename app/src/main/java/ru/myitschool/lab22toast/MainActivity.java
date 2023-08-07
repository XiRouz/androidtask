package ru.myitschool.lab22toast;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import ru.myitschool.lab22toast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        showToast(getResources().getString(R.string.ncreate));
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast(getResources().getString(R.string.nstart));
    }
    @Override
    protected void onResume() {
        super.onResume();
        showToast(getResources().getString(R.string.nresume));
    }
    @Override
    protected void onDestroy() {
        MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        int count = model.getCount();
        count++;
        model.setCount(count);
        if (count%2 == 0){
            showToast(getResources().getString(R.string.ndestroy));
        }
        super.onDestroy();
    }

    public void showToast(String str){
        Toast toast = Toast.makeText(this, str,Toast.LENGTH_LONG);
        toast.show();
    }
}
