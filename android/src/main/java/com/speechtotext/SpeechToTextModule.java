package com.speechtotext;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import android.speech.RecognizerIntent;
import android.content.ActivityNotFoundException;
import android.app.Activity;

import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.*;
import com.facebook.react.module.annotations.ReactModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;

public class SpeechToTextModule extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";
    private final int SPEECH_REQUEST_CODE = 123;
    private Promise mPickerPromise;

    public SpeechToTextModule(ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addActivityEventListener(mActivityEventListener);
    }

    @Override
    public String getName() {
        return "SpeechToText";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {

            switch (requestCode) {
                case SPEECH_REQUEST_CODE: {
                    if (resultCode == Activity.RESULT_OK && null != data) {

                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        mPickerPromise.resolve(result.get(0));
                    }
                    break;
                }

            }
        }
    };

    @ReactMethod
    public void showGoogleInputDialog(final Promise promise) {
        Activity currentActivity = getCurrentActivity();

        if (currentActivity == null) {
            mPickerPromise.reject("Your device is not supported!");
            mPickerPromise = null;
            return;
        }

        mPickerPromise = promise;

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        try {
            this.getReactApplicationContext().addActivityEventListener(mActivityEventListener);
            currentActivity.startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } catch (Exception e) {
            mPickerPromise.reject("Your device is not supported!");
            mPickerPromise = null;
        }
    }

}