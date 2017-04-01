package www.csj.mobileplayer.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.csj.mobileplayer.R;
import www.csj.mobileplayer.fragment.AudioFragment;
import www.csj.mobileplayer.fragment.FragmentFactory;
import www.csj.mobileplayer.fragment.NetAudioFragment;
import www.csj.mobileplayer.fragment.NetVideoFragment;
import www.csj.mobileplayer.fragment.VideoFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.fl_content)
    FrameLayout mFlContent;
    @BindView(R.id.iv_video)
    ImageView mIvVideo;
    @BindView(R.id.tv_video)
    TextView mTvVideo;
    @BindView(R.id.rl_tab_video)
    LinearLayout mRlTabVideo;
    @BindView(R.id.iv_audio)
    ImageView mIvAudio;
    @BindView(R.id.tv_audio)
    TextView mTvAudio;
    @BindView(R.id.rl_tab_audio)
    LinearLayout mRlTabAudio;
    @BindView(R.id.iv_net_video)
    ImageView mIvNetVideo;
    @BindView(R.id.tv_net_video)
    TextView mTvNetVideo;
    @BindView(R.id.rl_tab_netvideo)
    LinearLayout mRlTabNetvideo;
    @BindView(R.id.iv_net_audio)
    ImageView mIvNetAudio;
    @BindView(R.id.tv_net_audio)
    TextView mTvNetAudio;
    @BindView(R.id.rl_tab_netaudio)
    LinearLayout mRlTabNetaudio;
    @BindView(R.id.tv_top_search)
    TextView mTvTopSearch;
    @BindView(R.id.iv_top_game)
    ImageView mIvTopGame;
    @BindView(R.id.iv_top_record)
    ImageView mIvTopRecord;
    private FragmentManager mFm;
    private VideoFragment mVideoFragment;
    private AudioFragment mAudioFragment;
    private NetVideoFragment mNetVideoFragment;
    private NetAudioFragment mNetAudioFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 允许使用transitions
            getWindow().setEnterTransition(new Explode());
            getWindow().setReenterTransition(new Fade());
        }
        initUI();
        initListener();
        initData();
    }

    private void initListener() {
        mRlTabVideo.setOnClickListener(this);
        mRlTabAudio.setOnClickListener(this);
        mRlTabNetvideo.setOnClickListener(this);
        mRlTabNetaudio.setOnClickListener(this);
        mIvTopGame.setOnClickListener(this);
        mTvTopSearch.setOnClickListener(this);
        mIvTopRecord.setOnClickListener(this);
    }

    /**
     * 初始化数据
     */
    private void initData() {

    }

    /**
     * 初始化页面
     */
    private void initUI() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRlTabVideo.post(new Runnable() {
            @Override
            public void run() {
                mRlTabVideo.performClick();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_tab_video:
                setSlectedTabBg(mTvVideo, mIvVideo, R.drawable.ic_tab_video_press);
                unSlectedTabBg(mTvAudio, mIvAudio, mTvNetVideo, mIvNetVideo, mTvNetAudio, mIvNetAudio,
                        R.drawable.ic_tab_audio, R.drawable.ic_tab_netvideo, R.drawable.ic_tab_netaudio);
                mVideoFragment = (VideoFragment) FragmentFactory.getInstanceByIndex(1);
                //replaceFragment(mVideoFragment == null ? VideoFragment.newInstance() : mVideoFragment);
                replaceFragment(mVideoFragment);

                break;
            case R.id.rl_tab_audio:
                setSlectedTabBg(mTvAudio, mIvAudio, R.drawable.ic_tab_audio_press);
                unSlectedTabBg(mTvVideo, mIvVideo, mTvNetVideo, mIvNetVideo, mTvNetAudio, mIvNetAudio,
                        R.drawable.ic_tab_video, R.drawable.ic_tab_netvideo, R.drawable.ic_tab_netaudio);
                mAudioFragment = (AudioFragment) FragmentFactory.getInstanceByIndex(2);
                // replaceFragment(mAudioFragment == null ? AudioFragment.newInstance() : mAudioFragment);
                replaceFragment(mAudioFragment);

                break;
            case R.id.rl_tab_netvideo:
                setSlectedTabBg(mTvNetVideo, mIvNetVideo, R.drawable.ic_tab_netvideo_press);
                unSlectedTabBg(mTvAudio, mIvAudio, mTvVideo, mIvVideo, mTvNetAudio, mIvNetAudio,
                        R.drawable.ic_tab_audio, R.drawable.ic_tab_video, R.drawable.ic_tab_netaudio);
                mNetVideoFragment = (NetVideoFragment) FragmentFactory.getInstanceByIndex(3);
                // replaceFragment(mNetVideoFragment == null ? NetVideoFragment.newInstance() : mNetVideoFragment);
                replaceFragment(mNetVideoFragment);

                break;
            case R.id.rl_tab_netaudio:
                setSlectedTabBg(mTvNetAudio, mIvNetAudio, R.drawable.ic_tab_netaudio_press);
                unSlectedTabBg(mTvVideo, mIvVideo, mTvAudio, mIvAudio, mTvNetVideo, mIvNetVideo,
                        R.drawable.ic_tab_video, R.drawable.ic_tab_audio, R.drawable.ic_tab_netvideo);
                mNetAudioFragment = (NetAudioFragment) FragmentFactory.getInstanceByIndex(4);
                // replaceFragment(mNetAudioFragment == null ? NetAudioFragment.newInstance() : mNetAudioFragment);
                replaceFragment(mNetAudioFragment);
                break;
            case R.id.tv_top_search:
                Toast.makeText(this,"搜索",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_top_game:
                break;
            case R.id.iv_top_record:
                break;

        }
    }

    /**
     * 替换fragment
     */
    private void replaceFragment(Fragment fragment) {
        mFm = getSupportFragmentManager();
        mFm.beginTransaction().replace(R.id.fl_content, fragment).commit();
    }

    /**
     * 未按下去的bg
     */
    private void unSlectedTabBg(TextView tv1, ImageView iv1, TextView tv2,
                                ImageView iv2, TextView tv3, ImageView iv3,
                                int resId1, int resId2, int resId3) {
        tv1.setTextColor(getResources().getColor(R.color.main_tab_normal_bg));
        tv2.setTextColor(getResources().getColor(R.color.main_tab_normal_bg));
        tv3.setTextColor(getResources().getColor(R.color.main_tab_normal_bg));
        iv1.setImageResource(resId1);
        iv2.setImageResource(resId2);
        iv3.setImageResource(resId3);
    }


    /**
     * 按下去的bg
     */
    private void setSlectedTabBg(TextView textview, ImageView imageview, int resId) {
        textview.setTextColor(getResources().getColor(R.color.main_tab_selected_bg));
        imageview.setImageResource(resId);
    }
}
