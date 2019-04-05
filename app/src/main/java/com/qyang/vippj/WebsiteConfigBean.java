package com.qyang.vippj;

/**
 * 当前类注释：
 * Created by Qyang on 2019/4/5
 */

public class WebsiteConfigBean {

    private String websiteName;
    private int websiteIcon;
    private String websiteUrl;

    public WebsiteConfigBean(String websiteName, int websiteIcon, String websiteUrl) {
        this.websiteName = websiteName;
        this.websiteIcon = websiteIcon;
        this.websiteUrl = websiteUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public int getWebsiteIcon() {
        return websiteIcon;
    }

    public void setWebsiteIcon(int websiteIcon) {
        this.websiteIcon = websiteIcon;
    }
}
