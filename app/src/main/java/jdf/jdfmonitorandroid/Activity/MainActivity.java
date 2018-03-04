package jdf.jdfmonitorandroid.Activity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import jdf.jdfmonitorandroid.Fragment.HomePageFragment;
import jdf.jdfmonitorandroid.Fragment.InformationFragment;
import jdf.jdfmonitorandroid.Fragment.JobsFragment;
import jdf.jdfmonitorandroid.Fragment.StoreKeeperFragment;
import jdf.jdfmonitorandroid.Fragment.TaskFragment;
import jdf.jdfmonitorandroid.Interface.OnFragmentInteractionListener;
import jdf.jdfmonitorandroid.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener,OnFragmentInteractionListener {
    private TextView tx1, tx2, tx3,tx4,tx5;
    private LinearLayout mTab_item_container;
    LinearLayout content_container;
    private FragmentManager mFM = null;
    Fragment f1,f2,f3,f4,f5;
    private int mSelectIndex = 0;
    private View last, now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container,f1)
                    .add(R.id.content_container,f2)
                    .add(R.id.content_container,f3)
                    .add(R.id.content_container,f4)
                    .add(R.id.content_container,f5)
                    .commit();
        }
        changeHomepage();
    }
    private void init() {
        mTab_item_container = (LinearLayout) findViewById(R.id.tab_item_container);



        tx1 = (TextView)findViewById(R.id.tx_1);
        tx2 = (TextView)findViewById(R.id.tx_2);
        tx3 = (TextView)findViewById(R.id.tx_3);
        tx4 = (TextView)findViewById(R.id.tx_4);
        tx5 = (TextView)findViewById(R.id.tx_5);



        tx1.setOnClickListener(this);
        tx2.setOnClickListener(this);
        tx3.setOnClickListener(this);
        tx4.setOnClickListener(this);
        tx5.setOnClickListener(this);


        content_container = (LinearLayout) findViewById(R.id.content_container);
        f1 = HomePageFragment.newInstance("t","1");
        f2 = JobsFragment.newInstance("t","2");
        f3 = TaskFragment.newInstance("t","3");
        f4 = StoreKeeperFragment.newInstance("t","4");
        f5 = InformationFragment.newInstance("t","5");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.tx_1:{
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(0);
                startAnimation(last, now);
                mSelectIndex = 0;
                changeHomepage();
            }

                break;
            case  R.id.tx_2:{
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(1);
                startAnimation(last, now);
                mSelectIndex = 1;
                changeJobs();
            }
                break;
            case  R.id.tx_3:{
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(2);
                startAnimation(last, now);
                mSelectIndex = 2;
                changeTask();
            }

                break;
            case  R.id.tx_4:{
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(3);
                startAnimation(last, now);
                mSelectIndex = 3;
                changeStoreKeeper();
            }

            break;
            case  R.id.tx_5:{
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(4);
                startAnimation(last, now);
                mSelectIndex = 4;
                changeInformation();
            }

            break;
            default:
                break;
        }

    }
    /**
     * 切换fragement
     */
    private void changeHomepage() {
        getSupportFragmentManager().beginTransaction()
                .hide(f2)
                .hide(f3)
                .hide(f4)
                .hide(f5)
                .show(f1)
                .commit();


        this.settab();
        tx1.setTextColor(Color.parseColor("#1b9fd2"));

    }

    /**
     * 切换至工作
     */
    public void changeJobs() {

        getSupportFragmentManager().beginTransaction()
                .hide(f1)
                .hide(f3)
                .hide(f4)
                .hide(f5)
                .show(f2)
                .commit();


        this.settab();

        tx2.setTextColor(Color.parseColor("#1b9fd2"));
    }

    /**
     * 切换至任务
     */
    public void changeTask() {

        getSupportFragmentManager().beginTransaction()
                .hide(f1)
                .hide(f2)
                .hide(f4)
                .hide(f5)
                .show(f3)
                .commit();

        this.settab();

        tx3.setTextColor(Color.parseColor("#1b9fd2"));
    }
    /**
     * 切换至仓管
     */
    public void changeStoreKeeper() {

        getSupportFragmentManager().beginTransaction()
                .hide(f1)
                .hide(f2)
                .hide(f3)
                .hide(f5)
                .show(f4)
                .commit();

        this.settab();

        tx4.setTextColor(Color.parseColor("#1b9fd2"));
    }
    /**
     * 切换至资讯
     */
    public void changeInformation() {

        getSupportFragmentManager().beginTransaction()
                .hide(f1)
                .hide(f2)
                .hide(f4)
                .hide(f3)
                .show(f5)
                .commit();

        this.settab();

        tx5.setTextColor(Color.parseColor("#1b9fd2"));
    }

    private void startAnimation(View last, View now) {
        TranslateAnimation ta = new TranslateAnimation(last.getLeft(),
                now.getLeft(), 0, 0);
        ta.setDuration(300);
        ta.setFillAfter(true);

    }
    public void settab(){

        //
        tx1.setTextColor(Color.parseColor("#666666"));
        tx2.setTextColor(Color.parseColor("#666666"));
        tx3.setTextColor(Color.parseColor("#666666"));
        tx4.setTextColor(Color.parseColor("#666666"));
        tx5.setTextColor(Color.parseColor("#666666"));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
