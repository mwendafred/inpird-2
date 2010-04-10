//Import package
package com.thenerdtv.inspird;
 
//Define needed widgets
import android.app.AlertDialog;
import android.app.TabActivity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
 
	//Begin Activity
	public class MainActivity extends TabActivity {
 
    //Set string for GeneralPref
	private static final String PREFS_NAME = "GeneralPref";
        
	//Begin our view
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(1); 
       
        //Inits the Shared Preferences objects
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
       
        //This is a welcome dialog the first time you run the app
        //Pull up settings string, if it's null then show welcome dialog
        if(settings.getString("firstRun", null) == null){
        Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome!");  
        builder.setMessage("Welcome to Inspird v2.0! We have now added Bible quotes and hundreds of new regular quotes! Enjoy!");
        builder.setPositiveButton("Continue", null);
        builder.show();
 
        // This portion actually SAVES the value into preferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("firstRun", "false");
        editor.commit();
        }
       
        //Begins TabHost
        TabHost tabHost = getTabHost();
 
        LayoutInflater.from(this).inflate(R.layout.main, tabHost.getTabContentView(), true);
 
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("Quotes")
                .setContent(R.id.quotes));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("Bible Verses")
                .setContent(R.id.bible));
        
        //Notice this tab starts a new activity, called AboutActivity
        tabHost.addTab (tabHost.newTabSpec("tab3")
                .setIndicator("About")
                .setContent(new Intent(this,AboutActivity.class )));
    }
}