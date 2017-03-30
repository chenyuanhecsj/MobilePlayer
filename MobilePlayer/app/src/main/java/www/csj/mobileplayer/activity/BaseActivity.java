package www.csj.mobileplayer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import www.csj.mobileplayer.R;
import www.csj.mobileplayer.util.StatusBarCompat;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.compat(this, getResources().getColor(R.color.colorPrimaryDark));
    }
}
