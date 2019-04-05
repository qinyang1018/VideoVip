package com.qyang.vippj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qyang.vippj.adapter.WebsiteSelectAdapter;
import com.qyang.vippj.myapplication.R;
import com.qyang.vippj.utils.SpaceItemDecoration;
import com.qyang.vippj.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释：
 * Created by Qyang on 2019/4/5
 */

public class WebsiteSelectActivity extends AppCompatActivity {

    private Toolbar mTitleToolBar;
    private TextView mTvGunTitle;
    private RecyclerView mRecycle;
    private WebsiteSelectAdapter mAdapter;
    private List<WebsiteConfigBean> mConfigList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_select);
        initData();
        initView();
        initTitle();
    }

    private void initTitle() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary), 0);
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(mTitleToolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mTvGunTitle.setText("视频网站");
    }


    private void initView() {
        mTitleToolBar = findViewById(R.id.title_tool_bar);
        mTvGunTitle = findViewById(R.id.tv_gun_title);
        mRecycle = findViewById(R.id.recycle);

        mRecycle.setLayoutManager(new GridLayoutManager(this, 3));
        mRecycle.addItemDecoration(new SpaceItemDecoration(10));
        mAdapter = new WebsiteSelectAdapter();
        mRecycle.setAdapter(mAdapter);
        mAdapter.setNewData(mConfigList);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebsiteConfigBean configBean = (WebsiteConfigBean) adapter.getItem(position);
                Intent intent = new Intent(WebsiteSelectActivity.this, WebViewActivity.class);
                intent.putExtra("websiteUrl", configBean.getWebsiteUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionbar_update:
                loadUrl("https://fir.im/7gz9?release_id=5ca6d665959d69487203b230", "更新");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadUrl(String mUrl, String mTitle) {
        WebViewActivity.loadUrl(this, mUrl, mTitle);
    }

    private void initData() {
        mConfigList = new ArrayList<>();
        mConfigList.add(new WebsiteConfigBean("爱奇艺", R.drawable.aiqiyi, "https://www.iqiyi.com"));
        mConfigList.add(new WebsiteConfigBean("腾讯视频", R.drawable.tengxun, "https://v.qq.com"));
        mConfigList.add(new WebsiteConfigBean("优酷视频", R.drawable.youku, "https://www.youku.com"));
        mConfigList.add(new WebsiteConfigBean("乐视视频", R.drawable.leshi, "http://www.le.com/"));
        mConfigList.add(new WebsiteConfigBean("芒果TV", R.drawable.mangguo, "https://www.mgtv.com/"));
    }
}
