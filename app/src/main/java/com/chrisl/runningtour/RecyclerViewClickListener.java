package com.chrisl.runningtour;

import android.view.View;

//interface which modifies the normal onClick method to add in the
//position of the on click

public interface RecyclerViewClickListener {
    void onClick(View view, int position);

}
