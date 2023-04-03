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
    implementation 'io.intercom.android:intercom-sdk:14.2.0'
    implementation 'com.google.firebase:firebase-messaging:20.+'
}
```

### Option 2: Install Intercom without Push Messaging

If you'd rather not have push notifications in your app, you can use this dependency:
```groovy
dependencies {
    implementation 'io.intercom.android:intercom-sdk-base:14.2.0'
}
```

### Maven central
Add the following to your root build.gradle file
```groovy
allprojects {
    repositories {
      mavenCentral()
    }
}
```
### Push Notification
Apps targeting Android 13 should request a runtime permission to enable notifications.
Add the  following code to request permission.
```kotlin
registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
    if (isGranted) {
        // Permission is granted. Continue the action or workflow in your
        // app.
    } else {
        // Explain to the user that the feature is unavailable because the
        // features requires a permission that the user has denied. At the
        // same time, respect the user's decision. Don't link to system
        // settings in an effort to convince the user to change their
        // decision.
    }
}
```

## Customer Support
👋 Contact us with any issues at [Intercom Developer Hub available here](https://developers.intercom.com/installing-intercom/docs/intercom-for-android). If you bump into any problems or need more support, just start a conversation using Intercom there and it will be immediately routed to our Customer Support Engineers.

## Sample Apps
A project with some basic example integrations is provided [here](https://github.com/intercom/intercom-android/tree/master/sample).

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

### Transitive Dependencies

Intercom Android SDK transitively depends on the above libraries. If your app is using any one of these libraries, they should at least be on the same major version that Intercom SDK is using.
When there are two versions of a library at build time, Gradle automatically picks the newer version. 
This means if you are currently using say Glide 3.x, your app would automatically get Glide 4.x after including Intercom.
