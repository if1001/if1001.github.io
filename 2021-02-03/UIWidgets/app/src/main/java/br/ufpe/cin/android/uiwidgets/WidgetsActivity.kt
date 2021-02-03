package br.ufpe.cin.android.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.annotation.StringRes
import br.ufpe.cin.android.uiwidgets.databinding.ActivityWidgetsBinding

class WidgetsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWidgetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWidgetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icon.setOnClickListener {
            log(R.string.icon_clicked)
        }

        binding.button.setOnClickListener {
            log(R.string.button_clicked)
        }

        binding.swytch.setOnCheckedChangeListener {
                _, isChecked ->
                log(
                    if (isChecked) R.string.switch_checked
                    else R.string.switch_unchecked
                )
        }

        binding.checkbox.setOnCheckedChangeListener {
                    _, isChecked ->

                if (isChecked) {
                    log(R.string.checkbox_checked)
                }
                else {
                    log(R.string.checkbox_unchecked)
                }
        }

        binding.radioGroup.setOnCheckedChangeListener {
                _, checkedId ->
            log(
                when(checkedId) {
                    R.id.radioButton1 -> R.string.radiobutton1_checked
                    R.id.radioButton2 -> R.string.radiobutton2_checked
                    else -> R.string.radiobutton3_checked
                }
            )
        }

        binding.seekbar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    val msg = getString(R.string.seekbar_changed,progress)
                    binding.log.text = msg
                    Log.d("UIWidgetsApp", msg)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    //ignorar
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    //ignorar
                }

            }
        )



    }

    private fun log(@StringRes msg: Int) {
        binding.log.setText(msg)
        Log.d("UIWidgetsApp", getString(msg))
    }
}