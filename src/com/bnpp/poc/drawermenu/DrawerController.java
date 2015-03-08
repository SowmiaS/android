package com.bnpp.poc.drawermenu;

import java.io.IOException;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

import com.bnpp.poc.basecontainer.MessagentScreenFragment;
import com.bnpp.poc.drawermenu.models.Drawerchild;
import com.example.bnpppoc.R;

public class DrawerController implements OnGroupClickListener,
		OnChildClickListener {

	private ExpandableListView mDrawerList;
	private DrawerLayout mDrawerLayout;
	private FragmentActivity activity;
	private DrawermenuAdapter adpater;

	public DrawerController(FragmentActivity activity, ExpandableListView mDrawerList,
			final DrawerLayout mDrawerLayout) {
		this.mDrawerList = mDrawerList;
		this.mDrawerLayout = mDrawerLayout;
		this.activity = activity;
		initialise();
		initialiseWidgetListeners();
	}

	
	private void initialiseWidgetListeners() {
		mDrawerList.setOnChildClickListener(this);
		mDrawerList.setOnGroupClickListener(this);
	}


	private void initialise() {
		try {
			adpater = new DrawermenuAdapter();
			mDrawerList.setAdapter(adpater);
		} catch (IOException e) {
			Log.d("BASECONTAINER", " Not able to read Drawer config .....");
		}
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		return false;
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		mDrawerLayout.closeDrawers();
		try {
			openFragmentAsPerConfig(groupPosition, childPosition);
		} catch (ClassNotFoundException e) {
			Log.d("Drawer", "The Fragment Name is not valid.. kindly check the config file..");
		} catch (InstantiationException e) {
			Log.d("Drawer", "The Fragment class couldn't be initialised");
		} catch (IllegalAccessException e) {
			Log.d("Drawer", "The Fragment class couldn't be initialised");
		}
		return false;
	}
	
	private void openFragmentAsPerConfig(int groupPosition, int childPosition) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Drawerchild child = adpater.listHeader.get(groupPosition).getDrawerchild().get(childPosition);
		if(null != child.getFragmentname() && !"".endsWith(child.getFragmentname())){
			loadFragment(child.getFragmentname());
		}
		else if (null != child.getUrl() && !"".endsWith(child.getUrl())){
			loadUrlFragment(child.getUrl());
		}
		
	}


	public void loadFragment(String fragmentName) throws ClassNotFoundException,  InstantiationException, IllegalAccessException{
		Class<?> clazz = Class.forName(fragmentName);
		startFragment((Fragment) clazz.newInstance());
	}
	
	public void loadUrlFragment(String urlName) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> clazz = Class.forName("com.bnpp.poc.basecontainer.MessagentScreenFragment");
		Fragment fragment = (Fragment) clazz.newInstance();
		Bundle bundle = new Bundle();
		bundle.putString(MessagentScreenFragment.MESSAGANT_URL, urlName);
		fragment.setArguments(bundle);
		startFragment(fragment);
	}
	
	
	public void startFragment(Fragment fragment){
		FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
	    transaction.replace(R.id.contentroot, fragment);
	    transaction.commit();
	}
	
	
	

}
