# Android SDK 0.8.5 BETA

Currently in private beta. If you'd like an invite, please email us at brian.donohue@intercom.mail.intercom.io.

## Supported versions
Supports Android 2.3 (API 9) for data only calls and 4.0.3 (API 15) and above for the messaging functionality



## Basic set up

### aar
- Add the intercomsdk-0.8.5.aar to the libs directory of your project
- In the apps build.gradle add the following:

```Java
repositories {
    flatDir {
        dirs 'libs'
    }
}
dependencies {
    compile(name:'intercomsdk-0.8.5', ext:'aar')
}
```

### remote dependancy

- For 0.8.3 we have remote dependancies for this version. Please add the following to your build.gradle also.

```
compile 'com.google.code.gson:gson:2.3'
compile 'com.google.android.gms:play-services:6.5.87'
compile 'com.android.support:appcompat-v7:21.0.3'
```

also the compileSdkVersion needs to be 21.

## Initialize Intercom 

In your application class initialise Intercom with the application context

```Java
Intercom.initialize(getApplicationContext());
```

If you do not have an application class in your project here is a basic example

```
public class HostApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Intercom.initialize(getApplicationContext());

    }
```


## Begin Session
- Get the Intercom App Id and the SDK API key from `https://app.intercom.io/apps/<your_app_id>/sdk_apps`
- Initialize Intercom by calling `setApiKey(<your_api_key> ,<your_app_id>);` 
- Start a session by calling `beginSessionWithEmail(<your_email_here>, null);`, `beginSessionWithUserId(<your_userid_here>, null);` or `beginSessionForAnonymousUser(null);`
- Optionally you may also begin a session with an eventlister to inform you if and when a session is ready. The eventlistener may be used to kick off any user updates or event tracking that you require to do immediately after a session has started.
```Java
        Intercom.beginSessionWithEmail(<your_email_here>, new Intercom.IntercomEventListener() {
            @Override
            public void onComplete(String error) {
                // lets check if we get an error string
                if(error != null) {
                    // handle error here
                } else {
                    // do success logic here
                    // You can also do an user updates / event tracking from here as you are sure that the session has started at this point
                }
            }
        });
```

After calling beginSession you will see an initial 401 response as it will not have valid tokens at that point. This is expected behaviour. 

- End a session when your user successfully logs out of your application by adding
    `Intercom.endSession()`

## Developer's Advanced Guide

If you want to learn about the following topics:

- Session control
- Updating a user
- Working with attributes
- Company Data
- Custom Attributes
- Events
- Messaging
- Using Push notifications
- How to configure Secure Mode in the SDK

You may find our guide here

http://docs.intercom.io/Install-on-your-mobile-product/installing-the-android-sdk-developers-guide-part-1
 
 http://docs.intercom.io/Install-on-your-mobile-product/configuring-the-android-sdk-developers-guide-part-2
 
 http://docs.intercom.io/Install-on-your-mobile-product/secure-mode-developers-guide-part-3

http://docs.intercom.io/Install-on-your-mobile-product/using-google-cloud-messaging-gcm-developers-guide-part-4

## License
Copyright 2014 Intercom, Inc.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
