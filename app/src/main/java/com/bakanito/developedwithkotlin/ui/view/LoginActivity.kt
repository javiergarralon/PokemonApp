package com.bakanito.developedwithkotlin.ui.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.view.isVisible
import com.bakanito.developedwithkotlin.R
import com.bakanito.developedwithkotlin.core.HashPassword.toSHA256
import com.bakanito.developedwithkotlin.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.wait

private const val HASH_USER: String =
    "6E89996FCCB6F42B37B173F362194D498F34092696528A3EA26289371058CE18"
private const val HASH_PASSWORD: String =
    "741973BEC2F8DB20DDB5AE063AD8BA3D9EFD1EA79D83E40F114277F486FFC3C7"

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bLogin.setOnClickListener {
            if (!binding.etUser.text.isNullOrEmpty() || !binding.etPassword.text.isNullOrEmpty()) {

                val hashedUser = binding.etUser.text.toString().lowercase().toSHA256()
                val hashedPassword = binding.etPassword.text.toString().toSHA256()

                if (hashedUser.equals(HASH_USER) && hashedPassword.equals(HASH_PASSWORD)) {
                    //Success
                    logIn()
                } else {
                    //Error
                    rotatePokeball()
                    Toast.makeText(this, "Usuario y/o contraseña incorrectos.", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                //Incomplete
                rotatePokeball()
                Toast.makeText(this, "Introduzca usuario y contraseña.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun logIn() {
        pokeballDisappear()
    }

    private fun pokeballDisappear() {
        val moveToLeft = AnimationUtils.loadAnimation(this, R.anim.move_left)

        moveToLeft.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                rotatePokeball()
                openPokedex()
            }

            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        binding.ivPokeball.startAnimation(moveToLeft)


    }

    private fun rotatePokeball() {
        binding.ivPokeball.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(-360f)
            start()
        }
    }

    private fun openPokedex() {
        Toast.makeText(this, "Obteniendo datos de los Pokémons...", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, PokedexActivity::class.java)
        startActivity(intent)

    }
}