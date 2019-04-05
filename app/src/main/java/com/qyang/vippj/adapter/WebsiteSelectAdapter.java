package com.qyang.vippj.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qyang.vippj.WebsiteConfigBean;
import com.qyang.vippj.myapplication.R;

/**
 * 当前类注释：
 * Created by Qyang on 2019/4/5
 */

public class WebsiteSelectAdapter extends BaseQuickAdapter<WebsiteConfigBean, BaseViewHolder> {

    public WebsiteSelectAdapter() {
        super(R.layout.item_website_select);
    }

    @Override
    protected void convert(BaseViewHolder helper, WebsiteConfigBean item) {
        helper.setText(R.id.website_name, item.getWebsiteName());
        helper.setImageResource(R.id.website_img, item.getWebsiteIcon());
    }
}
