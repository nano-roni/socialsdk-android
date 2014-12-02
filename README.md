socialsdk-android
=================
i was tired of looking for good and easy made integrations,so i decided to create my own good one.
it uses facebook,google+,twitter and linkedin,there is option to add more social services.

GETTING STARTED!

Stage 1:

First of all, you need to register your application, please check this links: Facebook, Twitter, LinkedIn, GooglePlus.
at the links:
twitter- "http://twitter.com/apps"
facebook- "https://developers.facebook.com/apps"
linkedin- "http://developer.linkedin.com/"
google- "https://code.google.com/apis/console#access"

for more info how to register those services you can find here:

twitter- "https://github.com/3pillarlabs/socialauth-android/wiki/Guide-Twitter"
facebook= "https://github.com/3pillarlabs/socialauth-android/wiki/Guide-Facebook
google+= "https://github.com/3pillarlabs/socialauth-android/wiki/Guide-Google-Plus"
linkedin= "https://github.com/3pillarlabs/socialauth-android/wiki/Guide-Linkedin"

Stage 2:

Launch Eclipse.
Select File > Import > Android > Existing Android Code Into Workspace and click Next.
Select Browse....
select the project destination and finish.

Right Click Project > Properties. The project properties dialog displays.
Select Android, click Add. Choose the appcompat v7.

"make sure your app compat v7 is good, because sometimes its bugy for no reason"
if one of the values folder have red cross its mean that your app compat v7 is bugy
and not supported for this app" you can download the good one appcompat here:
"https://github.com/koush/android-support-v7-appcompat"

Stage 3 the most important Stage:

go to the app,go to mainactivity.class.
copy the code exactly as it is from the oncreate function
to your private app in your oncreate function, dont forget to copy the
"SocialAuthAdapter adapter;" to the class
dont forget to change the setcontentViews of the functions.and names of the acivities in the functions.
the setcontentview that located in the onComplete function is the content View that u will
see after successful logging.
go to res/layout and login_activity.xml.
copy from line 11 to line 67 to your app xml.
and copy the drawable-mdpi folder to your apps to.
copy the assets folder to your app.
go to your androidmanifest.xml
and add those lines lines below the uses-sdk lines:
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>

copy the libs folder to your app.

and your good to go... test the app..

to change to app keys go to assets folder and to oath_consumer.properties.

for now u can only logging to the app but u cannot sign out..
i will add this option in next version.

thanks for using my modified library.
