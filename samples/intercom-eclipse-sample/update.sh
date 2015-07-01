#!/bin/sh

cd appcompat_v7/
android update project -p .
cd ../google-play-services_lib
android update project -p .
cd ..

android update project -p .  -s -t android-22