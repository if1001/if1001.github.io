package br.ufpe.cin.utilities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import br.ufpe.cin.utilities.alarm.AlarmManagerActivity
import br.ufpe.cin.utilities.jobscheduler.JobSchedulerActivity
import br.ufpe.cin.utilities.location.LocationMapsActivity
import br.ufpe.cin.utilities.notification.NotificationManagerActivity
import br.ufpe.cin.utilities.phonesms.PhoneSmsActivity
import br.ufpe.cin.utilities.pkg.PackageManagerActivity
import br.ufpe.cin.utilities.power.PowerManagerActivity
import br.ufpe.cin.utilities.sensor.SensorManagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            startActivity(Intent(applicationContext, NotificationManagerActivity::class.java))
        }
        btn2.setOnClickListener {
            startActivity(Intent(applicationContext, AlarmManagerActivity::class.java))
        }
        btn3.setOnClickListener {
            startActivity(Intent(applicationContext, JobSchedulerActivity::class.java))
        }
        btn4.setOnClickListener {
            startActivity(Intent(applicationContext, PowerManagerActivity::class.java))
        }
        btn5.setOnClickListener {
            startActivity(Intent(applicationContext, SensorManagerActivity::class.java))
        }
        btn6.setOnClickListener {
            startActivity(Intent(applicationContext, PackageManagerActivity::class.java))
        }
        btn7.setOnClickListener {
            startActivity(Intent(applicationContext, PhoneSmsActivity::class.java))
        }
        btn8.setOnClickListener {
            startActivity(Intent(applicationContext, LocationMapsActivity::class.java))
        }

    }
    public companion object {
        val PACKAGE_NAME = "br.ufpe.cin.utilities"
    }
}
