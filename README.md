![Intercom](samples/Intercom_logo-github.png)

Intercom for Android supports API 15 and above.
## Installation
There are 3 options for installing Intercom on your Android app.
### Option 1: Install Intercom with Google Cloud Messaging (GCM) 

Add the following dependency to your app's `build.gradle` file:
```groovy
dependencies {
    compile 'io.intercom.android:intercom-sdk:3.+'
}
```

### Option 2: Install Intercom with Firebase Cloud Messaging (FCM) 
Add the following dependency to your app's `build.gradle` file:
```groovy
dependencies {
    compile 'io.intercom.android:intercom-sdk-base:3.+'
    compile 'io.intercom.android:intercom-sdk-fcm:3.+'
}
```

### Option 3: Install Intercom without Push Messaging  

If you'd rather not have push notifications in your app, you can use this dependency: 
```groovy
dependencies {
    compile 'io.intercom.android:intercom-sdk-base:3.+'
}
```

## Example App
An example app is provided [here](https://github.com/intercom/intercom-android/tree/master/samples) that shows a basic Android app integration with Intercom.

## Setup and Configuration

* Our [installation guide](https://developers.intercom.com/docs/android-installation) contains full setup and initialisation instructions.
* The [configuration guide](https://developers.intercom.com/docs/android-configuration) provides info on how to configure Intercom for Android.
* Read our guide on Push Notifications for [GCM](https://developers.intercom.com/docs/android-gcm-push-notifications) and [FCM](https://developers.intercom.com/docs/android-fcm-push-notifications).
* Please contact us on [Intercom](https://www.intercom.com/) with any questions you may have, we're only a message away!

## Cordova/Phonegap Support
Looking for Cordova/Phonegap support? We have a [Cordova Plugin](https://github.com/intercom/intercom-cordova) for Intercom 🎉

## Upgrading from 1.x.x
If you are upgrading from an older version of our Messenger you may need to change some of the methods you used to call. You can see any changes you may need to make [here](https://docs.intercom.com/a-guide-to-the-new-intercom-messenger/upgrade-to-the-new-messenger-android).


## Permissions

We include the [INTERNET](http://developer.android.com/reference/android/Manifest.permission.html#INTERNET) permission by default as we need it to make network requests:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```  

Optional permissions:

```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.MANAGE_DOCUMENTS"/>
```

[READ\_EXTERNAL\_STORAGE](http://developer.android.com/reference/android/Manifest.permission.html#READ_EXTERNAL_STORAGE) and [MANAGE_DOCUMENTS](http://developer.android.com/reference/android/Manifest.permission.html#MANAGE_DOCUMENTS) are used for attachments.

The necessary GCM permissions ([WAKE_LOCK](http://developer.android.com/reference/android/Manifest.permission.html#WAKE_LOCK) and [RECEIVE](https://developer.android.com/google/gcm/client.html#manifest)) are also included by default in the main package.

```xml
<uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
```

You can also include [VIBRATE](http://developer.android.com/reference/android/Manifest.permission.html#VIBRATE) to enable vibration in push notifications:

```xml
<uses-permission android:name="android.permission.VIBRATE"/>
```

## Dependency graph

Here is our complete dependency graph:

### intercom-sdk-base
```
# Transitive (shared with your app)
+--- com.android.support:design:25.1.1
+--- com.android.support:appcompat-v7:25.1.1
+--- com.android.support:animated-vector-drawable:25.1.1
+--- com.android.support:support-vector-drawable:25.1.1
+--- com.android.support:support-v4:25.1.1
+--- com.android.support:support-annotations:25.1.1
+--- com.android.support:recyclerview-v7:25.1.1

# Repackaged (not shared with your app)
+--- com.squareup:otto:1.3.8
+--- com.github.bumptech.glide:glide-intercom:3.7.0 # Modified version of Glide
+--- com.squareup.okio:okio:1.11.0
+--- com.squareup.okhttp3:okhttp:3.6.0
+--- com.squareup.retrofit2:retrofit:2.2.0
+--- com.squareup.retrofit2:converter-gson:2.2.0
+--- com.google.code.gson:gson:2.8.0
```

If you use some of the repackaged libraries in your app, you may want to use a build that depends on them transitively. A guide to using this build can be found [here](https://docs.intercom.com/configure-intercom-for-your-product-or-site/configure-intercom-for-mobile/using-transitive-dependencies-with-intercom-for-android). Using this build involves more work as you need to make sure your app uses the correct version of each library.

### intercom-sdk-gcm
```
+--- com.google.android.gms:play-services-base:10.2.0
|    +--- com.google.android.gms:play-services-basement:10.2.0
|    |    \--- com.android.support:support-v4:23.0.0 -> 25.1.1 (*)
|    \--- com.google.android.gms:play-services-tasks:10.2.0
|         \--- com.google.android.gms:play-services-basement:10.2.0 (*)
+--- com.google.android.gms:play-services-basement:10.2.0 (*)
\--- com.google.android.gms:play-services-iid:10.2.0
    +--- com.google.android.gms:play-services-base:10.2.0 (*)
    \--- com.google.android.gms:play-services-basement:10.2.0 (*)
```

### intercom-sdk-fcm
```
+--- com.google.android.gms:play-services-basement:10.2.0
|    \--- com.android.support:support-v4:23.0.0 -> 25.1.1 (*)
+--- com.google.firebase:firebase-iid:10.2.0
|    +--- com.google.android.gms:play-services-basement:10.2.0 (*)
|    \--- com.google.firebase:firebase-common:10.2.0
|         +--- com.google.android.gms:play-services-basement:10.2.0 (*)
|         \--- com.google.android.gms:play-services-tasks:10.2.0
|              \--- com.google.android.gms:play-services-basement:10.2.0 (*)
\--- com.google.firebase:firebase-common:10.2.0 (*)
```
