package www.csj.mobileplayer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.csj.mobileplayer.R;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
public class SplashActivity extends BaseActivity implements Animation.AnimationListener {

    @BindView(R.id.rl_splash)
    LinearLayout mRlSplash;

    private AlphaAnimation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initData();
        initListener();
    }

    private void initListener() {
        mAnimation.setAnimationListener(this);
    }

    /**
     * 初始化一些数据，延时三秒进入apk
     */
    private void initData() {

        mAnimation = new AlphaAnimation(0.1f, 1.0f);
        mAnimation.setDuration(2000);
        mAnimation.setFillAfter(true);
        mRlSplash.setAnimation(mAnimation);
    }

    /**
     * 进入主页面
     */
    private void goToMainActivity() {
        // Toast.makeText(this,"进入主页面",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        goToMainActivity();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
