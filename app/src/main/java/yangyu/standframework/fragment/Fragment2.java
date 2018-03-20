package yangyu.standframework.fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yangyu.standframework.R;

/**
 * Created by 杨宇 on 2018/3/9.
 */

public class Fragment2 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view02=inflater.inflate(R.layout.fragment_layout2,container,false);
        return view02;

    }
}
