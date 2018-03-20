package yangyu.standframework.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by 杨宇 on 2018/3/12.
 */

public class MyPagerAdapter extends PagerAdapter {

    ArrayList<View> viewlist;
    ArrayList<ImageButton> dots;

    public MyPagerAdapter(ArrayList<View> viewlist, ArrayList<ImageButton> dots) {
        this.viewlist = viewlist;
        this.dots = dots;
    }


    @Override
    public int getCount() {
        return viewlist.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(viewlist.get(position));

        return viewlist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(viewlist.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
