package at.mg.androidfeatures.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import at.mg.androidfeatures.R;
import at.mg.androidfeatures.R.layout;
import at.mg.androidfeatures.activities.parents.AF_Activity;
import at.mg.androidfeatures.util.Log;

public class MainActivity extends AF_Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        
        setContentView(R.layout.activity_main);
    }
    
    private void formatString(){
    	//this string can not be formated
    	String rString = getString(R.string.stop_message);
    	Log.i(rString);
    	
    	//a formatable string
    	String fString = getString(R.string.stop_message_format);
    	String formatString = String.format(fString, " text too much");
    	CharSequence styledString = Html.fromHtml(formatString);
    	Log.i(styledString);
    	
    	//plurals
    	String unicorns = getResources().getQuantityString(R.plurals.unicornCount, 1,1);
    	Log.i(unicorns);
    	unicorns = getResources().getQuantityString(R.plurals.unicornCount, 2,2);
    	Log.i(unicorns);
    	unicorns = getResources().getQuantityString(R.plurals.unicornCount, 0, "f", "g");
    	Log.i(unicorns);
    }
    


    
}
