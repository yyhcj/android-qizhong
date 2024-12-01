# 期中作业
## 添加时间戳
1. 修改布局文件：将notelist.item.xml文件改为
   `<?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
   android:layout_width="match_parent"
   android:orientation="horizontal"
   android:layout_height="match_parent">

   <TextView xmlns:android="http://schemas.android.com/apk/res/android"
   android:id="@android:id/text1"
   android:layout_width="0dp"
   android:layout_weight="1"
   android:layout_height="?android:attr/listPreferredItemHeight"
   android:textAppearance="?android:attr/textAppearanceLarge"
   android:gravity="center_vertical"
   android:paddingLeft="5dip"
   android:singleLine="true" />

   <TextView xmlns:android="http://schemas.android.com/apk/res/android"
   android:id="@+id/text_time"
   android:layout_width="0dp"
   android:layout_weight="1"
   android:layout_height="?android:attr/listPreferredItemHeight"
   android:textAppearance="?android:attr/textAppearanceLarge"
   android:gravity="center_vertical"
   android:paddingLeft="5dip"
   android:singleLine="true" />

</LinearLayout>`
加了一个时间的textview
2. 修改传输的数据
在notelist.java中修改这段代码
`        String[] dataColumns = { NotePad.Notes.COLUMN_NAME_TITLE,NotePad.Notes.COLUMN_NAME_CREATE_DATE } ;

        // The view IDs that will display the cursor columns, initialized to the TextView in
        // noteslist_item.xmltry / catch
int[] viewIDs = { android.R.id.text1, R.id.text_time };`
3. 将时间格式化

