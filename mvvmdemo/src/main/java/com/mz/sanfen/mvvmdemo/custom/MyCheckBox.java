package com.mz.sanfen.mvvmdemo.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;

import com.mz.sanfen.mvvmdemo.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/10/17.
 */

public class MyCheckBox extends CheckBox {
    public MyCheckBox(Context context) {
        this(context, null);
    }

    public MyCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyCheckBox);

        int indexCount = ta.getIndexCount();

        for (int i = 0; i < indexCount; i ++){
            int attr = ta.getIndex(i);
            switch (attr){
                case R.styleable.MyCheckBox_onCheckChange:
                    if (context.isRestricted()) {
                        throw new IllegalStateException("The "+getClass().getCanonicalName()+":onKeyLongPress attribute cannot "
                                + "be used within a restricted context");
                    }

                    final String handlerName = ta.getString(i);

                    if (handlerName != null){
                        setOnLongClickListener(new OnLongClickListener() {

                            private Method mHandler;

                            @Override
                            public boolean onLongClick(View view) {

                                boolean result = false;
                                try {
                                    if (mHandler == null){
                                        mHandler = getContext().getClass().getMethod(handlerName, View.class);
                                    }
                                } catch (NoSuchMethodException e) {
                                    int id = getId();
                                    String idText = id == NO_ID ? "" : " with id '"
                                            + getContext().getResources().getResourceEntryName(
                                            id) + "'";
                                    throw new IllegalStateException("Could not find a method " +
                                            handlerName + "(View) in the activity "
                                            + getContext().getClass() + " for onKeyLongPress handler"
                                            + " on view " + MyCheckBox.this.getClass() + idText, e);
                                }

                                try {
                                    mHandler.invoke(getContext(), MyCheckBox.this);
                                    result = true;
                                } catch (IllegalAccessException e) {
                                    throw new IllegalStateException("Could not execute non "
                                            + "public method of the activity", e);
                                } catch (InvocationTargetException e) {
                                    throw new IllegalStateException("Could not execute "
                                            + "method of the activity", e);
                                }

                                return result;
                            }
                        });
                    }

                    break;
            }


        }


        ta.recycle();






    }





}
