package yangyu.standframework.activity;





import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import yangyu.standframework.R;
import yangyu.standframework.fragment.*;
/**
 * Created by 杨宇 on 2018/3/9.
 */

public class IndexActivity extends FragmentActivity implements View.OnClickListener {

    public ImageButton btn1_route,btn2_map,btn3_message,btn4_profile;
    public TextView txt_route,txt_map,txt_message,txt_profile;
    Fragment fragment1,fragment2,fragment3,fragment4;

    FragmentManager FM;
    FragmentTransaction FRT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_activity);
        initView();

        FM=getSupportFragmentManager();
        FRT = FM.beginTransaction();
        fragment1 = new Fragment1();
        FRT.add(R.id.framelayout,fragment1);
        txt_route.setTextColor(getResources().getColor(R.color.colorAccent));
        FRT.commit();
    }

    private void setStatbartranslucent() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    private void initView() {
        setStatbartranslucent();
        btn1_route=findViewById(R.id.btn_index_route);
        btn2_map=findViewById(R.id.btn_index_map);
        btn3_message=findViewById(R.id.btn_btn_index_message);
        btn4_profile=findViewById(R.id.btn_index_profile);

        txt_route=findViewById(R.id.txt_index_route);
        txt_map=findViewById(R.id.txt_index_map);
        txt_message=findViewById(R.id.txt_index_message);
        txt_profile=findViewById(R.id.txt_index_profile);

        btn1_route.setOnClickListener(this);
        btn2_map.setOnClickListener(this);
        btn3_message.setOnClickListener(this);
        btn4_profile.setOnClickListener(this);

        txt_route.setOnClickListener(this);
        txt_map.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_profile.setOnClickListener(this);




        fragment2= new Fragment2();
        fragment3= new Fragment3();
        fragment4= new Fragment4();



    }

    @Override
    public void onClick(View view) {

        FM =getSupportFragmentManager();
        FRT = FM.beginTransaction();
        resetbtn();
        switch (view.getId())
        {
            case R.id.btn_index_route:
                if(fragment2!=null)
                {FRT.hide(fragment2);}
                if(fragment3!=null)
                {FRT.hide(fragment3);}
                if(fragment4!=null)
                {FRT.hide(fragment4);}
                if(fragment1.isAdded())
                {
                    FRT.show(fragment1);
                }
                else
                {
                    FRT.add(R.id.framelayout,fragment1).show(fragment1);
                }
                txt_route.setTextColor(getResources().getColor(R.color.colorAccent));
                break;

            case R.id.btn_index_map:

                if(fragment1!=null)
                {FRT.hide(fragment1);}
                if(fragment3!=null)
                {FRT.hide(fragment3);}
                if(fragment4!=null)
                {FRT.hide(fragment4);}

                    if(fragment2.isAdded()){

                        FRT.show(fragment2);
                    }
                    else
                    {
                        FRT.add(R.id.framelayout,fragment2).show(fragment2);
                    }

                txt_map.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case R.id.btn_btn_index_message:
                if(fragment1!=null)
                {FRT.hide(fragment1);}
                if(fragment2!=null)
                {FRT.hide(fragment2);}
                if(fragment4!=null)
                {FRT.hide(fragment4);}

                if(fragment3.isAdded()){

                    FRT.show(fragment3);
                }

                else
                {
                    FRT.add(R.id.framelayout,fragment3).show(fragment3);
                }


                txt_message.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case R.id.btn_index_profile:
                if(fragment1!=null)
                {FRT.hide(fragment1);}
                if(fragment2!=null)
                {FRT.hide(fragment2);}
                if(fragment3!=null)
                {FRT.hide(fragment3);}

                if(fragment4.isAdded()){

                    FRT.show(fragment4);
                }
                else
                {
                    FRT.add(R.id.framelayout,fragment4).show(fragment4);
                }
                txt_profile.setTextColor(getResources().getColor(R.color.colorAccent));
                break;

//            case R.id.txt_index_route:
//
//                if(fragment1.isAdded())
//                {
//                    FRT.hide(fragment2);
//                    FRT.hide(fragment3);
//                    FRT.hide(fragment4);
//                    FRT.show(fragment1);
//                }
//                else
//                {
//                    FRT.add(R.id.framelayout,fragment1);
//                }
//                txt_route.setTextColor(getResources().getColor(R.color.colorAccent));
//
//                break;
//            case R.id.txt_index_map:
//
//                if(fragment2.isAdded()){
//                    FRT.hide(fragment1);
//                    FRT.hide(fragment3);
//                    FRT.hide(fragment4);
//                    FRT.show(fragment2);
//                }
//                else
//                {
//                    FRT.add(R.id.framelayout,fragment2);
//                }
//                txt_map.setTextColor(getResources().getColor(R.color.colorAccent));
//                break;
//            case R.id.txt_index_message:
//
//                if(fragment3.isAdded()){
//                    FRT.hide(fragment1);
//                    FRT.hide(fragment2);
//                    FRT.hide(fragment4);
//                    FRT.show(fragment3);
//                }
//                else
//                {
//                    FRT.add(R.id.framelayout,fragment3);
//                }
//                txt_message.setTextColor(getResources().getColor(R.color.colorAccent));
//                break;
//            case R.id.txt_index_profile:
//
//                if(fragment4.isAdded()){
//                    FRT.hide(fragment1);
//                    FRT.hide(fragment2);
//                    FRT.hide(fragment3);
//                    FRT.show(fragment4);
//                }
//                else
//                {
//                    FRT.add(R.id.framelayout,fragment4);
//                }
//                txt_profile.setTextColor(getResources().getColor(R.color.colorAccent));
//                break;
            default:
                    break;
        }

        FRT.commit();

    }

    private void resetbtn() {

        txt_route.setTextColor(getResources().getColor(R.color.textview_color));
        txt_map.setTextColor(getResources().getColor(R.color.textview_color));
        txt_message.setTextColor(getResources().getColor(R.color.textview_color));
        txt_profile.setTextColor(getResources().getColor(R.color.textview_color));



    }
}


