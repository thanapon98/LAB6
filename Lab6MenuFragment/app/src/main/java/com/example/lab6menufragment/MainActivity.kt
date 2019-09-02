package com.example.lab6menufragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction().add(
                R.id.framelayout,
                OneFragment()
            ).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val manager:FragmentManager = supportFragmentManager
        val transaction:FragmentTransaction = manager.beginTransaction()
        when (item?.itemId){
            R.id.menu1 -> {
                transaction.replace(R.id.framelayout,OneFragment())
                transaction.addToBackStack(null)
                transaction.commit()
            return true}
            R.id.menu2 -> {
                transaction.replace(R.id.framelayout,TwoFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true}
            R.id.menu3 -> {
                transaction.replace(R.id.framelayout,ThreeFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true}

        else -> return super.onOptionsItemSelected(item)
    }}
}
