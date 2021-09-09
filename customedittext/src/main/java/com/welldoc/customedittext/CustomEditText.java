package com.welldoc.customedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.welldoc.customedittext.databinding.CustomEditTextLayoutBinding;

public class CustomEditText extends ConstraintLayout {
    private final CustomEditTextLayoutBinding binding;
    private Context context;
    @Nullable
    private AttributeSet attrs;

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        binding = CustomEditTextLayoutBinding.inflate(LayoutInflater.from(context), this, true);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomEditTextLayout, 0, 0);
        binding.textInputLayout.setHint(a.getString(R.styleable.CustomEditTextLayout_title));
        if (a.getBoolean(R.styleable.CustomEditTextLayout_editable, false)) {
            binding.tvEdit.setVisibility(GONE);
        } else {
            binding.tvEdit.setVisibility(VISIBLE);
        }
        a.recycle();

    }
}
