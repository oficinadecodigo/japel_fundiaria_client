package com.japelapp.ui.formulario;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.japelapp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    //private static final int[] TAB_TITLES = new int[]{R.string.formulario_tab_text_1, R.string.formulario_tab_text_2, R.string.formulario_tab_text_3, R.string.formulario_tab_text_4, R.string.formulario_tab_text_5};
    private static final int[] TAB_TITLES = new int[]{R.string.formulario_tab_text_1, R.string.formulario_tab_text_2, R.string.formulario_tab_text_3, R.string.formulario_tab_text_4};

    private final Context mContext;

    private FormularioBeneficiarioFragment fragmentBeneficiario;
    private FormularioConjujeFragment fragmentConjuje;
    private FormularioCompFamFragment fragmentCompFam;
    private FormularioMoradiaFragment fragmentMoradia;
    private FormularioFotosFragment fragmentFotos;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a FormularioBeneficiarioFragment (defined as a static inner class below).
        Fragment fragment = null;
        switch (position) {
            case 0: {
                if (fragmentBeneficiario == null) {
                    fragmentBeneficiario = FormularioBeneficiarioFragment.newInstance(1);
                }
                fragment = fragmentBeneficiario;
                break;
            }
            case 1: {
                if (fragmentConjuje == null) {
                    fragmentConjuje = FormularioConjujeFragment.newInstance(1);
                }
                fragment = fragmentConjuje;
                break;
            }
            case 2: {
                if (fragmentCompFam == null) {
                    fragmentCompFam = FormularioCompFamFragment.newInstance(1);
                }
                fragment = fragmentCompFam;
                break;
            }
            case 3: {
                if (fragmentMoradia == null) {
                    fragmentMoradia = FormularioMoradiaFragment.newInstance(1);
                }
                fragment = fragmentMoradia;
                break;
            }
            case 4: {
                if (fragmentFotos == null) {
                    fragmentFotos = FormularioFotosFragment.newInstance(1);
                }
                fragment = fragmentFotos;
                break;
            }
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length;
    }
}