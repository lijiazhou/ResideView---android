package com.sarnasea.reside.lib;

import com.sarnasea.reside.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @create date 2015/7/16
 * @author YL
 * @class description 菜单项视图
 */
public class ResideMenuItem extends LinearLayout {

	/** menu item icon */
	private ImageView menuIcon;

	/** menu item title */
	private TextView menutitleTv;

	public ResideMenuItem(Context context) {
		super(context);
		initViews(context);
	}

	public ResideMenuItem(Context context, int icon, int title) {
		super(context);
		initViews(context);
		menuIcon.setImageResource(icon);
		menutitleTv.setText(title);
	}

	public ResideMenuItem(Context context, int icon, String title) {
		super(context);
		initViews(context);
		menuIcon.setImageResource(icon);
		menutitleTv.setText(title);
	}

	/**
	 * 初始化Item视图组件
	 * @param context 上下文
	 */
	private void initViews(Context context) {
		
		LayoutInflater.from(context).inflate(R.layout.residemenu_item, this);
		menuIcon = (ImageView) findViewById(R.id.iv_icon);
		menutitleTv = (TextView) findViewById(R.id.tv_title);
	}

	/**
	 * 设置菜单图标
	 * @param icon 图片资源ID
	 */
	public void setIcon(int icon) {
		menuIcon.setImageResource(icon);
	}

	
	/**
	 * 设置菜单名称
	 * @param title 菜单名称字符串资源ID
	 */
	public void setTitle(int title) {
		menutitleTv.setText(title);
	}

	/**
	 * 设置菜单名称
	 * @param title 菜单名称字符串
	 */
	public void setTitle(String title) {
		menutitleTv.setText(title);
	}
}
