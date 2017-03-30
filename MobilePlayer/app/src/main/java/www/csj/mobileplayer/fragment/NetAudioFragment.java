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

public class NetAudioFragment extends BaseFragment {

    public static final NetAudioFragment newInstance(){
        NetAudioFragment f = new NetAudioFragment();
        Bundle bundle = new Bundle();
        f.setArguments(bundle);
        return f;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net_audio, null);
        return view;
    }
    @Override
    protected void initData() {
        Log.d(TAG,"NetAudioFragment initData");
        Toast.makeText(getActivity(),"NetAudioFragment initData",Toast.LENGTH_SHORT).show();
    }
}
