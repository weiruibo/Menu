package cn.edu.gdmec.w07150837.mymenudemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.textView1));
    }


    @Override
    //选项菜单
    public boolean onCreateOptionsMenu(Menu menu) {

        /*
            使用布局文件 设置选项菜单

            MenuInflater menuif=getMenuInflater();
            menuif.inflate(R.menu.menu,menu);

         */


        /*

            直接添加字符串

             menu.add("菜单一");
             menu.add("菜单二");
             menu.add("菜单三");

         */

        //使用资源文件添加
        menu.add(0, 1, 0, R.string.item1);
        menu.add(0, 1, 0, R.string.item2);
        menu.add(0, 1, 0, R.string.item3);

        SubMenu subMenu = menu.addSubMenu(1, 1, 0, R.string.about);
        subMenu.add(1, 1, 0, R.string.about);
        subMenu.add(1, 3, 0, R.string.exit);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    //每次菜单显示前调用的方法
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.add("新增菜单");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    //选项菜单触发事件
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == 3) {
            Toast.makeText(this, "你按了退出按钮", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    //上下文菜单
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0, 1, 0, R.string.item1);
        menu.add(0, 1, 0, R.string.item2);
        menu.add(0, 1, 0, R.string.item3);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    //上下文菜单选中事件
    public boolean onContextItemSelected(MenuItem item) {

        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }


}
