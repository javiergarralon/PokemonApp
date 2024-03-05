package com.bakanito.developedwithkotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bakanito.developedwithkotlin.core.HashPassword.toSHA256
import com.bakanito.developedwithkotlin.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

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
                    Toast.makeText(this, "Obteniendo datos de los Pokémons...", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, PokedexActivity::class.java)
                    startActivity(intent)
                } else {
                    //Error
                    Toast.makeText(this, "Usuario y/o contraseña incorrectos.", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                //Incomplete
                Toast.makeText(this, "Introduzca usuario y contraseña.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}