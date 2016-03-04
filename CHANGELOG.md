# Change Log

## Version 1.1.16

04-03-2016

* Updated to Okhttp 2.7.5 for improved reliability and bug fixes, fixes [issue#181](https://github.com/intercom/intercom-android/issues/181)
* Fixed an issue where a loading dialog could get into a state where it stayed on screen incorrectly, [issue#183](https://github.com/intercom/intercom-android/issues/183)
* Fixed an issue with the keyboard not dismissing while viewing an image, [issue#184](https://github.com/intercom/intercom-android/issues/184)

## Version 1.1.15

12-02-2016

* Fixed IndexOutOfBounds exception, [issue#176](https://github.com/intercom/intercom-android/issues/176)
* Fixed a crash caused by BitmapFactory.decodeResource returning null.

## Version 1.1.14

02-02-2016

* Reduced the initialization time by 50%
* Fixed an NPE in our ConversationAdapter, [issue#164](https://github.com/intercom/intercom-android/issues/164)
* Removed the remaining hard coded strings in the client, [issue#156](https://github.com/intercom/intercom-android/issues/156)
* Fixed a crash caused when a video failed to load. We now always show an error image for failed videos.

## Version 1.1.13

22-01-2016

* Fixed a crash with drawing the avatar in push notifcations, [issue#163](https://github.com/intercom/intercom-android/issues/163)
* Fixed a crash with websockets cleanup
* Fixed a bug that prevented URLs from displaying in a conversation

## Version 1.1.12

22-12-2015

* Protected against a potential NPE in the networking layer.
* Fixed an issue with the public reset call that resulted in the GCM device token not being removed from the server.
* Small improvements to GCM notifications, including enabling notification lighting to use the host apps base color.

## Version 1.1.11

04-12-2015

* Fixed a crashing issue when you add an attachment to a conversation that is a contact from an Android device. We now also protect against other unexpected failed attachment types.
* Fixed a bug with the unread count not being correctly maintained if you come and go from the Inbox and composer/conversation screen.

## Version 1.1.10

27-11-2015

* Tweaked some network settings for improved reliability
* Improved logging messages for network request failures, in particular a 'canceled' request should give the reason why it was cancelled now and if you provide invalid credentials (app-id or api key) the library will fail faster with a better log message.
* Fixed a bug that was causing the library to do work it didn't need to if an app became active in the background.
* Fixed a bug where calling `reset()` wasn't removing on screen notifications.
* Fixed a bug where push messages were still being sent after `reset()` was called.
* Fixed a bug that caused a new message to duplicate the first part if it was replied to immediately


## Version 1.1.9

03-11-2015

* Fixed a bug that could cause the notification preview to display over the message composer or conversations list

## Version 1.1.8

22-10-2015

* We've made some significant changes to the notification preview and how it works.
  * It's no longer draggable, instead it will now reposition when the screen changes, eg. when the keyboard appears.
  * It's a lot more memory efficient.
  * Fixed some longstanding UI issues when the notification was right aligned, it now reliably shows the text preview.
  * We no longer use the `SYSTEM_ALERT_WINDOW` permission
* Added better permission checking around attachments to handle cases where rooted phone are denying access, fixes [issue#137](https://github.com/intercom/intercom-android/issues/137)

## Version 1.1.7

01-10-2015

* Updated play services to 8.1 ('com.google.android.gms:play-services-gcm:8.1.0'). 8.1 introduces some breaking changes, see here for change details (https://developers.google.com/android/guides/releases#september_2015)
* Removed duplicate realtime requests
* Calling logEvent(String, Map) with a null or empty Map no longer fails but instead calls logEvent(String)
* Fixed an issue with HTC devices not being able to interact with the chathead from IceCreamSandwich to Jellybean.

## Version 1.1.6

23-09-2015

* Hot fix for a NoClassDefFound exception in the intercom-sdk-gcm, [issue#134](https://github.com/intercom/intercom-android/issues/134)

## Version 1.1.5

23-09-2015
* Deprecated openGCMMessage(Uri) in favour of openGCMMessage(Intent) and openGCMMessage(Intent, TaskStackBuilder)
* Fixed a crash for requesting permissions on pre Lolipop devices
* Fixed ConcurrentModificationException [issue#119](https://github.com/intercom/intercom-android/issues/119)
* New public method setLogLevel that allows developers to control the level of logging they want and to fully disable logging [issue#112](https://github.com/intercom/intercom-android/issues/112)
* New implementation for openGCMMessage that takes the a TaskStackBuilder allowign developers to provide a backstack before we open the in-app messenger[issue#110](https://github.com/intercom/intercom-android/issues/110)
* New implementation for openGCMMessage that takes the intent and only open the in-app messenger once per push [issue#105](https://github.com/intercom/intercom-android/issues/105)

## Version 1.1.4

18-09-2015
* Updated to support Android M preview [issue#116](https://github.com/intercom/intercom-android/issues/116)
* Swallow AssertionError in AppConfig caused by GSON [issue#120](https://github.com/intercom/intercom-android/issues/120)
* Protect against NPE in CallbackHolder [issue#122](https://github.com/intercom/intercom-android/issues/122)
* Fixed an index out of bound exception [issue#113](https://github.com/intercom/intercom-android/issues/113)
* Updated the signature for logEvent and updateUser to take maps of <String, ?>. Now you can pass in a Map<String, String> if that's what you happen to have instead of changing it to a Map<String, Object>. No changes are necessary to existing code. [issue#121](https://github.com/intercom/intercom-android/issues/121)

## Version 1.1.3

27-07-2015
* Integrated a smarter system for retrieving and displaying new messages sent while an app is open, fixes [issue#109](https://github.com/intercom/intercom-android/issues/109)
* Lowercased font assets names and added some better error handling for when fonts can't be made, fixes [issue#107](https://github.com/intercom/intercom-android/issues/107)
* Repackaged all of our dependencies _except_ the play services library, resolves [issue#50](https://github.com/intercom/intercom-android/issues/50)
* Fixed crash in preview service where the rootview was sometimes not inflating [issue#108](https://github.com/intercom/intercom-android/issues/108)

Notes:
When updating to this version from a previous version we recommend cleaning the project as you include the v1.1.3. If you're using eclipse *make sure to include the new fonts and repackaged dependencies jar*

## Version 1.1.2

06-07-2015
* Namespaced fonts and raw assets. Every asset should be prefixed with 'intercomsdk' to avoid conflicts, let us know if you see one that isn't
* Fixed a crash when loading a conversation if a participant had a leading space in their name
* Fixed [issue#104](https://github.com/intercom/intercom-android/issues/104), a memory leak
* Fixed a GCM related issue. Some saw an error stacktrace caused by our broadcast receiver for gcm setting a result on on unordered broadcast. That broadcast was the OS pinging the broadcast receiver (typically on first install). This is a benign 'error' that doesn't cause any issues, but we're going to try to ignore it anyway. You shouldn't see that error in your logs any more.

## Version 1.1.1

01-07-2015
* Catching exeption that sometimes gets thrown when app is backgrounded

## Version 1.1.0

01-07-2015
* Users can now send attachments
* Added new permissions for attachments: EAD_EXTERNAL_STORAGE and MANAGE_DOCUMENTS
* Users can expand and zoom images without leaving your app
* Improved performance in conversations with many images
* Split GCM related code into a separate module that is included by default but can be excluded if you don't require GCM
* Fixed [issue#95](https://github.com/intercom/intercom-android/issues/95)
* Fixed [issue#98](https://github.com/intercom/intercom-android/issues/98)

## Version 1.0.4

09-06-2015
* Visual improvements for conversations that involve more than two people
* Fixed a crash caused by the system passing null into our GcmIntentService
* Fixed [issue#83](https://github.com/intercom/intercom-android/issues/83)
* Fixed [issue#88](https://github.com/intercom/intercom-android/issues/88)


## Version 1.0.3

03-06-2015
* Updated dependencies in the library: okhttp, okhttp-ws, support and play services libraries
* Namedspaced custom XML attributes

## Version 1.0.2

26-05-2015
* Fixed a crash caused by messages containing a list with some HTML content in the list items

## Version 1.0.1

22-05-2015
* You can now change the Android API key used in an app without having to clear the local cache of your app, eg switching between a test app and your real app. This doesn't allow changing of the API key dynamically as an app is running.
* Fixed a bug where an avatar that was a gif would crash
* Fixed a bug where we were being too agrgressive with user attribute validation and stopping some correct attributes from being sent to Intercom
* Remade our assets for lower dpi phones, they look better now
* Small UI improvements

## Version 1.0.0

05-12-2015
* Small UI and visual tweaks

## Version 0.9.8

05-11-2015
* Many small UI and visual tweaks
* Fixed a bug that caused a converation loaded from a push notification to not display the unread conversations counter in the top left
* Fixed a bug that could cause the loading progress dialog in the conversations list to not be correctly dismissed

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
