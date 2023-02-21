package com.example.texttomp3

import android.graphics.Typeface
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.texttomp3.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var engVoice = false
    private var hindiVoice = true
    private var male = false
    private var female = true
    private lateinit var mTTS: TextToSpeech
    private var listLang = arrayListOf("Hindi - IN", "English", "China", "CANADA", "GERMAN")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set spinner
//        val adapter = ArrayAdapter(
//            this,
//            R.layout.simple_spinner_item, listLang
//        )
//
//        adapter.setDropDownViewResource(R.layout.simple_spinner_item)
//        binding.spLang.adapter = adapter
//
//        binding.spLang.onItemSelectedListener = object :
//            AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>,
//                view: View, position: Int, id: Long
//            ) {
//                Toast.makeText(
//                    this@MainActivity,
//                    position.toString(), Toast.LENGTH_SHORT
//                ).show()
//
//                when (position) {
//                    1 -> {
//                        result = mTTS.setLanguage(Locale.ENGLISH)
//                        Log.e("TAG", "onItemSelected1: $result", )
//                    }
//                    2 -> {
//                        result = mTTS.setLanguage(Locale.CHINA)
//                        Log.e("TAG", "onItemSelected2: $result", )
//                    }
//                    3 -> {
//                        result = mTTS.setLanguage(Locale.CANADA)
//                        Log.e("TAG", "onItemSelected3: $result", )
//                    }
//                    4 -> {
//                        result = mTTS.setLanguage(Locale.GERMAN)
//                        Log.e("TAG", "onItemSelected4: $result", )
//                    }
//                    else -> {
//                        result = mTTS.setLanguage(Locale("hin"))
//                        Log.e("TAG", "onItemSelected: $result", )
//                    }
//                }
//
//                mTTS = TextToSpeech(this@MainActivity) { status ->
//                    if (status == TextToSpeech.SUCCESS) {
//                        //val result = mTTS.setLanguage(Locale.ENGLISH);
//                        if (result == TextToSpeech.LANG_MISSING_DATA
//                            || result == TextToSpeech.LANG_NOT_SUPPORTED
//                        ) {
//                            Log.e("TTS", "Language not supported")
//                        } else {
//                            if (female) {
//                                binding.btnSay.isEnabled = true
//                            } else {
//                                val a: MutableSet<String> = HashSet()
//                                a.add("male") //here you can give male if you want to select male voice.
//                                val v = Voice(
//                                    "en-us-x-sfg#male_2-local",
//                                    Locale("hin"),
//                                    400,
//                                    200,
//                                    true,
//                                    a
//                                )
//                                mTTS.voice = v
//                                binding.btnSay.isEnabled = true
//                            }
//                        }
//                    } else {
//                        Log.e("TTS", "Initialization failed")
//                    }
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                // write code to perform some action
//            }
//        }

        binding.apply {
            mTTS = TextToSpeech(this.root.context) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    val result: Int = mTTS.setLanguage(Locale("vn"))
                    //val result = mTTS.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED
                    ) {
                        Log.e("TTS", "Language not supported")
                    } else {
                        btnSay.isEnabled = true
                    }
                } else {
                    Log.e("TTS", "Initialization failed")
                }
            }

            btnVn.setOnClickListener {
                Log.e("TAG", "Hindi", )
                engVoice = false
                hindiVoice = true

                btnVn.typeface = Typeface.DEFAULT_BOLD
                btnEng.typeface = Typeface.DEFAULT

                mTTS = TextToSpeech(this.root.context) { status ->
                    if (status == TextToSpeech.SUCCESS) {
                        val result: Int = mTTS.setLanguage(Locale("vn"))
                        //val result = mTTS.setLanguage(Locale.ENGLISH);
                        if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED
                        ) {
                            Log.e("TTS", "Language not supported")
                        } else {
                            if (female) {
                                btnSay.isEnabled = true
                            } else {
                                val a: MutableSet<String> = HashSet()
                                a.add("male") //here you can give male if you want to select male voice.
                                val v = Voice(
                                    "en-us-x-sfg#male_2-local",
                                    Locale("hin"),
                                    400,
                                    200,
                                    true,
                                    a
                                )
                                mTTS.voice = v
                                btnSay.isEnabled = true
                            }
                        }
                    } else {
                        Log.e("TTS", "Initialization failed")
                    }
                }
            }

            btnEng.setOnClickListener {
                Log.e("TAG", "Eng", )

                engVoice = true
                hindiVoice = false

                btnEng.typeface = Typeface.DEFAULT_BOLD
                btnVn.typeface = Typeface.DEFAULT

                mTTS = TextToSpeech(this.root.context) { status ->
                    if (status == TextToSpeech.SUCCESS) {
                        val result: Int = mTTS.setLanguage(Locale("en", "US"))
                        //val result = mTTS.setLanguage(Locale.ENGLISH);
                        if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED
                        ) {
                            Log.e("TTS", "Language not supported")
                        } else {
                            if (female) {
                                btnSay.isEnabled = true
                            } else {
                                val a: MutableSet<String> = HashSet()
                                a.add("male") //here you can give male if you want to select male voice.
                                val v = Voice(
                                    "en-us-x-sfg#male_2-local",
                                    Locale("en", "US"),
                                    400,
                                    200,
                                    true,
                                    a
                                )
                                mTTS.voice = v
                                btnSay.isEnabled = true
                            }
                        }
                    } else {
                        Log.e("TTS", "Initialization failed")
                    }
                }
            }

            btnMale.setOnClickListener {
                Log.e("TAG", "Male voice")
                female = false
                male = true
                btnMale.typeface = Typeface.DEFAULT_BOLD
                btnFemale.typeface = Typeface.DEFAULT

                val a: MutableSet<String> = HashSet()
                a.add("male") //here you can give male if you want to select male voice.

                val v = Voice("en-us-x-sfg#male_2-local", Locale("en", "US"), 400, 200, true, a)
                mTTS.voice = v

            }

            btnFemale.setOnClickListener {
                Log.e("TAG", "Female voice")
                female = true
                male = false
                btnFemale.typeface = Typeface.DEFAULT_BOLD
                btnMale.typeface = Typeface.DEFAULT

                if (hindiVoice) {
                    val a: MutableSet<String> = HashSet()
                    a.add("female") //here you can give male if you want to select mail voice.
                    val v = Voice("en-us-x-sfg#female_2-local", Locale("hin"), 400, 200, true, a)
                    mTTS.voice = v
                } else {
                    val a: MutableSet<String> = HashSet()
                    a.add("female") //here you can give male if you want to select mail voice.
                    val v =
                        Voice("en-us-x-sfg#female_2-local", Locale("en", "US"), 400, 200, true, a)
                    mTTS.voice = v
                }
            }

            btnSay.setOnClickListener {
                val text: String = binding.edTextToMp3.text.toString()
                var pitch: Float = binding.seekBarPitch.progress.toFloat() / 50
                if (pitch < 0.1) pitch = 0.1f
                var speed: Float = binding.seekBarSpeed.progress.toFloat() / 50
                if (speed < 0.1) speed = 0.1f
                mTTS.setPitch(pitch)
                mTTS.setSpeechRate(speed)
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null)
            }
        }
    }
}