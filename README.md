AppUtility
=====

[![](https://jitpack.io/v/Vedgaur07/AppUtility.svg)](https://jitpack.io/#Vedgaur07/AppUtility)

APpUtility library is define all type base classes for a project setup. This library is very helpful for validation and code customized and also use as reuseable and biolerplate code.

Download
--------

Use Gradle:

```gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.Vedgaur07:AppUtility:Tag'
}
```

Or Maven:

```xml
<dependency>
    <groupId>com.github.Vedgaur07</groupId>
    <artifactId>AppUtility</artifactId>
    <version>Tag</version>
</dependency>
```


### 1. .Android foundation tool class

| Android Basic Tools class |                                                                |     |     |
| ------------------ | -------------------------------------------------------------- | --- | --- |
| AppUtils          | AppUtils class used for basic app related fuctions like app share, Check app in background etc. |  [AppUtils][1]   |     |
| CheckInternetConnection              | Check Internet connectivity for the application. |   [CheckInternetConnection][2]   |     |
| DateUtils              | All type of date formating and convert into TimeZone etc. |   [DateUtils][3]   |     |
| DisplayHelper              |  |   [DisplayHelper][4]   |     |
| DownloadFileManagerUtils              | Download request of any file. |   [DownloadFileManagerUtils][5]   |     |
| GridSpacingItemDecoration              | Grid decoration in recycler view |   [GridSpacingItemDecoration][6]   |     |
| HeightProvider              | Get the height of view and resolve in keyboard opening related issue. |   [HeightProvider][7]   |     |
| ImageUtils              | Set image in image view and customize drawale with color, shape, gradient etc. |   [ImageUtils][8]   |     |
| KeyboardUtils              | Keyboard show and hide handler. |   [KeyboardUtils][9]   |     |
| LocaleHelper              | Locality setup for app with defined language. |   [LocaleHelper][10]   |     |
| PaginationScrollListener              | Setup pagination on recycler view scrolling. |   [PaginationScrollListener][11]   |     |
| ScrollingLinearLayoutManager              | Scrolling layout manager for recycler scrolling. |   [ScrollingLinearLayoutManager][12]   |     |
| StatusBarUtils              | Customize status bar with color and visibility with custom color. |   [StatusBarUtils][13]   |     |
| StringHelper              | All type of string ralated validation, formatting etc. in this class. |   [StringHelper][14]   |     |
| ValidationUtils              | Validation for email, mobile, url and phone number. |   [ValidationUtils][16]   |     |
| ViewPagerCustomDuration              | View pager custoize with some animation and smoothly change page. |   [ViewPagerCustomDuration][17]   |     |



[1]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/AppUtils.java
[2]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/CheckInternetConnection.java
[3]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/DateUtils.java
[4]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/DisplayHelper.java
[5]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/DownloadFileManagerUtils.java
[6]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/GridSpacingItemDecoration.java
[7]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/HeightProvider.java
[8]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/ImageUtils.java
[9]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/KeyboardUtils.java
[10]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/LocaleHelper.java
[11]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/PaginationScrollListener.java
[12]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/ScrollingLinearLayoutManager.java
[13]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/StatusBarUtils.java
[14]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/StringHelper.java
[15]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/TextUtils.java
[16]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/ValidationUtils.java
[17]:https://github.com/Vedgaur07/AppUtility/blob/master/AppUtilityLibrary/src/main/java/com/android/apputilitylibrary/utils/ViewPagerCustomDuration.java
