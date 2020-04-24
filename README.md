<img src="https://user-images.githubusercontent.com/3185423/39155454-0c61c11e-474a-11e8-9471-dc4b37bf9d7c.png" width="238" height="65" alt="Intercom">

### Onboard, retain and support mobile users at scale
Engage customers with email, push, and in‑app messages and support them with an integrated knowledge base and help desk.

<img src="https://user-images.githubusercontent.com/2615468/42951429-0e2d7d54-8b6e-11e8-9d17-ad6460120aac.png">

Intercom for Android supports API 21 and above.

## Installation
There are 2 options for installing Intercom on your Android app.

### Option 1: Install Intercom with Firebase Cloud Messaging (FCM)
Add the following dependency to your app's `build.gradle` file:
```groovy
dependencies {
    implementation 'io.intercom.android:intercom-sdk:6.+'
    implementation 'com.google.firebase:firebase-messaging:17.+'
}
```

### Option 2: Install Intercom without Push Messaging

If you'd rather not have push notifications in your app, you can use this dependency:
```groovy
dependencies {
    implementation 'io.intercom.android:intercom-sdk-base:6.+'
}
```

## Customer Support
👋 Contact us with any issues at [Intercom Developer Hub available here](https://developers.intercom.com/installing-intercom/docs/intercom-for-android). If you bump into any problems or need more support, just start a conversation using Intercom there and it will be immediately routed to our Customer Support Engineers.

## Sample Apps
A project with some basic example integrations is provided [here](https://github.com/intercom/intercom-android/tree/master/samples).

## Setup and Configuration

* Our [installation guide](https://developers.intercom.com/docs/android-installation) contains full setup and initialisation instructions.
* The [configuration guide](https://developers.intercom.com/docs/android-configuration) provides info on how to configure Intercom for Android.
* Read our guide on Push Notifications for [FCM](https://developers.intercom.com/installing-intercom/docs/android-fcm-push-notifications).
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

You will need to include the [READ\_EXTERNAL\_STORAGE](http://developer.android.com/reference/android/Manifest.permission.html#READ_EXTERNAL_STORAGE) permission if you have enabled attachments:

```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
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
com.android.support.constraint:constraint-layout:1.1.3
com.google.android:flexbox:1.0.0

# Repackaged (not shared with your app)
com.squareup:otto:1.3.8
com.github.bumptech.glide:glide:4.4.0
com.github.bumptech.glide:gifdecoder:4.4.0
com.github.bumptech.glide:disklrucache:4.4.0
com.github.bumptech.glide:annotations:4.4.0
com.squareup.okio:okio:1.17.4
com.squareup.okhttp3:okhttp:3.12.3
com.squareup.retrofit2:retrofit:2.6.1
com.squareup.retrofit2:converter-gson:2.6.1
com.google.code.gson:gson:2.8.5
```

If you use some of the repackaged libraries in your app, you may want to use a build that depends on them transitively. A guide to using this build can be found [here](https://docs.intercom.com/configure-intercom-for-your-product-or-site/configure-intercom-for-mobile/using-transitive-dependencies-with-intercom-for-android). Using this build involves more work as you need to make sure your app uses the correct version of each library.

### intercom-sdk-fcm
```
com.google.firebase:firebase-messaging:17.6.0
```
