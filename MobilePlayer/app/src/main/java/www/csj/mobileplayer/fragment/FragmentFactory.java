package www.csj.mobileplayer.fragment;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

public class FragmentFactory {
    private static SparseArray<Fragment> mFragments = new SparseArray<>();

    public static BaseFragment getInstanceByIndex(int index) {
        BaseFragment fragment = null;
        fragment = (BaseFragment) mFragments.get(index);
        if (fragment == null) {
            switch (index) {
                case 1:
                    fragment = VideoFragment.newInstance();
                    break;
                case 2:
                    fragment = AudioFragment.newInstance();
                    break;
                case 3:
                    fragment = NetVideoFragment.newInstance();
                    break;
                case 4:
                    fragment = NetAudioFragment.newInstance();
                    break;
            }
            mFragments.put(index,fragment);
        }
        return fragment;
    }
} 