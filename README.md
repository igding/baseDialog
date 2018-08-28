# BaseDialogFragment

基于DialogFragment的封装： [（研发中）](https://github.com/igding/baseDialog/tree/master)

## 引用方式 :

> **compile 'com.ding:basedialog:1.0.1'

## apk效果图
![basedialog.gif](https://upload-images.jianshu.io/upload_images/3117705-c7ce37b5fcd0c7d0.gif?imageMogr2/auto-orient/strip)

## apk下载
![](https://upload-images.jianshu.io/upload_images/3117705-b0f639b0e92df3eb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


## 框架思路简介
    常规的dialog和popuwindow的区别和弊端这里不做过多解释
    有兴趣的同学可以在网上找相应资料学习一下。
  
```
1.本库采用的是Google推荐的dialogFragment实现。
2.该库最大的特点在于，不会提供任何实现，而是给予一个架构思路。
3.demo中已有讲解实现方式，可以完美的解耦view，model和presenter，也足以解决开发者大部分业务场景
4.目前demo还比较简单，打算在后面丰富demo的功能，日后如遇到一些特别的业务时能有一个参考。
```
   
建议开始使用本框架前仔细阅读所有文档 ( 除版本更新日志和混淆相关外）

##  1.BaseDialog属性方法说明
  
    tag: 作为bundle的key，和Fragment的tag，可以共用一个

    isBack：如果dialog不可点击外部，同时需要点击back键 消失，则可以设置为true。

    newInstance是Fragment的基本使用方式，不作讲解

    设置style: 只能在onstart生命周期进行处理,如有特殊需要，则参考share类

    h:  dialog高度(为了适配，直接设置的屏幕宽高的比例。目前暂时没有考虑横竖屏的情况，之后会加上)
    w:  dialog宽度

    gravity: dialog弹出方向

    initView: 初始化布局和查找控件以及设置点击事件

    getLayoutId: 代表设置布局id

    show: 重写show方法的目的 就是为了让tag和bundle的key保持一致。

## 2.生命周期
newInstance先执行，其次show方法执行完之后，才执行Fragment的生命周期

## 3.常见问题汇总

### 3.1.什么功能都不提供，那我为什么要使用这个库？
     a.其的好处在于替换传统的dialog和popupwindow
     b.为了架构的可扩展性，所以该库本身并没有封装太多功能，仅仅提供了基本的架构。
       因为使用者具体的样式，布局，业务，我无从得知。而且我也不需要知道。
     c.参照demo，足以解决大部分业务场景(待完善)，包括对dialog本身的管理以及布局的统一管理

### 3.2. 我怎么设置style和弹出的方向？
      注释都有讲解。
      常规操作，可参考login。
      指定方向弹出，设置专门的style，可参考share。

### 4.混淆规则示例

```
#---------------------------------默认保留区---------------------------------
-keep public class * extends android.app.Activity
-keep public class * extends android.view.View
-keep class android.support.** {*;}

-keep class **.R$* {
 *;
}

#保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keep class [com.igding.basedialog].** { *; }

# support-v4
#https://stackoverflow.com/questions/18978706/obfuscate-android-support-v7-widget-gridlayout-issue
-dontwarn android.support.v4.**
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v4.** { *; }

# support-v7
-dontwarn android.support.v7.**
-keep class android.support.v7.internal.** { *; }
-keep interface android.support.v7.internal.** { *; }
-keep class android.support.v7.** { *; }
```

[我的博客](https://igding.github.io/)


交流群:275885217  入群密码:mvp