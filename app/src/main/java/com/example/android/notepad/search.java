package com.example.android.notepad;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
public class search extends ListActivity {
    private static final String TAG = "NotesList";
    private static final String[] PROJECTION = new String[] {
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_TYPE
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        // 获取ListView实例，注意这里使用的是android:id/list这个id来获取，符合ListActivity要求
        ListView listView = (ListView) findViewById(android.R.id.list);
        String selection = NotePad.Notes.COLUMN_NAME_TYPE + ">1)" + "GROUP BY (" + NotePad.Notes.COLUMN_NAME_TYPE;

        String[] selectionArgs = {};

        Cursor cursor = managedQuery(
                NotePad.Notes.CONTENT_URI,
                PROJECTION,
                selection,
                selectionArgs,
                NotePad.Notes.DEFAULT_SORT_ORDER
        );
        // 定义要显示的字段数组，这里只显示NotePad.Notes.COLUMN_NAME_TYPE字段，你可根据需求添加其他字段
        String[] dataColumns = {NotePad.Notes.COLUMN_NAME_TYPE};
        // 对应的布局文件（用于定义ListView的列表项样式）中控件id数组，这里假设布局中显示该字段的TextView的id是R.id.typeitem（如果使用前面创建的新布局文件，就是对应新布局里的id）
        int[] viewIDs = {R.id.typeitem};

        // 创建SimpleCursorAdapter，将查询到的Cursor数据与ListView的列表项布局进行绑定
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_item_type,  // 如果创建了新布局文件，就替换为新布局的资源ID；如果没创建就使用原布局里的默认样式（不过原布局需确保有对应id的控件）
                cursor,
                dataColumns,
                viewIDs
        );

        // 将适配器设置给ListView，这样ListView就能显示查询到的数据了
        listView.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.button_search);
        ListView listView1= (ListView) findViewById(android.R.id.list);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 通过position获取被点击项对应的视图（这里假设每一项布局中有一个id为typeitem的TextView用于展示文本）
                TextView textView = (TextView) view.findViewById(R.id.typeitem);
                if (textView!= null) {
                    String text = textView.getText().toString();
                    // 这里就获取到了被点击项中TextView的文字内容，可以进行后续操作，比如打印或者传递给其他方法等
                    Intent intent = new Intent(search.this,NotesList.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("message",text);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText_search);
                final String message = String.valueOf(editText.getText());

                Intent intent = new Intent(search.this,NotesList.class);
                Bundle bundle = new Bundle();
                bundle.putString("message",message);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
