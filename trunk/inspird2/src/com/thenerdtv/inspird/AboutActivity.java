//Define Package
package com.thenerdtv.inspird;

//Import needed widgets
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
//Begin Activity
public class AboutActivity extends Activity {
	
	//Set the view to 'about.xml'
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.about);
    	setRequestedOrientation(1); 
    	
    	//There is a button inside of 'about.xml'
    	//Define what to do on button click
    	//In our case, open a website
    	Button btn = (Button) findViewById(R.id.VisitSite); 
        btn.setOnClickListener(new OnClickListener() { 
          public void onClick(View v) { 
               Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW); 
               myWebLink.setData(Uri.parse("http://android.thenerdtv.com")); 
               startActivity(myWebLink); 
            } 
          }); 
	}
}