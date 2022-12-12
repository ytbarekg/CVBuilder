package edu.miu.mdp.cvbuilder

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {
    val itemSearchList: Array<String> = arrayOf("Facebook", "Google", "Linkedin", "Twitter");
    var arrayAdapter: ArrayAdapter<String>? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        arrayAdapter = ArrayAdapter(this, itemSearchList);
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if(menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true);
        }
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.menu_item_search).actionView as SearchView
        searchView.queryHint= "Search"
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(
            applicationContext,
            item.title.toString(),
            Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

    override fun onQueryTextChange(newText: String?): Boolean {
// adp is an ArrayAdapter for the ListView to filter the searched data

        arrayAdapter?.filter?.filter(newText)
        return true
    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

}