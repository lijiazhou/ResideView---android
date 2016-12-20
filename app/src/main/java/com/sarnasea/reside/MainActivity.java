package com.sarnasea.reside;

import java.util.ArrayList;
import java.util.List;

import com.sarnasea.reside.fragment.CalendarFragment;
import com.sarnasea.reside.fragment.HomeFragment;
import com.sarnasea.reside.fragment.ProfileFragment;
import com.sarnasea.reside.fragment.SettingsFragment;
import com.sarnasea.reside.lib.ResideMenu;
import com.sarnasea.reside.lib.ResideMenuItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * @create date 2015/7/16
 * @author YL
 * @class description 主页面
 */
public class MainActivity extends FragmentActivity implements OnClickListener {

	/**侧滑菜单*/
	private ResideMenu resideMenu;
	
	/**菜单项*/
	private ResideMenuItem itemHome,itemProfile,itemCalendar,itemSet;

	/**左侧打开按钮*/
	private Button leftMenuBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		initMenu();
		initView();
		if (savedInstanceState == null){
			switchFragment(new HomeFragment());
		}
	}
	
	
	/**
	 * 初始化菜单
	 */
	private void initMenu(){
		
		resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setScaleValue(0.6f);
        //显示阴影
        resideMenu.setShadowVisible(true);
        
        List<ResideMenuItem> menuItems = new ArrayList<ResideMenuItem>();
        itemHome = new ResideMenuItem(this, R.drawable.icon_home,"Home");
        itemHome.setOnClickListener(this);
        menuItems.add(itemHome);
        
        itemProfile = new ResideMenuItem(this, R.drawable.icon_profile, "Profile");
        itemProfile.setOnClickListener(this);
        menuItems.add(itemProfile);
        
        itemCalendar = new ResideMenuItem(this, R.drawable.icon_calendar,R.string.calendar);
        itemCalendar.setOnClickListener(this);
        menuItems.add(itemCalendar);
        
        itemSet = new ResideMenuItem(this, R.drawable.icon_settings, R.string.set);
        itemSet.setOnClickListener(this);
        menuItems.add(itemSet);
        
        //设置左侧菜单
        resideMenu.setMenuItems(menuItems, ResideMenu.DIRECTION_LEFT);
        //禁用右侧菜单
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
	}
	
	
	/**
	 * 初始化视图组件
	 */
	private void initView(){
		
		leftMenuBtn = (Button) findViewById(R.id.left_menu_btn);
		leftMenuBtn.setOnClickListener(this);
		
		Button rightMenuBtn = (Button) findViewById(R.id.right_menu_btn);
		rightMenuBtn.setVisibility(View.GONE);
	}
	
	
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }


	@Override
	public void onClick(View v) {
		
		if(v == itemHome){
			switchFragment(new HomeFragment());
		}else if(v == itemProfile){
			switchFragment(new ProfileFragment());
		}else if(v == itemCalendar){
			switchFragment(new CalendarFragment());
		}else if(v == itemSet){
			switchFragment(new SettingsFragment());
		}else{
			resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
			return;
		}
		resideMenu.closeMenu();
	}


	/**
	 * 切换页面片段
	 * @param targetFragment 目标片段
	 */
	private void switchFragment(Fragment targetFragment){
		
		resideMenu.clearIgnoredViewList();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment,targetFragment)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
	}
	
	
	/**
	 * 获取页面菜单对象
	 * @return {@link ResideMenu}
	 */
	public ResideMenu getResideMenu() {
		return resideMenu;
	}
}
