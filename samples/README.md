#### Responsible Team: Team Messenger

# Intercom Android SDK Samples

## Intercom Sample

### Setting Up
This is set of sample applications which show how to integrate Intercom in a simple app. To try a sample you will need to add your API key and app ID to the `SampleApplication` class in that sample. If you have enabled [Identity Verification](https://docs.intercom.com/configure-intercom-for-your-product-or-site/staying-secure/enable-identity-verification-on-intercom-for-android) you will need to provide a HMAC for your user too.
 
#### Push notifications with GCM

If you want to use GCM notifications in the `gcm_sample` app then put your `sender_id` (project number in google-services.json)
in the `strings.xml` file inside the tag `intercom_gcm_sender_id`:

```xml
<string name="intercom_gcm_sender_id">{your sender ID}</string>
```

#### Push notifications with FCM

If you want to use FCM notifications in the `fcm_sample` app then:

1. Follow the steps [here](https://firebase.google.com/docs/android/setup#add_firebase_to_your_app) to setup Firebase in your app and download your `google-services.json` file
2. Copy the `google-services.json` file into the `fcm-sample` directory in this repo
3. Go to `https://console.firebase.google.com/project/[YOUR_GOOGLE_APP]/settings/cloudmessaging`
   and copy the server key.
4. Go to `https://app.intercom.com/a/apps/[YOUR_INTERCOM_APP_ID]/settings/android` and enable GCM by adding the
   server key from the previous step.

### Usage
1. Build and run one of the apps
2. Go to [`https://app.intercom.com/a/apps/[YOUR_INTERCOM_APP_ID]/users/segments/active`](https://app.intercom.com/a/apps/[YOUR_INTERCOM_APP_ID]/users/segments/active)
3. Find the user named `123456` and send them a message.
4. The unread badge on the **Chat with us** button will update and the in app notification will arrive
5. Tap the **Chat with us** button to open the Messenger

### Troubleshooting
- Add `Intercom.setLogLevel(Intercom.LogLevel.VERBOSE);` before the `Intercom.initialize(...);` call in `SampleApplication`. Set your logcat viewer filter to Verbose and check for any errors or warnings.
- If you have any issues then talk to us through the Messenger on [our site](https://www.intercom.com/).
