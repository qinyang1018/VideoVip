package com.qyang.vippj.config;

import android.view.View;

public interface IWebPageView {

    /**
     * 隐藏进度条
     */
    void hindProgressBar();

    /**
     * 显示webview
     */
    void showWebView();

    /**
     * 隐藏webview
     */
    void hindWebView();


    /**
     * 进度条变化时调用
     *
     * @param newProgress 进度0-100
     */
    void startProgress(int newProgress);

    /**
     * 添加js监听
     */
    void addImageClickListener();

    /**
     * 播放网络视频全屏调用
     */
    void fullViewAddView(View view);

    void showVideoFullView();

    void hindVideoFullView();


}
