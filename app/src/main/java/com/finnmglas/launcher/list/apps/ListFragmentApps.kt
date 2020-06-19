package com.finnmglas.launcher.list.apps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.finnmglas.launcher.R
import com.finnmglas.launcher.UIObject
import com.finnmglas.launcher.list.intention
import com.finnmglas.launcher.list.forApp
import com.finnmglas.launcher.dominantColor
import com.finnmglas.launcher.getSavedTheme
import kotlinx.android.synthetic.main.list_apps.*


/**
 * The [ListFragmentApps] is used as a tab in ListActivity.
 *
 * It is a list of all installed applications that are can be launched.
 */
class ListFragmentApps : Fragment(), UIObject {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_apps, container, false)
    }

    override fun onStart() {
        super<Fragment>.onStart()
        super<UIObject>.onStart()
    }

    override fun applyTheme() {
        list_apps_container.setBackgroundColor(dominantColor)
    }

    override fun setOnClicks() { }

    override fun adjustLayout() {
        // set up the list / recycler
        list_apps_rview.apply {
            // improve performance (since content changes don't change the layout size)
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = AppsRecyclerAdapter(activity!!, intention, forApp)
        }
    }
}