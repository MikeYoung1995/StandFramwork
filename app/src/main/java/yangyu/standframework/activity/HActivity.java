package yangyu.standframework.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import yangyu.standframework.R;

/**
 * Created by 杨宇 on 2018/3/9.
 */

public class HActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hactivity_layout);
    }
}
