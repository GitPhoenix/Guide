# Guide防彩之云APP启动页和导航页，并解决了启动黑屏问题
######效果图：
![guide.gif](http://upload-images.jianshu.io/upload_images/3066970-fc3f12547e5a3d9e.gif?imageMogr2/auto-orient/strip)
一：启动页
* 2秒后进入主界面或者导航页
```
new Handler().postDelayed(new Runnable() {
	@Override
	public void run() {
		//判断是不是第一次启动此应用，第一次启动进入GuideActivity，否则直接进入MainActivity
		if (!SPUtil.getBoolean(Constant.SP_IS_FIRST_LOGIN, false)) {
			StartActivityUtil.startActivity(LaunchActivity.this, GuideActivity.class);
		}else {
			StartActivityUtil.startActivity(LaunchActivity.this, MainActivity.class);
		}
		finish();
	}
}, 2 * 1000);
```
* 启动黑屏问题
    我们常见的app启动样式有1.点击应用1-3秒后才会弹出启动界面2.有的点击后立即就弹出启动界面，还有的点击后会出现黑屏，白屏的问题。
     * 方法一：给app的启动页设置图片背景，此时点击应用会立即启动
```
<!--窗体背景，这个背景能在第一时间显示, 避免启动时白屏-->
<style name="LaunchTheme" parent="Theme.AppCompat.NoActionBar">
    <item name="android:background">@drawable/img_launch</item>
    <item name="android:windowFullscreen">true</item>
</style>
```
     * 方法二：设置背景为透明色，此时有启动延迟的感觉，其实应用早已启动了，只是背景透明的，看到的还是手机桌面罢了。
```
<!--窗体背景，这个背景能在第一时间显示, 避免启动时白屏-->
<style name="LaunchTheme" parent="Theme.AppCompat.NoActionBar">
    <item name="android:background">@android:color/transparent</item>
    <item name="android:windowFullscreen">true</item>
</style>
```

二：导航页
* 引导页
此处用四张图片来做引导页面，同时在最后一个页面提供一个按钮，点击进入主界面。
```
//把引导页加入到集合中，views是一个ArrayList
LayoutInflater inflater = LayoutInflater.from(this);
views.add(inflater.inflate(R.layout.view_guide_01, null));
views.add(inflater.inflate(R.layout.view_guide_02, null));
views.add(inflater.inflate(R.layout.view_guide_03, null));
views.add(inflater.inflate(R.layout.view_guide_04, null));
```
既然用到了ViewPager，那肯定会用到PagerAdapter并必须实现以下几个方法
     destroyItem(), getCount(), instantiateItem(), isViewFromObject()
提示一下destroyItem()，instantiateItem()两个方法在高版本上已经过时了，分别把他们的第一个参数换成ViewGroup 即可。
```
public class GuidePagerAdapter extends PagerAdapter {
    private List<View> views;
    private Activity activity;

    public GuidePagerAdapter(List<View> views, Activity activity) {
        this.views = views;
        this.activity = activity;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public int getCount() {
        return (views == null) ? 0 : views.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position), 0);
        //当滑动到最后一页的时候，监听按钮
        if (position == views.size() - 1) {
            TextView tvEnter = (TextView) container.findViewById(R.id.tv_guide_enter);

            tvEnter.setText(String.format(ResUtil.getString(R.string.guide_enter), APPUtil.getVersionName(activity)));
            tvEnter.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //在此记录曾经浏览过导航页，下次启动将不会进入导航页
                    SPUtil.put(Constant.SP_IS_FIRST_LOGIN, true);

                    StartActivityUtil.startActivity(activity, MainActivity.class);
                    activity.finish();
                }
            });
        }
        return views.get(position);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }
}
```
