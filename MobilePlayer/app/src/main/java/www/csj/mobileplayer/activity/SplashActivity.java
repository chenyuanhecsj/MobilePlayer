package www.csj.mobileplayer.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import www.csj.mobileplayer.R;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initData();
    }

    /**
     * 初始化一些数据，延时三秒进入apk
     */
    private void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToMainActivity();
            }
        },3000);
    }

    /**
     * 进入主页面
     */
    private void goToMainActivity() {
        Toast.makeText(this,"进入主页面",Toast.LENGTH_SHORT).show();
    }
}
