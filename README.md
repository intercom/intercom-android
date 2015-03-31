# Android SDK 0.9.3 BETA

Our Android SDK is currently in private beta. We are confident of its stability, however please be aware there is still some risk. This also means we may have frequent, small updates. We’ll attempt to keep these updates as easy as possible, though some changes may require you to update the integration in your app.

If you would like to be included in the next round of this beta, please email us at `brian.donohue@intercom.mail.intercom.io`.

## Supported versions
Supports Android 2.3 (API 9) for data only calls and 4.0.3 (API 15) and above for the messaging functionality

## Set up

A full guide to integrating the Intercom Android SDK with your app is available here: http://docs.intercom.io/6025-Install-on-your-mobile-product/install-the-intercom-android-sdk

### remote dependancy

- These are the dependencies we use in the SDK

```
compile 'com.android.support:support-v4:22.0.0'
compile 'com.google.code.gson:gson:2.3'
compile 'com.squareup:otto:1.3.6'
compile 'com.squareup.okhttp:okhttp:2.3.0'
compile 'com.squareup.retrofit:retrofit:1.9.0'
compile 'com.squareup.picasso:picasso:2.5.2'
compile 'com.google.android.gms:play-services-gcm:7.0.0’
```

also the compileSdkVersion needs to be 21.

## Initialize Intercom 

In the `oncreate()` method of your application class initialise Intercom with the application context, your api key and your app id

```Java
Intercom.initialize(getApplicationContext(), "your api key", "your app id");
```

If you do not have an application class in your project here is a basic example

```
public class HostApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Intercom.initialize(getApplicationContext(), "your api key", "your app id");

    }
```

## Developer's Advanced Guide

If you want to learn about the following topics:

- Updating a user
- Working with attributes
- Company Data
- Custom Attributes
- Events
- Messaging
- Using Push notifications
- How to configure Secure Mode in the SDK

You may find our guide here

http://docs.intercom.io/6025-Install-on-your-mobile-product/install-the-intercom-android-sdk

http://docs.intercom.io/6025-Install-on-your-mobile-product/using-the-android-sdk

http://docs.intercom.io/6025-Install-on-your-mobile-product/enabling-secure-mode-on-the-android-sdk

http://docs.intercom.io/6025-Install-on-your-mobile-product/using-google-cloud-messaging-gcm-with-the-android-sdk

## License
Copyright 2014 Intercom, Inc.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
