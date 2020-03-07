package fi.jukkalaitinen.adice

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var soundOn = true
    var verboseOn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return true
        var checked = sharedPref.getBoolean(getString(R.string.sound_setting), soundOn)
        var item = menu.findItem(R.id.sound_setting)
        item.setChecked(checked)

        checked = sharedPref.getBoolean(getString(R.string.verbose_setting), verboseOn)
        item = menu.findItem(R.id.verbose_setting)
        item.setChecked(checked)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> { true }
            R.id.sound_setting -> {
                setSound(!item.isChecked)
                item.setChecked(!item.isChecked)
                true
            }
            R.id.verbose_setting -> {
                setVerbose(!item.isChecked)
                item.setChecked(!item.isChecked)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun <T : View?> findViewByName(s: String): T {
        val id = resources.getIdentifier(s, "id", packageName)
        return findViewById<T>(id)
    }

    fun incrementOrdecrementDice(view: View) {
        val name = view.resources.getResourceEntryName(view.id)
        val dice = name.split("incr", "decr")[1].toLowerCase()
        var change = if (name.startsWith("incr")) 1 else -1
        val diceView = findViewByName<TextView>(dice)
        val n = diceView.text.toString().toInt(10) + change
        diceView.text = n.toString()
    }

    fun roll(view: View) {
        var result = 0
        var resultText = ""

        val diceIds = arrayListOf(4, 6, 8, 10, 12, 20, 100)
        for (d in diceIds) {
            val diceView = findViewByName<TextView>("d" + d.toString())
            val n = diceView.text.toString().toInt(10)
            if (n == 0)
                continue

            val times = Math.abs(n)
            var res = 0
            var results = arrayListOf<Int>()
            for (x in 1 .. times) {
                val i = Random.nextInt(1, d + 1)
                res += i
                results.add(i)
            }
            if (n < 0) {
                res *= -1
                resultText += "-"
            }
            else
                resultText += "+"
            result += res
            resultText += results.joinToString(prefix = "(", postfix = ")", separator = "+")
        }

        var view = findViewByName<TextView>("mod")
        val mod = view.text.toString().toInt(10)
        if (mod != 0)
            resultText = (if (mod < 0) "-" else "+") + mod.toString()
        result += mod

        view = findViewByName<TextView>("resultText")
        if (resultText.startsWith("+"))
            resultText = resultText.substring(1)
        if (resultText.isEmpty())
            return
        view.append(if (verboseOn) "$resultText = $result\n" else "$result\n")

        if (soundOn) {
            val mp = MediaPlayer.create(applicationContext, R.raw.dices)
            mp?.start()
        }
    }

    fun reset(view: View) {
        val ids = arrayListOf("d4", "d6", "d8", "d10", "d12", "d20", "d100", "mod")
        for (i in ids) {
            val view = findViewByName<TextView>(i)
            view.text = "0"
        }

        val view = findViewByName<TextView>("resultText")
        view.text = ""
    }

    fun setSound(checked: Boolean) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean(getString(R.string.sound_setting), checked)
            commit()
        }

        soundOn = checked
    }

    fun setVerbose(checked: Boolean) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean(getString(R.string.verbose_setting), checked)
            commit()
        }

        verboseOn = checked
    }
}
