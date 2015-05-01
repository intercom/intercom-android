# Change Log

## Version 0.9.7

05-01-2015
* The Intercom SDK no longer has any functionality on devices below API level 15 
* The Intercom SDK now supports real-time messaging
* Many visual tweaks and improvements
* Push notifications are now high priority on devices that support notification priority
* Fixed some issues where push notifications would be rendered when the app was open
* Resolved [issue#69](https://github.com/intercom/intercom-android/issues/69), a crash on Gingerbread devices

## Version 0.9.6

04-29-2015
* Removed GCM permissions so that now developers have the option of adding them only if you *want* to register for push notifications
    * &lt;!-- GCM REQUIRED PERMISSIONS --&gt;
    * &lt;uses-permission android:name="android.permission.WAKE_LOCK" /&gt;
    * &lt;uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" /&gt;
    * &lt;uses-permission android:name="android.permission.VIBRATE"/>
    *
    * &lt;!-- GCM Optional PERMISSIONS --&gt;
    * &lt;uses-permission android:name="android.permission.READ_PHONE_STATE"/&gt;
    * &lt;uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/&gt;
* Added audio cues to received and sent messages
* Fixed [issue#54](https://github.com/intercom/intercom-android/issues/54) Updated action bar visuals
* Fixed a bug where a conversation replied to by a user would update it's summary in the inbox but not it's position, related to [issue#58](https://github.com/intercom/intercom-android/issues/58)
* Fixed [issue#59](https://github.com/intercom/intercom-android/issues/59)
* Fixed [issue#60](https://github.com/intercom/intercom-android/issues/60) 
* Fixed [issue#65](https://github.com/intercom/intercom-android/issues/65) which was causing a crash
* Fixed [issue#67](https://github.com/intercom/intercom-android/issues/67) by removing metadata from the offending PNGs

## Version 0.9.5

04-15-2015
* The SDK now logs any API errors as well as the HTTP response status code received for errors
* Scrolling inside a conversation was a little janky, we've improved it. Specifically scrolling to the end of new replies and some general improvements
* Fixed a crash when our service was restarted unexpectedly
* Fixed an issue that could cause session counts to be incremented by one incorrectly in some cases

## Version 0.9.4

04-08-2015
* Deprecated 'setMessagedHidden' in the Intercom class in favour of 'setVisibility'. The 'setVisibility' method takes either Intercom.VISIBLE' or 'Intercom.GONE' as a parameter. 
* Timestamps periodically update within a conversation 
* Removed the 'GET_ACCOUNTS' permission [issue#46](https://github.com/intercom/intercom-android/issues/46). It's not necessary for GCM.
* Fixed a gingerbread compatibility issue that was incorrectly letting it try to access anything visual in the SDK and subsequently crashing.
* Fixed a bug with 'setMessagedHidden' where calling it with 'true.GONE' wouldn't dismiss the IAM if it was open.
* Fixed [issue#55](https://github.com/intercom/intercom-android/issues/55), deep links work now.
* Fixed [issue#57](https://github.com/intercom/intercom-android/issues/57) which caused a new message to never be correctly updated from the sending state to sent state.
* Fixed [issue#60](https://github.com/intercom/intercom-android/issues/60) that let users send a message many times if it got stuck in a 'sending failed' state 
*

## Version 0.9.3

03-31-2015
* Added the internet and access wifi state permissions to our Manifest 
* Validating the attributes map passed into the `updateUser` method and giving better error messages
* Updated to v2.3.0 of Okhttp

## Version 0.9.2

03-27-2015
* Updated the sdk proguard rules to reflect the new package

## Version 0.9.1

03-26-2015
* Repackaged the SDK from 'intercom.intercomsdk' -> 'io.intercom.android.sdk'. This will cause all your imports to break
* All network requests from the SDK are now SSL pinned 
* Fixed a bug where switching between conversations and new messages very quickly could cause a crash
* Fixed a bug where a new messages created from the SDK wasn't displaying in the inbox 
* Fixed a bug where the SDK could crash if it was resumed after a long backgrounding 
* Updated to v7.0.0 of the Google Play Services Library
* Updated to v2.5.2 of Picasso

## Version 0.9.0

02-23-2015
* adding CHANGELOG
* adding samples/intercom-push-sample to help test push integration