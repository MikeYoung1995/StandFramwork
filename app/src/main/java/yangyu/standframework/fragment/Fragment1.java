package yangyu.standframework.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import yangyu.standframework.R;
import yangyu.standframework.activity.HActivity;
import yangyu.standframework.activity.HBActivity;
import yangyu.standframework.adapter.MyPagerAdapter;


/**
 * Created by 杨宇 on 2018/3/9.
 */

public class Fragment1 extends Fragment implements ViewPager.OnPageChangeListener {


    ArrayList<String> imgtitlelist =new ArrayList<String>();
    int[] imgres =new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03};
    public TextView imgtitle;
    public ImageView headimg_1,headimg_2,headimg_3;
    public ArrayList<ImageButton> dots;
    public ArrayList<TextView> textviews;
    public ImageButton btn1,btn2,btn3;
    public ViewPager mViewPager;
    public MyPagerAdapter adapter;
    public View view1, view2, view3;
    public int oldPosition = 0;// 记录上一次点的位置
    public int currentItem; // 当前页面
    public ArrayList<View> viewList = new ArrayList<View>();// 把需要滑动的页卡添加到这个list中

    View view01;
    ImageButton btn11;


    public ListView listview;
    public SimpleAdapter simpleAdapter;
    public String[] Name_Landscape  = { "天山", "天池", "赛里木湖", "长白山", "长白山", "长白山", "长白山", "长白山" };
    public String[] Introuduction_Landspace = { "最漂亮的", "最漂亮的1", "最漂亮的2", "最漂亮的3", "最漂亮的3", "最漂亮的3", "最漂亮的3", "最漂亮的3" };
    int[] img_Landspace={R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_4,R.drawable.img_4,R.drawable.img_4,R.drawable.img_4};
    ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view01=inflater.inflate(R.layout.fragment_layout1,container,false);
        initView();
        initeEvent();
        return view01;

    }


    private void initView() {


        listview = view01.findViewById(R.id.listview_fragment1);

        for(int i = 0; i < Name_Landscape.length; i++){
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("Landspace_Name", Name_Landscape[i]);
            item.put("Landspace_Intruduction", Introuduction_Landspace[i]);
            item.put("img_show",img_Landspace[i]);
            mData.add(item);
        }

        simpleAdapter = new SimpleAdapter(getActivity(), mData, R.layout.listviewfrg1_item_layout,
                  new String[]{"img_show", "Landspace_Name", "Landspace_Intruduction"},
                  new int[]{R.id.img_show,R.id.Landspace_Name,R.id.Landspace_Intruduction});      //配置适配器，并获取对应Item中的ID
        listview.setAdapter(simpleAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                    Intent intent =new Intent(getActivity(),HActivity.class);
                    startActivity(intent);
                    break;

                    case 1:
                        Intent intent1 =new Intent(getActivity(), HBActivity.class);
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 =new Intent(getActivity(),HBActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });



        btn11=view01.findViewById(R.id.btn_allboard_travel);
        mViewPager=view01.findViewById(R.id.viewpager1);

        dots = new ArrayList<ImageButton>();
        btn1=view01.findViewById(R.id.dot1);
        btn2=view01.findViewById(R.id.dot2);
        btn3=view01.findViewById(R.id.dot3);

        dots.add(btn1);
        dots.add(btn2);
        dots.add(btn3);


        /**
         * 这里绝对原创 机智嘿嘿！！可以用网络实现动态加载字符串 不用写死
         */

        String[] imgtitlecontent= new String[]{"这里这美丽啊","这里真漂亮啊","这里真好看啊"};
        for (int i=0;i<imgtitlecontent.length;i++)
        {
            imgtitlelist.add(imgtitlecontent[i]);
        }

        imgtitle =view01.findViewById(R.id.imgtitle);



        // 得到viewPager的布局
        LayoutInflater lf = LayoutInflater.from(getActivity());
        view1 = lf.inflate(R.layout.head_img_layout1, null);
        view2 = lf.inflate(R.layout.head_img_layout2, null);
        view3 = lf.inflate(R.layout.head_img_layout3, null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        mViewPager = (ViewPager)view01.findViewById(R.id.viewpager1);
        adapter =new MyPagerAdapter(viewList,dots);
        mViewPager.setAdapter(adapter);

        dots.get(0).setBackgroundResource(R.drawable.dot_selected);
        imgtitle.setText(imgtitlelist.get(0));
//        imageView.setBackgroundResource(imgres[0]);

        mViewPager.addOnPageChangeListener(this);

    }


    private void initeEvent() {

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getActivity(),HActivity.class);
                startActivity(i);
            }
        });

    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
        dots.get(position).setBackgroundResource(R.drawable.dot_selected);

        imgtitle.setText(imgtitlelist.get(oldPosition));
        imgtitle.setText(imgtitlelist.get(position));

        switch (position)
        {
            case 0:
                /**
                 * viewpager里面写控件监听事件需要写在addPagerChangedListener
                 */
                headimg_1 =view01.findViewById(R.id.headimg_1);
                headimg_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity(),HBActivity.class);
                        startActivity(intent);

                    }
                });
                break;

                default:
                    break;
        }

        /**
         * 以这种方式加载图片会造成滑动卡顿
         */
//        imageView.setBackgroundResource(imgres[oldPosition]);
//        imageView.setBackgroundResource(imgres[position]);


        oldPosition = position;
        currentItem = position;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}





