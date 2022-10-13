package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.infra.MotivationConst
import com.example.motivation.infra.PreferencesFile
import com.example.motivation.R
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener { // importar a View, onClickListener, implement members

    private lateinit var binding: ActivityUserBinding // configurando o binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater) // configurando o binding
        setContentView(binding.root) // configurando o binding

        // ocultando a support action bar
        supportActionBar?.hide()

        // atribuindo um evento de clique no botao
        binding.buttonSave.setOnClickListener(this)

        verifyUserName() // chamando o metodo

    }

    override fun onClick(view: View) { // alterar a nomenclatura
        if(view.id == R.id.button_save) {
            handleSave() // chamando o metodo
        }
    }

    // metodo responsavel por validar as acoes do usuario na activity inicial
    private fun handleSave() {
        val userName = binding.editName.text.toString() // recuperando o valor digitado pelo usuario e transformando em String
        if (userName != "") { // fazendo a verificacao

            // instanciando a classe que contem o shared preferences
            PreferencesFile(this).storeString(MotivationConst.KEY.USER_NAME, userName)

            startActivity(Intent(this, MainActivity::class.java)) // fazendo a navegacao entre as activities
            // finish() // podemos usar o finish() se quisermos impedir que o usuario volte para a activity inicial

        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show() // toast de alerta para o usuario
        }

    }

    // metodo responsavel por verificar se o usuario ja possui seu nome salvo
    private fun verifyUserName() {
        val name = PreferencesFile(this).getString(MotivationConst.KEY.USER_NAME) // buscando o nome do usuario
        if (name != "") { // fazendo a verificacao
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}