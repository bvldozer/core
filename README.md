# CORE
cartenz android framework
framework ini digunakan sebagai core aplikasi android pada perusahaan Cartenz Technology Indonesia, meliputi
1. cartenz
2. design
3. helper
4. kotlin

# 1. cartenz
Core dari aplikasi cartenz
* CartenzApp sebagai base application semua aplikasi cartenz
* Dictionary sebagai kamus untuk berkomunikasi dengan cartenz-apicore
* API core mengunakan rx-retrofit yang telah dimodifikasi sesuai format cartenz-apicore

# 2. design
base design cartenz : image, textview, button, pageindicator, custom-widget
* Image : circleimageview, imagehelper ( glide ), ImageViewMeasurement
* PageIndicator : CirclePageIndicator
* TextLayout : CustomTextInputEditText, CustomTextInputLayout
* Wizard
* AlertDialogFragment
* EndlessScrollView
* FixAppBarLayoutBehavior ( fix bug for nestedscrollvview with AppBarLayout )
* UnitHelper ( dp to px, px to dp )
* WidgetUtils : editTextIsEmpty(EditText editText, String error), spinnerIsEmpty(Spinner spinner, int notSelectedPosition, TextView textError, String error), disableView(View view),enableView(View view)

# 3. helper
* CheckPermission : check(List requestList) : CAMERA, NETWORK, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, READ_PHONE_STORAGE, LOCATION, VIBRATE
* CurrencyHelper
* DateHelper
* FileUtils
* HelperUtils : dpToPx, hideKeyboard, isMyServiceRunning, getGenerateId
* PrefHelper

# 4. kotlin
berisi base untuk aplikasi yang meliputi
* BaseActivity
* BaseFragment
* BasePresenter
* BaseSubscriber
* BaseView

# Cara Pakai
"com.github.pratamacartenz.core:design:$rootProject.cartenzcore"
"com.github.pratamacartenz.core:cartenz:$rootProject.cartenzcore"
"com.github.pratamacartenz.core:helper:$rootProject.cartenzcore"
"com.github.pratamacartenz.core:kotlin:$rootProject.cartenzcore"

# Change Log
* 0.1.5
  - squircle
  - textlayout
  - delete utils-widget
  
* 0.1.4
  - fileutils
  - fix bug basesubscriber
  - create example kotlinapp
 
* 0.1.3
  - create module cartenz

* 0.1.2
  - create module helper and design

* 0.1.1
  - standardization library

* 0.1.0
  - modular

  
# Contributors
- Pratama Budiman Hakim : pratamax@gmail.com
- Adi Rahman : rahmanadi9@gmail.com
- ikhwan : ikhwan220397@gmail.com



