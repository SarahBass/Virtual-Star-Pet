package com.academy.virtualstarpet
import android.animation.AnimatorSet
import android.app.Activity
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.academy.virtualstarpet.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

private const val INTERACTIVE_UPDATE_RATE_MS = 600
private var heartRate: Float = 0f
private var stepCount: Float = 0f






/*
class SensorActivity : Activity(), SensorEventListener {
    private val mSensorManager: SensorManager
    private val mAccelerometer: Sensor
    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    override fun onSensorChanged(event: SensorEvent) {}

    init {
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }
}
*/

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
   //Set up Time Variables to be used in Program
    val sdf = SimpleDateFormat("EEE")
    val sdf1 = SimpleDateFormat("EEEE")
    val sdf2 = SimpleDateFormat("MMMM")
    val sdf3 = SimpleDateFormat("d")
    val sdf4 = SimpleDateFormat("yyyy")
    val sdf5 = SimpleDateFormat("MMMM d , yyyy")
    val sdf6 = SimpleDateFormat("h : m a" )
    val sdf7 = SimpleDateFormat("m" )
    val sdf8 = SimpleDateFormat("s" )
    val sdf9 = SimpleDateFormat("S" )
    val d = Date()
    val dayOfTheWeek: String = sdf.format(d)
    val dayOfTheWeekLong: String = sdf1.format(d)
    val monthOfYear: String = sdf2.format(d)
    val dayOfMonth: String = sdf3.format(d)
    val year4digits: String = sdf4.format(d)
    val fullDateSpaces: String = sdf5.format(d)
    val time12hour: String = sdf6.format(d)
    val minutes: String = sdf7.format(d)
    val seconds: String = sdf8.format(d)
    val miliseconds: String = sdf9.format(d)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Create Text Variables-------------------------------------
        //LAYOUT CONSTRAINT:
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        //TEXT FORMAT TIME
        val timeTextView = findViewById<View>(R.id.time) as TextView
        timeTextView.setText(time12hour)
        //DATE FORMAT TIME
        val dateTextView = findViewById<View>(R.id.date) as TextView
        timeTextView.setText(fullDateSpaces)
        //DAY FORMAT TIME
        val dayTextView = findViewById<View>(R.id.day) as TextView
        timeTextView.setText(dayOfTheWeekLong)
        //STEPS FORMAT TIME
         //  val stepTextView = findViewById<View>(R.id.steps) as TextView
         // timeTextView.setText((stepCount).toInt())
         //------------------------------------------------------
        //foodeaten



        //Create Animation Functions----------------------------------------------
         fun foodAnimation() {
            //SET ANIMATION for Eating uses two types of animations and 2 objects
            //Cow wave happy anim - food bounce trans- food eat anim - cow trans bigger

            //group1

            //Cow waves
            val img = findViewById<View>(R.id.Starpet) as ImageView
            img.setBackgroundResource(R.drawable.cowhearts)
            val cowCatchframeAnimation = img.background as AnimationDrawable
            cowCatchframeAnimation.start()
            //Food jumps over
            val img2 = findViewById<View>(R.id.StarObject) as ImageView
            img2.setBackgroundResource(R.drawable.healthy0)
            val bouncingAnimation = AnimationUtils.loadAnimation(this, R.anim.bouncing)
            img2.startAnimation(bouncingAnimation)

            //group2

            //Star blinks
            val img4 = findViewById<View>(R.id.Starpet) as ImageView
            img4.setBackgroundResource(R.drawable.cowjump2)
            val growingAnimation = AnimationUtils.loadAnimation(this, R.anim.blinkingstar)
            img4.startAnimation(growingAnimation)
            //Food turns to Level UP
            val img3 = findViewById<View>(R.id.StarObject) as ImageView
            img3.setBackgroundResource(R.drawable.healthy0eating)
            val healthy0Animation = img3.background as AnimationDrawable
            healthy0Animation.start()
        }
}


}









