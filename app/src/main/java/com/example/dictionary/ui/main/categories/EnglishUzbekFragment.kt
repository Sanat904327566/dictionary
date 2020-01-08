package com.example.dictionary.ui.main.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.BaseFragment

import com.example.dictionary.R
import com.example.dictionary.adapter.EngUzbAdapter
import com.example.dictionary.db.model.Translation
import com.example.dictionary.db.model.Words
import com.example.dictionary.ui.main.fragmentdiolog.MyAlertDialogFragment
import com.example.dictionary.ui.main.viewmodel.EngUzbViewModel
import kotlinx.android.synthetic.main.fragment_english_uzbek.*

/**
 * A simple [Fragment] subclass.
 */
class EnglishUzbekFragment : BaseFragment(),
EngUzbAdapter.Interaction{

    private lateinit var engUzbAdapter: EngUzbAdapter
    private lateinit var viewModel: EngUzbViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_english_uzbek, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initVM()
        initRV()
        observe()
    }

    private fun initVM(){
        viewModel = ViewModelProvider(this)[EngUzbViewModel::class.java]
        viewModel.insert(createWordsList())
    }

    private fun initRV() {
        eng_uzb_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            engUzbAdapter = EngUzbAdapter(this@EnglishUzbekFragment)
            adapter = engUzbAdapter
        }
    }

    private fun observe() {
        viewModel.allWords.observe(
            this, Observer {
                engUzbAdapter.submitList(it)
            }
        )
    }

    override fun onItemSelected(position: Int, item: Words) {
            showRVItemDialog(position,item)
    }

    private fun showRVItemDialog(pastion: Int,item: Words){


        val dialog = MyAlertDialogFragment.newInstance(createTranslations(pastion))
        dialog.setTargetFragment(this, 0)
        val fragmentManager = fragmentManager ?: return
        dialog.show(fragmentManager, MyAlertDialogFragment::class.java.simpleName)


//        val newFragment = MyAlertDialogFragment.newInstance(
//            R.string.alert_dialog_two_buttons_title
//        )
//        newFragment.show(fragmentManager!!, "dialog")
//

//         var newFragment: DialogFragment = MyAlertDialogFragment.newInstance(
//            R.string.app_name
//        )
//        getFragmentManager()?.let { newFragment.show(it,"dialog") };

//        val dialog = MaterialDialog(context!!)
//            .noAutoDismiss()
//            .customView(R.layout.material_dialog)
//        dialog.show()
    }

    private fun createWordsList(): ArrayList<Words> {
        val wordsList = ArrayList<Words>()
        wordsList.add(Words("aback"))
        wordsList.add(Words("abacus"))
        wordsList.add(Words("abandon"))
        wordsList.add(Words("babe"))
        wordsList.add(Words("baboon"))
        wordsList.add(Words("baby"))
        wordsList.add(Words("bacchanalian"))
        wordsList.add(Words("baccy"))
        wordsList.add(Words("bachelor"))
        wordsList.add(Words("cabaret"))
        wordsList.add(Words("cabbage"))
        wordsList.add(Words("cabbie"))
        wordsList.add(Words("dabble"))
        wordsList.add(Words("dacha"))
        wordsList.add(Words("dad"))
        wordsList.add(Words("daddy"))


        return wordsList
    }
    private fun createTranslations(position: Int): Translation {

        val translateList = ArrayList<Translation>()
        translateList.add(Translation("aback","[]","adverb","hayratda qoldirmoq"));
        translateList.add(Translation("abacus","[]","noun","cho't"));
        translateList.add(Translation("abandon","[]","verb","1) tashlab ketmoq,tark etmoq\n2)to'xtatmoq, oxirga yetkazmaslik\n-abandonment n tashlab ketish ,tarke tish:\n to'xtashish,oxirga yetkazmaslik"));
        translateList.add(Translation("babe","[]","","1)(old-fashioned)chaqaloq\n2)(US slang)(kishilarga,asosan\nayollarga,qizlarga nisbatan)qizaloq"));
        translateList.add(Translation("baboon","[]","noun","paviak,ittumshuq maymun"));
        translateList.add(Translation("baby","[]","noun","(pl babies) 1)chaqaloq\n2) = BABE - babyish adj bolalarcha,\nbachkana - baby carriage n(US) = \nPRAM - babysit v bolaga qaramoq -\nbabysitter n enaga"));
        translateList.add(Translation("bacchanalian","[]","adjectative","(formal)vakxanaliya...,uzluksiz\n ayshi-ishrat..."));
        translateList.add(Translation("baccy","[]","noun","tamaki"));
        translateList.add(Translation("bachelor","[]","noun","bo'ydoq (Ayollarga nisbatan spinster \n qo'llaniladi. \n 2) bakalavr"));
        translateList.add(Translation("cabaret","[]","noun","kabare"));
        translateList.add(Translation("cabbage","[]","noun","karam"));
        translateList.add(Translation("cabbie","[]","","(also cabby)izvosh (fayton)\n izvoshchi,kucher"));
        translateList.add(Translation("dabble","[]","verb","1)suvni chayqaltirmoq,shappillatmoq,\n sachratmoq;\n 2)shunchaki yuzaki qiziqmoq,yuzaki\n shug'ullantirmoq"));
        translateList.add(Translation("dacha","[]","noun","dacha(shahar tashqarisidagi hovli - joy)"));
        translateList.add(Translation("dad","[]","noun","(informal)dada,ota"));
        translateList.add(Translation("daddy","[]","noun","(pl daddies) (bolalar tomonidan \n qo'llaniladi)dada ,ota,otajon"));

        return translateList.get(position);
    }

}
