package com.example.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button setBtn, cancelBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		setBtn = (Button)findViewById(R.id.set);  
        cancelBtn = (Button)findViewById(R.id.cancel);  
          
        final AlarmManager am = (AlarmManager)this.getSystemService(ALARM_SERVICE);  
          
        Intent intent = new Intent();  
        intent.setAction("com.example.alarmmanager");  
        intent.putExtra("msg", "闹钟事件发生了");  
        final PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);  
        final long time = System.currentTimeMillis();  
          
        setBtn.setOnClickListener(new View.OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                am.setRepeating(AlarmManager.RTC_WAKEUP, time, 3*1000, pi);  
            }  
        });  
          
        cancelBtn.setOnClickListener(new View.OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                am.cancel(pi);  
            }  
        });  
		
		
		
		
		
		
		
	}
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
