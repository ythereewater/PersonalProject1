#实验一
#中山大学智慧健康服务平台应用开发

---  

---
##第三周任务
##基本的UI界面设计

---

###实验目的
   1. 熟悉Android Studio开发工具操作。  
   2. 熟悉Android Studio基本UI开发，并进行UI基本设计。
   
---

###实验内容
实现一个Android应用，界面呈现如图中的效果。  
 ![index](https://github.com/linwh8/ModernWebPrograming/raw/master/My_image/recipe_index.png) 
####要求  
* 该界面为应用启动后看到的第一个界面。  
* 各控件的要求
   1. 标题字体大小**20sp**，与顶部距离**20dp**，居中；
   2. 图片与上下控件的间距均为**20dp**，居中；  
   3. 输入框整体距左右屏幕各间距**20dp**，内容（包括提示内容）如图所示，内容字体大小**18sp**；  
   4. 按钮与输入框间距**10dp**，文字大小**18sp**。按钮背景框左右边框与文字间距**10dp**，上下边框与文字间距**5dp**，圆角半径**180dp**，背景色为**#3F51B5**；  
   5. 四个单选按钮整体居中，与输入框间距10dp，字体大小**18sp**，各个单选按钮之间间距**10dp**，默认选中的按钮为第一个。

####使用的组件
TextView、EditText、ConstraintLayout、Button、ImageView、RadioGroup、RadioButton。 

---

###验收内容
* 各控件的位置，间距，字体大小等属性与要求无误
* 图片大小不作为验收内容给之一

---

---
##第四周任务
##基础的事件处理
---
###实验目的
   1. 了解Android编程基础。  
   2. 熟悉Button、RadioButton、EditText等基本控件，能够处理这些控件的基本事件。
   3. 学会弹出对话框，并定制对话框中的内容，能对确定和取消按钮的事件做处理。
   
---

###实验内容
实现一个Android应用，界面呈现如图中的效果。  

![preview](https://gitee.com/code_sysu/PersonalProject1/tree/master/manual/images/preview.jpg)  
####要求  
* 该界面为应用启动后看到的第一个界面。  
* 各控件处理的要求
   1. 点击搜索按钮：
      * 如果搜索内容为空，弹出Toast信息“**搜索内容不能为空**”。
      * 如果搜索内容为“Health”，根据选中的RadioButton项弹出如下对话框。  
![preview](https://gitee.com/code_sysu/PersonalProject1/tree/master/manual/images/success.jpg)  
点击“确定”，弹出Toast信息——**对话框“确定”按钮被点击**。  
点击“取消”，弹出Toast 信息——**对话框“取消”按钮被点击**。  
否则弹出如下对话框，对话框点击效果同上。  
![preview](https://gitee.com/code_sysu/PersonalProject1/tree/master/manual/images/fail.jpg)  
   2. RadioButton选择项切换：选择项切换之后，弹出Toast信息“**XX被选中**”，例如从图片切换到视频，弹出Toast信息“**视频被选中**”  

---

###验收内容
* 布局是否正常
* 搜索内容为空时，提示是否正常
* 输入搜索内容后，点击搜索按钮是否能根据不同的搜索内容显示相应的弹出框，以及弹出框内容是否符合要求
* 点击弹出框的相应按钮是否能提示正确的内容
* RadioButton切换时，提示是否正常