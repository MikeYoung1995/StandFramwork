package yangyu.standframework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import yangyu.standframework.activity.IndexActivity;
import yangyu.standframework.adapter.MyPagerAdapter;

/**
 * Created by 杨宇 on 2018/3/12.
 */

public class SlidePageActiviey extends Activity implements ViewPager.OnPageChangeListener {


    Button Enter_App;
    public final  int SPLASH_DISPLAY_LENGTH=1000;
    public ArrayList<ImageButton> dots;
    public ImageButton btn1,btn2,btn3;
    public ViewPager mViewPager;
    public MyPagerAdapter adapter;
    public View view1, view2, view3;
    public int oldPosition = 0;// 记录上一次点的位置
    public int currentItem; // 当前页面
    public ArrayList<View> viewList = new ArrayList<View>();// 把需要滑动的页卡添加到这个list中
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.slidepage_layout);
        initView();

    }

    private void initView() {


        mViewPager=findViewById(R.id.viewpagerslidepager);
        dots = new ArrayList<ImageButton>();
        btn1=findViewById(R.id.dot1);
        btn2=findViewById(R.id.dot2);
        btn3=findViewById(R.id.dot3);

        dots.add(btn1);
        dots.add(btn2);
        dots.add(btn3);

        LayoutInflater lf = LayoutInflater.from(SlidePageActiviey.this);
        view1 = lf.inflate(R.layout.startpage_layout1, null);
        view2 = lf.inflate(R.layout.startpage_layout2, null);
        view3 = lf.inflate(R.layout.go_activity, null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        adapter =new MyPagerAdapter(viewList,dots);
        mViewPager.setAdapter(adapter);

        dots.get(0).setBackgroundResource(R.drawable.dot_selected);
        mViewPager.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
        dots.get(position).setBackgroundResource(R.drawable.dot_selected);

        oldPosition = position;
        currentItem = position;

        if(mViewPager.getCurrentItem()==2)
        {
            Enter_App =findViewById(R.id.Enter_APP);

            Enter_App.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i =new Intent(SlidePageActiviey.this,IndexActivity.class);
                            startActivity(i);
                            SlidePageActiviey.this.finish();;
                        }
                    },SPLASH_DISPLAY_LENGTH);

                }
            });

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
