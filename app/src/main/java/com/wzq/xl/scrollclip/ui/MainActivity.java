package com.wzq.xl.scrollclip.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wzq.xl.scrollclip.R;
import com.wzq.xl.scrollclip.adapter.clipAdapter.ClipAdapter;
import com.wzq.xl.scrollclip.widget.clipPager.ClipViewPager;
import com.wzq.xl.scrollclip.widget.clipPager.ScalePageTransformer;

import java.util.ArrayList;
import java.util.List;


/*
*
*   this is a demo loading local picture/images
*   you can modify it to load picture/images from internet
*
 */


public class MainActivity extends AppCompatActivity {
    private ClipViewPager mViewPager;//container
    private ClipAdapter mPagerAdapter;//adapter

    public final int clipMargin = 30;//page margin


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();
        initAdapter();
    }


    private void findViewByIds()//init view
    {
        mViewPager = (ClipViewPager) findViewById(R.id.viewpager);
    }


    private void initAdapter()//init adapter
    {
        mViewPager.setPageTransformer(true, new ScalePageTransformer());
        mPagerAdapter = new ClipAdapter(this);
        mViewPager.setAdapter(mPagerAdapter);
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.demo1);
        list.add(R.mipmap.demo2);
        list.add(R.mipmap.demo3);
        mViewPager.setOffscreenPageLimit(list.size());
        mViewPager.setPageMargin(clipMargin);
        mPagerAdapter.addAll(list);
        }

    }
