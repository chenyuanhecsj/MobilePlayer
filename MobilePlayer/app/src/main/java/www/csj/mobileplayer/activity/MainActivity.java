package www.csj.mobileplayer.activity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;

import www.csj.mobileplayer.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 允许使用transitions
            getWindow().setEnterTransition(new Fade());
            getWindow().setReenterTransition(new Fade());
        }
        setContentView(R.layout.activity_main);
    }
}
