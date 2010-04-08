/** Define our package */
package com.thenerdtv.inspird;

/** Import required packages */
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();

        LayoutInflater.from(this).inflate(R.layout.main, tabHost.getTabContentView(), true);

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("Quotes")
                .setContent(R.id.quotes));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("Bible Verses")
                .setContent(R.id.bible));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("About")
                .setContent(R.id.about));
    }
}
