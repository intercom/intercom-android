# Changelog

## Version 5.4.0
09-07-2019

###  Provide faster, more personal support at scale with Custom Bots for new conversations 🤖

When a customer starts a new conversation with you in the Messenger, they’ll be able to choose from suggested replies that you’ve defined. They can clarify why they’re getting in touch, and provide extra info without needing to wait for a response, or take up your team’s time.

![android-5-4-0-release](https://user-images.githubusercontent.com/5109304/60926201-a45faa00-a25a-11e9-9f96-2915541a55b7.png)

With Custom Bots from new conversations, you can accelerate your support by automating these initial interactions, so your support team can focus on resolving important issues. To get started, bump your Intercom SDK version to `5.4.0` and go to the `Operator` tab in Intercom, then `Custom Bots`, and select `From new conversations`. 

## Version 5.3.2
17-05-2019
- Revert to use okhttp version 3.11.0. There was a compatibility issue with 3.12.3, we'll hold off upgrading until it's fully tested.

## Version 5.3.1
15-05-2019
- Fixed the issue of unable to add images to conversation replies
- Fixed a crash with InputFragment
- Updated okhttp to use the latest version

## Version 5.3.0
29-04-2019

### Deliver Custom Bots to your mobile app users to unlock growth across all platforms

Custom Bots can now be targeted specifically to your mobile app users! Whether your users are on the web or mobile, Custom Bots now work cross-platform to automate and accelerate growth.

![android-5-3-0-release](https://user-images.githubusercontent.com/5046761/56959018-f772fd80-6b43-11e9-88e1-1f42e32a0d26.png)

Use our bots to provide better personalization at scale during critical moments of the customer lifecycle like when users first sign up for your app, or when they want to upgrade to a paid plan.

For more details on how to use Custom Bots on mobile, see our [docs here](https://www.intercom.com/help/faqs-and-troubleshooting/custom-bots/do-custom-bots-work-on-mobile).

## Version 5.2.1
01-03-2019
- Fix for Vimeo thumbnails showing the wrong thumbnail preview

## Version 5.2.0
04-12-2018
- Removed GCM support as it is being deprecated.

Google is [deprecating GCM](https://developers.google.com/cloud-messaging/faq) on April 11, 2019. We are no longer updating our GCM library, 5.1.6 will be the last version of our messenger with GCM support. We strongly recommend [migrating your app to FCM](https://developers.google.com/cloud-messaging/android/android-migrate-fcm) and then [migrating from Intercom GCM to Intercom FCM library](https://developers.intercom.com/installing-intercom/docs/android-fcm-push-notifications)

## Version 5.1.6
13-11-2018

- Bug fix for fullscreen GIFs not animating
- Updated Support Library and Build Target SDK versions 
- Added error reporting for SDK crashes
- Updated GCM and FCM versions

## Version 5.1.5
24-10-2018

- Handled empty state in the home screen
- Fixed a bug in messenger apps that broke input when some special characters were used

## Version 5.1.4
02-10-2018

- Added support for users to change a conversation rating
- Added support for Vimeo video thumbnails
- Fixed an issue with launcher positioning when bottom padding is set
- Fixed a crash on a text input that occurred on Android devices running Android Version 5

## Version 5.1.3
25-09-2018

- Added DOM storage support in Sheets web view
- We now provide support for Loom videos in Intercom

## Version 5.1.2
17-09-2018

- [AnswerBot](https://www.intercom.com/bots-for-support) support.

**Bug Fixes**

- Add Android translations key for Help Center
- Draw Help Center toolbar with dark text if the help center color is light.
- Fix crash with missing string
- Fix article cards on old devices

## Version 5.1.1
17-08-2018

**Bug Fixes**

- Fixed the crash while loading large images 
- Fixed the bug where keyboard covers composer on tablets
- Fixed text overlap in the conversation list on tablets
- Fixed an issue where teammate avatar flickers during UI updates
- Bug fix for toolbar title doesn't show up in Messenger App sheets
- Fixed a bug that was causing Messenger App sheet to open in browser
- Reorder dependencies for failing PhoneGap build

## Version 5.1.0
19-07-2018

**Enable mobile users to help themselves with the new mobile SDK for iOS and Android 🎉 😃**

The new Intercom mobile SDK brings the Messenger Home to your mobile applications. This means you can add messenger apps that allow your users to self-serve instead of starting a conversation. Users can now quickly access relevant help articles, review pinned content, and view product status in real time – all from the messenger home screen.

![5-1-0-release-screens](https://user-images.githubusercontent.com/2615468/42951497-316de29a-8b6e-11e8-8ed8-a0a3a93f6f4f.png)

**Bug fixes and Changes**
* Deprecated `Intercom.client().displayConversationsList()`. `Intercom.client().displayMessenger() should be used instead to open our Messenger Home screen.`
* Fixed issue with the header

## Version 5.0.2
27-06-2018

**Send apps in Messages** ⚡📨⚡

Messages have always been a great way to welcome, onboard, and connect with people in your product and on your website. Now with apps in your messages, you can do even more. Embed apps right inside a message to drive actions, engage your audience, and grow your business.

Whether you need to gather customer feedback, schedule a sales call, or share your latest content, apps make it easy for people to take action within the message experience. And with the targeting capabilities of Intercom, you can make sure your message reaches the right person at the right time.

## Version 5.0.1
27-04-2018

- Removed all code that used a persistent device identifier to adhere to [Android Advertising ID policy](https://support.google.com/googleplay/android-developer/answer/6048248?hl=en)

## Version 5.0.0
24-04-2018

The Business Messenger reimagined.

**Messenger apps**
- Complete actions beyond chat in the Messenger seamlessly with a growing library of apps. Messenger apps are being rolled out to all customers over the next 2 weeks.

**Extendable platform**
- Create your own Messenger apps to suit your unique workflows – and enable entirely new ones.

**Updated Design**
- Updated visual design with new wallpapers and expanded color settings.

**Messenger settings**
- New wallpapers to customize your profile.
- Set a background color for your profile and an action color for cards and chat bubbles.
- Support light theme colors in your messenger.

![5-0-0-release-screens](https://user-images.githubusercontent.com/2615468/39157445-befb7196-4752-11e8-8a33-57636975ecec.png)

## Version 4.1.9
20-04-2018

* Fixed an issue where sending multiple messages before a conversation is created resulted in multiple conversations
* Clearer GCM token upload error message
* Add ProGuard rule for AutoValue
* Update Support Library to 27.1.1

## Version 4.1.8
19-02-2018

* Fix webview crash: https://github.com/intercom/intercom-android/issues/456
* Fix broken lightbox transitions: https://github.com/intercom/intercom-android/issues/464
* Fix launcher and in-app notifications showing on Intercom Messenger screens
* Update Play Services & Firebase libraries to 11.8.0
* Update Glide to 4.4.0
* Updated Okio & OkHttp to latest versions

## Version 4.1.7
25-01-2018

* Released Help Center on Android. Added the method `displayHelpCenter()` to the main API. This opens up an Activity which displays your Educate Help Center. Learn more about Educate [here](https://www.intercom.com/customer-support-software/knowledge-base). Details on how to setup the experimental API can be found [here](https://developers.intercom.com/docs/android-configuration#section-educate-help-center)
* Allow office hours banner to expand to two lines for languages where the string was truncating

## Version 4.1.6
06-12-2017

* Add support for API 27
* Update Support Library to 27.0.2
* Fix message composition issue on Samsung devices

## Version 4.1.5

01-12-2017

* Fixed https://github.com/intercom/intercom-android/issues/452
* Fixed https://github.com/intercom/intercom-android/issues/451
* Fixed https://github.com/intercom/intercom-android/issues/449

## Version 4.1.4

15-11-2017

* Fix OOM error https://github.com/intercom/intercom-android/issues/422
* Updated Gson to 2.8.2

## Version 4.1.3

08-11-2017

* Fixed an issue with the keyboard not closing on toolbar back pressed https://github.com/intercom/intercom-android/issues/435
* Fixed a RuntimeException with UploadEvent https://github.com/intercom/intercom-android/issues/439
* Fixed a NullPointerException in the PushPayload https://github.com/intercom/intercom-android/issues/442

**Experimental API**
* The `boot()` method now takes a user hash in the `IntercomSettings` object. You can still update the user hash by calling `setUserHash` but if you have Identity Verification enabled and you are booting with an email and/or user ID then it is required to provide a user hash at that time.

## Version 4.1.2

31-10-2017

* Updated Play Services to 11.4.2

**Experimental API**
* added the method `displayHelpCenter()` to the experimental API. This opens up an Activity which displays your Educate Help Center. Learn more about Educate [here](https://www.intercom.com/customer-support-software/knowledge-base). Details on how to setup the experimental API can be found [here](https://developers.intercom.com/v2.0/docs/experimental-api)

## Version 4.1.1

25-10-2017

* Add `equals()`, `hashCode()` and `toString()` implementations to `UserAttributes`, `Company` and `Registration`
* Minor fixes

## Version 4.1.0

10-10-2017

* Fix StrictMode warnings in Android Oreo
* Deprecated `Intercom.client().reset()` in favour of `Intercom.client().logout()`
* Intercom now runs a `ContentProvider` which automatically calls `registerForLaterInitialisation()`. This means Intercom no longer requires you to make a custom Application class. `Intercom.initialize` can now be called from your Activity if you would prefer.

**Experimental API**
* Added an experimental API. To use it please import `io.intercom.android.sdk.experimental.Intercom`. The changes to the new API are:
    * Replaced `Intercom.initialize(Application, String, String)` with `Intercom.boot(Application, IntercomSettings)` Unlike `initialize`, `boot` does not need to be called in a custom Application class. It also results in the creation/ logging in of a user.
    * The methods `registerUnidentifiedUser()` and `registerIdentifiedUser(Registration)` are removed. Calling `boot` now registers a user. The `IntercomSettings` object has an optional email and userId. If either of those was provided an identified user is registered, otherwise an unidentified user is created.
  * To migrate from an unidentified to an identified user you can simply call `updateUser(UserAttributes)` where the `UserAttributes` object contains an userId and/or email.
  * The method `logout()` has been replaced with `shutdown()`.


## Version 4.0.5

27-09-2017

* Fix NullPointerException: https://github.com/intercom/intercom-android/issues/423
* Update Support Library to 26.1.0
* Update FCM and GCM libraries to 11.4.0
* Fix crash when host app has Glide modules in its Manifest: https://github.com/intercom/intercom-android/issues/429
* Fix Intercom notification channels appearing when not using push notifications
* Improved image loading stability

## Version 4.0.4

18-09-2017

* Improved image performance and stability
* Fix UI issues with teammate profile section
* Updated translations

## Version 4.0.3

08-09-2017

* Improved image loading stability
* Fix crashes related to in-app notifications
* Update Support Library to 26.0.2
* Update OkHttp to 3.9.0 and Gson to 2.8.1
* Add support for article suggestions from Operator

## Version 4.0.2

07-09-2017

* Update Support Library to 26.0.1
* Fix GCM issue on Android Oreo: https://github.com/intercom/intercom-android/issues/406
* Improve logging around `displayMessageComposer()`

## Version 4.0.1

10-08-2017
* Fix image loading issues

## Version 4.0.0

10-08-2017
* **This version has issues with image loading, please use 4.0.1**
* Android O Support
* Updated to 26.0.0 of the support library
* Updated FCM and GCM play-services to 11.0.4
* Updated third party dependancies, a list of the current library versions is provided in the [github readme](https://github.com/intercom/intercom-android#dependency-graph)
* Removed deprecated methods
* Support for O Notification channels. The channels added by Intercom are: 
  - Chat Replies (when you reply to a customer in Intercom)
  - New Chats (when you send an in-app message to a customer with send notification checked)
  - Actions (when you send a push message to a customer)
* Fixed an OutOfMemoryError in the image gallery[#371](https://github.com/intercom/intercom-android/issues/371)

## Version 3.2.10

04-08-2017
* Added native support for conversation ratings. You can read more about conversation ratings [here](https://docs.intercom.com/responding-to-users-and-visitors/see-your-team-s-progress/measure-customer-satisfaction-with-conversation-ratings).

## Version 3.2.9

04-08-2017
* Fixed NullPointerException: https://github.com/intercom/intercom-android/issues/381
* Fixed UI issues in teammate profile: https://github.com/intercom/intercom-android/issues/378
* Fixed scrolling behaviour in conversation
* Fixed unread count being incorrect after a new conversation was started
* Fixed duplicate resources: https://github.com/intercom/intercom-android/issues/385

## Version 3.2.8

13-07-2017
* Miscellaneous crash fixes

## Version 3.2.7

30-06-2017
* Fixed `IndexOutOfBoundsException`: https://github.com/intercom/intercom-android/issues/366
* Fixed NPE when invalid data is passed to `IntercomPushClient`
* Fixed `logEvent()` from affecting user data when called directly after a registration
* Fixed `JsonSyntaxException` caused by loading persisted data
* Fixed the profile not loading correctly when opening the Messenger just after the app starts
* Optimised images

## Version 3.2.6

21-06-2017
* Minor translation updates

## Version 3.2.5

08-06-2017
* Fix potential crash when replying while uploading an image

## Version 3.2.4

31-05-2017
* Support AAPT2 in Android Gradle plugin 3.0-alpha2: https://github.com/intercom/intercom-android/issues/354
* Fix full in-app messages showing twice: https://github.com/intercom/intercom-android/issues/352
* Fix NPE: https://github.com/intercom/intercom-android/issues/351
* Fix IllegalStateException: https://github.com/intercom/intercom-android/issues/347
* Improved UI performance

## Version 3.2.3

22-05-2017
* Minor fixes

## Version 3.2.2

11-05-2017
* Added a new public API setBottomPadding() which takes a pixel value to add to the default bottom padding of the default launcher and in app messages.
* Fixed typo in our IntercomFcmInstanceIdService class check [#342](https://github.com/intercom/intercom-android/issues/342)
* Fixed IllegalArgumentException [#344](https://github.com/intercom/intercom-android/issues/344)
* Fixed an issue with our real time system not trigger a UI update for a message received when the app is backgrounded and reopened in a short period of time.

## Version 3.2.1

03-05-2017
* Fixed issue causing session count to double increment [#337](https://github.com/intercom/intercom-android/issues/337)

## Version 3.2.0

21-04-2017
* Updated support library to 25.3.1
* Added new public API `setUserHash(String userHash)` which replaces the now deprecated `setSecureMode(String hmac, String data)`
* Updated GCM and FCM to 10.2.1

## Version 3.1.5

18-04-2017
* Fixed issues when initialising Intercom outside of `Application.onCreate()`

## Version 3.1.4

14-04-2017
* Updates to the active/away UI
* Initialisation fixes

## Version 3.1.3

05-04-2017
* Updates to the active/away UI
* Fixes https://github.com/intercom/intercom-android/issues/332

## Version 3.1.2

29-03-2017
* Fixes [#325](https://github.com/intercom/intercom-android/issues/325)
* Translation fixes and improved logging

## Version 3.1.1

20-03-2017
* Add `withLanguageOverride()` method to the UserAttributes model
* Display error to users before uploading files that are larger than we support
* Fixed issue where the Intercom settings color was not applied to the the push icon and push title
* Fixed localization issues with the composer
* Fixed issue with applying a padding to in-app messages [#311](https://github.com/intercom/intercom-android/issues/311)

## Version 3.1.0

06-03-2017
* Added new method to the API updateUser(UserAttributes). Docs on how to use this can be found [here](https://developers.intercom.com/docs/android-configuration#section-update-a-user)
* Deprecated `updateUser(Map<String, ?>)` and `updateUser(User)` methods in favour of `updateUser(UserAttributes)`
* Search and send GIFs from our new message composer
* Dedicated image loader that allows you to preview and send images on your device
* Fixed a FileNotFoundException in the Intercom SoundPlayer
* Updated the Android Support Library to version 25.1.1
* Update the Android GCM and FCM libraries to version 10.2.0

## Version 3.0.21

08-02-2017
* Translation fixes
* Added `withSignedUpAt(Date date)` method to User
* Improved unread conversation count updating when using multiple devices at once.

## Version 3.0.20

25-01-2017
* Re-introduces IntercomLogger that were incorrectly removed from the last release. They are now deprecated in favour of the constants in `Intercom.LogLevel`.
* Fixes the conversation scrolling to the bottom incorrectly.

## Version 3.0.19

23-01-2017
* Fixed NPE on some devices (https://github.com/intercom/intercom-android/issues/304)
* Fixed aliasing in some Drawables (https://github.com/intercom/intercom-android/issues/303)
* Fixed crash caused by permission issues in other apps (https://github.com/intercom/intercom-android/issues/302)
* Fixed temporary memory leak (https://github.com/intercom/intercom-android/issues/297)
* Fixed messages showing after a conversation has been read (https://github.com/intercom/intercom-android/issues/243)
* Fixed sounds playing multiple times for the same notification
* Fixed attachment upload icon being incorrectly hidden
* Improved logging for developers
* Better support for `singleTask` and `singleInstance` Activities
* Fixed incorrect delays when changing visibility of in-app notifications and launcher
* Optimised networking code
* Updated localisation

## Version 3.0.18

09-01-2017
* Fixed a warning when updating the RecyclerView data in a scroll callback https://github.com/intercom/intercom-android/issues/301
* Fixed a handler that was blocking initialization off the main thread https://github.com/intercom/intercom-android/issues/299
* Fixed an issue with a handler causing a background failure in the push service.
* Fixed showing the attachment button if the device requires the manifest permission https://github.com/intercom/intercom-android/issues/296
* Fixed an issue where not having access to the cache directory produced an NPE
* Added sample code for company custom attributes https://github.com/intercom/intercom-android/issues/293
* Added an xml public padding field to allow users to alter the position of the Intercom FAB and in-apps if it is blocking host app FABs https://github.com/intercom/intercom-android/issues/231 To update the position simply add this to your dimens.xml with the value you want to move up by `<dimen name="intercom_bottom_padding">74dp</dimen>`
* Added functionality to make sure that if the user has scrolled to the bottom of the conversation then opens the compsoer we will not hide that message

## Version 3.0.17

16-12-2016
* The SDK now targets API 25
* UI fixes
* Push notification fixes

## Version 3.0.16

13-12-2016
* Networking optimisations
* UI fixes
* Fix crash in conversations started from Acquire on web

## Version 3.0.15

06-12-2016
* Now supports Intercom Educate. Learn more [here](https://www.intercom.com/customer-support-software/knowledge-base)
* Networking optimisations
* Fix https://github.com/intercom/intercom-android/issues/291

## Version 3.0.14

24-11-2016
* Reduced method count by eliminating synthetic methods
* Networking optimisations

## Version 3.0.13

18-11-2016
* Updated Android Support Library to 25.0.1
* The SDK now throws a more specific exception when it is incorrectly initialised
* Fixed log message incorrectly appearing (https://github.com/intercom/intercom-android/issues/289)
* Fixed crash in some initialisation situations (https://github.com/intercom/intercom-android/issues/288)
* Fixed crash when permissions request is cancelled (https://github.com/intercom/intercom-android/issues/285)
* Fixed missing translations for the inbox empty state
* Fixed duplicate push notifications appearing (https://github.com/intercom/intercom-android/issues/261)
* Fixed crash when opening a photo attachment
* Fixed Parcelable crash

## Version 3.0.12

10-11-2016
* Fixed https://github.com/intercom/intercom-android/issues/282
* Fixed https://github.com/intercom/intercom-android/issues/281
* Fixed https://github.com/intercom/intercom-android/issues/280
* Fixed https://github.com/intercom/intercom-android/issues/279

## Version 3.0.11

07-11-2016
* Removed dependency on Rebound
* Updated Android Support Library to 25.0.0
* Updated Play Services and Firebase to 9.8.0
* Performance improvements

## Version 3.0.10

05-10-2016
* Fixed crash on OPPO devices https://github.com/intercom/intercom-android/issues/263
* Better logging when we can't find a launch intent for the host application
* Update translations

## Version 3.0.9

16-09-2016
* Added a new method to the API, displayMessageComposer now accepts an optional String to pre-populate the composer.`Intercom.client().displayMessageComposer(message);`
* Update Android Support Library to 24.2.1
* Update translations
* Reduced method count

## Version 3.0.8

14-09-2016

* Fixed issue where a long team intro couldn't be fully displayed on smaller devices.
* Update appearance of code in messages.

## Version 3.0.7

09-09-2016

* Fixed an issue with GCM and FCM conflicting with other registration services.
* Prevent real-time connections in background processes.

## Version 3.0.6

06-09-2016

* Hide the soft keyboard when we open a Post message.
* Default to the host app launch activity if no URI is set in a push message.
* Fix newer API method being called on all OS versions - https://github.com/intercom/intercom-android/issues/252
* Ensure that view operations in `Intercom.client().reset()` are called on the main thread - https://github.com/intercom/intercom-android/issues/251
* Improved performance when the Messenger opens for the first time
* Fix images with links not following their link when tapped

## Version 3.0.5

01-09-2016

* Fixed an issue with GCM and FCM conflicting with other receivers [issue#246](https://github.com/intercom/intercom-android/issues/246)
* Update Support Library to 24.2.0
* Fix crash when tapping a message after it gets detached from the RecyclerView

## Version 3.0.4

22-08-2016

* Added two pane tablet support.
* Fixed a bug with Android click tracking.
* Fixed crash when loading a small subset of resources on older Android versions.
* Fix app name overlapping with close button in toolbar.
* Stopped sending a request to remove device token on reset if the user has no device token.

## Version 3.0.3

16-08-2016

* Added FCM support
* Deprecated openGcmMessage() and openGcmMessage(TaskStackBuilder customStack) with handlePushMessage() and handlePushMessage(TaskStackBuilder customStack)
* Fixed TCP connections not being fully killed when the application moves into the background
* Unread count listeners will now receive the latest unread count when they are attached
* Fixed an issue where the team profile could have an incorrect height after unlocking your device

## Version 3.0.2

26-07-2016

* Fixed an issue where Context objects could have their locale changed by the SDK
* Fixed an issue where the Messenger could be opened more than once from a push notification
* Update Support Library dependencies to `24.1.1`

## Version 3.0.1

22-07-2016

* Fixed an issue with real time messaging.
* Fixed an issue with launcher color being default color on first registration of a user on launch.
* Fixed an issue with passing attributes to a user registration which resulted in not updating the user after the * very first registration.
* Fixed an issue with failed text parts being treated like uploaded attachments.

## Version 3.0.0

21-07-2016

Our new Messenger is out of beta! You can read all about the updated design and new functionality [here](https://www.intercom.io/in-app-messaging).
If you are upgrading from an older version of our Messenger you may need to change some of the methods you used to call. You can see any changes you may need to make [here](https://docs.intercom.io/messenger-v3/upgrade-to-the-new-messenger-android).
Where is 2.x? We're skipping it. We did this to align the Android SDK with our iOS and web counter parts.

## Version 3.0.0-beta5

08-07-2016

### Changes in the API

How GCM is set up has been simplified. There is not longer a method `Intercom.client().setupGcm(token)` and  `Intercom.client().registerIdentifiedUser(Registration.create().withGcmRegistrationId(token));`

Instead of the methods above, in your res/values/strings.xml add the following line replacing YOUR_SENDER_ID. The sender is is in your google-services.json file as "project_number": "YOUR_SENDER_ID"

`<string name="intercom_gcm_sender_id">YOUR_SENDER_ID</string>`

### What's new

* We have added localization to the SDK. This can be set in your app settings https://app.intercom.io/a/apps/<YOUR_APP_ID>/settings/messenger
* We have updated our default launcher icon.

### Issues and bug fixes

* Fixed crashes in the photoviewer
* UI bugs and tweaks

## Version 3.0.0-beta4

14-06-2016

### Changes in the API

We no longer take a resource ID for the push notification icon. To set a push notification icon simply add an image named intercom_push_icon.png to your apps resource drawable directory. Its important to add this for all of the densities you support for example:
/res/drawable-xxhdpi/intercom_push_icon.png
/res/drawable-xhdpi/intercom_push_icon.png
/res/drawable-hdpi/intercom_push_icon.png
/res/drawable-mdpi/intercom_push_icon.png

This changes a couple of the public APIs in Intercom:

`Intercom.client().setupGcm(token, R.drawable.intercom_push_icon);`
becomes
`Intercom.client().setupGcm(token);`

`Intercom.client().registerIdentifiedUser(Registration.create().withGcmCredentials(token, R.drawable.intercom_push_icon));`
becomes
`Intercom.client().registerIdentifiedUser(Registration.create().withGcmRegistrationId(token));`

### What's new

* We added in a new message pill to let users know when they have recieved replies offscreen in the conversation thread they are viewing

### Issues and bug fixes

* We fixed an issue that could result in inflated session counts.


## Version 3.0.0-beta3

27-05-2016

### New methods in the API

The `Registration` object now has a `withGcmCredentials(String token, int logo)` that you can use to set a GCM token and push logo. `withGCMRegistrationId(String token)` has been removed in favour of this method. Setting a token without a logo is a poorer user experience as we'll have to use a generic default.

In the `Intercom` class we've introduced a new API method that intelligently opens the messenger to the correct location based on context the messenger is aware of and a users actions in your app. It can open to the conversations list, to an existing conversation, or to compose a new conversation, `void displayMessenger()`.

We've also corrected all methods that used `GCM` to be `Gcm`. This is a **breaking change**.



* Lazily instantiate much of the object graph the messenger needs to work. This will speed up your app startup time!
* More improvements to reduce overdraw in the messenger
* Performance improvements to how we were rendering messages. They render roughly 30-50% faster now.
* Removed permissions READ_EXTERNAL_STORAGE and MANAGE_DOCUMENTS. These permissions are optional for attachments. In most cases they are not required but certain OS and file provider combinations may fail to send the attachment without.
* Fixed a bug with push only messages not following an included URI correctly.
* Fixed a bug that was causing images to be cropped slightly in a chat style messages
* Fixed a memory leak that sometimes lead to threads not being garbage collected [issue#197](https://github.com/intercom/intercom-android/issues/197) and [issue#136](https://github.com/intercom/intercom-android/issues/136)

## Version 3.0.0-beta2

12-05-2016

* Fixed a crash that would occur if you sent 3+ manual messages to a user, opened your app, then sent another
* Hide the back arrow when coming from the conversation screen back to the conversations list
* Fixed the sizing for our FAB asset on the conversations list screen. It's more crisp now
* Removed a lot of overdraw from inside the conversations list
* Made some performance improvements to how we're rending messages

## Version 3.0.0-beta1

06-05-2016

We're skipping 2.x entirely. This is being done to align the iOS and Android versions of Intercom such that going forward we'll have similar major.minor patches for features. It's easier for all of us internally too if we can refer to something in a platform agnostic way (Messenger V3!) :)

### What's new

We’ve updated every pixel of our Messenger. The UI feels a lot more native, fluid and is more visually appealing while fitting into the visual aesthetic of your app better too.

Part of this involves a new Intercom Launcher that you can show in your app to let your users instantly access the Messenger.

### Dependencies

As part of the work to bring a better visual aesthetic to the Messenger we started using some new dependencies. Chief amongst these are the support libraries Google provides. This library now relies on:
 * `com.android.support:appcompat-v7:23.3.0`
 * `com.android.support:recyclerview-v7:23.3.0`
 * `com.android.support:design:23.3.0`

If you use these libraries in your project be aware that we plan to stay up to date with releases and this will, by default, transitively force your app to use these versions too.

We also added some dependencies that we're namespacing to avoid version conflicts and other conflicts:
 * `com.facebook.rebound:rebound:0.3.8` for nice spring animations
 * `com.github.bumptech.glide:glide:3.7.0` for gif support

And on top of that we've updated OkHttp and Retrofit to the 3.x and 2.x versions. These are also namespaced so that won't confict with anything in your code.

### New methods on the public interface

 * `void setLauncherVisibility(Visibility visibility)` will toggle whether the new Intercom launcher appears in your app. Valid parameters are `Intercom.Visibility.VISIBLE` and `Intercom.Visibility.GONE`. The default is `GONE`.
 * `void setInAppMessageVisibility(Visibility visibility)` will toggle whether in-app messages appear in your app when sent to a user. Valid parameters are `Intercom.VISIBLE` and `Intercom.GONE`. The default is `VISIBLE`.
 * `void hideMessenger()` will close the Intercom Messenger if it's onscreen. The typical use case we've seen for something like this is that an important event has happened in the background of your app (eg a user has taken 10,000 steps) and you need to display something immediately. We'd advise normally using an `Intent` to start your activity if that's possible within your app's architecture; we're accounting for the possibility that it isn't always possible with this method.
 * `int getUnreadConversationCount` will return the last known number of unread conversations that a user has.
 * `void addUnreadConversationCountListener(UnreadConversationCountListener listener)` lets you set a listener that will be notified every time the known conversation count for this user changes. For example, you may want to display a badge somewhere in your app that exposes to a user the number of unread conversations they have. Multiple listeners can be registered at a time. A **strong** reference is kept to each listener.
 * `void removeUnreadConversationCountListener(UnreadConversationCountListener listener)` removes this listener from the list that will be notified of unread conversation count updates.

### Removed methods from public interface

All deprecated methods have been dropped from Intercom, these include
  * `setMessagesHidden(boolean visibility)` in favour of two new visibility methods explained below
  * `openGCMMessage(Uri data)` in favour of `openGCMMessage(Intent intent)`

In addition some other methods have been dropped:
  * `setPreviewPosition` has been removed with no replacement
  * `setVisibility` has been removed in favour of `setLauncherVisibility` and `setInAppMessageVisibility`

### Miscellaneous
  * We've hidden our resources so you won't see all our layouts, colours etc when you're trying to reference your own resources

## Version 1.1.21

14-06-2016

Protect against crash if the image resource is not found [issue#198](https://github.com/intercom/intercom-android/issues/198).

## Version 1.1.20

02-06-2016

* Fixed an issue which can result in inflated session counts for both identified and unidentified users.

## Version 1.1.19

17-05-2016

* Removed permission VIBRATE. VIBRATE was used for push notifications. If it is included in the host app the push will still cause the default device vibration.
* Removed permissions READ_EXTERNAL_STORAGE and MANAGE_DOCUMENTS. These permissions are optional for attachments. In most cases they are not required but certain OS and file provider combinations may fail to send the attachment without.
* Fixed an issue with push only messages not following the URI correctly.

## Version 1.1.18

18-04-2016

* Checks that there are intents capable of opening links etc before opening them, fixes [issue#190](https://github.com/intercom/intercom-android/issues/190)
* Fixed an bug where apps running on Ice Cream Sandwich were unable to send attachments
* Fixed a bug that was causing us to generate a URL to communicate with the Intercom servers that doesn't conform with [rfc1123](https://www.ietf.org/rfc/rfc1123.txt) for a small number of people, more context in [issue#186](https://github.com/intercom/intercom-android/issues/186)

## Version 1.1.17

01-04-2016

* Update to fix remaining issues with registration [issue#181](https://github.com/intercom/intercom-android/issues/181)
* Made some permissions we use in the GCM module optional ("android.permission.READ_PHONE_STATE" and "android.permission.ACCESS_WIFI_STATE")
* Removed some unnecessary noisy logging when calling reset, fixes [issue#188](https://github.com/intercom/intercom-android/issues/188)
* Fixed a bug where the empty inbox list does not update when the user starts a new conversation for the first time.

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
