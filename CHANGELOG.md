# Change Log

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