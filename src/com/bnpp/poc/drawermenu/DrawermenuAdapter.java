package com.bnpp.poc.drawermenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bnpp.poc.application.BaseApplication;
import com.bnpp.poc.drawermenu.models.DrawerMenuModel;
import com.bnpp.poc.drawermenu.models.Drawerheader;
import com.example.bnpppoc.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DrawermenuAdapter extends BaseExpandableListAdapter {

	public List<Drawerheader> listHeader;
	
	public DrawermenuAdapter() throws IOException{
		retriveConfigInfo();
//		this.listHeader = new ArrayList<Drawerheader>();
//		ArrayList<String> childData = new ArrayList<String>();
//		childData.add("Twitter HashTag Transfer");
//		childData.add("Facebook");
//		listchildData = new HashMap<String, List<String>>();
//		listchildData.put(listHeader.get(0), childData);
	}
	
	private void retriveConfigInfo() throws IOException {
		AssetManager assetManager = BaseApplication.getContext().getAssets();
		InputStream in = assetManager.open("config.json");
		InputStreamReader inReader = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(inReader);
		Gson gson = new GsonBuilder().create();
		DrawerMenuModel model = gson.fromJson(reader, DrawerMenuModel.class);
		this.listHeader = model.getDrawerheader();
		
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		Drawerheader header = listHeader.get(groupPosition);
		return header.getDrawerchild().get(childPosition).getChildtitle();
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		 final String childText = (String) getChild(groupPosition, childPosition);
		 
	        if (convertView == null) {
	            LayoutInflater infalInflater = (LayoutInflater) BaseApplication.getContext()
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = infalInflater.inflate(R.layout.drawermenu_child_item, null);
	        }
	 
	        TextView txtListChild = (TextView) convertView
	                .findViewById(R.id.drawermenu_childitem_title);
	 
	        txtListChild.setText(childText);
	        return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		Log.d("DRAWER", "listchildData.get(groupPosition) >>>"+ listHeader.get(groupPosition));
		return listHeader.get(groupPosition).getDrawerchild().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return listHeader.get(groupPosition).getHeadertitle();
	}

	@Override
	public int getGroupCount() {
		return listHeader.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) BaseApplication.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.drawermenu_groupheader_item, null);
        }
 
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.drawermenu_groupitem_title);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
 
        return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
