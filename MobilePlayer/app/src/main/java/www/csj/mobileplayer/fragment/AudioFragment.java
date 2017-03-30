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

public class AudioFragment extends BaseFragment {


    public static final AudioFragment newInstance(){
        AudioFragment f = new AudioFragment();
        Bundle bundle = new Bundle();
        f.setArguments(bundle);
        return f;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, null);
        return view;
    }

    @Override
    protected void initData() {
        Log.d(TAG,"audioFragment initData");
        Toast.makeText(getActivity(),"audioFragment initData",Toast.LENGTH_SHORT).show();

    }
}
