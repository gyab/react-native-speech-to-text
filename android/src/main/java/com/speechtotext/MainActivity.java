package com.speechtotext;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ReactActivity {

    @Override
    protected String getMainComponentName() {
        return "speechtotext";
    }

    protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

}
