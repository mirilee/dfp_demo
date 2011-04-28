package com.example.simplelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleList extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ListView lv = (ListView) findViewById(R.id.lvResult);
		int[] ad_icons = getResources().getIntArray(R.array.ad_icons); 
		String[] ad_names = getResources().getStringArray(R.array.ad_names);
		String[] ad_sizes = getResources().getStringArray(R.array.ad_sizes); 
		ListAdapter listAdapter = new ListAdapter(SimpleList.this, ad_icons, ad_names, ad_sizes);
		lv.setAdapter(listAdapter);
		
        
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {
				// TODO Auto-generated method stub
				TextView tvUrl = (TextView) view.findViewById(R.id.item1);
				Toast.makeText(getApplicationContext(), tvUrl.getText(),
				          Toast.LENGTH_SHORT).show();
				Intent i = new Intent(SimpleList.this,WebViewDemo.class);
				i.putExtra("ad_type", tvUrl.getText());
				startActivity(i);		
			}
		}); 
	}
}