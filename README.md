<img src="https://user-images.githubusercontent.com/3185423/39155454-0c61c11e-474a-11e8-9471-dc4b37bf9d7c.png" width="238" height="65" alt="Intercom">

### Onboard, retain and support mobile users at scale
Engage customers with email, push, and in‑app messages and support them with an integrated knowledge base and help desk.

<img src="https://user-images.githubusercontent.com/2615468/42951429-0e2d7d54-8b6e-11e8-9d17-ad6460120aac.png">

Intercom for Android supports API 15 and above.

## Installation
There are 3 options for installing Intercom on your Android app.
### Option 1: Install Intercom with Google Cloud Messaging (GCM)

Add the following dependency to your app's `build.gradle` file:
```groovy
dependencies {
    compile 'io.intercom.android:intercom-sdk:5.+'
}
```

### Option 2: Install Intercom with Firebase Cloud Messaging (FCM)
Add the following dependency to your app's `build.gradle` file:
```groovy
dependencies {
    compile 'io.intercom.android:intercom-sdk-base:5.+'
    compile 'io.intercom.android:intercom-sdk-fcm:5.+'
}
```

### Option 3: Install Intercom without Push Messaging

If you'd rather not have push notifications in your app, you can use this dependency:
```groovy
dependencies {
    compile 'io.intercom.android:intercom-sdk-base:5.+'
}
```

## Customer Support
👋 Contact us with any issues at [Intercom Developer Hub available here](https://developers.intercom.com/docs/intercom-mobile-installation?utm_source=github&utm_campaign=android-help). If you bump into any problems or need more support, just start a conversation using Intercom there and it will be immediately routed to our Customer Support Engineers.

## Sample Apps
A project with some basic example integrations is provided [here](https://github.com/intercom/intercom-android/tree/master/samples).

## Setup and Configuration

* Our [installation guide](https://developers.intercom.com/docs/android-installation) contains full setup and initialisation instructions.
* The [configuration guide](https://developers.intercom.com/docs/android-configuration) provides info on how to configure Intercom for Android.
* Read our guide on Push Notifications for [GCM](https://developers.intercom.com/docs/android-gcm-push-notifications) and [FCM](https://developers.intercom.com/docs/android-fcm-push-notifications).
* Please contact us on [Intercom](https://www.intercom.com/) with any questions you may have, we're only a message away!

## ProGuard

If you are using ProGuard, add the following rules:

```
-keep class io.intercom.android.** { *; }
-keep class com.intercom.** { *; }
```

You might also need to add rules for OkHttp, Okio and Retrofit which are dependencies used in this library.

## Cordova/Phonegap Support
Looking for Cordova/Phonegap support? We have a [Cordova Plugin](https://github.com/intercom/intercom-cordova) for Intercom 🎉

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
com.android.support:design:28.0.0
com.android.support:appcompat-v7:28.0.0
com.android.support:animated-vector-drawable:28.0.0
com.android.support:support-vector-drawable:28.0.0
com.android.support:support-compat:28.0.0
com.android.support:support-core-utils:28.0.0
com.android.support:support-core-ui:28.0.0
com.android.support:support-fragment:28.0.0
com.android.support:support-annotations:28.0.0
com.android.support:recyclerview-v7:28.0.0

# Repackaged (not shared with your app)
com.squareup:otto:1.3.8
com.github.bumptech.glide:glide:4.4.0
com.github.bumptech.glide:gifdecoder:4.4.0
com.github.bumptech.glide:disklrucache:4.4.0
com.github.bumptech.glide:annotations:4.4.0
com.squareup.okio:okio:1.14.0
com.squareup.okhttp3:okhttp:3.9.1
com.squareup.retrofit2:retrofit:2.3.0
com.squareup.retrofit2:converter-gson:2.3.0
com.google.code.gson:gson:2.8.2
```

If you use some of the repackaged libraries in your app, you may want to use a build that depends on them transitively. A guide to using this build can be found [here](https://docs.intercom.com/configure-intercom-for-your-product-or-site/configure-intercom-for-mobile/using-transitive-dependencies-with-intercom-for-android). Using this build involves more work as you need to make sure your app uses the correct version of each library.

### intercom-sdk-gcm
```
com.google.android.gms:play-services-gcm:16.0.0
```

### intercom-sdk-fcm
```
com.google.firebase:firebase-messaging:17.3.4
```
