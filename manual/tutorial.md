# 实验一
# 中山大学智慧健康服务平台应用开发

---  

---
## 第三周任务
## 基本的UI界面设计
### 基础知识
Android的组件分为布局和控件。  
布局，就是让控件在里面按一定的次序排列好的一种组件，本身并不提供内容。  
控件，就是显示内容的组件，比如显示一张图片，显示文字等等。  
最基本也最常用的布局有以下四种：LinearLayout、RelativeLayout、TableLayout、FrameLayout。  
最常用的控件有以下几种：用于显示文字的 TextView、用于显示图片的ImageView、用于接受用户输入的输入框EditText、按钮Button、单选按钮RadioButton，等等。  

以下简要介绍本次实验使用到的组件。  
#### ConstraintLayout
约束布局，布局内组件按各种约束排列的布局。每个组件受到三类约束，即其他组件，父容器(parent)，基准线(GuideLine)。
约束布局代码可归纳为以下形式：  
  
**app:layout_constraint[组件本身的位置]_to[目标位置]Of="[目标id]"**  
  
例如
```javascript
    <Button
        android:id="@+id/btn0" />
    <Button
        android:id="@+id/btn1"
        app:layout_constraintLeft_toRightOf="@id/btn0" />
```
这一段代码便是将 btn1 按钮的左边界与 btn0 按钮的右边界进行对齐，效果如图  
 ![align](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/align.jpg) 

若想要组件水平居中，只需设置组件的左右边界与父容器的左右边界分别对齐。同理，组件的垂直居中也可以这么设置。  

当确定好一个组件的左右边界范围后，若这个组件的宽度设置为wrap_content，则该组件会在这个范围中居中显示，若宽度设置为0dp，则该组件会自动拉伸宽度，将这个边界范围全部占满。  
例如
```javascript
    <Button
        android:id="@+id/btn0" />
    <Button
        android:layout_width="0dp"
        android:id="@+id/btn1"
        app:layout_constraintLeft_toRightOf="@id/btn0"
        app:layout_constraintRight_toRightOf="parent" />
```
效果图  ![fill](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/fill.jpg) 

####TextView
用于显示文字内容的控件，通过设置 text 的值来显示要显示的内容，常用的属性有 textColor，用于设置文字的颜色，textSize，用于设置文字大小。  
```javascript
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" 
        android:textSize="20sp"
        android:textColor="@color/colorAccent"
        android:text="实验" />
```
效果图:
 ![test](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/test.jpg) 

关于@color/colorAccent 这种形式的资源引用后面会讲。
####EditText
用于接受用户输入的输入框，常用属性除了和 TextView 相同的 textColor 和 textSize 之外，还有inputType，用于设置输入框中文本的类型，如果设置为textPassword，会使输入的文字变为小点(·)，hint，用于设置当输入框为空时的提示内容。  
```javascript
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:hint="这是一个输入框" />
```
效果图:   ![edit](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/edit.jpg)  
#### ImageView
显示图片的控件，通过设置src来设置要显示的图片。  
```javascript
    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="20dp"
        android:src="@mipmap/sysu" />
```
 ![sysu](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/sysu.jpg)   
关于ImageView的src和background属性的区别，自行查阅资料。
#### RadioButton和RadioGroup
RadioButton是单选按钮，一组单选按钮需要包括在一个RadioGroup中，并且需要对RadioGroup和其包括的每一个RadioButton都设置 id，RadioButton 才能正常工作。   
可通过设置 checked 属性来使某个RadioButton被选中。  
```javascript
    <RadioGroup
        android:id="@+id/rb0"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <RadioButton
            android:id="@+id/rb1"
            style="@style/MyRadioButton"
            android:text="man" />

        <RadioButton
            android:id="@+id/rb2"
            style="@style/MyRadioButton"
            android:text="woman" />
            
    </RadioGroup>
```

组件的介绍就到这里，下面简单介绍以下几个重要的通用属性
#### layout_width和layout_height
这两个属性分别指定所属组件的宽度和高度，属性值可以是具体的距离，如：20dp，更常见的是指定为match_parent或者wrap_content，match_parent指的是组件的宽度或高度与父组件的宽度或高度一致，如果组件没有父组件，那么组件的宽度或高度与屏幕的宽度或高度一致。wrap_content指组件的宽度或高度刚好可以包裹住组件内的子组件即可。
#### layout_gravity和gravity
这两个属性的基本属性值有五种：top、bottom、center、left、right，可以使用组合属性，如left|bottom表示左下角。  
区别在于layout_gravity用于指定设置该属性的组件相对于父组件的位置，gravity用于指定指定设置该属性的组件下的子组件的位置。
#### layout_margin和padding
layout_margin指定外边距，padding指定内边距，这两个属性配合上四个方向还各有四个属性，如layout_marginTop，paddingTop等。
#### 关于自定义背景边框
当需要将一个button设置为圆角矩形时，光设置button的属性是达不到效果的，需要定义一个背景边框来达到这个效果。这种自定义的背景边框定义在 drawable 文件夹下，所以为了不把它和图片混杂在一起，习惯上把图片放在mipmap文件夹下。  
定义的方法如下：  
在drawable文件夹下新建一个Drawable resource file，填写file name，然后把自动生成的selector标签改为shape，shape下有多个属性，padding，radius，solid等等。圆角矩形的生成主要是修改corner属性，具体自行查阅资料。  

最后，在Button中设置background为@drawable/加上刚刚填写的文件名即可引用这个自定义的背景。

#### 如何在应用中显示布局
首先，需要在res/layout文件夹下写好布局文件，  
 ![tree1](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/tree1.jpg) 

然后创建一个java文件，在该文件中将布局引入，  
 ![tree2](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/tree2.jpg) 

然后在注册文件中注册，  
```javascript
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```
将该Activity设置为应用启动时第一个加载的Activity，
```javascript
    <activity android:name=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
    </activity>
```
然后就可以运行了。
### 拓展知识
#### 关于资源的引用
Android项目中不建议使用硬编码来使用资源，建议将各类资源定义在res文件夹中的values文件夹下，字符串资源定义在strings.xml中，颜色资源定义在colors.xml中，距离，字体大小资源定义在dimens.xml中。图片资源例外，是存放在res文件夹中的mipmap文件夹下或者drawable文件夹下。  

*示例colors.xml*
```javascript
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#3F51B5</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="colorWhite">#FFFFFF</color>
    <color name="colorBlack">#000000</color>
</resources>
```
通过键值对来定义，使用的时候用@color/colorAccent 即可引用到对应资源，注意是*@color*不是@colors，这里和文件名是不相同的。其它资源的引用也一样。
#### 关于自定义style
style定义在res/values/styles.xml文件中，也是一种资源。例如当多个TextView具有相同的layout_height，layout_width，textSize，textColor设定时，如果每次都要把这些属性设定一次会很烦，而且如果全部需要修改的话（改变字体大小）也不方便，因此可以把这些属性统一定义为一个style，这样使用的时候只要直接引用这个styl 即可。

*示例styles.xml*
```javascript
    <style name="myEditTextStyle">
        <item name="android:layout_width">match_parent</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:textColor">@color/colorPrimaryDark</item>
        <item name="android:textSize">@dimen/normal_size</item>
    </style>
```
一个自定义 style 下包含多个键值对，引用的时候设置 style=“@style/my_edittext_style”即可。在引用 style 之后，还可以继续定义属性，如果有重复，以重复定义的属性为准。

---

---

## 第四周任务
## 基础的事件处理
---
### 基础知识 
#### 在java文件中引用布局文件中的控件 
在上一次实验中，在onCreateView(Bundle savedInstanceState)方法中调用setContentView()方法将布局加载进来。如果需要用到布局中的某些控件的话，首先需要给控件一个id
```javascript
    <Button
        android:id="@+id/btn0"
        style="@style/MyButtonStyle"/>
```
定义 id 的语法和引用资源类似，@+id/id名称，在同一个布局文件中不允许有重复的id，即使是不同控件也不行，但是不同的布局文件中可以使用同一个id之后在java文件中将布局加载之后，也就是setContentView()之后，使用findViewById()方法可以获得该控件：
```javascript
    Button btn0 = (Button) findViewById(R.id.btn0);
```
findViewById()方法带一个参数，就是刚刚定义的那个id，参数形式为R.id.XXX，其中XXX 就是刚刚定义的那个 id，由于 findViewById()方法返回的是一个View类型，所以需要强制类型转换为Button类型。获得这个 Button 之后，就可以对这个 Button 进行后续的操作了。

#### 弹出Toast信息
在需要弹出Toast信息的地方，写上：
```javascript
    Toast.makeText(MainActivity.this, "A Toast", Toast.LENGTH_SHORT).show();
```
这个方法带三个参数，context，text，duration。  
context是一个上下文类型，写上使用这个方法的 java 类名加上.this即可;  
text是Toast要显示的信息；
duration是Toast显示的时间长度，有Toast.LENGTH_SHORT和Toast.LENGTH_LONG可选，最后记得调用show()方法将Toast显示出来。

#### 事件处理
此次实验用到的事件处理方法一共两个，一个是Button的单击事件，button.setOnClickListener()，一个是RadioGroup的切换事件，radioGroup.setOnCheckedChangeListener()，下面以Button为例简单介绍一下事件处理。  
要处理事件，首先要将与该事件有关的控件引入进来，比如要判断搜索内容是否为空，那么除了Button需要引入外（因为Button是触发事件的主体），还需要引入搜索内容的输入框。  
引入之后，button.setOnClickListener()中做处理，这里的button是一个变量名，记得换成自己定义的变量名。
```javascript
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //事件处理
        }
    });
```
onClick方法带的view参数是触发这个单击事件的控件的引用，在这个例子中，view就是触发事件的Button，在onClick()方法中做事件的处理，例如判断搜索内容是否为空：
```javascript
Button button = (Button) findViewById(R.id.btn0);
EditText searchContent = (EditText) findViewById(R.id.search);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(TextUtils.isEmpty(searchContent.getText().toString())) {
            Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_SHORT).show();
        }
    }
});
```
#### 简单对话框的使用
Android 中最基本的对话框是AlertDialog，之所以说它最简单，是因为布局和使用的方法都很简单，布局是写好的。  
标题，通过 setTitle()方法设置；  
图标，通过 setIcon()方法设置；  
显示在中间的主要信息，通过setMessage()方法显示，等等。  

显示一个AlertDialog 的基本步骤如下：  
1. 创建AlertDialog.Builder对象；  
2. 调用上面的方法进行设置；  
3. 如果需要设置取消按钮，方法原型如下：
```javascript
setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //点击后的事件处理
            }
        })
```
确定按钮怎么设置自行查阅资料。  
4. 调用AlertDialog.Builder的create()方法创建AlertDialog对象，再调用AlertDialog对象的show()方法将对话框显示出来。

### 拓展知识
有兴趣的同学可以查阅Snackbar,TextInputLayout这两个控件的使用方法。

