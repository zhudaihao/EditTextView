package cn.zdh.edittextview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.ziyeyouhu.library.KeyboardTouchListener;
import com.ziyeyouhu.library.KeyboardUtil;

import cn.zdh.edittextview.view.ClearEditText;

public class MainActivity extends AppCompatActivity {
    private KeyboardUtil keyboardUtil;
    private LinearLayout ll_layout;
    private ScrollView scroll_view;
    private EditText editText, et_2;
    private ClearEditText et_3;

    /**
     * 注意ScrollView布局
     * android:layout_width="match_parent"
     * android:layout_height="0dp"
     * android:layout_weight="1"
     *
     * 如果想 刚进activity不显示键盘 在manifest的activity设置下面几个属性
     *
     *             android:screenOrientation="portrait"
     *             android:windowSoftInputMode="stateHidden|adjustPan"
     *             android:launchMode="singleTask"
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_layout = findViewById(R.id.ll_layout);
        scroll_view = findViewById(R.id.scrollView);
        editText = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);
        et_3 = findViewById(R.id.et_3);


        keyboardUtil = new KeyboardUtil(this, ll_layout, scroll_view);
        keyboardUtil.setOtherEdittext(editText);
        keyboardUtil.setOtherEdittext(et_2);
        keyboardUtil.setOtherEdittext(et_3);

        editText.setOnTouchListener(new KeyboardTouchListener(keyboardUtil, KeyboardUtil.INPUTTYPE_ABC, -1));
        // et_2.setOnTouchListener(new KeyboardTouchListener(keyboardUtil, KeyboardUtil.INPUTTYPE_ABC, -1));
        et_3.setOnTouchListener(new KeyboardTouchListener(keyboardUtil, KeyboardUtil.INPUTTYPE_NUM, -1));

        //键盘监听
        keyboardUtil.setInputOverListener(new KeyboardUtil.InputFinishListener() {
            @Override
            public void inputHasOver(int onclickType, EditText editText) {

            }
        });


    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//            if (keyboardUtil.isShow) {
//                keyboardUtil.hideSystemKeyBoard();
//                keyboardUtil.hideAllKeyBoard();
//                keyboardUtil.hideKeyboardLayout();
//            } else {
//                return super.onKeyDown(keyCode, event);
//            }
//
//            return false;
//        } else
//            return super.onKeyDown(keyCode, event);
//    }


}
