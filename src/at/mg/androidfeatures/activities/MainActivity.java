package at.mg.androidfeatures.activities;

import android.app.Activity;
import android.os.Bundle;
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
    


    
}
