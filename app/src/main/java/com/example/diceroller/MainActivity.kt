package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // GO ahead and prime the dice
        rollDice()
    }

    private fun rollDice() {
        val dieImage1: ImageView = findViewById(R.id.imageView1)
        val dieImage2: ImageView = findViewById(R.id.imageView2)

        val die1 = Dice(6)
        val die2 = Dice(6)

        val die1roll = die1.roll()
        val die2roll = die2.roll()

        val drawableResource1 = when (die1roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (die2roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        dieImage1.setImageResource(drawableResource1)
        dieImage2.setImageResource(drawableResource2)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}