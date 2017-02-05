package com.speechtotext;

import com.facebook.react.bridge.*;
import com.facebook.react.*;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import com.facebook.react.uimanager.ViewManager;

public class SpeechToTextPackage implements ReactPackage {

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {

        List<NativeModule> modules = new ArrayList<>();

        modules.add(new SpeechToTextModule(reactContext));

        return modules;
    }

}
