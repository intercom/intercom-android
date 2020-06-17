<img src="https://user-images.githubusercontent.com/3185423/39155454-0c61c11e-474a-11e8-9471-dc4b37bf9d7c.png" width="238" height="65" alt="Intercom">


## Onboard, retain and support mobile users at scale
Engage customers with email, push, and in‑app messages and support them with an integrated knowledge base and help desk.

### The Intercom Messenger
The [Intercom Messenger](https://www.intercom.com/help/en/articles/316-the-intercom-messenger-in-your-product-and-on-your-website) is the home for the conversations your customers have with you via Intercom, and the place where they can self-serve for support or to learn more about your product.

The Messenger works for both logged in and logged out users. It’s worth reading the detailed instructions in our [developer docs](https://developers.intercom.com/installing-intercom/docs/intercom-for-android) on user management before you get started.

You can open the Intercom Messenger from a button in your app, programmatically when someone does something, or from a persistent button that sits over your app’s UI.

When you trigger the Intercom Messenger, your customer is presented with a home screen. This is configurable inside Intercom to change how it looks and what’s presented.

From there, your customer can search for help articles or start a conversation. A conversation goes to your inbox inside Intercom, and replies in both directions happen in real time. You can also send push notifications to your customers to let them know they have a reply after they’ve left your app.

![Android-2](https://user-images.githubusercontent.com/5046761/84916427-fdb09a00-b0b5-11ea-90f6-01a3f5cd395e.jpg)

### [Outbound messaging features](https://www.intercom.com/mobile-carousels)
You can send messages to your customers from Intercom, and the mobile SDK will present them in your app. Messages can be targeted at specific users or groups of users, and can be scheduled to be sent during specific time windows.

Companies use this for many use cases, including onboarding new users, announcing features, proactive support, important notices etc.

The mobile SDK supports many different message formats, all of which can be created and configured inside Intercom. These include:

* **Push notifications** - these can open your app or follow a deep link.
* **Chats** - messages from someone in your team to your customer.
* **Mobile Carousels** - highly customizable, multi-screen messages with calls to action and device permissions.
* **Small posts** - a short announcement.
* **Large posts** - a full screen announcement.

We check for new messages when your app opens and whenever your customer or your app interacts with Intercom.

![Android - Content types](https://user-images.githubusercontent.com/5046761/84916422-fbe6d680-b0b5-11ea-90c2-b72dab16ff7e.jpg)

## Installation
Intercom for Android supports API 21 and above.

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
