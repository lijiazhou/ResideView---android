package com.sarnasea.reside.fragment;

import com.sarnasea.reside.MainActivity;
import com.sarnasea.reside.R;
import com.sarnasea.reside.lib.ResideMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
/**
 * @create date 2015/7/16
 * @author YL
 * @class description 主页片段
 */
public class HomeFragment extends Fragment {

	/**侧滑菜单*/
    private ResideMenu resideMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
    	View v = inflater.inflate(R.layout.home, container, false);
        initView(v);
        return v;
    }

    
    /**
     * 初始化组件
     * @param v
     */
    private void initView(View v) {
    	
        MainActivity parentActivity = (MainActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();

        Button openBtn = (Button) v.findViewById(R.id.open_btn);
        openBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
			}
		});
        //添加为取消触摸响应的布局
        FrameLayout ignored_view = (FrameLayout)v.findViewById(R.id.ignored_view);
        resideMenu.addIgnoredView(ignored_view);
    }
}
