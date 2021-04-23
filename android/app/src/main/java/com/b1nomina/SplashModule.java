package com.b1nomina;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class SplashModule extends ReactContextBaseJavaModule {
  public SplashModule(ReactApplicationContext context) {
    super(context);
  }

  @NonNull
  @Override
  public String getName() {
    return "SplashScreen";
  }

  @ReactMethod
  public void hide() {
    SplashManager.hide();
  }
}
