package yangyu.standframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * 这个项目作为以后开发使用的公共APP架构，可以直接使用这个类似的交互和UI界面 或者略做更改
 */

public class MainActivity extends AppCompatActivity {
    public final  int SPLASH_DISPLAY_LENGTH=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent minIntent=new Intent(MainActivity.this, SlidePageActiviey.class);
                MainActivity.this.startActivity(minIntent);
                MainActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
