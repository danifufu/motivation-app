package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConst
import com.example.motivation.infra.PreferencesFile
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener { // importar a View, onClickListener, implement members

    private lateinit var binding: ActivityMainBinding // configurando o binding
    private var categoryId = MotivationConst.FILTER.ALL_INCLUSIVE // var para categorizar os filtros da top bar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // configurando o binding
        setContentView(binding.root) // configurando o binding

        // atribuindo um evento de clique
        binding.buttonGeneratePhrase.setOnClickListener(this)
        binding.imageAllInclusive.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)

        // ocultando a support action bar
        supportActionBar?.hide()

        handleUserName() // chamando o metodo que faz a alteracao do nome no layout

        handleFilter(R.id.image_all_inclusive) // selecionando esse filtro por default quando iniciar a activity
        handleNextPhrase() // exibir uma frase por default assim que o usuario entrar no app
    }

    override fun onClick(view: View) { // alterei a nomenclatura para view
        if (view.id == R.id.button_generate_phrase) {
            handleNextPhrase() // chamando o metodo
        } else if (view.id in listOf(R.id.image_all_inclusive, R.id.image_happy, R.id.image_sunny)) {
            handleFilter(view.id) // chamando o metodo
        }
    }

    // metodo resposavel por gerar/exibir a frase random
    private fun handleNextPhrase() {
        binding.textPhrase.text = Mock().getPhrase(categoryId)
    }

    // metodo responsavel pela logica dos filtros da top bar
    private fun handleFilter(id: Int) {
        // todas as imagens (filtros) da top bar irao ter a cor levemente apagada
        binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        // quando determinada imagem for selecionada, a cor dela ira ser alterada para branco
        when (id) {
            R.id.image_all_inclusive -> {
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConst.FILTER.ALL_INCLUSIVE
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConst.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConst.FILTER.SUNNY
            }
        }
    }

    // metodo responsavel por fazer a mudanca do nome no layout e exibir o nome do usuario que foi salvo
    private fun handleUserName() {
        val name = PreferencesFile(this).getString(MotivationConst.KEY.USER_NAME)
        binding.salutation.text = "Olá, $name!"
    }

}