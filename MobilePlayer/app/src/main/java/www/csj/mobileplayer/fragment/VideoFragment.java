package www.csj.mobileplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import www.csj.mobileplayer.R;

/**
 * Created by Administrator on 2017/3/30 0030.
 */

public class VideoFragment extends BaseFragment {

    public static final VideoFragment newInstance(){
        VideoFragment f = new VideoFragment();
        Bundle bundle = new Bundle();
        f.setArguments(bundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, null);
        return view;
    }
    @Override
    protected void initData() {
        Log.d(TAG,"VideoFragment initData");
        Toast.makeText(getActivity(),"VideoFragment initData",Toast.LENGTH_SHORT).show();
    }
}
