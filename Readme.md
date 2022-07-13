# <image src="./app/src/main/res/drawable/icon.png" width="30"/> One Click

## 개발 팀원
- KAIST 새내기과정학부 김지나
- POSTECH 컴퓨터공학과 변민우

<br>

## 개발 환경
Client)
- OS: Android (minSdk: 26, targetSdk: 32)
- Language: Java
- IDE: Android Studio
- Target Device: Galaxy S7

Server)
- Stack: Nodejs
- Language: javascript
- Framework: Express
- DataBase: Mysql

<br>

## 앱 소개
One Click App은 연락처, 갤러리, 알람 기능을 가지고 있는 기본적인 앱이다. <br>
하단 3개의 탭을 통해 연락처, 갤러리, 알람 기능에 접근할 수 있다.
<br>

### 탭 1 . Contacts
<div>
<image src="./app/src/main/res/drawable/tab_phone_1.jpg" width="200"/>
<image src="./app/src/main/res/drawable/tab_phone2.jpg" width="200"/>
</div>


+ 앱을 실행하면 가장 먼저 뜨는 탭을 연락처 탭으로 설정한다.
+ 동기화 버튼을 클릭하면 `ListView`를 활용해 주소록에서 불러온 연락처를 보여준다.
+ "+" 버튼을 눌러주면 주소록 연락처 추가 앱으로 넘어가 연락처 추가가 가능하다.
+ (`HomeFragment` -> `ClickActivity`)
  + 각 목록을 클릭하면 `ClickActivity`로 넘어가게 되고, 이때 `HomeFragment`로부터 받은 name, number을 띄워준다.
  + 전화 버튼을 클릭하면 number가 전화 앱으로 넘어가고, 해당 번호로 전화가 가능하다.
  + 문자 버튼을 클릭하면 number가 문자 앱으로 넘어가고, 해당 번호로 문자가 가능하다.

<br>

### 탭 2 . Gallery
<div>
<image src="./app/src/main/res/drawable/tab_gallery_1.jpg" width="200"/>
<image src="./app/src/main/res/drawable/tab_fullscreen.jpg" width="200"/>
</div>


- 휴대폰 갤러리에서 사진을 가져와 목록을 구성한다.
- "+" 버튼을 클릭하면 휴대폰 갤러리에 접근할 수 있으며, 동시에 여러장을 선택하여 가져와 GridView를 이용하여 2 Columns로 보여준다.
- 불러온 사진을 클릭하면 Intent를 통해 `FullScreenActivity`를 실행하여 Full Screen을 볼 수 있다.
- 이미지를 추가하면 기존에 있던 이미지에 append 되어 추가 된다.
<br>
 

<br>

### 탭 3 . Alarm
<div>
<image src="./app/src/main/res/drawable/tab_alarm.jpg" width="200"/>
<image src="./app/src/main/res/drawable/alarm_check.jpg" width="200"/>
</div>

- 알람을 설정하고 알람이 울린 이후 알람을 끌 수 있다.
- 시간을 설정한 후 저장 버튼을 클릭하면, 하단에 알림창이 뜨고, 해당 시간에 알람이 울린다.
- 종료 버튼을 클릭하면, 알람을 끌 수 있다.

<br>

- `Notification` 과 `AlarmManager`을 이용하여 알림을 set하였다.
- AlarmReceiver class에서 `onReceive` method를 이용하여 알림을 notify하였다.

<br>


* * *
### Permission

전화 - 연락처 탭에서 특정 사람을 클릭한 후, 전화 버튼을 클릭했을 때, 전화 앱과 연동하기 위해 필요하다.
<br>


주소록 - 동기화 버튼을 클릭하면 주소록에 저장되어 있는 연락처들을 불러오기 위해 필요하다.

